package ro.pava.pretpetrol.server;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

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
        if (method.equals("stations")) {
            List<StationFlavor> allStations = services.getAllStations();
            for (StationFlavor sf : allStations) {
                resp.getWriter().println(sf.getStation() + " " + sf.getStationPriceDiesel() + "D " + sf.getStationPricePetrol() + "P"
                                        + "<b><a href='pprice?m=lowest&s=" + sf.getStation() + "'>see prices</a></b><br/>");
            }
        } else if (method.equals("lowest")) {
            List<StationFlavor> stationPrices = services.getStationPrices(req.getParameter("s"));
            resp.getWriter().println(req.getParameter("s") + "<br/>");
            for (StationFlavor sf : stationPrices) {
                resp.getWriter().println(sf.getFlavor() + " " + sf.getFlavorPrice() + " "
                                         + "<b><a href='pprice?m=flavor&s=" + sf.getStation() + "&f=" + sf.getFlavor() + "'>see prices</a></b><br/>");
            }
        } else if (method.equals("flavor")) {
            String station = req.getParameter("s");
            String flavor = req.getParameter("f");
            resp.getWriter().println(station + " - " + flavor);
            List<Price> prices = services.getFlavorPrices(station, flavor);
            for (Price price : prices) {
                resp.getWriter().println(price.getLocation() + " " + price.getType() + " " + price.getValue() + " Lei <br/>");
            }
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

        resp.setContentType("text/plain");
        resp.getWriter().println("Price was added!");
    }
}
