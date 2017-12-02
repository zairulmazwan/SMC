package VFpreparation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

		public static double [][] ReadFileArray (String filename, String sep)
		{
			double [][] arrayFile=null;
			
			try
			{
				FileReader reader = new FileReader (filename);
				BufferedReader input = new BufferedReader (reader);
				
				String line=null;
				int row=0, col=0;
				
				while ((line = input.readLine())!= null) // this is just to get number of columns and rows
						{
							row++;
							String[] columns = line.split(sep);
							col = columns.length;
							//System.out.println( Arrays.toString(columns));
						}
				
				//System.out.println ("No of row is (when read raw data) : "+row);
				//System.out.println ("No of col is (when read raw data) : "+col);
				//System.out.println ();
				
				
				int i=0, j=0;
				arrayFile = new double [row][col];
				input = new BufferedReader(new FileReader(filename));
				
				while ((line = input.readLine())!=null)
				{
					String [] columns = line.split(sep); //register all values of first line found in the file into 1D array
					
					for (j=0; j<columns.length; j++)
					{
						arrayFile [i][j]=Double.parseDouble(columns[j]);
					}
					
					i++;
				}
				
			}
			catch(Exception E)
			{
				System.out.println("+++ReadArrayFile: "+E.getMessage());
			}
			
			//System.out.println( Arrays.toString(arrayFile));
			return (arrayFile);
		}
		
		
		static public void PrintArray(double x[][])
		{
					
			for(int i=0;i<+x.length;++i)
			{
				for(int j=0;j<x[i].length;++j)
				{
					System.out.print(x[i][j]);
					System.out.print(" ");
				}
				System.out.println();
			}
			
			System.out.println ("No. of col is : "+x[0].length);
			System.out.println ("No. of row is : "+x.length);
		}
		
		public static void write52VF (double [][] x, int i) 
		{
			String fn = getSource.write52VF(i);
			
			try
			{
			FileWriter writehandle = new FileWriter(fn);
			BufferedWriter bw = new BufferedWriter (writehandle);
			
			
			bw.write("Patient_ID");
			bw.write(" "); 
			
			for (int k=1; k<55; k++)
			{
				
			if (k==26 || k==35)
				{
					k++;
				}
			bw.write("VF_"+k); 
			bw.write(" ");
			}
			bw.write("AGIS(n+1)"); 
			bw.write(" "); 
			bw.write("AuditTrail_RandomPost"); 
			bw.write(" "); 
			bw.write("AuditTrail_NoRecord"); 
			bw.write(" "); 
			bw.newLine(); 
			
			for (int j=0; j<x.length; j++)
			{
				for (int k=0; k<x[0].length; k++)
				{
					String r = Double.toString(x[j][k]); 
					bw.write(r); 
					bw.write(" ");
				}
				bw.newLine(); 
			}
			
			bw.close();
			writehandle.close();
			}
			catch (IOException e) 
			{
		        System.err.println("Problem writing to the file");
			}
		}
		
		
		public static void writeBundle (double [][] vfBundle, String model, ArrayList<ArrayList<Integer>> VFCluster) 
		{
			
			String fn = getSource.writeBundlePath(model);
			int clusterSize = VFCluster.size();
			
			try
			{
				FileWriter f = new FileWriter (fn);
				BufferedWriter bw = new BufferedWriter (f);
			
				bw.write("Patient_ID");
				bw.write(" "); 
			
				for (int k=1; k<clusterSize+1; k++)
				{
					bw.write("VF_Bundle_"+k);
					bw.write(" ");
				}
					bw.write("AGIS_n+1");
					bw.newLine();
			
			
					for (int k=0; k<vfBundle.length; k++)
					{
						for (int j=0; j<vfBundle[0].length; j++)
						{
							String datavalue = Double.toString(vfBundle[k][j]);
							bw.write(datavalue);
							bw.write(" ");
						}
						bw.newLine(); // goes to next row for the next record
					}
			
			
					bw.close();
					f.close();
			
			}
			
			catch (IOException e) 
			{
		        System.err.println("Problem writing to the file");
			}
		}
		
		public static void writeCurrentPatient (double [][] currentPatient, int iteration)
		{
			String fn = getSource.writeCurrentPatient((iteration+1));
			//System.out.println ("No. of col is : "+currentPatient[0].length);
			try
			{
				FileWriter fw = new FileWriter (fn);
				BufferedWriter bw = new BufferedWriter (fw);
				
				bw.write("Patient_ID");
				bw.write(" "); 
				
				for (int i=0; i<currentPatient[0].length-2; i++)
				{
					bw.write("VF_"+(i+1));
					bw.write(" "); 
				}
				bw.write("AGIS_(n+1)");
				bw.newLine(); 
				
				for (int i=0; i<currentPatient.length; i++)
				{
					for (int j=0; j<currentPatient[0].length; j++)
					{
						String record = Double.toString(currentPatient[i][j]);
						bw.write(record);
						bw.write(" ");
					}
					bw.newLine();// goes to next row for the next record
				}
				
				bw.close();
				fw.close();
				
			}
			catch (IOException e) 
			{
				System.err.println("Problem writing to the file");
			}
		}
		
	}


