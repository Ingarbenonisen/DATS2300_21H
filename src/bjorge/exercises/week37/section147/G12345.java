package bjorge.exercises.week37.section147;


import bjorge.eksempelKlasser.*;
import bjorge.structure.Tabell;

import java.util.Arrays;

public class G12345 {
    public static void main(String[] args) {
        /*  Endret i innsettingssortering slit at den kan ta inn metoder fra Comperator ikkje Komperator som i kode her.
         *  Derfor er den kommentert ut.

        // Kode fra avsnittet 1.4.7
        //Integer[] a = {6,2,10,9,5,1,8,4,3,7};                            // Integer
        //String[] s = {"Sohil","Per","Thanh","Ann","Kari","Jon"};         // String

        //Tabell.innsettingssortering(a, (x,y) -> x.compareTo(y));         // lamda-uttrykk
        //abell.innsettingssortering(a, Integer::compareTo);               // Metode referanse
        //Tabell.innsettingssortering(s, (x,y) -> x.compareTo(y));         // lamda-uttrykk
        //Tabell.innsettingssortering(s, String::compareTo);               // Metode referanse

        //Tabell.innsettingssortering(a, Komparator.naturligOrden());       // Naturlig orden
        //Tabell.innsettingssortering(s, Komparator.naturligOrden());       // Naturlig orden

        //Tabell.innsettingssortering(a, Komparator.omvendtOrden());          // Unaturlig orden
        //Tabell.innsettingssortering(s, Komparator.omvendtOrden());          // Unaturlig orden

        //Funksjon<Student,String> velger = x -> x.studium();
        //Funksjon<Student,String> velger = Student::studium;  // metodenavn etter ::

        //Funksjon<Student,String> velger = x -> String.valueOf(x.studium());
        //Komparator<Student> c = Komparator.orden(velger);
        // System.out.println(Arrays.toString(a));  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        // System.out.println(Arrays.toString(s));  // [Ann, Jon, Kari, Per, Sohil, Thanh]

        Student student1 = new Student("Per", "Arne", Studium.IT);
        Student student2 = new Student("Per", "Olsen", Studium.IT);

        Student[] st = {student1, student2};
        Tabell.innsettingssortering(st, Komparator.orden(Student::studium));

        String[] s = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        Tabell.innsettingssortering(s, Komparator.orden(String::length));

        Integer[] a = {13,25,11,3,2,21,10,1,33,100};  // en Integer-tabell
        Tabell.innsettingssortering(a, Komparator.omvendtOrden());
        System.out.println(Arrays.toString(a)); // [1, 10, 100, 11, 13, 2, 21, 25, 3, 33]

        // Oppgaver

        // Oppgave 1
        System.out.println("Oppgave 1: " + "lagt grensesnittet Komparator under mappen eksmepelKlasser");

        // Oppgave 2
        System.out.println("Oppgave 2: ");

        Double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        Tabell.innsettingssortering(d, Komparator.naturligOrden());
        System.out.println(Arrays.toString(d));
        Tabell.innsettingssortering(d, Komparator.omvendtOrden());
        System.out.println(Arrays.toString(d));

        // Oppgave 3
        System.out.println("Oppgave 3: ");
        Boolean[] b = {false, true, true, false, false, true, false, true};
        Tabell.innsettingssortering(b, Komparator.naturligOrden());
        System.out.println(Arrays.toString(b));

        // Oppgave 4
        System.out.println("Oppgave 4: ");
        Person[] p = new Person[5];                       // en persontabell
        p[0] = new Person("Kari", "Svendsen");            // Kari Svendsen
        p[1] = new Person("Boris", "Zukanovic");          // Boris Zukanovic
        p[2] = new Person("Ali", "Kahn");                 // Ali Kahn
        p[3] = new Person("Azra", "Zukanovic");           // Azra Zukanovic
        p[4] = new Person("Kari", "Pettersen");           // Kari Pettersen

        Tabell.innsettingssortering(p, Komparator.orden(Person::etternavn));
        System.out.println(Arrays.toString(p));

        // Oppgave 5
        System.out.println("Oppgave 5: ");
        // Sorterer lengst til minst
        Tabell.innsettingssortering(s, (x,y) -> y.length() - x.length());
        // eller
        Tabell.innsettingssortering(s, Komparator.orden(x -> -x.length()));
        System.out.println(Arrays.toString(s));
        // Sorterer minst til lengst
        Tabell.innsettingssortering(s, Komparator.orden(x -> x.length()));
        System.out.println(Arrays.toString(s));

         */


    }
}
