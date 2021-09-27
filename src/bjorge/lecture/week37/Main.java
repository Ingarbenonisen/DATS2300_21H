package bjorge.lecture.week37;


import bjorge.structure.Tabell;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("A", "C");
        Person person2 = new Person("A", "Å");
        Person[] persontabell = {person1, person2};
        Integer[] talltabell  = {2, 35, 6, 7, 99};
        System.out.println(Tabell.maks_generic(persontabell));
        System.out.println(Tabell.maks_generic(talltabell));

    }
}
