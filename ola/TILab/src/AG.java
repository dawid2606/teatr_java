

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AG
 */
@WebServlet("/AG")
public class AG extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String strona;

		strona=Narzedzia.parsujStrone(request.getParameter("strona"), "glowna;kwadratowe;trzecia");
		
		
		HttpSession sesja = request.getSession(true);
		
		Uzytkownik user = (Uzytkownik)sesja.getAttribute("user");
		if(user==null){
			user=new Uzytkownik();
			sesja.setAttribute("user", user);
		}
		if (user.getUprawnienia()>0)
		strona=Narzedzia.parsujStrone(request.getParameter("strona"),"glowna;kwadratowe;trzecia;ustawienia");
		
		out.println(Narzedzia.generujNaglowek("TILab0", "style.css;hsgdhs", "script.js"));
		out.println(Narzedzia.generujHeader("TIz1-Lab2"));
		out.println(Narzedzia.generujMenu(user.getUprawnienia(), user.getLogin()));
		out.println(Narzedzia.generujTresc(strona, user.getImie(), user.getNazwisko(), user.getWiek()));
		out.println(Narzedzia.generujStopke());
		//out.println("Witaj Œwiecie w serwlecie</br>");
		//Date date=new Date();
		//out.println(date.toString());
		//out.println(user.getUprawnienia());
		
		out.println("</body></html>");
		out.println(strona+" "+strona.length());
		out.close();
	}

}
