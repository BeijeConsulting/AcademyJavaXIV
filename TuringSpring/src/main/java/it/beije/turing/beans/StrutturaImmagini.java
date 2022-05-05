package it.beije.turing.beans;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "struttura_immagini")
public class StrutturaImmagini {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)//, fetch = FetchType.LAZY
    @JoinColumn(name="id")
    private Struttura struttura;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)//, fetch = FetchType.LAZY
    @JoinColumn(name="id")
    private List<Immagine> immagine;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Struttura getStruttura() {
        return struttura;
    }

    public void setStruttura(Struttura struttura) {
        this.struttura = struttura;
    }

    public List<Immagine> getImmagine() {
        return immagine;
    }

    public void setImmagine(List<Immagine> immagine) {
        this.immagine = immagine;
    }


}