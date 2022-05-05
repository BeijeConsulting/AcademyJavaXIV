package it.beije.turing.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recensioni")
public class Recensione {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "testo")
    private String testo;

    @Column(name = "punteggio")
    private Integer punteggio;

    @Column(name = "data")
    private Date data;

    @Column(name = "utente_id")
    private Integer reviewerId;

    @Column(name = "periodo_prenotazione_id")
    private Integer prenotazioneId;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTesto() {
        return testo;
    }
    public void setTesto(String testo) {
        this.testo = testo;
    }

    public Integer getPunteggio() {
        return punteggio;
    }
    public void setPunteggio(Integer punteggio) {
        this.punteggio = punteggio;
    }

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }

    public Integer getReviewerId() {
        return reviewerId;
    }
    public void setReviewerId(Integer reviewerId) {
        this.reviewerId = reviewerId;
    }

    public Integer getPrenotazioneId() {
        return prenotazioneId;
    }
    public void setPrenotazioneId(Integer prenotazioneId) {
        this.prenotazioneId = prenotazioneId;
    }

    @Override
    public String toString() {
        return "Recensione{" +
                "id=" + id +
                ", testo='" + testo + '\'' +
                ", punteggio=" + punteggio +
                ", data=" + data +
                ", reviewerId=" + reviewerId +
                ", prenotazioneId=" + prenotazioneId +
                '}';
    }

}
