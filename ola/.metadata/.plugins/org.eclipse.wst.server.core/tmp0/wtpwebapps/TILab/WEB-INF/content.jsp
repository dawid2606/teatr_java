<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div class="content">
<% String strona= request.getParameter("strona"); %>
<% if(strona.equals("glowna")){%>
Lorem ipsum dolor sit amet enim. Etiam ullamcorper. Suspendisse a pellentesque dui, non felis. Maecenas malesuada elit lectus felis, malesuada ultricies. Curabitur et ligula. Ut molestie a, ultricies porta urna. Vestibulum commodo volutpat a, convallis ac, laoreet enim. Phasellus fermentum in, dolor. Pellentesque facilisis. Nulla imperdiet sit amet magna. Vestibulum dapibus, mauris nec malesuada fames ac turpis velit, rhoncus eu, luctus et interdum adipiscing wisi. Aliquam erat ac ipsum. Integer aliquam purus. Quisque lorem tortor fringilla sed, vestibulum id, eleifend justo vel bibendum sapien massa ac turpis faucibus orci luctus non, consectetuer lobortis quis, varius in, purus. Integer ultrices posuere cubilia Curae, Nulla ipsum dolor lacus, suscipit adipiscing. 
<%} else if (strona.equals("kwadratowe")){ %>
Równanie Kwadratowe
<%} else if (strona.equals("trzecia")){ %>
Trzecia podstrona
<%} else if (strona.equals("ustawienia")){ %>
<jsp:include page="/WEB-INF/ustawienia.jsp"/>
<%} else { %>
Brak podstrony
<% }  %>
</div>