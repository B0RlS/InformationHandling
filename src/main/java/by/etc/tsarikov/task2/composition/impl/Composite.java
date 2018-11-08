package by.etc.tsarikov.task2.composition.impl;

import by.etc.tsarikov.task2.action.Collection;
import by.etc.tsarikov.task2.action.Iterator;
import by.etc.tsarikov.task2.composition.Version;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Version, Collection {
    private String str;
    private List<Version> versions = new ArrayList<>();

    public Composite(){}

    public Composite(String str){
        this.str = str;
    }


    public void add(Version version){
        this.versions.add(version);
    }

    public void remove(Version version){
        this.versions.remove(version);
    }

    @Override
    public Version getElement(int index) {
        return versions.get(index);
    }

    @Override
    public void parse() {

    }

    @Override
    public Iterator getIterator() {
        return new VersionIterator();
    }

    private class VersionIterator implements Iterator{
        int index;

        @Override
        public boolean hasNext() {
            if(index < versions.size()){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            return versions.get(index++);
        }
    }
}
