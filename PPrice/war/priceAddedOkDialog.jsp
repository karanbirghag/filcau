<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="ro.pava.pretpetrol.model.StationFlavor"%>
<%@page import="com.google.appengine.api.datastore.KeyFactory"%>

<% String stationKey = (String) request.getAttribute("s"); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add price</title>
    <link rel="stylesheet" href="/jquery.mobile-1.0a2.css" />
    <link rel="stylesheet" href="/addprice.css" />
    <script type="text/javascript" src="/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="/jquery.mobile-1.0a2.js"></script>
    <script type="text/javascript" src="/addprice.js"></script>

</head>
<body>
<div data-role="page" data-theme="b">

    <div data-role="header" data-theme="b">
        <h1>Success!</h1>
    </div>

    <div data-role="content">
    	The price was successfully added.<br/>Thank you!<br/>
    	<a href="pprice?m=lowest&s=<%=stationKey%>" data-role="button">OK</a>	
	</div>

    <div data-role="footer" data-position="fixed">
        <h4>&copy; Copyright Pava 2011</h4>
    </div>

</div>
    

</body>
</html>