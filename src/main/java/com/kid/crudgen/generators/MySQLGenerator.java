package com.kid.crudgen.generators;

import com.kid.crudgen.model.Model;
import com.kid.crudgen.model.Requisite;

public class MySQLGenerator implements Generator {

    @Override
    public StringBuilder getText(Model model) {

        StringBuilder sb = new StringBuilder();

        sb.append("--" + model.getName() + System.lineSeparator());

        sb.append("CREATE TABLE " + model.getShortName() + "(" + System.lineSeparator());

        String separator = "";

        for(Requisite r : model.getRequisites()){
            sb.append("\t" + separator + r.getShortName()+ " " + r.getType().getDbType() + System.lineSeparator());
            separator = ", ";
        }

        sb.append(");");

        return sb;
    }
}
