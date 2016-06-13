

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.*;

/**
 * Servlet implementation class AGformularz
 */
@WebServlet("/AGformularz")
public class AGformularz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AGformularz() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter out = response.getWriter();
			
			String komunikat;

			HttpSession sesja = request.getSession(true);
			
			Uzytkownik user = (Uzytkownik)sesja.getAttribute("user");
			if(user==null){
				user=new Uzytkownik();
				sesja.setAttribute("user", user);
				komunikat="Zostales zalogowany";
			}
			
	
			out.println(Narzedzia.generujNaglowek("TILab0", "style.css", "script.js"));
			out.println(Narzedzia.generujHeader("TIz1-Lab2"));
			
			String akcja = request.getParameter("akcja");
			if(akcja==null) akcja="";
			
			if (akcja.equals("zaloguj")){
				String login=request.getParameter("login");
				String haslo=request.getParameter("haslo");
				
				if(login==null) login="";
				if(haslo==null) haslo="";
				komunikat="Niepoprawny login i/lub haslo\n";
				if((login.equals("user")) && (haslo.equals("user"))){
					//logowanie uzytkownika
					user.setUprawnienia(1);
					user.setLogin(login);
					sesja.setAttribute("user", user);
					komunikat="Zostales zalogowan jako "+login+"\n";
				}
				
				if((login.equals("admin")) && (haslo.equals("admin"))){
					//logowanie administratora
					user.setUprawnienia(2);
					user.setLogin(login);
					sesja.setAttribute("user", user);
					komunikat="Zostales zalogowan jako "+login+"\n";
				}
			}
				
			
			
			else if(akcja.equals("wyloguj")){
				Uzytkownik user0=new Uzytkownik();
				sesja.setAttribute("user", user0);
			}
			
			else if (akcja.equals("ustawienia")){
				//zapisywanie ustawein
				
				String login=user.getLogin();
				int uprawnienia=user.getUprawnienia();
				
				try {
					BeanUtils.populate(user, request.getParameterMap());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				user.setLogin(login);
				user.setUprawnienia(uprawnienia);
				komunikat="Ustawienia zostaly zapisane";
				sesja.setAttribute("user", user);
				
			}
					
			
			//kliknij tutaj aby.... TODO!!!!!!!!!!
			out.println(Narzedzia.generujStopke());
			out.println("</body></html>");
					
	}

}
