package VFpreparation;
import weka.core.Instances;
import weka.core.Instance;
import java.util.ArrayList;
import java.util.ArrayList;

public class form_ClusteredData {
	
		public static double [][] getData (ArrayList<ArrayList<Integer>> VFCluster, double [][] VF52)
		{	
			int cluster = VFCluster.size();
			double [] summedBundle = new double [cluster];
			double [] average = new double [cluster];
			double [][] vfBundled = new double [VF52.length][cluster+2];
			
			//System.out.println("VF52.length is : "+VF52.length);
			//System.out.println("num of row is : "+VF52[0].length);
			
				
			for (int k=0; k<VF52.length; k++)
			{
				for (int j=1; j<=52; j++) //to read and calculate bundle VF each row of the record based on the clusters
				{
					for (int c=0; c<cluster; c++) // to check the VF point in every clusters
					{
						//System.out.println("Current VF location is : "+j);
						//System.out.println(VFCluster.get(c).contains(j)); //true or false
						boolean vfpoint = VFCluster.get(c).contains(j); // to check VF location which bundle it belongs (true or false)
						
						if (vfpoint == true) //if the VF point is found it is true and perform this
						{
							//System.out.println("Bundle for VF point "+j +" is "+(c+1));
							summedBundle [c] += VF52 [k][j]; //to get the VF value and add to an array for summation
							//System.out.println("Record is "+VF52 [k][j]);
							//System.out.println("");
							break; // to break the loop once the VF is found and go to find next VF point
						}
					}	
					
					//ReadFile.printSingleArray(bundle);
				}
				
				for (int i=0; i<cluster; i++) // to register each row record with patient ID, averaged bundles and AGIS
				{
					double size = VFCluster.get(i).size(); // to get the size of the cluster at i
					average [i] = summedBundle[i]/size; // to get the average of the VF for each cluster
					
					vfBundled [k][0] = VF52 [k][0]; // for patient ID
					vfBundled [k][i+1] = average [i]; // for each averaged bundles
					vfBundled [k][cluster+1] = VF52 [k][53]; // for the AGIS
					//System.out.println("vfBundled [k][i]: "+vfBundled [k][i]);
				}
				
				//System.out.println("vfBundled [k][4]: "+vfBundled [k][0]);
				//ReadFile.printSingleArray(average);
				//ReadFile.PrintArray(vfBundled);
				
				for (int i=0; i<cluster; i++) // to zerorised the average and bundle array for next row record VF calculation
				{
					summedBundle [i] = 0.0;
					average [i] = 0.0;
				}
				
				//System.out.print("average array after zerorised is : ");
				//ReadFile.printSingleArray(average);
				
			}
			//System.out.println("Cluster size is : "+cluster);
			//System.out.println("VF52 data size is : "+VF52.length);
			//getCluster.printCluster(VFCluster);
			//ReadFile.PrintArray(vfBundled);
			return vfBundled;
		}

	}

