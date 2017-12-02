package Data_Retrieval;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class ReadWrite_DataRetrieval {
	
		public static void writeAllPatient (double [][] patientVF) 
		{
			//String filepath = "C:\\Zairul Mazwan\\Java Output\\Moorefield\\Simultaneous_Modeling_Project1\\AllPatient_Data.txt";
			String filepath = "D:\\Java Output\\Moorefield\\Simultaneous Modelling Project 1\\AllPatient_Data.txt";
			
			try
			{
				FileWriter fn = new FileWriter (filepath);
				BufferedWriter bw = new BufferedWriter (fn);
				
				bw.write ("No.");
				bw.write (" ");
				bw.write("Patient_ID");
				bw.write (" ");
				
				for (int i=1; i<53; i++)
				{
					bw.write("VF_"+i);
					bw.write (" ");
				}
				bw.write (" ");
				bw.write("AGIS_(T+1)");
				bw.newLine();
				
				for (int l=0; l<patientVF.length; l++)
				{
					bw.write (Integer.toString(l));
					bw.write (" ");
					for (int c=0; c<patientVF[0].length; c++)
					{
						
						
						double record = patientVF[l][c];
						bw.write (Double.toString(record));
						bw.write (" ");
						
					}
					bw.newLine();
				}
				bw.close();
				fn.close();
			}
			catch (IOException e)
			{
				 System.err.println("Problem writing all patient data to the file");
			}
			
			
		}

	}
