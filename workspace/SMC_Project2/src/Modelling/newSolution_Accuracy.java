package Modelling;
import weka.classifiers.Classifier;
import weka.core.Instances;

import java.util.ArrayList;

import VFpreparation.form_ClusteredData;
import Instances_Format.CreateInstances;
import Instances_Format.Randomise_Data;


public class newSolution_Accuracy {

		public static double newAccuracy (ArrayList<ArrayList<Integer>> newCluster, double [][] VF52Data, Classifier model, String modelName, int fold) throws Exception
		{
			Instances iData = null;
			double newAccuracy = 0;
			double [][] VFBundleddata = null;
			
			
			VFBundleddata = form_ClusteredData.getData(newCluster, VF52Data); //prepare a VF data according to the bundles
			iData = CreateInstances.createInstances(VFBundleddata, newCluster); // transform the VF data into Instances format
			iData.deleteAttributeAt(0);; //remove PID column from the data
			iData.setClassIndex(iData.numAttributes()-1); // set the class variable
			iData = Randomise_Data.RandData(iData);  //randomise the data
			newAccuracy = runModelling.modellingAccuracy(iData, model, modelName, fold);
			
			return newAccuracy;
		}

	}

