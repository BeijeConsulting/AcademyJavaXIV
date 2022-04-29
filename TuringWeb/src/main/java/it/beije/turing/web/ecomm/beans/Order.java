package it.beije.turing.web.ecomm.beans;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="ordine")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @ManyToOne
    @JoinColumn(name="idCliente")
    private Client idCliente;
    @Column(name = "valoreTotale")
    private double valoreTotale;
    @Column(name = "stato")
    private String stato;
    @OneToMany(mappedBy="idOrdine")
    private List<Transaction> Carrello;

    public Order(){
        this(null, 0.00, "");
    }

    public Order(Client idCliente, double valoreTotale, String stato) {

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

    public Client getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Client idCliente) {
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

    @Override
    public String toString() {
        return "Ordine  [" +
                " Id = " + id +
                " , IdCliente = " + idCliente.getId() +
                " , ValoreTotale=" + valoreTotale +
                " , Stato='" + stato + '\'' +
                " ] ";
    }

	public List<Transaction> getCarrello() {
		return Carrello;
	}

	public void setCarrello(List<Transaction> carrello) {
		Carrello = carrello;
	}
}
