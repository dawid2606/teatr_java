<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <jsp:useBean id="user"  class="Uzytkownik" scope="session"/> <!--  instancja klasy Uzytkownik, powolywana warunkowo-->
	
	

<form method="POST" action="AGformularz.jsp?akcja=ustawienia">"
imie: <input type="text" value="<%=user.getImie() %>"  name="imie" ></br>
nazwisko: <input type="text" value='<jsp:getProperty name="user" property="nazwisko"/>' name="nazwisko" ></br>

<%if(user.getWiek()>-1){ %>
wiek: <input type="value" value="<%=user.getWiek() %>" name="wiek" ></br>
 <%}else{ %>
 wiek: <input type="number" name="wiek"></br>
  <%} %>
 
 <input type="submit" value="zapisz" name="zapisz" ></br>
</form>  
<!-- dokonczyc -->
