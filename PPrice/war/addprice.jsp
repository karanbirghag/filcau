<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="ro.pava.pretpetrol.model.StationFlavor"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add price</title>
</head>
<body>

    <form action="pprice" method="POST">
        <input type="hidden" name="stationKey"/><br/>
        <label>flavor</label><input type="text" name="flavor"/><br/>
        <label>latitude</label><input type="text" name="latitude"/><br/>
        <label>longitude</label><input type="text" name="longitude"/><br/>
        <label>location</label><input type="text" name="location"/><br/>
        <label>station</label><input type="text" name="station"/><br/>
        <label>type</label><input type="text" name="type"/><br/>
        <label>value</label><input type="text" name="value"/><br/>
        <input type="submit" value="Add price"/>
    </form>

</body>
</html>