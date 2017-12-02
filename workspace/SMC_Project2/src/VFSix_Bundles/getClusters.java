package VFSix_Bundles;
import java.util.ArrayList;

public class getClusters {
		
		public static ArrayList<ArrayList<Integer>> getCluster (int noCluster) //create VF cluster
		{
			ArrayList<ArrayList<Integer>> VFCluster = new ArrayList<ArrayList<Integer>> (noCluster);
					
			for (int i=0; i<noCluster; i++)
			{
				Six_Bundles.setBundleArrayList(i, VFCluster);
			}
					
			return VFCluster;
		}
		
		
		
		public static void printCluster (ArrayList<ArrayList<Integer>> Cluster)
		{
			int noCluster = Cluster.size();
			//ArrayList<ArrayList<Integer>> Cluster = getCluster (noCluster);
			
			//System.out.println(Cluster);	
			
			for (int i=0; i<Cluster.size(); i++)
			{		
				System.out.println("Bundle "+(i+1) +" is ");
				System.out.println(Cluster.get(i));
				System.out.println("Cluster size is : "+Cluster.get(i).size());
				System.out.println();	
			}
			
		}
		
		
	}

