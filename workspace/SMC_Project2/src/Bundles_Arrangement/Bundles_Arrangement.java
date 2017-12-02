package Bundles_Arrangement;

import java.util.ArrayList;
import java.util.Random; 

import Random_Bundles.Bundles_Creation;


public class Bundles_Arrangement {
	
	static Random rand = new Random (System.nanoTime());
	//static Random rand = new Random (System.currentTimeMillis());
	

		public static int clusterFrom (ArrayList<ArrayList<Integer>> VFCluster) // to get the index of cluster to be picked
		{
			int size = VFCluster.size();
			//Random rand = new Random ();
			
			int ClusterFrom = Math.abs (rand.nextInt()%size);
			
			return ClusterFrom;
		}
		
		public static int clusterTo (ArrayList<ArrayList<Integer>> VFNewCluster) // to get the index of cluster to be replaced
		{
			int size = (VFNewCluster.size()+1); //+ 1 is for the possibility to get a new cluster
			//Random rand = new Random ();
			
			int clusterTo = Math.abs (rand.nextInt()%size);
			
			return clusterTo;
		}
		
		public static ArrayList<Integer> getClusterFrom (ArrayList<ArrayList<Integer>> VFCluster, int ClusterFrom) // to get the cluster 
		{
			ArrayList<Integer> getClusterFrom = new ArrayList<Integer> ();
			getClusterFrom = VFCluster.get(ClusterFrom);
			return getClusterFrom;
		}
		
		/*public static ArrayList getClusterTo (ArrayList<ArrayList<Integer>> VFCluster, int clusterTo) //to get the cluster 
		{
			ArrayList<Integer> getClusterTo = new ArrayList<Integer> ();
			getClusterTo = VFCluster.get(clusterTo);
			return getClusterTo;
		}*/
		
		public static ArrayList<ArrayList<Integer>> newArrangement (ArrayList<ArrayList<Integer>> VFNewCluster)
		{
			
			ArrayList<ArrayList<Integer>> currentClusterA = (ArrayList<ArrayList<Integer>>) VFNewCluster.clone();
			ArrayList<ArrayList<Integer>> VFNewClusterA = (ArrayList<ArrayList<Integer>>) VFNewCluster.clone();
			
			ArrayList<Integer> clusterFrom = new ArrayList<Integer> ();
			int VFNewClusterSize = VFNewClusterA.size();
			int indexFrom = clusterFrom (currentClusterA); //get the index for a cluster from
			int indexTo = clusterTo (VFNewClusterA); //get the index for a cluster to
			
			clusterFrom = getClusterFrom (currentClusterA, indexFrom); // get the cluster from
			//System.out.println ("CLuster from size is : "+clusterFrom.size());
			//System.out.println ("CLuster from is : "+clusterFrom);
			int randElement = Math.abs((rand.nextInt(clusterFrom.size()))); // to get a random index to pick element from the cluster
			int elementFrom = clusterFrom.get(randElement); // to get the element (VF point from the selected cluster)
			
			
			//System.out.println ("index from is : "+indexFrom);
			//System.out.println ("index to is : "+indexTo);
			//System.out.println ("Selected element is : "+elementFrom);
			//System.out.println ("VFNewClusterSize to is : "+VFNewClusterSize);
			
			
			if (indexTo > (VFNewClusterSize-1)) // to add the element to a new cluster
			{
				ArrayList<Integer> newCluster = new ArrayList<Integer> (); // create a new cluster
				newCluster.add(elementFrom); // adding chosen element (VF point) into the new created cluster
				VFNewClusterA.add(newCluster); // adding the cluster into the cluster
				VFNewClusterA.get((indexFrom)).remove(randElement); // to delete the old element from the old index
				Bundles_Creation.deleteEmptyC(VFNewClusterA);
			}
			else
			{
				VFNewClusterA.get(indexTo).add(elementFrom); 
				//System.out.println("New cluster before remove element is : "+VFNewClusterA);
				VFNewClusterA.get(indexFrom).remove(randElement);
				Bundles_Creation.deleteEmptyC(VFNewClusterA);
				
			}
			//System.out.println("New cluster is : "+VFNewClusterA);
			return VFNewClusterA;
			
		}

		
		
		public static ArrayList<ArrayList<Integer>> newArrangementGSA (ArrayList<ArrayList<Integer>> VFNewCluster, int visit)
		{
			ArrayList<ArrayList<Integer>> currentClusterA = Bundles_RandomCreation.cloneArrayList(VFNewCluster);
			ArrayList<ArrayList<Integer>> VFNewClusterA = Bundles_RandomCreation.cloneArrayList(VFNewCluster);
			
			for (int i=0; i<visit; i++)
			{
				//Random rand = new Random ();
				ArrayList<Integer> clusterFrom = new ArrayList<Integer> ();
				int VFNewClusterSize = VFNewClusterA.size();
				int indexFrom = clusterFrom (currentClusterA); //get the index for a cluster from
				int indexTo = clusterTo (VFNewClusterA); //get the index for a cluster to
				
				clusterFrom = getClusterFrom (currentClusterA, indexFrom); // get the cluster from
				//System.out.println ("CLuster from size is : "+clusterFrom.size());
				//System.out.println ("CLuster from is : "+clusterFrom);
				int randElement = Math.abs((rand.nextInt(clusterFrom.size()))); // to get a random index to pick element from the cluster
				int elementFrom = clusterFrom.get(randElement); // to get the element (VF point from the selected cluster)
			
				//System.out.println ("index from is : "+indexFrom);
				//System.out.println ("index to is : "+indexTo);
				//System.out.println ("Selected element is : "+elementFrom);
				//System.out.println ("VFNewClusterSize to is : "+VFNewClusterSize);
				
				
				if (indexTo > (VFNewClusterSize-1)) // to add the element to a new cluster
				{
					ArrayList<Integer> newCluster = new ArrayList<Integer> (); // create a new cluster
					newCluster.add(elementFrom); // adding chosen element (VF point) into the new created cluster
					VFNewClusterA.add(newCluster); // adding the cluster into the cluster
					VFNewClusterA.get((indexFrom)).remove(randElement); // to delete the old element from the old index
					Bundles_Creation.deleteEmptyC(VFNewClusterA);
				
				}
				else
				{
					VFNewClusterA.get(indexTo).add(elementFrom); 
					//System.out.println("New cluster before remove element is : "+VFNewClusterA);
					VFNewClusterA.get(indexFrom).remove(randElement);
					Bundles_Creation.deleteEmptyC(VFNewClusterA);
					
				}
				//System.out.println("New cluster is : "+VFNewClusterA);
				
				currentClusterA = Bundles_RandomCreation.cloneArrayList(VFNewClusterA); //to copy the whole set the changes made in the bundles to the current bundles 
				
			}
			
			return VFNewClusterA;
		}
	}

