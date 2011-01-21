<%@page import="ro.pava.pretpetrol.model.Price"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="ro.pava.pretpetrol.model.StationFlavor"%>
<%@page import="com.google.appengine.api.datastore.KeyFactory"%><html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Prices</title>
    

 <% List<Price> prices = (List<Price>) request.getAttribute("prices"); %>    
 <% String flavorName = (String) request.getAttribute("flavorName"); %>
 <% String stationName = (String) request.getAttribute("stationName"); %>

</head>
<body>
<div data-role="page" data-theme="b">

    <div data-role="header" data-theme="b">
        <h1>Reported prices</h1>
    </div>

    <div data-role="content">
        <ul data-role="listview" data-inset="true" data-theme="c" data-dividertheme="a">
            <li data-role="list-divider"><%=flavorName%> (<%=stationName%>)</li>
            <% for (Price price : prices) { %>
            	<li><h1><%=price.getValue().toString()%> Lei</h1> Added in: <%=price.getReportDate() %></li>
            <% } %>
        </ul>
    </div>

    <div data-role="footer" data-position="fixed">
        <h4>&copy; Copyright Pava 2011</h4>
    </div>

</div>

</body>
</html>