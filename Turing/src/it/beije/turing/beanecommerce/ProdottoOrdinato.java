package it.beije.turing.beanecommerce;

import javax.persistence.*;
import java.sql.Date;

public class ProdottoOrdinato {

    @Entity
    @Table(name = "carte")
    public class Carta{
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="id")
        private int id;

        @Column(name = "prodotto_id")
        private int prodotto_id;
        @Column(name = "quantità")
        private int quantita;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getProdotto_id() {
            return prodotto_id;
        }

        public void setProdotto_id(int prodotto_id) {
            this.prodotto_id = prodotto_id;
        }

        public int getQuantita() {
            return quantita;
        }

        public void setQuantita(int quantita) {
            this.quantita = quantita;
        }

        @Override
        public String toString() {
            return "Carta{" +
                    "id=" + id +
                    ", prodotto_id=" + prodotto_id +
                    ", quantita=" + quantita +
                    '}';
        }
    }
}
