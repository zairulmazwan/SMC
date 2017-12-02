package Sampled_Data;

import java.util.ArrayList;

import VFSix_Bundles.getClusters;
import VFpreparation.ReadFile;
import VFpreparation.form_ClusteredData;
import VFpreparation.getSource;

public class Main_Sampled_Patient {
	
	public static void main (String [] args)
	{
		String filesource = getSource.getData();
		String sep = ",";
		double [][] rawData = ReadFile.ReadFileArray(filesource, sep); //raw data
		//double [][] vf52Data = Prepare_PatientData.patientVFData(rawData); //data contains 12159 record of VF
		double [][] vf52Data = Sampling_Patient.searchPatient(rawData); //contains sampled data
		
		System.out.println();
		//RegisterVF.PrintArray(vf52Data);
		
		ArrayList<ArrayList<Integer>> cluster = getClusters.getCluster(6);
		
		double [][] VFBundled = form_ClusteredData.getData(cluster, vf52Data);
		
		System.out.println("No. of record for bundled VF is : "+VFBundled.length);
		System.out.println("No. of variables for bundled VF is : "+VFBundled[0].length);
		
	}

}
