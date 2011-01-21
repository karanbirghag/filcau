package ro.pava.pretpetrol.server;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slim3.util.StringUtil;

import ro.pava.pretpetrol.api.Services;
import ro.pava.pretpetrol.model.Price;
import ro.pava.pretpetrol.model.StationFlavor;
import ro.pava.pretpetrol.model.Type;

import com.google.appengine.api.datastore.GeoPt;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@SuppressWarnings("serial")
public class PPriceServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        Services services = new Services();
        String method = req.getParameter("m");
        if (method.equals("maintenance")) {
            services.initStations();
        } else if (method.equals("stations")) {
            List<StationFlavor> allStations = services.getAllStations();
            req.setAttribute("stations", allStations);
            forward(req, resp, "/stations.jsp");
        } else {
            String stationKeyAsString = req.getParameter("s");
            if (method.equals("lowest")) {
                List<StationFlavor> stationPrices = services.getStationPrices(stationKeyAsString);
                req.setAttribute("prices", stationPrices);
                req.setAttribute("s", stationKeyAsString);
                req.setAttribute("stationName", services.getStationFlavor(stationKeyAsString).getStation());
                forward(req, resp, "/stationsprices.jsp");
            } else if (method.equals("flavor")) {
                String station = stationKeyAsString;
                String flavor = req.getParameter("f");
                resp.getWriter().println(station + " - " + flavor);
                List<Price> prices = services.getFlavorPrices(station, flavor);
                for (Price price : prices) {
                    resp.getWriter().println(price.getLocation() + " " + price.getType() + " " + price.getValue() + " Lei <br/>");
                }
            } else if (method.equals("addprice")) {
                String key = req.getParameter("s");
                req.setAttribute("stationKey", key);
                req.setAttribute("stationName", services.getStationFlavor(key).getStation());
                req.setAttribute("flavors", services.getStationPrices(stationKeyAsString));
                forward(req, resp, "/addprice.jsp");
            }
        }
    }

    /**
     * @param req
     * @param resp
     * @param nextJSP
     * @throws IOException
     */
    private void forward(HttpServletRequest req, HttpServletResponse resp, String nextJSP) throws IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Services services = new Services();
        String keyValue = req.getParameter("stationKey");
        Key stationKey = null;
        if (keyValue != null && keyValue.trim().length() != 0) {
            stationKey = KeyFactory.stringToKey(keyValue);
        }
        Price price = new Price();
        price.setFlavour(req.getParameter("flavor"));
        String latitude = req.getParameter("latitude");
        String longitude = req.getParameter("longitude");
        if (!StringUtil.isEmpty(longitude) && !StringUtil.isEmpty(latitude)) {
            price.setGpsLocation(new GeoPt(Float.parseFloat(latitude), Float.parseFloat(longitude)));
        }
        price.setLocation(req.getParameter("location"));
        price.setStation(req.getParameter("station"));
        price.setType(Type.valueOf(req.getParameter("type")));
        price.setValue(new BigDecimal(req.getParameter("value")));
        services.add(stationKey, price);

        forward(req, resp, "/price?m=stations");
    }
}
