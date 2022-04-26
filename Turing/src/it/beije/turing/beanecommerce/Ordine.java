package it.beije.turing.beanecommerce;

import javax.persistence.*;
import java.sql.Date;

public class Ordine {
    @Entity
    @Table(name = "carte")
    public class Carta {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "data")
        private Date data;
        @Column(name = "utenti_id")
        private int utenti_id;
        @Column(name = "indirizzo_spedizione_id")
        private int indirizzo_spedizione_id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getData() {
            return data;
        }

        public void setData(Date data) {
            this.data = data;
        }

        public int getUtenti_id() {
            return utenti_id;
        }

        public void setUtenti_id(int utenti_id) {
            this.utenti_id = utenti_id;
        }

        public int getIndirizzo_spedizione_id() {
            return indirizzo_spedizione_id;
        }

        public void setIndirizzo_spedizione_id(int indirizzo_spedizione_id) {
            this.indirizzo_spedizione_id = indirizzo_spedizione_id;
        }

        @Override
        public String toString() {
            return "Carta{" +
                    "id=" + id +
                    ", data=" + data +
                    ", utenti_id=" + utenti_id +
                    ", indirizzo_spedizione_id=" + indirizzo_spedizione_id +
                    '}';
        }
    }

}
