<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="ro.pava.pretpetrol.model.StationFlavor"%>
<%@page import="com.google.appengine.api.datastore.KeyFactory"%><html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Stations</title>
    
    <link rel="stylesheet" href="/jquery.mobile-1.0a2.css" />
    <script type="text/javascript" src="/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="/jquery.mobile-1.0a2.js"></script>

</head>
<body>
<div data-role="page" data-theme="b">

    <div data-role="header" data-theme="b">
        <h1>Titlu</h1>
    </div>

    <div data-role="content">
        <% List<StationFlavor> stations = (List<StationFlavor>) request.getAttribute("stations"); %>
        <ul data-role="listview" data-inset="true" data-theme="c" data-dividertheme="a">
            <li data-role="list-divider">All stations</li>
            <% for (StationFlavor sf : stations) { %>
            <li><span><a href="pprice?m=lowest&s=<%=KeyFactory.keyToString(sf.getKey())%>"><%= sf.getStation() %></a></span> <span><%= sf.getDieselPrice()%></span><span>D</span> <span><%= sf.getPetrolPrice()%></span><span>P</span>
            <span>View prices</span></li>
            <% } %>
        </ul>
    </div>

    <div data-role="footer" data-position="fixed">
        <h4>&copy; Copyright Pava 2011</h4>
    </div>

</div>

</body>
</html>