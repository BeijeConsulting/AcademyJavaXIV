package it.beije.turing.xmlparser3.classes;


public class Attributo{

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String name;
    private String value;

    @Override
    public String toString() {
        return "Name= "+this.name+" Value= "+this.value;
    }
}
