package VFSix_Bundles;
import java.util.ArrayList;

public class Six_Bundles {
	
		public static void setBundleArrayList (int i, ArrayList VFCluster)
		{
			if (i==0) // for bundle # 1
			{
				int bundle1 = 8;
				ArrayList<Integer> VFElement0 = new ArrayList<Integer> ();
				for (int b1=0; b1<5; b1++)
				{
					VFElement0.add(b1+1);
				}
				VFElement0.add(9);
				VFElement0.add(10);
				VFElement0.add(17);
				VFCluster.add(VFElement0);
			}
			
			if (i==1)
			{
				int bundle2 = 13;
				ArrayList<Integer> VFElement1 = new ArrayList<Integer> ();
				
				VFElement1.add(6);
				VFElement1.add(7);
				VFElement1.add(8);
				
				for (int b1=11; b1<17; b1++)
				{
					VFElement1.add(b1);
				}
				
				VFElement1.add(19);
				VFElement1.add(20);
				VFElement1.add(21);
				VFElement1.add(22);
				
				VFCluster.add(VFElement1);
			}
			
			if (i==2)
			{
				int bundle3 = 4;
				ArrayList<Integer> VFElement2 = new ArrayList<Integer> ();
			
					VFElement2.add(18);
					VFElement2.add(26);
					VFElement2.add(34);
					VFElement2.add(42);
			
				VFCluster.add(VFElement2);
			}
			
			if (i==3)
			{
				int bundle4 = 6;
				ArrayList<Integer> VFElement3 = new ArrayList<Integer> ();
				
					VFElement3.add(23);
					VFElement3.add(24);
					VFElement3.add(25);
					VFElement3.add(31);
					VFElement3.add(32);
					VFElement3.add(33);
				
				VFCluster.add(VFElement3);
			}
			
			if (i==4)
			{
				int bundle5 =11;
				ArrayList<Integer> VFElement4 = new ArrayList<Integer> ();
				
				VFElement4.add(27);
				VFElement4.add(35);
				VFElement4.add(41);
				VFElement4.add(43);
				VFElement4.add(44);
				
				for (int b1=47; b1<53; b1++)
				{
					VFElement4.add(b1);
				}
				VFCluster.add(VFElement4);
			}
			
			if (i==5)
			{
				int bundle6 = 10;
				ArrayList<Integer> VFElement5 = new ArrayList<Integer> ();
				
				VFElement5.add(28);
				VFElement5.add(29);
				VFElement5.add(30);
				
				for (int b1=36; b1<41; b1++)
				{
					VFElement5.add(b1);
				}
				
				VFElement5.add(45);
				VFElement5.add(46);
				VFCluster.add(VFElement5);
			}
		}

	}

