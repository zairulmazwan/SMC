package Instances_Format;
import weka.core.Attribute;
import weka.core.Instances;
import weka.core.Instance;
import weka.core.FastVector;
import weka.core.converters.ArffLoader.ArffReader;
import weka.core.converters.ConverterUtils.DataSource;
import java.util.ArrayList;

public class CreateInstances {

		public static Instances createInstances (double [][] vfData, ArrayList<ArrayList<Integer>> VFCluster)
		{
			Instances idata = null;
			int col = vfData[0].length;
			int row = vfData.length;
			if (row == 0) return(idata);
			int clusterSize = VFCluster.size();
			
			//System.out.println("no of row is : "+vfData.length);
			//System.out.println("no of col is : "+vfData[0].length);
			
			FastVector fv = new FastVector(col); //create a template to fill attributes (variables)
			
			 Attribute att = new Attribute("Patient_ID"); //add a variable using attribute method                                                           
	         fv.addElement(att); //add created variable into the template
	         
	         //System.out.println("col is : "+col);
	         
			for (int i=1; i<(clusterSize+1); i++) //creating and adding variables using for loop
			{
				att = new Attribute("VF"+(i));   //created another variables                                                       
	             fv.addElement(att); //adding the variables
			}
			
			
			FastVector nomClass = new FastVector ();
			nomClass.addElement ("0");
			nomClass.addElement ("1");
			nomClass.addElement ("2");
			//nomClass.addElement ("3");
			//nomClass.addElement ("4");
			Attribute nominal = new Attribute ("AGIS_(n+1)", nomClass);
			fv.addElement(nominal);
			
			
			Attribute string = new Attribute ("Test", (FastVector)null);
			
			//att = new Attribute("AGIS_(n+1)");                                                           
	        //fv.addElement(att);
	        
	        idata = new Instances("Bundled VF Data",fv,row); //create and insert the data template
	        
			for (int i=0; i<row; i++)
			{
				Instance current = new Instance (col);
				
				for (int j=0; j<col; j++)
				{
					current.setValue(j, vfData[i][j]);  // add each data into instances data type
				}
				idata.add(current);
			}
			
			// idata.setClass(nominal); //this is to set nominal var (AGIS+1) as the class variable
			return idata;
		}

	}
