package it.beije.turing;

import javax.persistence.*;

@Entity
@Table(name = "tipologia_struttura")
public class TipoStruttura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tipo")
    private String tipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TipoStruttura{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
