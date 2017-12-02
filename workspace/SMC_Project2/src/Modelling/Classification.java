package Modelling;
import java.util.Random;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.evaluation.NominalPrediction;
import weka.classifiers.evaluation.Prediction;
import weka.core.FastVector;
import weka.core.Instances;

public class Classification {
		
		public static Evaluation classify (Classifier model, Instances trainingSet, Instances testSet) throws Exception
		{
			Evaluation ev = new Evaluation (trainingSet);
			model.buildClassifier(trainingSet);
			ev.evaluateModel(model, testSet);
			
			return ev;
		}
		
		public static Instances [][] crossValidation (Instances data, int no_fold) 
		{
			Instances [][] split = new Instances [2][no_fold]; //2 x 10 array
			
			for (int i=0; i<no_fold; i++)
			{
				split [0][i] = data.trainCV(no_fold, i); // 1 x 10 array
				split [1][i] = data.testCV(no_fold, i);
			}
			
			return split;
		}
		
		
		public static double calAccuracy(FastVector prediction)
		{
			double correct=0;
			
			for (int i=0; i<prediction.size(); i++)
			{
				
				NominalPrediction np = (NominalPrediction) prediction.elementAt(i);
				if (np.predicted() == np.actual())
				{
					correct++;
				}
			}
			
			correct = correct/prediction.size()*100;
			return correct;
			
		}
		
		public static Instances RandData (Instances data)
		{
			int seed = 789;
			int folds = 10;
			Instances randData = null;
			
			Random rand = new Random (seed);
			randData = new Instances (data);
			randData.randomize(rand);
			
			if (randData.classAttribute().isNominal())
				randData.stratify(folds);
			
			return randData;
				
		}

	}

