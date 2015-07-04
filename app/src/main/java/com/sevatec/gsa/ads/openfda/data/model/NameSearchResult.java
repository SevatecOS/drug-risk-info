package com.sevatec.gsa.ads.openfda.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NameSearchResult implements Serializable {

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
    
    public static class Name implements Serializable {

        private String name;

        public Name() {
            // noop
        }
        
        public Name(String name) {
            this.name = name;
        }
        
        
        
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
	
}


