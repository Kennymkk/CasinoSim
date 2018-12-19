import java.util.HashMap;

import modele.MachineManchot;
import modele.Wheel;
import modele.RulesGainWheel;

public class test_purposes {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		HashMap<String,HashMap<String,Float>> global = new HashMap<String,HashMap<String,Float>>();
		String [] a= {"a","b","c","d","e"};
		
		for(int i=1;i<=4;i++) {
			HashMap<String,Float> test=new HashMap<String,Float>();
			test.put("probability", (float) (0.1* (float) i));
			test.put("value", (float) (10*i));
			
			global.put(a[i],test);
		}
	
			
		Wheel rr =new Wheel(global);
		Wheel rr2 =new Wheel(global);
		Wheel rr3 =new Wheel(global);
		
						
		Wheel [] tab= {rr,rr2,rr3};
		RulesGainWheel rules=new RulesGainWheel();
		
		MachineManchot m = new MachineManchot(tab,rules);
		
		@SuppressWarnings("unused")
		int debug=0;
		System.out.println(m.getStringOfWheels());
		for(int i=0;i<10;i++) {
			System.out.println("The player has won :"+m.jouer());
			System.out.println(m.getStringOfWheels());
		}
	}

}
