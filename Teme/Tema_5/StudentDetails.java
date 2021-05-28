package lab5;

import java.util.ArrayList;

public class StudentDetails {
    private String Nume;
    private String Prenume;
    private ArrayList<Double> NoteLibRomana;
    private ArrayList<Double> NoteMatematica;

    StudentDetails(String Nume, String Prenume, ArrayList<Double> NoteLibRomana, ArrayList<Double> NoteMatematica) {

        this.Nume = Nume;
        this.Prenume = Prenume;
        this.NoteLibRomana = NoteLibRomana;
        this.NoteMatematica = NoteMatematica;

        getNume();
        getPrenume();
        getNoteLibRomana();
        getNoteMatematica();
    }

    private String getNume() {
        System.out.println("Nume: " + this.Nume);
        return this.Nume;
    }

    private String getPrenume() {
        System.out.println("Prenume: " + this.Prenume);
        return this.Prenume;
    }

    private ArrayList<Double> getNoteLibRomana() {
        System.out.println("Note la limba romana: " + this.NoteLibRomana);
        return this.NoteLibRomana;
    }

    private ArrayList<Double> getNoteMatematica() {
        System.out.println("Note la matematica: " + this.NoteMatematica + "\n");
        return this.NoteMatematica;
    }

    void checkStudent() {
        System.out.println("Nume: " + this.Nume);
        System.out.println("Prenume: " + this.Prenume);
        System.out.println("Note la limba romana: " + this.NoteLibRomana);
        System.out.println("Note la matematica: " + this.NoteMatematica + "\n");
    }
}
