package it.beije.turing.rubrica.db;

import java.util.List;

import it.beije.turing.rubrica.bean.Contatto;

public interface DbInterface {
public List<Contatto> getContatti();
public void insertContatti(Contatto c);
public void updateContatti(Contatto c);
public Contatto getContatto(int id);
public List<Contatto> search(String string);
public List<Contatto> getOrdered(String string);
public void delete(int parseInt);
}
