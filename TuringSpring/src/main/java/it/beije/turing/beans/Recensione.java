package it.beije.turing.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
        import javax.persistence.JoinColumn;
        import javax.persistence.OneToMany;
        import javax.persistence.Table;
        import javax.persistence.Transient;

        import com.fasterxml.jackson.annotation.JsonGetter;
        import com.fasterxml.jackson.annotation.JsonIgnore;
        import com.fasterxml.jackson.annotation.JsonInclude;
        import com.fasterxml.jackson.annotation.JsonSetter;
        import com.fasterxml.jackson.annotation.JsonInclude.Include;
        import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "recensioni")
@JsonInclude(Include.NON_NULL)
public class Recensione {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @JsonProperty("text")
    @Column(name = "testo")
    private String testo;

    @JsonProperty("score")
    @Column(name = "punteggio")
    private Integer punteggio;

    @JsonProperty("date")
    @Column(name = "data")
    private String data;
//    @ManyToOne()
    @JsonProperty("user_id")
    @Column(name = "utente_id")
    private Integer reviewerId;

    @JsonProperty("booking_id")
    @Column(name = "periodo_prenotato_id")
    private Integer prenotazioneId;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId() {
        return id;
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

    public String getData() {
        return data;
    }
    public void setData(String data) {
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
