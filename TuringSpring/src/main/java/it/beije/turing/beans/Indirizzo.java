package it.beije.turing.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "indirizzo" )
@JsonInclude(Include.NON_NULL)
public class Indirizzo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="cap")
    private String cap;
    @Column(name="citta")
    private String citta;
    @Column(name="provincia")
    private String provincia;
    @Column(name="via")
    private String via;
    @Column(name="stato")
    private String stato;
    @Column(name="numero_civico")
    private String numeroCivico;
    @Column(name="coordinate")
    private String coordinate;
    public Integer getId() {
        return id;
    }

        public void setId(Integer id) {
        this.id = id;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getNumeroCivico() {
        return numeroCivico;
    }

    public void setNumeroCivico(String numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }


    @Override
    public String toString() {
        return "Indirizzo{" +
                "id=" + id +
                ", cap='" + cap + '\'' +
                ", citta='" + citta + '\'' +
                ", provincia='" + provincia + '\'' +
                ", via='" + via + '\'' +
                ", stato='" + stato + '\'' +
                ", numeroCivico='" + numeroCivico + '\'' +
                ", coordinate='" + coordinate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Indirizzo indirizzo = (Indirizzo) o;
        return Objects.equals(id, indirizzo.id) && Objects.equals(cap, indirizzo.cap) && Objects.equals(citta, indirizzo.citta) && Objects.equals(provincia, indirizzo.provincia) && Objects.equals(via, indirizzo.via) && Objects.equals(stato, indirizzo.stato) && Objects.equals(numeroCivico, indirizzo.numeroCivico) && Objects.equals(coordinate, indirizzo.coordinate);
    }
}
