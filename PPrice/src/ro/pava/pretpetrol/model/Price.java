package ro.pava.pretpetrol.model;

import java.math.BigDecimal;
import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.CreationDate;
import org.slim3.datastore.CreationUser;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.GeoPt;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;

@Model
public class Price {

    @Attribute(primaryKey = true)
    private Key key;

    private String station;

    private String flavour;

    private Type type;

    @Attribute(lob = true)
    private BigDecimal value;

    private String location;

    private GeoPt gpsLocation;

    @Attribute(listener = CreationUser.class)
    private User user;

    @Attribute(listener = CreationDate.class)
    private Date reportDate;

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	/**
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Make sure that the key for a Price is a child of StationFlavour
     * @param key the key to set
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * @return the station
     */
    public String getStation() {
        return station;
    }

    /**
     * @param station the station to set
     */
    public void setStation(String station) {
        this.station = station;
    }

    /**
     * @return the flavour
     */
    public String getFlavour() {
        return flavour;
    }

    /**
     * @param flavour the flavour to set
     */
    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * @return the value
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the gpsLocation
     */
    public GeoPt getGpsLocation() {
        return gpsLocation;
    }

    /**
     * @param gpsLocation the gpsLocation to set
     */
    public void setGpsLocation(GeoPt gpsLocation) {
        this.gpsLocation = gpsLocation;
    }
}
