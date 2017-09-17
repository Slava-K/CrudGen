package com.kid.crudgen.model;

public class Type {
    private String name;
    private String shortName;
    private String dbType;
    private String javaType;

    public Type(String name, String shortName, String dbType, String javaType) {
        this.name = name;
        this.shortName = shortName;
        this.dbType = dbType;
        this.javaType = javaType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }
}
