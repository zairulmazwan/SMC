package Sampled_Data;

public class Sampling_Patient {
	

/*
 This class returns an array of 52 visual field data record. The raw data is passed to this class to be read each record of the data and identify how many record
 each patient has. From each patient's records (which is registered to a temporary array), a single record (not the last record) is to be picked and register into
 a final visual field array. 
 */
	
	public static double [][] searchPatient (double [][] patient)
	{
		double [][] patientVF=patient;
		double [][] currentPatient;
		double [][] VFData= new double [1580][56]; //final VF52 data to be prepared
		int row=0;
		int counter=0;
		
		
		for (int i=0; i<patientVF.length; i++)  //loop to read each row of the raw data 
		{
			double currentPID = patientVF[i][0]; //to get the current patient record read at current iteration
			double nextPID = 0.0;
			//System.out.println ("Current patient ID is : "+currentPID);
			
			if (i<patientVF.length-1) //to avoid error of reading the record
			{
			nextPID = patientVF[i+1][0]; //define next record which patient ID it refers
			//System.out.println ("Next patient ID is : "+nextPID);
			
				if (currentPID == nextPID) //if the current PID is the same with next PID, means it is the another record of the same patient
				{
					row++; //to count number of record for visit for the specific patient
					
				}
						
				
				if (currentPID != nextPID) //if the current PID is not the same with next PID, means it is the another record of other patient, the this is to register all patient records into an array
				{
					counter++; // to count a record for each patient
					//System.out.println ("counter is " +counter);
					//System.out.println ("Max of row for " +currentPID +" is " +row);
					//System.out.println ("Current iteration is " +(i+1));
					currentPatient = RegisterVF.regVF((i+1), row, patient); //to register patient VF record individually
					//RegisterVF.PrintArray(currentPatient);
					
					//ReadFile.writeCurrentPatient(currentPatient, i); // to get each patient record and write it into a file - becareful this method writes a file for each iteration
					
					int randPost = RegisterVF.randPos(currentPatient); // to get random position in patient record
					double [] patientVFrecord = RegisterVF.pickRandVF(currentPatient, randPost); // to get the record of VF from the random position
					//RegisterVF.pickAGIS(currentPatient, randPost);
					double agis = RegisterVF.pickAGIS(currentPatient, randPost); // to get AGIS value from n+1 patient record
					//System.out.println("AGIS value is : "+agis);
					//System.out.println();
					 
					VFData = RegisterVF.regVFData(counter, VFData, patientVFrecord, agis, randPost, row); //to register the selected VF to final array VF data 
					row=1; //to set row becomes 1 for next patient record reading
				}
				
				//System.out.println ("patientVF.length is " +patientVF.length);
				
				if ((i+1) == patientVF.length-1) //for reading the last record of the raw data
				{
					counter++;
					//System.out.println ("counter is " +counter);
					//System.out.println ("i is " +(i+1));
					//System.out.println ("Max of row for " +currentPID +" is " +row);
					//System.out.println ("Current iteration is " +(i+1));
					currentPatient = RegisterVF.regVF((i+2), row, patient); //to register patient VF record individually
					//RegisterVF.PrintArray(currentPatient);
					
					//ReadFile.writeCurrentPatient(currentPatient, i); // to get each patient record and write it into a file - becareful this method writes a file for each iteration
					
					int randPost = RegisterVF.randPos(currentPatient); // to get random position in patient record
					double [] patientVFrecord = RegisterVF.pickRandVF(currentPatient, randPost);
					double agis = RegisterVF.pickAGIS(currentPatient, randPost); // to get AGIS value from n+1 patient record
					//System.out.println("AGIS value is : "+agis);
					VFData = RegisterVF.regVFData(counter, VFData, patientVFrecord, agis, randPost, row); //to register the selected VF to final array VF data 
					
				}
			
				
			}
			
			//System.out.println ("i is " +i);
		}
		
		System.out.println("No. of record is : "+VFData.length);
		System.out.println("No. of variables is : "+VFData[0].length);
		return VFData;
	}

}
