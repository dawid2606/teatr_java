<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.*" import="ti.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Witaj Świecie w jsp
<%=new java.util.Date()  %><br/>
<%=new testowa()  %><br/>
<% int zmienna=0; %><br/>
<%=++zmienna %><!--lokalna zmienna, ładowana za każdym razem  -->

<%! int zmienna2=0; %><br/>
<%=++zmienna2 %> <!-- zmienna gobalna, kazdy watek inkrementwuje ta wartosc, moze 
zluzyc jako licznik -->
request.getMethod():  <%=request.getMethod() %><br/>
<% out.println("abc"); %><br/>
session.getId():  <%=session.getId() %><br/>
application.getServerInfo(): <%=application.getServerInfo() %><br/>

<!-- <a href="plik.html">plik</a> --> <!--glowny katalog serwaera  -->
<jsp:include page="/WEB-INF/index.html"/> <!--plik index.html zaincludowany z naszej apllikacji, /na poczatku jest glownym katalogiem sewera  -->
<!--index.html powinien nie miec juz naglowka, musi byc w miejscu niedostepnym dla uzytkownika
a w miejscu dostepnym dla serwera, czyli w folderze WEB-INF  -->

Parametr abc: <%=request.getParameter("abc") %>
Parametr abc2: <%=request.getParameter("abc2") %>


<jsp:include page="/WEB-INF/drugiJsp.jsp">
	<jsp:param name="abc" value="100"/>
</jsp:include>

<%@include file="/WEB-INF/drugiJsp.jsp" %>
<%=licznik %></br>

</body>
</html>



<!-- tesowyMateuszaBolka na dyscku google-->

