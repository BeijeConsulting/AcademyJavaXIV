package it.beije.turing.xmlparser3.classes;

/**
 * @author Giuseppe Raddato
 * Data: 14 apr 2022
 */

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

}
