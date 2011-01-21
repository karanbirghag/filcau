<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="ro.pava.pretpetrol.model.StationFlavor"%>
<%@page import="com.google.appengine.api.datastore.KeyFactory"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add price</title>
    <link rel="stylesheet" href="/jquery.mobile-1.0a2.css" />
    <link rel="stylesheet" href="/addprice.css" />
    <script type="text/javascript" src="/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="/jquery.mobile-1.0a2.js"></script>
    <script type="text/javascript" src="/addprice.js"></script>

<% String stationName = (String) request.getAttribute("stationName"); %>
<% String stationKey = (String) request.getAttribute("stationKey"); %>
<% List<StationFlavor> flavors = (List<StationFlavor>) request.getAttribute("flavors"); %>

</head>
<body>
<div data-role="page" data-theme="b">

    <div data-role="header" data-theme="b">
        <h1>Add price for <%=stationName%></h1>
    </div>

    <div data-role="content">
        <form action="pprice" method="POST">
            <input type="hidden" name="stationKey" value="<%=stationKey%>"/>
            <input type="hidden" name="station" value="<%=stationName%>"/>

            <div data-role="fieldcontain"><label>Price:</label><input type="text" name="value"/></div>

            <div data-role="fieldcontain" id="flavorSelector">
                <label for="flavor" class="select">Flavor:</label>
                <select name="flavor" id="flavor">
                    <% for (StationFlavor flavor : flavors) { %>
                        <option value="<%= KeyFactory.keyToString(flavor.getKey())%>"><%=flavor.getFlavor() %></option>
                    <% } %>
                    <option value="newFlavor">Add new flavor</option>
                </select>
            </div>
            <div id="flavorEditor">
	            <div data-role="fieldcontain">
	                <label for="flavorTxt" class="select">Flavor:</label>
	                <input type="text" name="flavor" id="flavorTxt" />
	            </div>
	
	            <fieldset data-role="controlgroup">
	                <legend>Type:</legend>
	                    <input type="radio" name="type" id="Diesel" value="Diesel" checked="checked" />
	                    <label for="Diesel">Diesel</label>
	        
	                    <input type="radio" name="type" id="Petrol" value="Petrol"  />
	                    <label for="Petrol">Petrol</label>
	        
	            </fieldset>
            </div>

            <div data-role="fieldcontain" style="display: none;">
                <label>latitude</label><input type="text" name="latitude"/>
                <label>longitude</label><input type="text" name="longitude"/>
                <label>location</label><input type="text" name="location"/>
            </div>

            <input type="submit" value="Save price"/>
         </form>
    </div>

    <div data-role="footer" data-position="fixed">
        <h4>&copy; Copyright Pava 2011</h4>
    </div>

</div>
    

</body>
</html>