package VFSix_Bundles;
import java.util.ArrayList;

public class Main_SixBundles {
	
	public static void main (String [] args)
	{
		int cluster = 6;
				
		ArrayList<ArrayList<Integer>> VFCluster = getClusters.getCluster(cluster);
		getClusters.printCluster(VFCluster);
		
	}

}
