<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.*" import="ti.*" errorPage="/WEB-INF/bledy.jsp"%>

<h3>plik drugiJsp.jsp</h3>
<%! int licznik=0; %>

Licznik: <%=++licznik %>

PArametr abc (drugiJsp.jsp) <%=request.getParameter("abc") %> 
PArametr abc (drugiJsp.jsp) ile: <%=request.getParameterValues("abc").length %> 
PArametr abc2 (drugiJsp.jsp) <%=request.getParameter("abc2") %> 


<% int parametr= Integer.parseInt(request.getParameter("abc")); %><br/>
Parametr "parametr" z drugiJsp: <%=parametr %>
