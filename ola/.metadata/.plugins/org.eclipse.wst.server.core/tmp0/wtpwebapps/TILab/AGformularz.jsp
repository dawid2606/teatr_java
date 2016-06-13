<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.*" import="ti.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Lab3</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>

<!-- <body onload="GetClock(); setInterval(GetClock,1000);" -->

<body>
<jsp:useBean id="user"  class="Uzytkownik" scope="session"/> <!--  instancja klasy Uzytkownik, powolywana warunkowo-->
	
<% String akcja = request.getParameter("akcja");
	if(akcja==null) akcja=""; /*na wypadek wklepania z palca, na wypadek bledu  */
%>

<% String komunikat="";  %>

<div class="container">

<%if (akcja.equals("zaloguj")){
	String login=request.getParameter("login");
	String haslo=request.getParameter("haslo");
	
	if(login==null) login="";
	if(haslo==null) haslo="";
	komunikat="Niepoprawny login i/lub haslo\n";
	if((login.equals("user")) && (haslo.equals("user"))){
		//logowanie uzytkownika
		user.setUprawnienia(1);
		user.setLogin(login);
		komunikat="Zostales zalogowan jako user";
		/* out.println(komunikat);
		out.println("Uprawnienia" + user.getUprawnienia());    */
	}
	
	if((login.equals("admin")) && (haslo.equals("admin"))){
		//logowanie administratora
		user.setUprawnienia(2);
		user.setLogin(login);
		komunikat="Zostales zalogowan jako administrator";
		//out.println(komunikat);
		//out.println("Uprawnienia" + user.getUprawnienia());   
	}%>
<%}	else if(akcja.equals("wyloguj")){
	session.invalidate();
	komunikat="zostales prawidlowo wyl;ogowany";
	%>
	<%}			else if (akcja.equals("ustawienia")){
		//zapisywanie ustawein		
		komunikat="Ustawienia zostaly zapisane";
		
		%>
		<jsp:setproperty property="imie" name="user"/>
		<jsp:setproperty property="nazwisko" name="user"/>
		<jsp:setproperty property="wiek" name="user"/>
		<%
	}

else{
		komunikat="Nieprawidlowe wywolania formularza";
	}
%>

<div id="komunikat"> <!--  zrobic w css-->
<%=komunikat%><br/>
<span>Kliknij <a href="index.jsp">tutaj</a>aby wrocic na strone</span></div>

</body>
</html>