package it.beije.turing.beans;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "periodi_prenotati")
public class PeriodoPrenotato
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@ManyToOne(cascade=CascadeType.MERGE, fetch = FetchType.EAGER)//, fetch = FetchType.LAZY
	@JoinColumn(name="annuncio_id")
	private Annuncio annuncio;
	
	@Column(name = "data_inizio")
	private LocalDate dataInizio;
	
	@Column(name = "data_fine")
	private LocalDate dataFine;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)//, fetch = FetchType.LAZY
	@JoinColumn(name="utente_id")
	private Utente ospiteId;
	
	@Column(name = "stato_pagamento")
	private String statoPagamento;
	
	@Column(name = "stato_accettazione")
	private String statoAccettazione;

	public Annuncio getAnnuncio() {
		return annuncio;
	}

	public void setAnnuncio(Annuncio annuncio) {
		this.annuncio = annuncio;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}

	public Utente getOspiteId() {
		return ospiteId;
	}

	public void setOspiteId(Utente ospiteId) {
		this.ospiteId = ospiteId;
	}

	public String getStatoPagamento() {
		return statoPagamento;
	}

	public void setStatoPagamento(String statoPagamento) {
		this.statoPagamento = statoPagamento;
	}

	public String getStatoAccettazione() {
		return statoAccettazione;
	}

	public void setStatoAccettazione(String statoAccettazione) {
		this.statoAccettazione = statoAccettazione;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "PeriodoPrenotato [id=" + id + ", annuncio=" + annuncio + ", dataInizio=" + dataInizio + ", dataFine="
				+ dataFine + ", ospiteId=" + ospiteId + ", statoPagamento=" + statoPagamento + ", statoAccettazione="
				+ statoAccettazione + "]";
	}
}