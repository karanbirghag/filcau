package com.betfair.blocantii.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-10-26 11:38:35")
/** */
public final class SpotMeta extends org.slim3.datastore.ModelMeta<com.betfair.blocantii.model.Spot> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Spot, java.lang.Boolean> blocked = new org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Spot, java.lang.Boolean>(this, "blocked", "blocked", boolean.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Spot, java.lang.Boolean> blocking = new org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Spot, java.lang.Boolean>(this, "blocking", "blocking", boolean.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Spot, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Spot, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.betfair.blocantii.model.Spot> type = new org.slim3.datastore.StringAttributeMeta<com.betfair.blocantii.model.Spot>(this, "type", "type");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.betfair.blocantii.model.Spot, org.slim3.datastore.ModelRef<com.betfair.blocantii.model.User>, com.betfair.blocantii.model.User> user = new org.slim3.datastore.ModelRefAttributeMeta<com.betfair.blocantii.model.Spot, org.slim3.datastore.ModelRef<com.betfair.blocantii.model.User>, com.betfair.blocantii.model.User>(this, "user", "user", org.slim3.datastore.ModelRef.class, com.betfair.blocantii.model.User.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Spot, java.lang.Integer> x1 = new org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Spot, java.lang.Integer>(this, "x1", "x1", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Spot, java.lang.Integer> x2 = new org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Spot, java.lang.Integer>(this, "x2", "x2", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Spot, java.lang.Integer> y1 = new org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Spot, java.lang.Integer>(this, "y1", "y1", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Spot, java.lang.Integer> y2 = new org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Spot, java.lang.Integer>(this, "y2", "y2", int.class);

    private static final SpotMeta slim3_singleton = new SpotMeta();

    /**
     * @return the singleton
     */
    public static SpotMeta get() {
       return slim3_singleton;
    }

    /** */
    public SpotMeta() {
        super("Spot", com.betfair.blocantii.model.Spot.class);
    }

    @Override
    public com.betfair.blocantii.model.Spot entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.betfair.blocantii.model.Spot model = new com.betfair.blocantii.model.Spot();
        model.setBlocked(booleanToPrimitiveBoolean((java.lang.Boolean) entity.getProperty("blocked")));
        model.setBlocking(booleanToPrimitiveBoolean((java.lang.Boolean) entity.getProperty("blocking")));
        model.setKey(entity.getKey());
        model.setType((java.lang.String) entity.getProperty("type"));
        if (model.getUser() == null) {
            throw new NullPointerException("The property(user) is null.");
        }
        model.getUser().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("user"));
        model.setX1(longToPrimitiveInt((java.lang.Long) entity.getProperty("x1")));
        model.setX2(longToPrimitiveInt((java.lang.Long) entity.getProperty("x2")));
        model.setY1(longToPrimitiveInt((java.lang.Long) entity.getProperty("y1")));
        model.setY2(longToPrimitiveInt((java.lang.Long) entity.getProperty("y2")));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.betfair.blocantii.model.Spot m = (com.betfair.blocantii.model.Spot) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("blocked", m.isBlocked());
        entity.setProperty("blocking", m.isBlocking());
        entity.setProperty("type", m.getType());
        if (m.getUser() == null) {
            throw new NullPointerException("The property(user) must not be null.");
        }
        entity.setProperty("user", m.getUser().getKey());
        entity.setProperty("x1", m.getX1());
        entity.setProperty("x2", m.getX2());
        entity.setProperty("y1", m.getY1());
        entity.setProperty("y2", m.getY2());
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.betfair.blocantii.model.Spot m = (com.betfair.blocantii.model.Spot) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.betfair.blocantii.model.Spot m = (com.betfair.blocantii.model.Spot) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(com.betfair.blocantii.model.Spot) is not defined.");
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.betfair.blocantii.model.Spot m = (com.betfair.blocantii.model.Spot) model;
        if (m.getUser() == null) {
            throw new NullPointerException("The property(user) must not be null.");
        }
        m.getUser().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    protected void postGet(Object model) {
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
        com.betfair.blocantii.model.Spot m = (com.betfair.blocantii.model.Spot) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        writer.setNextPropertyName("blocked");
        encoder0.encode(writer, m.isBlocked());
        writer.setNextPropertyName("blocking");
        encoder0.encode(writer, m.isBlocking());
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getType() != null){
            writer.setNextPropertyName("type");
            encoder0.encode(writer, m.getType());
        }
        if(m.getUser() != null && m.getUser().getKey() != null){
            writer.setNextPropertyName("user");
            encoder0.encode(writer, m.getUser(), maxDepth, currentDepth);
        }
        writer.setNextPropertyName("x1");
        encoder0.encode(writer, m.getX1());
        writer.setNextPropertyName("x2");
        encoder0.encode(writer, m.getX2());
        writer.setNextPropertyName("y1");
        encoder0.encode(writer, m.getY1());
        writer.setNextPropertyName("y2");
        encoder0.encode(writer, m.getY2());
        writer.endObject();
    }

    @Override
    protected com.betfair.blocantii.model.Spot jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.betfair.blocantii.model.Spot m = new com.betfair.blocantii.model.Spot();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("blocked");
        m.setBlocked(decoder0.decode(reader, m.isBlocked()));
        reader = rootReader.newObjectReader("blocking");
        m.setBlocking(decoder0.decode(reader, m.isBlocking()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("type");
        m.setType(decoder0.decode(reader, m.getType()));
        reader = rootReader.newObjectReader("user");
        decoder0.decode(reader, m.getUser(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("x1");
        m.setX1(decoder0.decode(reader, m.getX1()));
        reader = rootReader.newObjectReader("x2");
        m.setX2(decoder0.decode(reader, m.getX2()));
        reader = rootReader.newObjectReader("y1");
        m.setY1(decoder0.decode(reader, m.getY1()));
        reader = rootReader.newObjectReader("y2");
        m.setY2(decoder0.decode(reader, m.getY2()));
        return m;
    }
}