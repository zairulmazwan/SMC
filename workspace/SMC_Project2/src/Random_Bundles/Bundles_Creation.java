package Random_Bundles;
import java.util.ArrayList;
import java.util.Random;

public class Bundles_Creation {
	
		public static int genRandomCluster ()
		{
			Random rand = new Random ();
			int min_range = 2;
			int max_range = 52;
			int range = (max_range - min_range)+1;
			
			int rand_cluster = Math.abs(rand.nextInt(range)+min_range); // to get a random number starting from 2 to 52
			System.out.println ("Random number generated is : "+rand_cluster);
			
			//ArrayList<ArrayList<Integer>> cluster = new ArrayList<ArrayList<Integer>> ();
			
			return rand_cluster;
		}
		
		public static ArrayList createEmptyCluster (int randNo) //randNo is number of cluster
		{
			ArrayList<ArrayList<Integer>> cluster = new ArrayList<ArrayList<Integer>> (randNo); // create an empty cluster 
					
			for (int i=0; i<randNo; i++)
			{
				ArrayList<Integer> VFElement = new ArrayList<Integer> (); //add a VF bundle in arraylis<arraylist>
				cluster.add(VFElement);
			}
			
			System.out.println ("cluster size is : "+cluster.size());
			return cluster;
		}
		
		public static void addElement (ArrayList<ArrayList<Integer>> VFCluster) // randomly adds VF point into a random chosen cluster
		{
			int size  = VFCluster.size();
			//System.out.println ("cluster size is : "+size);
			Random rand = new Random ();
			
			for (int i=1; i<53; i++)
			{
				int seletectedCluster = Math.abs(rand.nextInt()%size);
				VFCluster.get(seletectedCluster).add(i);
			}
		}
		
		public static void deleteEmptyC (ArrayList<ArrayList<Integer>> VFCluster) // to delete empty clusters
		{
			int size  = VFCluster.size();
			//System.out.println ("cluster size is : "+size);
			ArrayList<Integer> arrayRemove = new ArrayList<Integer> ();
					
			for (int i=0; i<size; i++) // to find empty cluster and register it to an arrayList
			{			
				if (VFCluster.get(i).isEmpty()==true)
				{
					//System.out.println ("i is : "+i);
					//System.out.println ("cluster is : "+VFCluster.get(i));
					arrayRemove.add(i);
					
					}
				}
			
			//System.out.println ("Arraylist to be removed is : "+arrayRemove);
			
			for (int i=0; i<arrayRemove.size(); i++) // to delete the clusters from the cluster which registered in the arrayList  
			{
				int j = arrayRemove.get(i);
				//System.out.println ("J is : "+j);
				//System.out.println ("VFCluster current size is : "+VFCluster.size());
				j = j-i;
				VFCluster.remove(j);
				//System.out.println ("J-i is : "+j);
				//VFCluster.remove(j);
				
			} 
		}
		
		public static  ArrayList<ArrayList<Integer>> cloneArrayList (ArrayList<ArrayList<Integer>> currentCluster)
		{
			
			ArrayList<ArrayList<Integer>> NewCluster = new ArrayList<ArrayList<Integer>> ();
			int size  = currentCluster.size();
			//System.out.println ("Size is : "+size);
			
			for (int i=0; i<size; i++)
			{
				ArrayList<Integer> inner = new ArrayList<Integer> ();
				ArrayList<Integer> innerB = new ArrayList<Integer> ();
				inner = (ArrayList<Integer>) currentCluster.get(i).clone();
				
				NewCluster.add(inner);
			}
			
			return NewCluster;
		}

		public static ArrayList<ArrayList<Integer>> initialCluster (ArrayList<ArrayList<Integer>> iniCluster)
		{
			int rn =  genRandomCluster (); // get a random number for the outer arraylist cluster
			iniCluster = createEmptyCluster(rn); // create an empty cluster for the number of random number
			//System.out.println(iniCluster);
			addElement(iniCluster); // adds 52 VF points to a random clusters
			System.out.println(iniCluster);
			deleteEmptyC(iniCluster); // delete empty clusters if any
			System.out.println("Final cluster's size is : "+iniCluster.size());
			
			return iniCluster;
		}
	}

