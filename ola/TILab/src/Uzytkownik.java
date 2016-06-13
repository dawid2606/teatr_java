
public class Uzytkownik {

	private int uprawnienia=-1;
	private String login="";
	
	private String imie="";
	private String nazwisko="";
	private int wiek=-1;
	
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public int getWiek() {
		return wiek;
	}
	public void setWiek(int wiek) {
		if(wiek>0)
		this.wiek = wiek;
		else wiek=-1;
	}
	public int getUprawnienia() {
		return uprawnienia;
	}
	public void setUprawnienia(int uprawnienia) {
		this.uprawnienia = uprawnienia;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	
}
