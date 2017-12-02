package Sampled_Data;


import java.util.Random;

public class RegisterVF {
	
	public static double [][] regVF (int currentRow, int noRecord, double [][] patientVF)
	{
			
		double [][] regPatientVF = new double [noRecord][patientVF[0].length];
		int firstRow = currentRow-noRecord; 
		
		//System.out.println("Current row is : "+currentRow);
		//System.out.println("Current record is : "+noRecord);
		//System.out.println("currentRow-(noRecord+1)==0 is : "+(currentRow-(noRecord+1)));
		
		if (currentRow==6) // to get the very first record in raw data
		{
			regPatientVF = new double [noRecord+1][patientVF[0].length];
			
			for (int i=0; i<(noRecord+1); i++)
			{
				//System.out.println(i);
				for (int j=0; j<patientVF[0].length; j++) 
				{
					//System.out.println(j);
					//System.out.println("patientVF[0].length is : "+patientVF[0].length);
					regPatientVF [i][j]=patientVF[i][j];
				}
			}
			
			//ReadFile.PrintArray(regPatientVF);
		}
		
		else // get the remaining record in raw data for each patients
		{
			for (int i=0; i<noRecord; i++)
			{
				for (int j=0; j<patientVF[i].length; j++) 
				{
					regPatientVF [i][j]=patientVF[firstRow][j];
				}
			
				firstRow++;
			}
		}
		
		return regPatientVF;
	}
	
	public static int randPos (double [][] currentPatient)
	{
		Random rand = new Random();
		int randPost;
		int record = currentPatient.length;
		
		//System.out.println("Current no. of patient record is : "+record);
		
		if (record==2)
		{
			randPost=0;
		}
		else
			{
				randPost = Math.abs(rand.nextInt()%(record-1));
				//System.out.println("Randpost value is : "+randPost);
		
				if (randPost==record)
					{
						randPost = Math.abs(rand.nextInt()%(record-1));
					}
			}
		
		//System.out.println("Position picked  in the array is : "+randPost);
		return randPost;
	}
	
	public static double [] pickRandVF (double [][] currentPatient, int randPost)
	{
		
		double [] randVF = new double [currentPatient[0].length];
		//System.out.println("Position picked  in the array is : "+randPost);
					
				for (int j=0; j<currentPatient[0].length; j++)
				{
					randVF [j] = currentPatient [randPost][j];
				}
			
		//PrintSingleArray(randVF);
		return (randVF);
		
	}
	
	public static double pickAGIS (double [][] currentPatient, int position)
	{
		double agis; 
		int agisPos = position+1;
		
		//System.out.println ("AGIS record position selected is : "+agisPos);
		
		agis = currentPatient [agisPos][53];
		
		return agis;
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
	
	public static double [][] regVFData (int counter, double [][] VF, double [] currentPatient, double agis, int randPost, int noRecord)
	{
		
		double [][] VFData = VF;
		counter = counter-1;
		
		//System.out.println("VF to be registed in fina array VF data is : ");
		//PrintSingleArray(currentPatient);
		//System.out.println ("currentPatient.length-2 is : "+((currentPatient.length)-2));
		
		for (int j=0; j<currentPatient.length-1; j++)
		{
			VFData [counter][j]=currentPatient[j];
		}
		 
		VFData [counter][53]=agis;
		VFData [counter][54]=randPost;
		VFData [counter][55]=noRecord;
		//System.out.println("AGIS values registred in final VF data is : "+VFData [i][53]);
		
		return VFData;
	}
	
	public static double [][] VF6Sector (double [][] vf)
	{
		double [][] vf6 = new double [vf.length][6];
		
		double b1=0,b2=0,b3=0,b4=0,b5=0,b6=0;
		
		//System.out.println ("vf6 [0][26] is : "+vf6 [0][6]); // error here!!
		//System.out.println ("vf [0] length is : "+vf[0].length); 
		//System.out.println ("vf [0][1] is : "+vf[5][1]);
		
		
		for (int i=0; i<vf.length; i++)
		{
			for (int j=1; j<53; j++)
			{
				int bundle = j;
				
				
				//bundle 1
				if (bundle>=1 && bundle <=5 || bundle == 17 || bundle == 9 || bundle == 10)
				{
					b1 = b1 + vf[i][bundle];
					//System.out.println ("B1 is : "+b1);
				
				}
				//bundle 2
				else if (bundle >=6 && bundle <=8 || bundle >= 11 && bundle <=16 || bundle >=19 && bundle <= 22)
				{
					b2 = b2 +  vf[i][bundle];
					//System.out.println ("B2 is : "+b2);
				}
				//bundle 3
				else if (bundle == 18 || bundle == 26 || bundle == 34 || bundle == 42)
				{
					b3 = b3 +  vf[i][bundle];
					//System.out.println ("B3 is : "+b3);
				}
				//bundle 4
				else if (bundle >= 23 && bundle <= 25 || bundle >= 31 && bundle <= 33)
				{
					b4 = b4 +  vf[i][bundle];
					//System.out.println ("B4 is : "+b4);
				}
				//bundle 5
				else if (bundle == 27 || bundle == 35 || bundle == 41 || bundle == 43 || bundle == 44 || bundle >= 47 && bundle <= 52)
				{
					b5 = b5 +  vf[i][bundle];
					//System.out.println ("B5 is : "+b5);
				}
				//bundle 6
				else if (bundle >= 28 && bundle <= 30 || bundle >= 36 && bundle <= 40 || bundle == 45 || bundle == 46)
				{
					b6 = b6 +  vf[i][bundle];
					//System.out.println ("B6 is : "+b6);
				}
				else
				{
					System.out.println ("current i and j are : "+i +" " +j);
					System.out.println ("Location 26 and 35 are the blind spot");
				}
				
				System.out.print ("i is : "+i +" ");
				System.out.println ("j is : "+j);
				System.out.println ("B1: "+b1 +" " +"B2: "+b2 +" " +"B3: "+b3 +" " +"B4: "+b4 +" " +"B5: "+b5 +" " +"B6: "+b6);
				
				//System.out.println ("vf6.length is : "+vf6.length);
				//System.out.println ("vf6[0].length is : "+vf6[0].length);
				
				for (int k=0; k<vf6.length; k++)
				{
					for (int l=0; l<vf6[0].length; l++)
					{
						
						if (l==0)
						{
							vf6 [k][l] = b1; 
						}
						else if (l==1)
						{
							vf6 [k][l] = b2; 
						}
						else if (l==2)
						{
							vf6 [k][l] = b3; 
						}
						else if (l==3)
						{
							vf6 [k][l] = b4; 
						}
						else if (l==4)
						{
							vf6 [k][l] = b5; 
						}
						else if (l==5)
						{
							vf6 [k][l] = b6; 
						}
						else 
						{
							System.out.println ("Error registering VF6 to array");
						}
						
					}
				}
				
			}
			
		}
		
		
		return vf6;
	}
	
	static public void PrintSingleArray (double x [])
	{
		//System.out.println("Picked array record is : ");
		for (int i=0; i<x.length; i++)
		{
			System.out.print(x[i] +" ");
		}
		System.out.println();
	}
	

}
