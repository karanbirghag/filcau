package ro.pava.pretpetrol.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-01-21 15:38:55")
/** */
public final class PriceMeta extends org.slim3.datastore.ModelMeta<ro.pava.pretpetrol.model.Price> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<ro.pava.pretpetrol.model.Price, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<ro.pava.pretpetrol.model.Price, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<ro.pava.pretpetrol.model.Price> station = new org.slim3.datastore.StringAttributeMeta<ro.pava.pretpetrol.model.Price>(this, "station", "station");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<ro.pava.pretpetrol.model.Price> flavour = new org.slim3.datastore.StringAttributeMeta<ro.pava.pretpetrol.model.Price>(this, "flavour", "flavour");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<ro.pava.pretpetrol.model.Price, ro.pava.pretpetrol.model.Type> type = new org.slim3.datastore.CoreAttributeMeta<ro.pava.pretpetrol.model.Price, ro.pava.pretpetrol.model.Type>(this, "type", "type", ro.pava.pretpetrol.model.Type.class);

    /** */
    public final org.slim3.datastore.UnindexedAttributeMeta<ro.pava.pretpetrol.model.Price, java.math.BigDecimal> value = new org.slim3.datastore.UnindexedAttributeMeta<ro.pava.pretpetrol.model.Price, java.math.BigDecimal>(this, "value", "value", java.math.BigDecimal.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<ro.pava.pretpetrol.model.Price> location = new org.slim3.datastore.StringAttributeMeta<ro.pava.pretpetrol.model.Price>(this, "location", "location");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<ro.pava.pretpetrol.model.Price, com.google.appengine.api.datastore.GeoPt> gpsLocation = new org.slim3.datastore.CoreAttributeMeta<ro.pava.pretpetrol.model.Price, com.google.appengine.api.datastore.GeoPt>(this, "gpsLocation", "gpsLocation", com.google.appengine.api.datastore.GeoPt.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<ro.pava.pretpetrol.model.Price, com.google.appengine.api.users.User> user = new org.slim3.datastore.CoreAttributeMeta<ro.pava.pretpetrol.model.Price, com.google.appengine.api.users.User>(this, "user", "user", com.google.appengine.api.users.User.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<ro.pava.pretpetrol.model.Price, java.util.Date> reportDate = new org.slim3.datastore.CoreAttributeMeta<ro.pava.pretpetrol.model.Price, java.util.Date>(this, "reportDate", "reportDate", java.util.Date.class);

    private static final org.slim3.datastore.CreationUser slim3_userAttributeListener = new org.slim3.datastore.CreationUser();

    private static final org.slim3.datastore.CreationDate slim3_reportDateAttributeListener = new org.slim3.datastore.CreationDate();

    private static final PriceMeta slim3_singleton = new PriceMeta();

    /**
     * @return the singleton
     */
    public static PriceMeta get() {
       return slim3_singleton;
    }

    /** */
    public PriceMeta() {
        super("Price", ro.pava.pretpetrol.model.Price.class);
    }

    @Override
    public ro.pava.pretpetrol.model.Price entityToModel(com.google.appengine.api.datastore.Entity entity) {
        ro.pava.pretpetrol.model.Price model = new ro.pava.pretpetrol.model.Price();
        model.setKey(entity.getKey());
        model.setStation((java.lang.String) entity.getProperty("station"));
        model.setFlavour((java.lang.String) entity.getProperty("flavour"));
        model.setType(stringToEnum(ro.pava.pretpetrol.model.Type.class, (java.lang.String) entity.getProperty("type")));
        java.math.BigDecimal _value = blobToSerializable((com.google.appengine.api.datastore.Blob) entity.getProperty("value"));
        model.setValue(_value);
        model.setLocation((java.lang.String) entity.getProperty("location"));
        model.setGpsLocation((com.google.appengine.api.datastore.GeoPt) entity.getProperty("gpsLocation"));
        model.setUser((com.google.appengine.api.users.User) entity.getProperty("user"));
        model.setReportDate((java.util.Date) entity.getProperty("reportDate"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        ro.pava.pretpetrol.model.Price m = (ro.pava.pretpetrol.model.Price) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("station", m.getStation());
        entity.setProperty("flavour", m.getFlavour());
        entity.setProperty("type", enumToString(m.getType()));
        entity.setUnindexedProperty("value", serializableToBlob(m.getValue()));
        entity.setProperty("location", m.getLocation());
        entity.setProperty("gpsLocation", m.getGpsLocation());
        entity.setProperty("user", m.getUser());
        entity.setProperty("reportDate", m.getReportDate());
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        ro.pava.pretpetrol.model.Price m = (ro.pava.pretpetrol.model.Price) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        ro.pava.pretpetrol.model.Price m = (ro.pava.pretpetrol.model.Price) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(ro.pava.pretpetrol.model.Price) is not defined.");
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
    }

    @Override
    protected void prePut(Object model) {
        ro.pava.pretpetrol.model.Price m = (ro.pava.pretpetrol.model.Price) model;
        m.setUser(slim3_userAttributeListener.prePut(m.getUser()));
        m.setReportDate(slim3_reportDateAttributeListener.prePut(m.getReportDate()));
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        ro.pava.pretpetrol.model.Price m = (ro.pava.pretpetrol.model.Price) model;
        writer.beginObject();
        org.slim3.datastore.json.JsonCoder encoder = null;
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getKey());
        }
        if(m.getStation() != null){
            writer.setNextPropertyName("station");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getStation());
        }
        if(m.getFlavour() != null){
            writer.setNextPropertyName("flavour");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getFlavour());
        }
        if(m.getType() != null){
            writer.setNextPropertyName("type");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getType());
        }
        // java.math.BigDecimal is not supported.
        if(m.getLocation() != null){
            writer.setNextPropertyName("location");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getLocation());
        }
        if(m.getGpsLocation() != null){
            writer.setNextPropertyName("gpsLocation");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getGpsLocation());
        }
        if(m.getUser() != null){
            writer.setNextPropertyName("user");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getUser());
        }
        if(m.getReportDate() != null){
            writer.setNextPropertyName("reportDate");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getReportDate());
        }
        writer.endObject();
    }

    @Override
    public ro.pava.pretpetrol.model.Price jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        ro.pava.pretpetrol.model.Price m = new ro.pava.pretpetrol.model.Price();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.JsonCoder decoder = null;
        reader = rootReader.newObjectReader("key");
        decoder = new org.slim3.datastore.json.Default();
        m.setKey(decoder.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("station");
        decoder = new org.slim3.datastore.json.Default();
        m.setStation(decoder.decode(reader, m.getStation()));
        reader = rootReader.newObjectReader("flavour");
        decoder = new org.slim3.datastore.json.Default();
        m.setFlavour(decoder.decode(reader, m.getFlavour()));
        reader = rootReader.newObjectReader("type");
        decoder = new org.slim3.datastore.json.Default();
        m.setType(decoder.decode(reader, m.getType(), ro.pava.pretpetrol.model.Type.class));
        // java.math.BigDecimal is not supported.
        reader = rootReader.newObjectReader("location");
        decoder = new org.slim3.datastore.json.Default();
        m.setLocation(decoder.decode(reader, m.getLocation()));
        reader = rootReader.newObjectReader("gpsLocation");
        decoder = new org.slim3.datastore.json.Default();
        m.setGpsLocation(decoder.decode(reader, m.getGpsLocation()));
        reader = rootReader.newObjectReader("user");
        decoder = new org.slim3.datastore.json.Default();
        m.setUser(decoder.decode(reader, m.getUser()));
        reader = rootReader.newObjectReader("reportDate");
        decoder = new org.slim3.datastore.json.Default();
        m.setReportDate(decoder.decode(reader, m.getReportDate()));
    return m;
}
}