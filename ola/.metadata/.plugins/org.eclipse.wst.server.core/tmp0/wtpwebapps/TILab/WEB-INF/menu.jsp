<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.*" import="ti.*" %>
<% int uprawnienia= Integer.parseInt(request.getParameter("uprawnienia")); %> <!--  
za pomoca parametru przekazujemy zawsze string, wiec musimy to sparsowac-->



<div class="menu">
<ul>
<li><a href="index.jsp?strona=glowna">Główna</a></li>
<li><a href="index.jsp?strona=kwadratowe">Równanie kwadratowe</a></li>
<li><a href="index.jsp?strona=trzecia">Trzecia</a></li>
<% if (uprawnienia>0){ %>
<li><a href="index.jsp?strona=ustawienia">Ustawienia</a></li>
<% } %>
</ul>
<% if (uprawnienia>0){ %>
			<form method="POST" action="AGformularz?akcja=wyloguj">
			Jestes zalogowany jako <b><%=request.getParameter("login") %></b></br>
			
			<input type="submit" value="wyloguj" name="wyloguj" ></br>
			</form>
<% }else{ %>
			<form method="POST" action="AGformularz.jsp?akcja=zaloguj">
			Login: <input type="text" name="login" ></br>
			Hasło: <input type="password" name="haslo" ></br>
			<input type="submit" value="zaloguj" name="zaloguj" ></br>
			</form>
<% } %>
<div class="news"><p>Newski newski..................</p></div>
</div>