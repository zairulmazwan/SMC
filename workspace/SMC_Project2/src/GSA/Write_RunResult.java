package GSA;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Write_RunResult {
	
		
	public static void writeRunExperiment (double [][] finalFit, double qa_para)
	{
		String path = "C:\\Zairul Mazwan\\Java Output\\VF GSA\\RunResults\\GSA_RunResult_"+qa_para+".txt";
		//String path = "D:\\Java Output\\VF GSA\\RunResult\\GSA_RunResult_"+qa_para+".txt";
		
		try
		{
			FileWriter fw = new FileWriter (path);
			BufferedWriter bw = new BufferedWriter (fw);
			
			
			bw.write("Run");
			bw.write(" ");
			bw.write("QA");
			bw.write(" ");
			bw.write("QV");
			bw.write(" ");
			bw.write("Temp");
			bw.write(" ");
			bw.write("Fitness");
			bw.write(" ");
			bw.write("Running_Time");
			bw.write(" ");
			bw.write("Conv_Point");
			bw.write(" ");
			bw.write("Best_Result");
			bw.newLine();
			
			
			for (int i=0; i<finalFit.length; i++)
			{
				double iter = finalFit[i][0];
				double qa = finalFit[i][1];
				double qv = finalFit[i][2];
				double temp = finalFit[i][3];
				double fitness = finalFit[i][4];
				double time = finalFit[i][5];
				double conv_point = finalFit[i][6];
				double bestResult = finalFit[i][7];
				
				bw.write(Double.toString(iter));
				bw.write(" ");
				bw.write(Double.toString(qa));
				bw.write(" ");
				bw.write(Double.toString(qv));
				bw.write(" ");
				bw.write(Double.toString(temp));
				bw.write(" ");
				bw.write(Double.toString(fitness));
				bw.write(" ");
				bw.write(Double.toString(time));
				bw.write(" ");
				bw.write(Double.toString(conv_point));
				bw.write(" ");
				bw.write(Double.toString(bestResult));
				bw.newLine();
				
			}
			bw.close();
			fw.close();
		}
		catch (Exception e)
		{
			   System.err.println("Problem writing GSA TSP result to the file");
		}
	}

}
