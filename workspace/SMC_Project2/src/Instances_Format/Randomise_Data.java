package Instances_Format;

import java.util.Random;

import weka.core.Instances;

public class Randomise_Data {
	
	public static Instances RandData (Instances iData)
	{
		int seed = 789;
		int folds = 10;
		Instances randData = null;
		
		Random rand = new Random (seed);
		randData = new Instances (iData);
		randData.randomize(rand);
		
		if (randData.classAttribute().isNominal())
			randData.stratify(folds);
		
		return randData;
			
	}


}
