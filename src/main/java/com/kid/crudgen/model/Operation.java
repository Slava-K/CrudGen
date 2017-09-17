package com.kid.crudgen.model;

import java.util.List;

public class Operation {


    public enum OperationType {
        Simple
        ,Group
        ,List
        ,Library
    }

    private String name;
    private String shortName;
    private OperationType operationType;
    private String returnType;
    private List<Parametr> parameters;

    public Operation(String name, String shortName, OperationType operationType, String returnType, List<Parametr> parameters) {
        this.name = name;
        this.shortName = shortName;
        this.operationType = operationType;
        this.returnType = returnType;
        this.parameters = parameters;
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

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public List<Parametr> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parametr> parameters) {
        this.parameters = parameters;
    }
}
