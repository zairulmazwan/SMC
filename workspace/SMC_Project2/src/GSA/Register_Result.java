package GSA;

public class Register_Result {
	
	public static double [][] regResult (double [][] result, int iter, int no, double curFit, double newFit, double prob, double temp, int curBundles, int newBundles, int oldV, int newV)
	{
		result [iter][0] = no;
		result [iter][0] = curFit;
		result [iter][0] = newFit;
		result [iter][0] = prob;
		result [iter][0] = temp;
		result [iter][0] = curBundles;
		result [iter][0] = newBundles;
		result [iter][0] = oldV;
		result [iter][0] = newV;
		
		return result;
	}

}
