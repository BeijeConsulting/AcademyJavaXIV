package it.beije.turing.db;

import java.util.List;

import it.beije.turing.rubrica.Contatto;

public interface DbInterface {
public List<Contatto> getContatti();
public void insertContatti(Contatto c);
public void updateContatti(Contatto c);
public Contatto getContatto(int id);
}
