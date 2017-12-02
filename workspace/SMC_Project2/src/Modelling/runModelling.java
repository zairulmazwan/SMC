package Modelling;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.FastVector;
import weka.core.Instances;

public class runModelling {
	
	public static double modellingAccuracy (Instances iData, Classifier model, String modelName, int fold) throws Exception
	{	
		FastVector prediction = new FastVector();
		Instances [][] split = Classification.crossValidation(iData, fold);
		Instances [] trainingSplit = split [0];
		Instances [] testSplit = split [1];
				
		//System.out.println("TrainingSplit size is : "+testSplit.length);
		//System.out.println("TrainingSplit size is : "+trainingSplit.length);
		
		//System.out.println("testSplit[0] is : "+testSplit[0]);
		//System.out.println("TrainingSplit size is : "+trainingSplit.length);
		//System.out.println();
		
		//double [][] result = new double [fold][2];
		double sumAccuracy = 0;
		double accuracy = 0;
		
		for (int i=0; i<fold; i++)
		{
			//System.out.println("Iteration "+i);
			//System.out.println("Model is : "+classifier);
			Evaluation validation = Classification.classify(model, trainingSplit[i], testSplit[i]);
			prediction.appendElements(validation.predictions());
			//System.out.println(model.toString());
			accuracy = Classification.calAccuracy(prediction);
			sumAccuracy += accuracy;
			//System.out.println("Accuracy of model "+model.getClass().getSimpleName() +" is " +String.format("%.2f%%", accuracy));
			//System.out.println("Accuracy of the model is " +accuracy +"\n");
		}
		accuracy = sumAccuracy/fold;
		//System.out.println("SumAccuracy of the model is " +sumAccuracy +"\n");
		return accuracy;
	}

}

