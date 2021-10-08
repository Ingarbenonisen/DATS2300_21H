package bjorge.exercises.week37.section145;

import bjorge.eksempelKlasser.Student;
import bjorge.eksempelKlasser.Studium;
import bjorge.structure.Tabell;

public class E12345 {
    public static void main(String[] args) {
        Student[] s = new Student[5];  // en Studenttabell

        s[0] = new Student("Kari", "Svendsen", Studium.Data);    // Kari Svendsen
        s[1] = new Student("Boris", "Zukanovic", Studium.IT);    // Boris Zukanovic
        s[2] = new Student("Ali", "Kahn", Studium.Anvendt);      // Ali Kahn
        s[3] = new Student("Azra", "Zukanovic", Studium.IT);     // Azra Zukanovic
        s[4] = new Student("Kari", "Pettersen", Studium.Data);   // Kari Pettersen
        s[4] = new Student("Kari", "dwdw", Studium.Elektro);   // Kari Pettersen

        Tabell.innsettingssortering(s);                     // Programkode 1.4.2 e)
        for (Student t : s) System.out.println(t);

        // Utskrift:
        // Ali Kahn Anvendt
        // Kari Pettersen Data
        // Kari Svendsen Data
        // Azra Zukanovic IT
        // Boris Zukanovic IT

    }
}
