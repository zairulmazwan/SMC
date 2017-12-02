package Data_Retrieval;

public class Prepare_PatientData {
	
			
		public static double [][] getAllData (double [][] rawData)
		{
			double [][] allPatientData = new double [13738][54];
			double [][] curPatientData = null;
			int patientCounter=0;
			int recordCounter=0;
			int sumRecord =0;
			
			for (int i=0; i<rawData.length; i++)
			{
				double curPID = rawData [i][0];
				//System.out.println ("i  is : "+i);
				
				if (i+1<rawData.length) // to all all row except the last patient record
				{
					double nextPID = rawData [i+1][0];
					
					if (curPID == nextPID)
					{
						recordCounter++;
					}
					
					if (curPID != nextPID) // this does not apply to the last patient record. Will go to the next if condition for the last patient record. 
					{
						recordCounter += 1;
						//System.out.println ("Current patient is : "+curPID);
						//System.out.println ("No. of current patient record is : "+recordCounter);
						patientCounter++;
						curPatientData = registerPatientRecord (rawData, i, recordCounter, curPID);
						//System.out.println ("Length of record is : "+curPatientData.length);
						//ReadFile.PrintArray(curPatientData);
						int record = curPatientData.length;
						allPatientData = regAllPatient (allPatientData, curPatientData, i, sumRecord);
						sumRecord += record;
						//ReadFile.PrintArray(allPatientData);
						recordCounter=0;
						
					}
					
					if (i+1 == rawData.length-1) // to take into account the last record in the data
					{
						recordCounter++;
						//System.out.println ("Current patient is : "+curPID);
						//System.out.println ("No. of current patient record is : "+recordCounter);
						curPatientData = registerPatientRecord (rawData, (i+1), recordCounter, curPID);
						int record2 = curPatientData.length;
						
						//System.out.println ("Length of record is : "+curPatientData.length);
						//ReadFile.PrintArray(curPatientData);
						allPatientData = regAllPatient (allPatientData, curPatientData, i, sumRecord);
						sumRecord += record2;
						//ReadFile.PrintArray(allPatientData);
					}
					
				}
				//System.out.println ();
				//System.out.println ("PID is : "+curPID);
			}
			System.out.println ("Length of row of raw data is : "+allPatientData.length);
			System.out.println ("Number of record is : "+sumRecord);
			System.out.println ("No. of patient in data is : "+patientCounter);
			
			//System.out.println ("Length of col is : "+rawData[0].length);
			
			return allPatientData;
		}
		
		public static double [][] registerPatientRecord (double [][] rawData, int i, int recordCounter, double curPID)
		{
			double [][] curPatientRecord = new double [recordCounter-1][54];
			int firstIndex = (i-recordCounter)+1;
			
			//System.out.println ("curPID is : "+curPID);
			
			for (int j=0; j<(recordCounter-1); j++)
			{
				//System.out.println ("(recordCounter-1) is : "+(recordCounter-1));
				for (int k=0; k<rawData[k].length-1; k++)
				{
					curPatientRecord [j][k] =  rawData [firstIndex+j][k];
					int agisindex = firstIndex+j;
					curPatientRecord [j][53] =  rawData [agisindex+1][53];
				}
				//System.out.println ();
			}
			
			return curPatientRecord;
		}
		
		public static double [][] regAllPatient (double [][] allPatient, double [][] curPatient, int i, int sumRecord)
		{
			double [][] patient = allPatient;
			
			//System.out.println ("summed record is : "+sumRecord);
			//System.out.println ("record is : "+curPatient.length);
			//System.out.println ("record column is : "+curPatient[0].length);
			
			//ReadFile.PrintArray(curPatient);
			
			if (i == 5)
			{
				//System.out.println ("This is performed");
				for (int k=0; k<curPatient.length; k++) // chek at the length
				{
					for (int j=0; j<curPatient[0].length; j++)
					{
						patient [k][j] = curPatient[k][j];
					}
				}
			}
			else
			{
				//int firstIndex = (i-curPatient.length);
				//System.out.println ("i is : "+i);
				//System.out.println ("summed record 2 is : "+sumRecord);
				//System.out.println ("curPatient.length is : "+curPatient.length);
				//ReadFile.PrintArray(curPatient);
				
				for (int k=0; k<curPatient.length; k++)
				{
					for (int j=0; j<curPatient[0].length; j++)
					{
						patient [sumRecord][j] = curPatient[k][j];
					}
					sumRecord++;
				}
				
			} 
			
			return patient;
		}
		
		public static double [][] rereadPatient (double [][] patient) //initial VFdata consists of 13738 rows, this method to reread the array and gets 12159 record only.
		{
			double [][] patientVF = new double [12159][54];
			
			for (int i=0; i<12159; i++)
			{
				for (int j=0; j<patient[0].length; j++)
				{
					//System.out.print(patient[i][j]);
					//System.out.print(" ");
					patientVF [i][j] = patient [i][j];
				}
				//System.out.println();
			}
			return patientVF;
			//System.out.println("row " +patient);
		}
		
		public static double [][] allPatientVFData (double [][] rawData)
		{
			double [][] finalData = null;
			
			finalData = getAllData(rawData);
			finalData = rereadPatient (finalData);
			
			return finalData;
		}

	}

