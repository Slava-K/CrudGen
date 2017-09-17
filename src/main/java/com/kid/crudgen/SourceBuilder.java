package com.kid.crudgen;

import com.kid.crudgen.builders.ModelBuilder;
import com.kid.crudgen.generators.Generator;

import java.io.FileWriter;
import java.io.IOException;

public class SourceBuilder {

    private Generator sqlGenerator;
    private ModelBuilder modelBuilder;

    public SourceBuilder(Generator sqlGenerator, ModelBuilder modelBuilder){
        this.sqlGenerator = sqlGenerator;
        this.modelBuilder = modelBuilder;
    }

    public void save(String path) throws IOException {
        StringBuilder sb = sqlGenerator.getText(modelBuilder.getModel());

        try (FileWriter writer = new FileWriter(path)) {
            writer.write(sb.toString());
        }
    }

}
