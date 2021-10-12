package bjorge.exercises.week37.section149;

import bjorge.eksempelKlasser.Dato;
import bjorge.structure.Tabell;

import java.util.Arrays;
import java.util.Comparator;

public class I123456 {
    public static void main(String[] args) {
        /*

        Komparator<String> c1 = Komparator.naturligOrden();             // vanlig orden
        Komparator<String> c2 = Komparator.orden(String::length);       // etter lengde

        Comparator<String> c1 = Comparator.naturalOrder();              // vanlig orden
        Comparator<String> c2 = Comparator.comparing(String::length);   // etter lengde


        String[] s = {"Sohil","Per","Thanh","Ann","Kari","Jon"};       // String-tabell
        //Comparator<String> c =  Comparator.comparing(String::length);  // etter lengde
        Comparator<String> c =  Comparator.comparingInt(String::length); // etter  lengde - mindre kostbar fordi den ikkje trenger og outoboxe int til Integer
        Tabell.innsettingssortering(s, c.thenComparing(x -> x));       // vanlig orden
        System.out.println(Arrays.toString(s));                        // skriver ut

        Comparator<Point> p_1 = (p1, p2) ->
        {
            int d = p1.x - p2.x;    // forskjellen mellom x-koordinatene
            if (d != 0) return d;
            return p1.y - p2.y;     // forskjellen mellom y-koordinatene
        };

        Comparator<Point> p_2 = Comparator.comparing(Point::getX).thenComparing(Point::getY);
        Comparator<Point> p_3 = Comparator.comparing((Point p) -> p.x).thenComparing(p -> p.y);
        Comparator<Point> p_4 = Comparator.comparingInt((Point p) -> p.x).thenComparingInt(p -> p.y);

        int[] x = {3,5,6,2,6,1,4,7,7,4};         // x-koordinater
        int[] y = {3,6,3,5,5,2,1,4,2,4};         // y-koordinater

        Point[] punkt = new Point[x.length];     // en punkttabell
        for (int i = 0; i < punkt.length; i++) punkt[i] = new Point(x[i],y[i]);

        for (Point p : punkt) System.out.print("(" + p.x + "," + p.y + ") ");
        System.out.println();                    // linjeskift

        Tabell.innsettingssortering(punkt, Comparator.comparing(Point::getX).thenComparing(Point::getY));

        for (Point p : punkt) System.out.print("(" + p.x + "," + p.y + ") ");

        // Utskriften blir:
        // (3,3) (5,6) (6,3) (2,5) (6,5) (1,2) (4,1) (7,4) (7,2) (4,4)
        // (1,2) (2,5) (3,3) (4,1) (4,4) (5,6) (6,3) (6,5) (7,2) (7,4)

         */

        Dato[] d = new Dato[5];           // en datotabell
        d[0] = new Dato(24, 12, 2014);      // 24/12-2014
        d[1] = new Dato(24, 12, 2012);      // 24/12-2012
        d[2] = new Dato(9, 12, 2013);       // 9/12-2013
        d[3] = new Dato(25, 12, 2012);      // 25/12-2012
        d[4] = new Dato(10, 12, 2013);      // 10/12-2013

        Tabell.innsettingssortering(d);
        for (Dato x : d) System.out.print(x + " ");

        // Utskrift: 24/12-2012 25/12-2012 9/12-2013 10/12-2013 24/12-2014

        // Oppgave 1
        System.out.println("Oppgave 1");
        String[] s = {"Sohil","Per","Thanh","Ann","Kari","Jon"};       // String-tabell
        Comparator<String> c =  Comparator.comparing(String::length);  // etter lengde
        // Comparator<String> c =  Comparator.comparingInt(String::length); // etter  lengde - mindre kostbar fordi den ikkje trenger og outoboxe int til Integer
        Tabell.innsettingssortering(s, c.thenComparing(x -> x));       // vanlig orden
        System.out.println(Arrays.toString(s));                        // skriver ut

        // Oppgave 2
        System.out.println("Oppgave 2");



    }
}
