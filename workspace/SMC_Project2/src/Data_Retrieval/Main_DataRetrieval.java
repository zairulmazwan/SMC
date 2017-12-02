package Data_Retrieval;
import VFpreparation.getSource;
import VFpreparation.ReadFile;

public class Main_DataRetrieval {
	
	public static void main (String [] args)
	{
		String filesource = getSource.getData();
		String sep = ",";
		double [][] rawData = ReadFile.ReadFileArray(filesource, sep);
		double [][] vfData = null;
		//ReadFile.PrintArray(rawData);
		//vfData = Prepare_ReadPatient.getAllData(rawData);
		//vfData = Prepare_ReadPatient.rereadPatient (vfData);
		//ReadFile.PrintArray(vfData);
		//ReadWrite_AllPatientData.writeAllPatient(vfData);
		vfData = Prepare_PatientData.allPatientVFData(rawData);
	}

}


	
	


