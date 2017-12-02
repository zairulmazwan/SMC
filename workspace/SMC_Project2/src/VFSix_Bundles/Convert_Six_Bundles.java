package VFSix_Bundles;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Convert_Six_Bundles {
	
	public static void main (String [] args)
	{
		/*
		for (int i=1; i<11; i++)
		{
			String filename = "RRHC_Bundles_"+i+"_J48_run6";
			String fileoutput = "Converted_RRHC_Bundles_"+i+"_J48_run6";
			String filepath = "C:\\Zairul Mazwan\\Java Output\\Experiment 4 - Sample Data Random Clusters\\RRHC\\J48\\run 6\\"+filename+".txt";
			
			ArrayList<ArrayList<Integer>> bundles = new ArrayList<ArrayList<Integer>> ();
			bundles = ReadBundles.readBundles(filepath, filename);
			
			System.out.println (bundles);
			
			convert(bundles);
			System.out.println (bundles);
			
			writeBundles (bundles, fileoutput);
		}
		*/
		
		String filename = "SixBundles_1";
		String fileoutput = "Converted_SixBundles_1";
		String filepath = "C:\\Zairul Mazwan\\Java Input\\VF Bundles\\"+filename+".txt";
		
		ArrayList<ArrayList<Integer>> bundles = new ArrayList<ArrayList<Integer>> ();
		bundles = ReadBundles.readBundles(filepath, filename);
		
		System.out.println (bundles);
		
		convert(bundles);
		System.out.println (bundles);
		
		writeBundles (bundles, fileoutput);
		
		
	}
	
	public static ArrayList<ArrayList<Integer>> convert (ArrayList<ArrayList<Integer>> bundles)
	{
		for (int i=0; i<bundles.size(); i++)
		{
			for (int j=0; j<bundles.get(i).size(); j++)
			{
				int element = bundles.get(i).get(j);
				if (element > 25 && element < 34)
				{
					int newElement = element+1;
					bundles.get(i).set(j, newElement);
					
				}
				
				if (element > 33)
				{
					int newElement = element+2;
					bundles.get(i).set(j, newElement);
				}
				
				
			}
		}
		
		return bundles;
	}
	
	public static void writeBundles (ArrayList<ArrayList<Integer>> curCluster, String fileName)
	{
		//String filepath = "C:\\Zairul Mazwan\\Java Output\\Moorefield\\Simultaneous_Modeling_Project1\\Stichastic Hill Climbing\\SHC_Bundles.txt";
		String filepath = "C:\\Zairul Mazwan\\Java Input\\VF Bundles\\"+fileName+".txt";
		
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
