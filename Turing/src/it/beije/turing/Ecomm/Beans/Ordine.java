package it.beije.turing.Ecomm.Beans;

import javax.persistence.*;


public class Ordine {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "idCliente")
    private int idCliente;
    @Column(name = "valoreTotale")
    private double valoreTotale;
    @Column(name = "stato")
    private String stato;


    public Ordine(int id, int idCliente, double valoreTotale, String stato) {
        this.id = id;
        this.idCliente = idCliente;
        this.valoreTotale = valoreTotale;
        this.stato = stato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getValoreTotale() {
        return valoreTotale;
    }

    public void setValoreTotale(double valoreTotale) {
        this.valoreTotale = valoreTotale;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }
}
