package ro.pava.pretpetrol.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-01-21 15:38:55")
/** */
public final class StationFlavorMeta extends org.slim3.datastore.ModelMeta<ro.pava.pretpetrol.model.StationFlavor> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<ro.pava.pretpetrol.model.StationFlavor, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<ro.pava.pretpetrol.model.StationFlavor, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<ro.pava.pretpetrol.model.StationFlavor> station = new org.slim3.datastore.StringAttributeMeta<ro.pava.pretpetrol.model.StationFlavor>(this, "station", "station");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<ro.pava.pretpetrol.model.StationFlavor> flavor = new org.slim3.datastore.StringAttributeMeta<ro.pava.pretpetrol.model.StationFlavor>(this, "flavor", "flavor");

    /** */
    public final org.slim3.datastore.UnindexedAttributeMeta<ro.pava.pretpetrol.model.StationFlavor, java.math.BigDecimal> flavorPrice = new org.slim3.datastore.UnindexedAttributeMeta<ro.pava.pretpetrol.model.StationFlavor, java.math.BigDecimal>(this, "flavorPrice", "flavorPrice", java.math.BigDecimal.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<ro.pava.pretpetrol.model.StationFlavor, java.lang.Integer> flavorPriceCount = new org.slim3.datastore.CoreAttributeMeta<ro.pava.pretpetrol.model.StationFlavor, java.lang.Integer>(this, "flavorPriceCount", "flavorPriceCount", int.class);

    /** */
    public final org.slim3.datastore.UnindexedAttributeMeta<ro.pava.pretpetrol.model.StationFlavor, java.math.BigDecimal> stationPricePetrol = new org.slim3.datastore.UnindexedAttributeMeta<ro.pava.pretpetrol.model.StationFlavor, java.math.BigDecimal>(this, "stationPricePetrol", "stationPricePetrol", java.math.BigDecimal.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<ro.pava.pretpetrol.model.StationFlavor, java.lang.Integer> stationPricePetrolCount = new org.slim3.datastore.CoreAttributeMeta<ro.pava.pretpetrol.model.StationFlavor, java.lang.Integer>(this, "stationPricePetrolCount", "stationPricePetrolCount", int.class);

    /** */
    public final org.slim3.datastore.UnindexedAttributeMeta<ro.pava.pretpetrol.model.StationFlavor, java.math.BigDecimal> stationPriceDiesel = new org.slim3.datastore.UnindexedAttributeMeta<ro.pava.pretpetrol.model.StationFlavor, java.math.BigDecimal>(this, "stationPriceDiesel", "stationPriceDiesel", java.math.BigDecimal.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<ro.pava.pretpetrol.model.StationFlavor, java.lang.Integer> stationPriceDieselCount = new org.slim3.datastore.CoreAttributeMeta<ro.pava.pretpetrol.model.StationFlavor, java.lang.Integer>(this, "stationPriceDieselCount", "stationPriceDieselCount", int.class);

    private static final StationFlavorMeta slim3_singleton = new StationFlavorMeta();

    /**
     * @return the singleton
     */
    public static StationFlavorMeta get() {
       return slim3_singleton;
    }

    /** */
    public StationFlavorMeta() {
        super("StationFlavor", ro.pava.pretpetrol.model.StationFlavor.class);
    }

    @Override
    public ro.pava.pretpetrol.model.StationFlavor entityToModel(com.google.appengine.api.datastore.Entity entity) {
        ro.pava.pretpetrol.model.StationFlavor model = new ro.pava.pretpetrol.model.StationFlavor();
        model.setKey(entity.getKey());
        model.setStation((java.lang.String) entity.getProperty("station"));
        model.setFlavor((java.lang.String) entity.getProperty("flavor"));
        java.math.BigDecimal _flavorPrice = blobToSerializable((com.google.appengine.api.datastore.Blob) entity.getProperty("flavorPrice"));
        model.setFlavorPrice(_flavorPrice);
        model.setFlavorPriceCount(longToPrimitiveInt((java.lang.Long) entity.getProperty("flavorPriceCount")));
        java.math.BigDecimal _stationPricePetrol = blobToSerializable((com.google.appengine.api.datastore.Blob) entity.getProperty("stationPricePetrol"));
        model.setStationPricePetrol(_stationPricePetrol);
        model.setStationPricePetrolCount(longToPrimitiveInt((java.lang.Long) entity.getProperty("stationPricePetrolCount")));
        java.math.BigDecimal _stationPriceDiesel = blobToSerializable((com.google.appengine.api.datastore.Blob) entity.getProperty("stationPriceDiesel"));
        model.setStationPriceDiesel(_stationPriceDiesel);
        model.setStationPriceDieselCount(longToPrimitiveInt((java.lang.Long) entity.getProperty("stationPriceDieselCount")));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        ro.pava.pretpetrol.model.StationFlavor m = (ro.pava.pretpetrol.model.StationFlavor) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("station", m.getStation());
        entity.setProperty("flavor", m.getFlavor());
        entity.setUnindexedProperty("flavorPrice", serializableToBlob(m.getFlavorPrice()));
        entity.setProperty("flavorPriceCount", m.getFlavorPriceCount());
        entity.setUnindexedProperty("stationPricePetrol", serializableToBlob(m.getStationPricePetrol()));
        entity.setProperty("stationPricePetrolCount", m.getStationPricePetrolCount());
        entity.setUnindexedProperty("stationPriceDiesel", serializableToBlob(m.getStationPriceDiesel()));
        entity.setProperty("stationPriceDieselCount", m.getStationPriceDieselCount());
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        ro.pava.pretpetrol.model.StationFlavor m = (ro.pava.pretpetrol.model.StationFlavor) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        ro.pava.pretpetrol.model.StationFlavor m = (ro.pava.pretpetrol.model.StationFlavor) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(ro.pava.pretpetrol.model.StationFlavor) is not defined.");
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
    }

    @Override
    protected void prePut(Object model) {
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
        ro.pava.pretpetrol.model.StationFlavor m = (ro.pava.pretpetrol.model.StationFlavor) model;
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
        if(m.getFlavor() != null){
            writer.setNextPropertyName("flavor");
            encoder = new org.slim3.datastore.json.Default();
            encoder.encode(writer, m.getFlavor());
        }
        // java.math.BigDecimal is not supported.
        writer.setNextPropertyName("flavorPriceCount");
        encoder = new org.slim3.datastore.json.Default();
        encoder.encode(writer, m.getFlavorPriceCount());
        // java.math.BigDecimal is not supported.
        writer.setNextPropertyName("stationPricePetrolCount");
        encoder = new org.slim3.datastore.json.Default();
        encoder.encode(writer, m.getStationPricePetrolCount());
        // java.math.BigDecimal is not supported.
        writer.setNextPropertyName("stationPriceDieselCount");
        encoder = new org.slim3.datastore.json.Default();
        encoder.encode(writer, m.getStationPriceDieselCount());
        writer.endObject();
    }

    @Override
    public ro.pava.pretpetrol.model.StationFlavor jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        ro.pava.pretpetrol.model.StationFlavor m = new ro.pava.pretpetrol.model.StationFlavor();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.JsonCoder decoder = null;
        reader = rootReader.newObjectReader("key");
        decoder = new org.slim3.datastore.json.Default();
        m.setKey(decoder.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("station");
        decoder = new org.slim3.datastore.json.Default();
        m.setStation(decoder.decode(reader, m.getStation()));
        reader = rootReader.newObjectReader("flavor");
        decoder = new org.slim3.datastore.json.Default();
        m.setFlavor(decoder.decode(reader, m.getFlavor()));
        // java.math.BigDecimal is not supported.
        reader = rootReader.newObjectReader("flavorPriceCount");
        decoder = new org.slim3.datastore.json.Default();
        m.setFlavorPriceCount(decoder.decode(reader, m.getFlavorPriceCount()));
        // java.math.BigDecimal is not supported.
        reader = rootReader.newObjectReader("stationPricePetrolCount");
        decoder = new org.slim3.datastore.json.Default();
        m.setStationPricePetrolCount(decoder.decode(reader, m.getStationPricePetrolCount()));
        // java.math.BigDecimal is not supported.
        reader = rootReader.newObjectReader("stationPriceDieselCount");
        decoder = new org.slim3.datastore.json.Default();
        m.setStationPriceDieselCount(decoder.decode(reader, m.getStationPriceDieselCount()));
    return m;
}
}