
public class Narzedzia {

	public static String generujNaglowek(String tytul, String css, String js){
		
		StringBuffer wyjscie = new StringBuffer();
		wyjscie.append("<!DOCTYPE html>");
		wyjscie.append("<html>\n");		
		wyjscie.append("<head>\n");
		if(tytul.length()>0)
		wyjscie.append("<title>"+tytul+"</title>");
		
		if(css.length()>0){
			String[] cssy=css.split(";");
			for(String csss:cssy){
				wyjscie.append("<link rel=\"stylesheet\" href=\""+csss+"\" type=\"text/css\">");
			}
		}
		wyjscie.append("</head>\n");
		wyjscie.append("<body>\n");
		return wyjscie.toString();
	}
	
	public static String generujHeader(String tresc){
		
		StringBuffer wynik = new StringBuffer();
		wynik.append("<div class=\"header\">\n");
		wynik.append("<h1>"+tresc+"</h1>\n");
		wynik.append("</div>");
		return wynik.toString();
	}
	
	public static String generujMenu(int uprawnienia, String login){
		StringBuffer wynik = new StringBuffer();
		wynik.append("<div class=\"menu\">\n");

		wynik.append("<ul>\n");
		wynik.append("<li><a href=\"AG?strona=glowna\">Link1</a></li>\n");
		wynik.append("<li><a href=\"AG?strona=kwadratowe\">Link2</a></li>\n");
		wynik.append("<li><a href=\"AG?strona=trzecia\">Link3</a></li>\n");
		
		if(uprawnienia>0)
			wynik.append("<li><a href=\"AG?strona=ustawienia\">Link3</a></li>\n");
		wynik.append("</ul>\n");
		
		if (uprawnienia<0){
			wynik.append("  <form method==\"POST\" action=\"AGformularz?akcja=zaloguj\">\n");
			wynik.append("Login: <input type=\"text\" name=\"login\" ></br>\n");
			wynik.append("Has³o: <input type=\"password\" name=\"haslo\" ></br>\n");
			wynik.append(" <input type=\"submit\" value=\"Zaloguj\" name=\"zaloguj\" ></br>\n");
			wynik.append("</form>\n");
		}
		
		else if (uprawnienia>0){
			
			wynik.append("  <form method==\"POST\" action=\"AGformularz?akcja=wyloguj\">\n");
			wynik.append("Jestes zalogowany jako <b>"+login+"</b></br>\n");
			
			wynik.append(" <input type=\"submit\" value=\"Wyloguj\" name=\"wyloguj\" ></br>\n");
			wynik.append("</form>\n");
		}
		

		wynik.append("<div class=\"news\"><p>Newski newski..................</p></div>\n");
		wynik.append("</div>");
		return wynik.toString();		
	}
	
	public static String generujTresc(String strona, String imie, String nazwisko, int wiek){
		StringBuffer wynik = new StringBuffer();
		wynik.append("<div class=\"content\">\n");
		
		if (strona.equals("glowna"))
		wynik.append("<p>Lorem ipsum dolor sit amet enim. Etiam ullamcorper. Suspendisse a pellentesque dui, non felis. Maecenas malesuada elit lectus felis, malesuada ultricies. Curabitur et ligula. Ut molestie a, ultricies porta urna. Vestibulum commodo volutpat a, convallis ac, laoreet enim. Phasellus fermentum in, dolor. Pellentesque facilisis. Nulla imperdiet sit amet magna. Vestibulum dapibus, mauris nec malesuada fames ac turpis velit, rhoncus eu, luctus et interdum adipiscing wisi. Aliquam erat ac ipsum. Integer aliquam purus. Quisque lorem tortor fringilla sed, vestibulum id, eleifend justo vel bibendum sapien massa ac turpis faucibus orci luctus non, consectetuer lobortis quis, varius in, purus. Integer ultrices posuere cubilia Curae, Nulla ipsum dolor lacus, suscipit adipiscing. \n");
		
		else if(strona.equals("kwaratowe"))
			wynik.append("Równanie Kwadratowe");

		else if(strona.equals("trzecia"))
			wynik.append("   Trzecia");
		else if(strona.equals("ustawienia")){ ////dokonczyc
			wynik.append("  <form method==\"POST\" action=\"AGformularz?akcja=ustawienia\">\n");
			wynik.append("imie: <input type=\"text\" name=\"imie\" ></br>\n");
			wynik.append("nazwisko: <input type=\"password\" name=\"nazwisko\" ></br>\n");
			wynik.append("wiek: <input type=\"password\" name=\"wiek\" ></br>\n");
			wynik.append(" <input type=\"submit\" value=\"Zapisz\" name=\"zapisz\" ></br>\n");
			wynik.append("</form>\n");
		}
		else 
			wynik.append("\n");
		
		wynik.append("</p>");
		wynik.append("</div>");
		return wynik.toString();	
	}
	public static String generujStopke(){
		StringBuffer wynik = new StringBuffer();
		wynik.append("<div class=\"footer\">@2016 stopka</div>\n");
		return wynik.toString();	
	}
	
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
