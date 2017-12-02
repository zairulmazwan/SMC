package GSA;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;

public class Write_Result {
	
	public static void writeResult (double [][] result, int j, double qa_para)
	{
		//String path = "D:\\Java Output\\VF GSA\\VF_GSA_Result_"+j+"_"+qa_para+".txt";
		String path = "C:\\Zairul Mazwan\\Java Output\\VF GSA\\VF_GSA_Result_"+j+"_"+qa_para+".txt";
		
		
		
		try
		{
			FileWriter fw = new FileWriter (path);
			BufferedWriter bw = new BufferedWriter (fw);
			
			bw.write("Iter");
			bw.write(" ");
			bw.write("CurrenFitness");
			bw.write(" ");
			bw.write("NewFitness");
			bw.write(" ");
			bw.write("CurrentBundles");
			bw.write(" ");
			bw.write("NewBundles");
			bw.write(" ");
			bw.write("OldV");
			bw.write(" ");
			bw.write("NewV");
			bw.write(" ");
			bw.write("DiffFit");
			bw.write(" ");
			bw.write("Prob");
			bw.write(" ");
			bw.write("Random_No");
			bw.write(" ");
			bw.write("Temp");
			bw.write(" ");
			bw.write("QA");
			bw.write(" ");
			bw.write("QV");
			bw.newLine();
			
			for (int i=0; i<result.length; i++)
			{
				double iter = result [i][0];
				double curFit = result [i][1];
				double newFit = result [i][2];
				double curBund = result [i][3];
				double newBund = result [i][4];
				double oldV = result [i][5];
				double newV = result [i][6];
				double diffit = result [i][7];
				double prob = result [i][8];
				double rand = result [i][9];
				double temp = result [i][10];
				double qa = result [i][11];
				double qv = result [i][12];
				
				bw.write(Double.toString(iter));
				bw.write(" ");
				bw.write(Double.toString(curFit));
				bw.write(" ");
				bw.write(Double.toString(newFit));
				bw.write(" ");
				bw.write(Double.toString(curBund));
				bw.write(" ");
				bw.write(Double.toString(newBund));
				bw.write(" ");
				bw.write(Double.toString(oldV));
				bw.write(" ");
				bw.write(Double.toString(newV));
				bw.write(" ");
				bw.write(Double.toString(diffit));
				bw.write(" ");
				bw.write(Double.toString(prob));
				bw.write(" ");
				bw.write(Double.toString(rand));
				bw.write(" ");
				bw.write(Double.toString(temp));
				bw.write(" ");
				bw.write(Double.toString(qa));
				bw.write(" ");
				bw.write(Double.toString(qv));
				bw.newLine();
			}
			
			bw.close();
			fw.close();
			
			
		}
		catch (Exception e)
		{
			 System.err.println("Problem writing GSA TSP result to the file");
		}
	}

	
	public static void writeBundles (ArrayList<ArrayList<Integer>> curCluster, String modelName, double qa, int k)
	{
		
		String filepath = "C:\\Zairul Mazwan\\Java Output\\VF GSA\\Bundles_Results\\GSA_Bundles"+modelName+"_"+qa+"_"+k+".txt";
		//String filepath = "D:\\Java Output\\VF GSA\\Bundles Results\\GSA_Bundles"+modelName+"_"+qa+"_"+k+".txt";
		
		try
		{
			FileWriter fw = new FileWriter (filepath);
			BufferedWriter bw = new BufferedWriter (fw);
			
			int bundleSize = curCluster.size();
			
			for (int i=0; i<bundleSize; i++)
			{
				for (int j=0; j<curCluster.get(i).size(); j++)
				{
					int element = curCluster.get(i).get(j);
					bw.write(Integer.toString(element));
					bw.write(" ");
				}
				bw.newLine();
			}
					
			bw.close();
			fw.close();
		}
		catch (Exception e)
		{
			 System.err.println("Problem writing bundles to the file");
		}
		
	}
	
	public static void writeBestBundles (ArrayList<ArrayList<Integer>> curCluster, String modelName, double qa, int k)
	{
		//String filepath = "C:\\Zairul Mazwan\\Java Output\\Moorefield\\Simultaneous_Modeling_Project1\\Hill Climbing\\HC_Bundles_"+modelName+".txt";
		//String filepath = "D:\\Java Output\\Other Output\\For Conference Paper Initial Analysis\\HC\\NB\\Random Initial Bundles\\Run 7\\HC_Bundles"+modelName+".txt";
		String filepath = "C:\\Zairul Mazwan\\Java Output\\VF GSA\\Bundles_Results\\GSA_BestBundles_"+modelName+"_"+qa+"_"+k+".txt";
		
		try
		{
			FileWriter fw = new FileWriter (filepath);
			BufferedWriter bw = new BufferedWriter (fw);
			
			int bundleSize = curCluster.size();
			
			for (int i=0; i<bundleSize; i++)
			{
				for (int j=0; j<curCluster.get(i).size(); j++)
				{
					int element = curCluster.get(i).get(j);
					bw.write(Integer.toString(element));
					bw.write(" ");
				}
				bw.newLine();
			}
					
			bw.close();
			fw.close();
		}
		catch (Exception e)
		{
			 System.err.println("Problem writing bundles to the file");
		}
		
	}
}
