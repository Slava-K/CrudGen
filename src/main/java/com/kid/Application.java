package com.kid;


import com.kid.crudgen.generators.ModelGenerator;

import com.kid.crudgen.SourceBuilder;
import com.kid.crudgen.builders.XmlModelBuilder;

import java.io.IOException;

public class Application {
    public static void main(String[] args){
        System.out.println("Start");

        SourceBuilder sb = new SourceBuilder(new ModelGenerator(),new XmlModelBuilder("C:\\Users\\konon\\Desktop\\model.xml"));

        try {
            sb.save("C:\\Users\\konon\\Desktop\\table.sql");
        }
        catch (IOException e) {
            System.out.println("Error save file");
        }
    }
}
