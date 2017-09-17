package com.kid.crudgen.generators;

import com.kid.crudgen.model.Model;

public interface Generator {
    public StringBuilder getText(Model model);
}
