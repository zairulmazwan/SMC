package GSA;
import java.io.BufferedReader;
import java.io.FileReader;

public class Read_Parameter {
	
	public static void main (String [] args)
	{
		double [][] gsa_para = GSA_parameters ();
		print_array (gsa_para);
		
		
	}
	
	public static double [][] GSA_parameters ()
	{
		double [][] para = null;
		
		//String file = "D:\\Java Output\\NewtonRaphson_TSP_GSA\\newton_raphson_para.txt";
		String file = "C:\\Zairul Mazwan\\Java Input\\Newton Raphson Para - GSA\\newton_raphson_para_Dist.txt";
		//String file = "D:\\Java Input\\newton_raphson_para.txt";
		int row = 0;
		int col = 0;
		String line = null;
		
		try
		{
			FileReader fr = new FileReader (file);
			BufferedReader br = new BufferedReader (fr);
			
			while ((line = br.readLine()) != null)
			{
				row++;
				String [] columns = line.split(" ");
				col = columns.length;
			}
			
			para = new double [row][col];
			fr = new FileReader (file);
			br = new BufferedReader (fr);
			int i=0;
			int j=0;
			
			while ((line = br.readLine()) != null)
			{
				String [] value = line.split(" ");
				
				for (j=0; j<col; j++)
				{
					para [i][j] = Double.parseDouble(value [j]);
					//System.out.println (value [j]);
				}
				i++;
			}
			
			
		}
		catch (Exception e)
		{
			System.out.println("+++ReadArrayFile: "+e.getMessage());
		}
		
		return (para);
	}
	
	public static void print_array (double [][] x )
	{
		
		System.out.println();
		
		for(int i=0;i<x.length;++i)
		{
			for(int j=0;j<x[i].length;++j)
			{
				System.out.print(x[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
