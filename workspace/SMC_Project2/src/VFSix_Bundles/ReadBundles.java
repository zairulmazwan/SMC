package VFSix_Bundles;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadBundles {
	
	public static ArrayList<ArrayList<Integer>> readBundles (String filepath, String bundlesName)
	{
		//String a = "D:\\Java Input\\Bundles Files\\BundlesA.txt";
		//String b = "D:\\Java Input\\Bundles Files\\BundlesB.txt";
		
		String sep = " ";
			
		ArrayList<ArrayList<Integer>> vfA = new ArrayList<ArrayList<Integer>> ();
		
		int counter = 0; //to count no. of bundles in the file
		
		try
		{
			FileReader fr =  new FileReader (filepath);
			BufferedReader br = new BufferedReader (fr);
			
			String line = null;
			
			while ((line = br.readLine()) !=null)
			{
				counter++;
			}
			
			System.out.println("Number of bundles in "+bundlesName+" is : "+counter);
			
			vfA = new ArrayList<ArrayList<Integer>> (counter);
			
			fr = new FileReader (filepath);
			br = new BufferedReader (fr);
			
			while ((line = br.readLine())!= null)
			{
				String [] readInput = line.split(sep);
				ArrayList<Integer> inner = new ArrayList<Integer> ();
				
				for (int i=0; i<readInput.length; i++)
				{
					int element = Integer.parseInt(readInput[i]);
					inner.add(element);
				}
				vfA.add(inner);
			}
			
			//System.out.println ("Bundles are : "+vfA);
			
			br.close();
			fr.close();
		}
		catch(Exception e)
		{
			 System.err.println("Problem read the bundles file");
		}
		
		return vfA;
	}
	
	public static void main (String [] args)
	{
		String filepath =  "D:\\Java Input\\Bundles Files\\HC_Bundles.txt";
		String file_name = "HC_Bundles.txt";
		
		ArrayList<ArrayList<Integer>> bundles = readBundles (filepath, file_name);
		printBundles(bundles);
	}
	
	public static void printBundles (ArrayList<ArrayList<Integer>> bundles)
	{
		System.out.println ("Bundles are : ");
		for (int i=0; i<bundles.size(); i++)
		{
			System.out.println (bundles.get(i));
		}
	}

}
