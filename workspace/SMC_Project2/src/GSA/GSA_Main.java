package GSA;
import java.util.Random;
import java.util.ArrayList;

import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;


import weka.classifiers.bayes.NaiveBayesMultinomial;
import weka.core.Instances;
import Bundles_Arrangement.Bundles_Arrangement;
import Bundles_Arrangement.Bundles_RandomCreation;
import Data_Retrieval.Prepare_PatientData;
import GSA.Read_Parameter;
import GSA.Write_RunResult;
import Instances_Format.CreateInstances;
import Instances_Format.Randomise_Data;
import Modelling.runModelling;
import Sampled_Data.Sampling_Patient;
import VFSix_Bundles.getClusters;
import VFpreparation.ReadFile;
import VFpreparation.form_ClusteredData;
import VFpreparation.getSource;

public class GSA_Main {
	
	static Random rand = new Random ();

	static double iniTemp= 0.0;
	
	static double qa=0.0;
	static double qv= 0.0;
	
	public static void main (String [] args) throws Exception
	{
		int run = 1;
		double [][] gsa_para = Read_Parameter.GSA_parameters();
		double [][] finalFit = new double [run][8];
		long timestart = 0;
		int iter = (int) gsa_para [0][3];
		
		System.out.println ("Iter is " +iter);
		
		for (int k=0; k<gsa_para.length; k++)
		{
			qa = gsa_para [k][0];
			iniTemp = gsa_para [k][4];
			qv = gsa_para [k][6];
			
			for (int j=0; j<run; j++)
			{
				finalFit [j][0] = (j+1);
				System.out.println ("Result number " +(j+1));
				timestart = System.currentTimeMillis();
				runGSA_VF(j, finalFit, timestart, iter);
				System.out.println ();
			}
			
			Write_RunResult.writeRunExperiment(finalFit, qa);
		}
		
	}
	
	public static void runGSA_VF (int j, double [][] finalFit, long timestart, int iteration) throws Exception
	{
		rand.setSeed(System.nanoTime());	
		
		String filesource = getSource.getData();
		String sep = ",";
		
		Classifier model = new NaiveBayesMultinomial ();
		//String modelname = "MNB";
		//Classifier model = new NaiveBayesUpdateable ();
		//Classifier model = new J48 ();
		String modelname = "MNB";
		//Classifier model = new NaiveBayes ();
		//String modelname = "NaiveBayes";
		int fold = 10;
		int iter = iteration;
		//double qa = 0.1;
		//double qv = 1.37788166108833;
		double temp = iniTemp;
		double [] visitA = new double [1];
		double prob = 0;
		double random = 0;
		
		double [][] rawData = ReadFile.ReadFileArray(filesource, sep); // read raw data from path and create into an array
		double [][] bundledData = null;
		//System.out.println ("No of row : "+rawData.length);
		//System.out.println ("No of col : "+rawData [0].length);
		//ReadFile.PrintArray(rawData);
		
		double [][] allVFData =  Prepare_PatientData.allPatientVFData(rawData); //prepare all data which consists of 12159 records from 1579 patients. Using all data with the 6NFB gives the same accuracy
		//double [][] allVFData =  Sampling_Patient.searchPatient(rawData); //prepare all data which consists of 12159 records from 1579 patients.
		//ReadFile.PrintArray(allVFData);
		System.out.println ("No of variables before clustered : "+allVFData[0].length);
		
		ArrayList<ArrayList<Integer>> curClusters = new ArrayList<ArrayList<Integer>> ();
		curClusters = Bundles_RandomCreation.initialCluster(curClusters); //random initial clusters
		//curClusters = getClusters.getCluster(6); // the six nerve fibers bundles
		//System.out.println (iniCluster);		
		
		bundledData = form_ClusteredData.getData(curClusters, allVFData);
		System.out.println ("No of records : "+allVFData.length);
		System.out.println ("No of variables : "+allVFData[0].length);
		
		Instances iData = CreateInstances.createInstances(bundledData, curClusters); // transform the VF data into Instances format
		iData.deleteAttributeAt(0); //remove PID column from the data
		iData.setClassIndex(iData.numAttributes()-1); //assigns the last attribute as the class variable
		iData = Randomise_Data.RandData(iData); //randomise the data (this dataset is ready for modelling)
		
		double curAccuracy = runModelling.modellingAccuracy(iData, model, modelname, fold);
		System.out.println ("Initial accuracy is : "+curAccuracy+"\n");
		
		double [][] result = new double [iter][13];
		ArrayList<ArrayList<Integer>> bestClusters = new ArrayList<ArrayList<Integer>> ();
		int oldSwap = 0;
		int noSwap = 0;
		double best = 0;
				
		for (int i=0; i<iter; i++)
		{
			result [i][0] = (i+1);
			result [i][1] = curAccuracy;
			oldSwap = noSwap;
			System.out.println ("Run # : "+j);
			System.out.println ("No. of record : "+bundledData.length);
			System.out.println ("Iteration : "+i);
			System.out.println ("QA : "+qa);
			System.out.println ("QV : "+qv);
			
			ArrayList<ArrayList<Integer>> newClusters = Bundles_RandomCreation.cloneArrayList(curClusters);
			
			double newVisit0 = GSA_Algo.SmallChange(qv, temp, visitA);
			System.out.println ("Current accuracy is : "+curAccuracy);
			System.out.println ("Newvisit0 is : "+newVisit0);
			System.out.println ("Current clusters size is : "+curClusters.size());
			noSwap = (int)(newVisit0*52);
		
			//System.out.println ("NoSwap is : "+noSwap);
			if(noSwap==0 ||noSwap==1)
			noSwap = 2;
			System.out.println ("NoSwap is : "+noSwap);
			
			newClusters = Bundles_Arrangement.newArrangementGSA(newClusters, noSwap);
			//System.out.println ("New cluster size is : "+newClusters.size());
			
			bundledData = form_ClusteredData.getData(newClusters, allVFData); // form a bundled VF data
			iData = CreateInstances.createInstances(bundledData, newClusters); // convert into instances data
			iData.deleteAttributeAt(0); //remove PID column from the data
			iData.setClassIndex(iData.numAttributes()-1); //assigns the last attribute as the class variable
			iData = Randomise_Data.RandData(iData); //randomise the data (this dataset is ready for modelling)
			
			double newAccuracy = runModelling.modellingAccuracy(iData, model, modelname, fold); //modelling process to get the accuracy
			System.out.println ("new accuracy is : "+newAccuracy);
			result [i][2] = newAccuracy;
			result [i][3] = curClusters.size();
			result [i][4] = newClusters.size();
			result [i][5] = oldSwap;
			result [i][6] = noSwap;
			
			finalFit [j][1] = qa; 
			finalFit [j][2] = qv; 
			finalFit [j][3] = temp;
			
			if (newAccuracy>best)
			{
				best = newAccuracy;
				finalFit [j][7] = newAccuracy; //to capture the best accuracy
				finalFit [j][6] = (i+1); //to capture the best accuracy point
				bestClusters = Bundles_RandomCreation.cloneArrayList(newClusters); // to capture the best clusters
			}
			
			
			if (newAccuracy>curAccuracy)
			{
				curClusters.clear();
				curClusters = Bundles_RandomCreation.cloneArrayList(newClusters);
				curAccuracy = newAccuracy;
				prob = 1;
			}
			else
			{
				random = rand.nextDouble();
				double difFit = (curAccuracy-newAccuracy)/100;  //current accuracy greater than the new accuracy
				//System.out.println("Different fitness is : "+difFit);
				result [i][7] = difFit;
				prob = GSA_Algo.prob(difFit, temp, qa);
				
				if (prob>random)
				{
					curClusters.clear();
					curClusters = Bundles_RandomCreation.cloneArrayList(newClusters);
					curAccuracy = newAccuracy;
					System.out.println("This IS PERFORMED");
				}
			}
			
			result [i][8] = prob;
			result [i][9] = random;
			
			temp = GSA_Algo.NewTemp(iniTemp, (double)(i+1), qv);
			result [i][10] = temp;
			result [i][11] = qa;
			result [i][12] = qv;
			
			newClusters.clear(); 
			
			System.out.println();
		}
		
		long timeEnd = System.currentTimeMillis();
		double time = (double) (timeEnd-timestart)/1000;
		
		finalFit [j][4] = curAccuracy; 
		finalFit [j][5] = time; 
		
		System.out.println("No of col is : "+result[0].length);
		System.out.println("No of row is : "+result.length);
		
		Write_Result.writeResult(result, j, qa);
		Write_Result.writeBundles(curClusters, modelname, qa, j);
		Write_Result.writeBestBundles(bestClusters, modelname, qa, j);
		System.out.println("Final accuracy is : "+curAccuracy);
		System.out.println("Final cluster size is : "+curClusters.size());
		System.out.println("Final cluster is : "+curClusters);
	}
	
	

}
