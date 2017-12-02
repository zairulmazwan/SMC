
public class Hexadecimals {
	
	public static void main (String [] agrs)
	{
		int num = 10; //<- user input here
		String hexa ="";
		System.out.println("Decimal number is : "+num);
		
		//hexa = hexa(num);
		if (num < 16)
		{
			if (num < 10)
			{
				System.out.println("Hexa number is : "+num);
			}
			else
			{
				hexa = hexa(num);
				System.out.println("Hexa number is : "+hexa);
			}
		}
		
		
		if (num > 15)
		{
			int res = num/16;
			int mod = num%16;
			//System.out.println("res is : "+res);
			//System.out.println("mod is : "+mod);
			
			if (mod >9)
			{
				String mod2  = hexa (mod);
				hexa += String.valueOf(mod2);
			}
			else 
			{
				hexa += String.valueOf(mod);
			}
			
			
			while (res>15)
			{
				int m = res%16;
				res =  res/16;
				//System.out.println("m number is : "+m);
				if (m > 9)
				{
					String m2  = hexa (m);
					hexa += String.valueOf(m2);
				}
				else 
				{
					hexa += String.valueOf(m);
				}
				
			}
			
			//System.out.println("res number is : "+res);
			if (res > 9)
			{
				String res2 = hexa(res);
				hexa += String.valueOf(res2);
			}
			else
			{
				hexa += String.valueOf(res);
			}
			hexa = reverse(hexa);
			System.out.println("Hexa number is : "+hexa);
		}
		
		
	}
	
	public static String reverse (String x)
	{
		String y ="";
		for (int i=x.length()-1; i>=0; i--)
		{
			y+=x.charAt(i);
		}
		return y;
	}
	
	public static String hexa (int num)
	{
		String hexa = "";
		
		if (num < 10)
		{
			hexa = String.valueOf(num);
		}
		else if (num > 9 && num < 16)
		{
			hexa = hexaABC(num);
		}
		
		return hexa;
	}
	
	public static String hexaABC (int num)
	{
		String hexa="";
		
		switch (num)
		{
		case 10:
			hexa +='A';
			break;
		
		case 11:
			hexa +='B';
			break;
		
		case 12:
			hexa +='C';
			break;
			
		case 13:
			hexa +='D';
			break;
			
		case 14:
			hexa +='E';
			break;
			
		case 15:
			hexa +='F';
			break;
			
		}
		
		return hexa;
	}

}
