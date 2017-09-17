package com.kid.crudgen.generators;

import com.kid.crudgen.model.Model;
import com.kid.crudgen.model.Requisite;

public class ModelGenerator implements Generator {

    @Override
    public StringBuilder getText(Model model) {

        StringBuilder sb = new StringBuilder();

        sb.append("public class " + capitalize(model.getShortName()) + "{" + System.lineSeparator());


        for(Requisite r : model.getRequisites()){
            sb.append("\tprivate " + r.getType().getJavaType() + " " + r.getShortName() + ";" + System.lineSeparator());
        }

        sb.append(System.lineSeparator());

        for(Requisite r : model.getRequisites()){
            sb.append("\tpublic "+r.getType().getJavaType()+" get"+capitalize(r.getShortName())+"() { "+System.lineSeparator()+
                    "\t\treturn "+r.getShortName()+";"+System.lineSeparator()+
                    "\t}"+ System.lineSeparator());

            sb.append("\tpublic void set"+capitalize(r.getShortName())+"("+r.getType().getJavaType()+" "+r.getShortName()+") {"+System.lineSeparator()+
                    "\t\tthis."+r.getShortName()+" = "+r.getShortName()+";"+System.lineSeparator()+
                    "\t}"+ System.lineSeparator());
        }

        sb.append("}");


        return sb;
    }

    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
