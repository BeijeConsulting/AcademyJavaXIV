package it.beije.turing.Ecomm.Beans;

import javax.persistence.*;
@Entity
@Table(name="prodotto")
public class Prodotto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "costo")
    private double costo;
    @Column(name = "quantita")
    private int quantitaP;

    public Prodotto(){
        this("", 0.00, 0);
    }


    public Prodotto( String nome, double costo, int quantitaP) {

        this.nome = nome;
        this.costo = costo;
        this.quantitaP = quantitaP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getQuantitaP() {
        return quantitaP;
    }

    public void setQuantitaP(int quantitaP) {
        this.quantitaP = quantitaP;
    }

    @Override
    public String toString() {
        return "  Prodotto [ " +
                " Id=" + id +
                " , Nome= " + nome + '\'' +
                " , Costo= " + costo +
                " , Quantita' = " + quantitaP +
                " ]";
    }
}
