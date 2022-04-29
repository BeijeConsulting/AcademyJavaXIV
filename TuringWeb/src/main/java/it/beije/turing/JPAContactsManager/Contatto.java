package main.java.it.beije.turing.JPAContactsManager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Scanner;


@Entity
@Table(name = "rubrica")
public class Contatto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "note")
    private String note;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public static Contatto inputCreaContatto() {
        Contatto contatto = new Contatto();
        Scanner scan = new Scanner(System.in);

        System.out.println("Se vuoi saltare il campo non inserire nessun carattere e premi invio. ");
        System.out.println("Inserisci il nome: ");
        contatto.setNome(scan.nextLine());
        System.out.println("Inserisci il cognome: ");
        contatto.setCognome(scan.nextLine());
        System.out.println("Inserisci il numero di telefono: ");
        contatto.setTelefono(scan.nextLine());
        System.out.println("Inserisci l'email: ");
        contatto.setEmail(scan.nextLine());
        System.out.println("Inserisci delle note: ");
        contatto.setNote(scan.nextLine());

//        String[] s = new String[5];
//        stringbuilder.append("WHERE ")
//        if(this.nome == null) {
//            stringbuilder.append(" nome LIKE " + s[0]);
//            boolean = true
//        }
//        if(!s[1].equalsIgnoreCase("")) {
//
//            if(boolean)
//            stringbuilder.append(" AND cognome LIKE " + s[1]);
//            else()
//            stringbuilder.append(" cognome LIKE " + s[1]);
//        }



        return contatto;
    }

    public static Contatto creaContatto(ArrayList<String> s, String[] individuaCampi) {
        Contatto contatto = new Contatto();
        int i = 0;

        for (String stringa : individuaCampi) {
            switch (s.get(i).toLowerCase()) {
                case "nome":
                    contatto.setNome(stringa);
                    ;
                    break;
                case "cognome":
                    contatto.setCognome(stringa);
                    break;
                case "telefono":
                    contatto.setTelefono(stringa);
                    break;
                case "email":
                    contatto.setEmail(stringa);
                    break;
                case "note":
                    contatto.setNote(stringa);
                    break;
                default:
                    break;
            }
            i++;
        }

        return contatto;
    }

    public static ArrayList<Contatto> writeContatti() {
        Scanner scan = new Scanner(System.in);
        ArrayList<Contatto> contatti = new ArrayList<Contatto>();
        boolean contattiNonInseriti = true;

        System.out.println("Vuoi inserire dei contatti? (Si o no)");
        while (contattiNonInseriti) {
            if (scan.nextLine().equalsIgnoreCase("Si")) {
                contatti.add(inputCreaContatto());
                System.out.println("Vuoi inserire altri contatti? (Si o no)");
            } else {
                System.out.println("Inserimento dei contatti terminato.");

                contattiNonInseriti = false;
            }
        }

        return contatti;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder()
                .append("{ id : ").append(this.id)
                .append(", cognome : ").append(this.cognome)
                .append(", nome : ").append(this.nome)
                .append(", telefono : ").append(this.telefono)
                .append(", email : ").append(this.email)
                .append(", note : ").append(this.note).append(" } + \n");

        return builder.toString();
    }

}
