package it.beije.turing;

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
    private Struttura strutturaId;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)//, fetch = FetchType.LAZY
    @JoinColumn(name="id")
    private List<Immagine> immagineId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStrutturaId() {
        return strutturaId;
    }

    public void setStrutturaId(Integer strutturaId) {
        this.strutturaId = strutturaId;
    }

    public List<Immagine> getImmagineId() {
        return immagineId;
    }

    public void setImmagineId(List<Immagine> immagineId) {
        this.immagineId = immagineId;
    }


}