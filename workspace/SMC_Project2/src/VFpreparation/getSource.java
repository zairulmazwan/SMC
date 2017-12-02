package VFpreparation;

public class getSource {
	
	
		public static String getData ()
		{
			String dataFile = "C:\\Zairul Mazwan\\Java Input\\VF Moorfield Raw Data\\Moorefield Raw Data - Reclassified.csv"; //personal laptop
			//String dataFile = "C:\\Zairul Mazwan\\Java Output\\Data\\Moorefield_RawData - Balanced Classes.csv";
			//String dataFile = "D:\\Zairul Documents\\Java Programs\\Data\\Moorefield VF.csv";
			//String dataFile = "D:\\Zairul Documents\\Java Programs\\Data\\Moorefield_RawData - Balanced Classes.csv";
			//String dataFile = "D:\\Zairul Documents\\Java Programs\\Data\\Moorefield Raw Data - Reclassified.csv";
			//String dataFile = "D:\\Zairul Documents\\Java Programs\\Data\\Moorefield_RawData - Balanced Classes 2.csv";
			return dataFile;
		}

		
		public static String writeDataPath (int i)
		{
			String dataFile = "C:\\Zairul Mazwan\\Java Output\\Moorefield\\VF_Data_"+i+".txt"; 
			return dataFile;
		}
		
		public static String writeBundlePath (String model)
		{
			//String dataFile = "C:\\Zairul Mazwan\\Java Output\\Moorefield\\Simultaneous_Modeling_Project1\\VFBundle_File_"+model+".txt";
			String dataFile = "D:\\Java Output\\Moorefield\\Simultaneous Modelling Project 1\\VFBundle_File_"+model+".txt";
			return dataFile;
		}
		
		public static String writeCurrentPatient (int i)
		{
			//String dataFile = "C:\\Zairul Mazwan\\Java Output\\Moorefield\\CurrentPatient\\CurrentPatient_"+i+".txt";
			String dataFile = "D:\\Java Output\\Moorefield\\Current Patient\\CurrentPatient_"+i+".txt";
			return dataFile;
		}
		
		public static String write52VF (int i)
		{
			
			//String dataFile = "C:\\Zairul Mazwan\\Java Output\\Moorefield\\VF_52\\VF_52_"+i+".txt";
			String dataFile = "C:\\Zairul Mazwan\\Java Output\\RRHC_SameSampledData\\VF52\\VF_52_"+i+".txt";
			
			
			return dataFile;
		}
	}



