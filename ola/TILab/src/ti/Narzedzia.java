package ti;

public class Narzedzia {

	public static String parsujStrone(String wejscie, String poprawne){
		String wyjscie="glowna";
		
		if(wejscie==null) wejscie="glowna";
		if(poprawne.length()>0){
			String[] strony = poprawne.split(";");
			for(String strona:strony){
				if(wejscie.equals(strona))
					wyjscie=wejscie;
			}
		}
		return wyjscie;
		
	}
}
