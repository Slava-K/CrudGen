package com.kid.crudgen.model;

import java.util.List;

public class Model {
    private String name;
    private String shortName;
    private List<Requisite> requisites;

    public Model() {

    }
    public Model(String name, String shortName, List<Requisite> requisites){
        this.name = name;
        this.shortName = shortName;
        this.requisites = requisites;
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

    public List<Requisite> getRequisites() {
        return requisites;
    }

    public void setRequisites(List<Requisite> requisite) {
        this.requisites = requisite;
    }
}
