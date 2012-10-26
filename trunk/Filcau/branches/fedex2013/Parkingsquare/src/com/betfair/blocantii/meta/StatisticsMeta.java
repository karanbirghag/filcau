package com.betfair.blocantii.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-10-26 12:35:10")
/** */
public final class StatisticsMeta extends org.slim3.datastore.ModelMeta<com.betfair.blocantii.model.Statistics> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Statistics, java.lang.Integer> blockedSpots = new org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Statistics, java.lang.Integer>(this, "blockedSpots", "blockedSpots", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Statistics, java.lang.Integer> blockingSpots = new org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Statistics, java.lang.Integer>(this, "blockingSpots", "blockingSpots", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Statistics, java.lang.Integer> freeSpots = new org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Statistics, java.lang.Integer>(this, "freeSpots", "freeSpots", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Statistics, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Statistics, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Statistics, java.lang.Integer> occupiedSpots = new org.slim3.datastore.CoreAttributeMeta<com.betfair.blocantii.model.Statistics, java.lang.Integer>(this, "occupiedSpots", "occupiedSpots", int.class);

    private static final StatisticsMeta slim3_singleton = new StatisticsMeta();

    /**
     * @return the singleton
     */
    public static StatisticsMeta get() {
       return slim3_singleton;
    }

    /** */
    public StatisticsMeta() {
        super("Statistics", com.betfair.blocantii.model.Statistics.class);
    }

    @Override
    public com.betfair.blocantii.model.Statistics entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.betfair.blocantii.model.Statistics model = new com.betfair.blocantii.model.Statistics();
        model.setBlockedSpots(longToPrimitiveInt((java.lang.Long) entity.getProperty("blockedSpots")));
        model.setBlockingSpots(longToPrimitiveInt((java.lang.Long) entity.getProperty("blockingSpots")));
        model.setFreeSpots(longToPrimitiveInt((java.lang.Long) entity.getProperty("freeSpots")));
        model.setKey(entity.getKey());
        model.setOccupiedSpots(longToPrimitiveInt((java.lang.Long) entity.getProperty("occupiedSpots")));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.betfair.blocantii.model.Statistics m = (com.betfair.blocantii.model.Statistics) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("blockedSpots", m.getBlockedSpots());
        entity.setProperty("blockingSpots", m.getBlockingSpots());
        entity.setProperty("freeSpots", m.getFreeSpots());
        entity.setProperty("occupiedSpots", m.getOccupiedSpots());
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.betfair.blocantii.model.Statistics m = (com.betfair.blocantii.model.Statistics) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.betfair.blocantii.model.Statistics m = (com.betfair.blocantii.model.Statistics) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(com.betfair.blocantii.model.Statistics) is not defined.");
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
        com.betfair.blocantii.model.Statistics m = (com.betfair.blocantii.model.Statistics) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        writer.setNextPropertyName("blockedSpots");
        encoder0.encode(writer, m.getBlockedSpots());
        writer.setNextPropertyName("blockingSpots");
        encoder0.encode(writer, m.getBlockingSpots());
        writer.setNextPropertyName("freeSpots");
        encoder0.encode(writer, m.getFreeSpots());
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        writer.setNextPropertyName("occupiedSpots");
        encoder0.encode(writer, m.getOccupiedSpots());
        writer.endObject();
    }

    @Override
    protected com.betfair.blocantii.model.Statistics jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.betfair.blocantii.model.Statistics m = new com.betfair.blocantii.model.Statistics();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("blockedSpots");
        m.setBlockedSpots(decoder0.decode(reader, m.getBlockedSpots()));
        reader = rootReader.newObjectReader("blockingSpots");
        m.setBlockingSpots(decoder0.decode(reader, m.getBlockingSpots()));
        reader = rootReader.newObjectReader("freeSpots");
        m.setFreeSpots(decoder0.decode(reader, m.getFreeSpots()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("occupiedSpots");
        m.setOccupiedSpots(decoder0.decode(reader, m.getOccupiedSpots()));
        return m;
    }
}