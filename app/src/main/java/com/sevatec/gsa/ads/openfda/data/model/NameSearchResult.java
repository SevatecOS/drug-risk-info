package com.sevatec.gsa.ads.openfda.data.model;

import java.util.ArrayList;
import java.util.List;

public class NameSearchResult {

    private List<Name> names = new ArrayList<Name>();

    public List<Name> getNames() {
        return names;
    }
    public void setNames(List<Name> names) {
        this.names = names;
    }

    public void addName(String name) {
        getNames().add(new Name(name));
    }
	
}

class Name {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Name(String name) {
        this.name = name;
    }

}
