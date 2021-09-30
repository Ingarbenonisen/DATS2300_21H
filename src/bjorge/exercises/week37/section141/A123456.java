package bjorge.exercises.week37.section141;

public class A123456 {
    // Oppgave 1, 2, 3 har blitt gjort tidlegere.
    // Oppgave 4
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        System.out.println(a.compareTo(a)); // Denne blir 0 fordi a og a er like
        System.out.println(a.compareTo(b)); // Denne blir -1 fordi a er mindre enn b
        System.out.println(b.compareTo(a)); // Denne blir 1 fordi b er større enn a
    // Oppgave 5
        String A = "Jason";
        String B = "Jasoy";
        System.out.println(A.compareTo(B));
    // Oppgave 6 for lett
    }
}
