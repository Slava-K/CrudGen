package com.kid.crudgen.builders;

import com.kid.crudgen.model.Model;

public interface ModelBuilder {
    public Model getModel();
    public void saveModel(Model model);
}
