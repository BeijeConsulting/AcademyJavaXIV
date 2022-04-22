package it.beije.turing.rubrica;

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

    public boolean isDuplicateContact(Contatto contatto) {
        if (this.nome != null && contatto.nome != null && !this.nome.equalsIgnoreCase(contatto.nome)) {
            return false;
        } else if (this.cognome != null && contatto.cognome != null && !this.cognome.equalsIgnoreCase(contatto.cognome)) {
            return false;
        } else if (this.telefono != null && contatto.telefono != null && !this.telefono.equalsIgnoreCase(contatto.telefono)) {
            return false;
        } else if (this.email != null && contatto.email != null && !this.email.equalsIgnoreCase(contatto.email)) {
            return false;
        }

        return true;
    }

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

        return contatto;
    }

    public static Contatto creaContatto(ArrayList<String> s, String[] individuaCampi) {
        Contatto contatto = new Contatto();
        int i = 0;

        for (String stringa : individuaCampi) {
            switch (s.get(i).toLowerCase()) {
                case "nome":
                    if (stringa != null) {
                        contatto.setNome(stringa);
                    } else {
                        contatto.setNome("");
                    }
                    break;
                case "cognome":
                    if (stringa != null) {
                        contatto.setCognome(stringa);
                    }else {
                        contatto.setCognome("");
                    }
                    break;
                case "telefono":
                    if (stringa != null) {
                        contatto.setTelefono(stringa);
                    }else {
                        contatto.setTelefono("");
                    }
                    break;
                case "email":
                    if (stringa != null) {
                        contatto.setEmail(stringa);
                    }else {
                        contatto.setEmail("");
                    }
                    break;
                case "note":
                    if (stringa != null) {
                        contatto.setNote(stringa);
                    }else {
                        contatto.setNote("");
                    }
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
                .append(", note : ").append(this.note).append(" }");

        return builder.toString();
    }

}
