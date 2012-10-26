package com.betfair.blocantii.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-10-26 11:07:39")
/** */
public final class UserMeta extends org.slim3.datastore.ModelMeta<com.betfair.blocantii.model.User> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.betfair.blocantii.model.User> carNumber = new org.slim3.datastore.StringAttributeMeta<com.betfair.blocantii.model.User>(this, "carNumber", "carNumber");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.User, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.User, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.betfair.blocantii.model.User> phoneNumber = new org.slim3.datastore.StringAttributeMeta<com.betfair.blocantii.model.User>(this, "phoneNumber", "phoneNumber");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.betfair.blocantii.model.User> username = new org.slim3.datastore.StringAttributeMeta<com.betfair.blocantii.model.User>(this, "username", "username");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.betfair.blocantii.model.User> yahooId = new org.slim3.datastore.StringAttributeMeta<com.betfair.blocantii.model.User>(this, "yahooId", "yahooId");

    private static final UserMeta slim3_singleton = new UserMeta();

    /**
     * @return the singleton
     */
    public static UserMeta get() {
       return slim3_singleton;
    }

    /** */
    public UserMeta() {
        super("User", com.betfair.blocantii.model.User.class);
    }

    @Override
    public com.betfair.blocantii.model.User entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.betfair.blocantii.model.User model = new com.betfair.blocantii.model.User();
        model.setCarNumber((java.lang.String) entity.getProperty("carNumber"));
        model.setKey(entity.getKey());
        model.setPhoneNumber((java.lang.String) entity.getProperty("phoneNumber"));
        model.setUsername((java.lang.String) entity.getProperty("username"));
        model.setYahooId((java.lang.String) entity.getProperty("yahooId"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.betfair.blocantii.model.User m = (com.betfair.blocantii.model.User) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("carNumber", m.getCarNumber());
        entity.setProperty("phoneNumber", m.getPhoneNumber());
        entity.setProperty("username", m.getUsername());
        entity.setProperty("yahooId", m.getYahooId());
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.betfair.blocantii.model.User m = (com.betfair.blocantii.model.User) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.betfair.blocantii.model.User m = (com.betfair.blocantii.model.User) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(com.betfair.blocantii.model.User) is not defined.");
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
        com.betfair.blocantii.model.User m = (com.betfair.blocantii.model.User) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getCarNumber() != null){
            writer.setNextPropertyName("carNumber");
            encoder0.encode(writer, m.getCarNumber());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getPhoneNumber() != null){
            writer.setNextPropertyName("phoneNumber");
            encoder0.encode(writer, m.getPhoneNumber());
        }
        if(m.getUsername() != null){
            writer.setNextPropertyName("username");
            encoder0.encode(writer, m.getUsername());
        }
        if(m.getYahooId() != null){
            writer.setNextPropertyName("yahooId");
            encoder0.encode(writer, m.getYahooId());
        }
        writer.endObject();
    }

    @Override
    protected com.betfair.blocantii.model.User jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.betfair.blocantii.model.User m = new com.betfair.blocantii.model.User();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("carNumber");
        m.setCarNumber(decoder0.decode(reader, m.getCarNumber()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("phoneNumber");
        m.setPhoneNumber(decoder0.decode(reader, m.getPhoneNumber()));
        reader = rootReader.newObjectReader("username");
        m.setUsername(decoder0.decode(reader, m.getUsername()));
        reader = rootReader.newObjectReader("yahooId");
        m.setYahooId(decoder0.decode(reader, m.getYahooId()));
        return m;
    }
}