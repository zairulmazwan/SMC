package GSA;

import java.util.Random;
import org.apache.commons.math3.special.Gamma;



public class GSA_Algo {
	
	static Random rand = new Random();
	
	public static double NewTemp(double t0, double i,double qv) 
    {
                double newt = t0*((Math.pow(2.0,qv-1.0)-1.0));
                double x = (Math.pow(1.0+i,qv-1.0)-1.0);
                newt /= x;
              
                return(newt);
    }
    
    
    
    public static double SmallChange(double qv, double temp, double [] visitA) 
    {
    	//System.out.println("oldv is : "+oldv);
    	//System.out.println("q is :" +q);
    	//System.out.println("temp is "+temp);
    	
                double visita;
                double pi=3.14159265;
                double fatorl = Math.exp(Math.log(temp)/(qv-1.0));
                //System.out.println("1 = "+fatorl);
                double fator2=Math.exp((4.0-qv)*Math.log(qv-1.0));
                //System.out.println("2 = "+fator2);
                double fator3=Math.exp((2.0-qv)*Math.log(2.0)/(qv-1.0));
                //System.out.println("3 = "+fator3);
                double fator4=(Math.sqrt(pi)*fatorl*fator2)/(fator3*(3.0-qv));
                //System.out.println("4 = "+fator4);
                double fator5=(1./(qv-1.))-0.5;
                //System.out.println("5 = "+fator5);
                // Calculates the Gamma Junction using the reflection formula Jor
                // O < arg < l
                //System.out.println(Gamma.logGamma(2.0- fator5 ));
                double fator6=pi*( 1.0-fator5 )/Math.sin(pi*( 1.0-fator5 ))/Math.exp(Gamma.logGamma(2.0- fator5 ));
                //System.out.println("6 = "+fator6);
                double sigmax=Math.exp(-(qv- 1.0)*Math.log(fator6/fator4)/(3.0-qv));
                //System.out.println("sigmax = "+sigmax);
                double x=sigmax*rand.nextGaussian();
                double y=rand.nextGaussian();
                double den=Math.exp((qv-1.)*Math.log(Math.abs(y))/(3.-qv));

                visita=Math.abs(x/den);
                visitA [0] = visita; //this is captured for recording to raw data

                //System.out.println("visita = "+visita);
                
                double newv = 1-(Math.exp(-visita));
                
               // System.out.println("newv = "+newv);
                                
                //System.out.println("1-newv is = "+newv);

                //double newv = oldv + 2*(rand.nextDouble() - 0.5)*visita;                     
                return(newv); 
    }
    
    public static double prob(double df, double temp, double qa) 
    {
                double p = 1.0 + (qa - 1)*(df/temp);
                //System.out.println("df="+df);
                //System.out.println("p="+p);
                //System.out.println(1.0/(qa-1.0));
                //System.out.println(Math.pow(-12.19,-0.1666));
                
                double p2 = Math.pow(p,1.0/(qa-1.0));
               
                
                if (p2<1)
                {
                	p=0;
                }
                p = 1.0/p2;
              //System.out.println(p);
                return(p);
    }
    
    public static double SmallChange1(double oldv, double q, double temp, double sum_visitA) 
    {
    	//System.out.println("oldv is : "+oldv);
    	//System.out.println("q is :" +q);
    	//System.out.println("temp is "+temp);
    	
                double visita;
                double pi=3.14159265;
                double fatorl = Math.exp(Math.log(temp)/(q-1.0));
                //System.out.println("1 = "+fatorl);
                double fator2=Math.exp((4.0-q)*Math.log(q-1.0));
                //System.out.println("2 = "+fator2);
                double fator3=Math.exp((2.0-q)*Math.log(2.0)/(q-1.0));
                //System.out.println("3 = "+fator3);
                double fator4=(Math.sqrt(pi)*fatorl*fator2)/(fator3*(3.0-q));
                //System.out.println("4 = "+fator4);
                double fator5=(1./(q-1.))-0.5;
                //System.out.println("5 = "+fator5);
                // Calculates the Gamma Junction using the reflection formula Jor
                // O < arg < l
                //System.out.println(Gamma.logGamma(2.0- fator5 ));
                double fator6=pi*( 1.0-fator5 )/Math.sin(pi*( 1.0-fator5 ))/Math.exp(Gamma.logGamma(2.0- fator5 ));
                //System.out.println("6 = "+fator6);
                double sigmax=Math.exp(-(q- 1.0)*Math.log(fator6/fator4)/(3.0-q));
                //System.out.println("sigmax = "+sigmax);
                double x=sigmax*rand.nextGaussian();
                double y=rand.nextGaussian();
                double den=Math.exp((q-1.)*Math.log(Math.abs(y))/(3.-q));

                visita=Math.abs(x/den);
                sum_visitA += visita;
                //double newv = oldv + 2*(rand.nextDouble() - 0.5)*visita;     
                
                double newv = 1-Math.exp(-visita); //exp value is = 2.718281828
                
                //System.out.println("1-Math.exp(-visita)  is :"+newv);
                
                newv = oldv+newv;
                return(newv); 
    }


}
