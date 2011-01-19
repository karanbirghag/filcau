<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="ro.pava.pretpetrol.model.StationFlavor"%>
<%@page import="com.google.appengine.api.datastore.KeyFactory"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<% List<StationFlavor> prices = (List<StationFlavor>) request.getAttribute("prices"); %>
<% String stationKey = (String) request.getAttribute("s"); %>
<title>Station prices</title>
</head>
<body>
<ul>
<% for (StationFlavor sf : prices) { %>
    <li>
        <span><%= sf.getFlavor() %></span>
        <span><%= sf.getFlavorPrice()%></span><span>Lei</span>
        <span><a href="pprice?m=lowest&s=<%=KeyFactory.keyToString(sf.getKey())%>">View all</a></span>
    </li>
<% } %>
</ul>
<a href="pprice?m=addprice&s=<%=stationKey%>">Report price</a>
</body>
</html>