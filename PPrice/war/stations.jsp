<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="ro.pava.pretpetrol.model.StationFlavor"%>
<%@page import="com.google.appengine.api.datastore.KeyFactory"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stations</title>
</head>
<body>
<% List<StationFlavor> stations = (List<StationFlavor>) request.getAttribute("stations"); %>
<ul>
<% for (StationFlavor sf : stations) { %>
    <li>
        <span><%= sf.getStation() %></span>
        <span><%= sf.getStationPriceDiesel()%></span><span>D</span>
        <span><%= sf.getStationPricePetrol()%></span><span>P</span>
        <span><a href="pprice?m=lowest&s=<%=KeyFactory.keyToString(sf.getKey())%>">View prices</a></span>
    </li>
<% } %>
</ul>
</body>
</html>