<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.*" import="ti.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Lab1</title>
<link rel="stylesheet" href="style.css" type="text/css">
</head>

<!-- <body onload="GetClock(); setInterval(GetClock,1000);" -->
<body>
<div class="container">
<% request.setCharacterEncoding("UTF-8"); %>


	<jsp:useBean id="user"  class="Uzytkownik" scope="session"/> <!--  instancja klasy Uzytkownik, powolywana warunkowo-->
	<%=user.getUprawnienia() %>  <!--  session u gory przetrzymuje nam Uzytkownika user w sesji, nie trzeba sprawdzac, czy sesja jest, czy nie-->
<% int uprawnienia=user.getUprawnienia(); %>
<%String strona = request.getParameter("strona");
if(uprawnienia>0)
	strona=Narzedzia.parsujStrone(strona, "glowna;kwadratowe;trzecia;ustawienia");
else strona=Narzedzia.parsujStrone(strona, "glowna;kwadratowe;trzecia");
	%>
	<%=strona %><br/>
		
<jsp:include page="/WEB-INF/naglowek.jsp">
	<jsp:param name="tresc" value="Treść nagłówka"/>
</jsp:include>
<jsp:include page="/WEB-INF/menu.jsp">
	<jsp:param name="uprawnienia" value="<%=uprawnienia %>"/>
	<jsp:param name="login" value="<%=user.getLogin() %>"/>
</jsp:include>
<jsp:include page="/WEB-INF/content.jsp">
	<jsp:param name="strona" value="<%=strona %>"/>
</jsp:include>
<jsp:include page="/WEB-INF/header.jsp"/>

</body>
</html>