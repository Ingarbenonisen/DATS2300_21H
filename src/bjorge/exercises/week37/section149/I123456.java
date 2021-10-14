package bjorge.exercises.week37.section149;

import bjorge.eksempelKlasser.Dato;
import bjorge.eksempelKlasser.Klokkeslett;
import bjorge.eksempelKlasser.Tid;
import bjorge.structure.Tabell;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Math.*;

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



        Dato[] d = new Dato[5];           // en datotabell
        d[0] = new Dato(24, 12, 2014);      // 24/12-2014
        d[1] = new Dato(24, 12, 2012);      // 24/12-2012
        d[2] = new Dato(9, 12, 2013);       // 9/12-2013
        d[3] = new Dato(25, 12, 2012);      // 25/12-2012
        d[4] = new Dato(10, 12, 2013);      // 10/12-2013

        Tabell.innsettingssortering(d);
        for (Dato x : d) System.out.print(x + " ");

        // Utskrift: 24/12-2012 25/12-2012 9/12-2013 10/12-2013 24/12-2014

         */

        /*
        // Oppgave 1
        System.out.println("Oppgave 1");
        String[] s = {"Sohil","Per","Thanh","Ann","Kari","Jon"};       // String-tabell
        Comparator<String> c =  Comparator.comparing(String::length);  // etter lengde
        // Comparator<String> c =  Comparator.comparingInt(String::length); // etter  lengde - mindre kostbar fordi den ikkje trenger og outoboxe int til Integer
        Tabell.innsettingssortering(s, c.thenComparing(x -> x));       // vanlig orden
        System.out.println(Arrays.toString(s));                        // skriver ut

        // Oppgave 2
        System.out.println("Oppgave 2");
        System.out.println("Metoder med c lagt inn i Tabell klasse");

        */
        /*
        // Oppgave 3
        System.out.println("Oppgave 3");

        int[] x = {3,5,6,2,6,1,4,7,7,4};         // x-koordinater
        int[] y = {3,6,3,5,5,2,1,4,2,4};         // y-koordinater

        Point[] punkt = new Point[x.length];     // en punkttabell
        for (int i = 0; i < punkt.length; i++) punkt[i] = new Point(x[i],y[i]);




        System.out.println("a)");
        Tabell.innsettingssortering(punkt,
                Comparator.comparing(Point::getX).thenComparing(Point::getY));

        System.out.println("b)");
        Comparator<Point> c = (p1, p2) ->
        {
            int d = p1.x - p2.x;    // forskjellen mellom x-koordinatene
            if (d != 0) return d;
            return p1.y - p2.y;     // forskjellen mellom y-koordinatene
        };



        System.out.println("c)");
        Comparator<Point> c =  Comparator.comparingInt((Point p) -> p.x).thenComparingInt(p -> p.y);

        System.out.println("d)");
        Comparator<Point> c =  Comparator.comparingInt((p) -> p.x).thenComparingInt(p -> p.y);
        Her har eg gjerna type deklarasjon Point og for raud error for p."x"



        System.out.println("e)");
        Comparator<Point> c =  Comparator.comparingDouble((Point p) -> p.x).thenComparingDouble(p -> p.y);



        // Utskriften blir for alle Comparatoren over:
        // (3,3) (5,6) (6,3) (2,5) (6,5) (1,2) (4,1) (7,4) (7,2) (4,4)
        // (1,2) (2,5) (3,3) (4,1) (4,4) (5,6) (6,3) (6,5) (7,2) (7,4)
        System.out.println("f)");
        // Punktet nermest orgigo skal vere minst, hvis dei er like lang fra origo er punktet med minst y verdi minst.
        // Avstanden fra origog vil bli hypotinusen til trekanten som dei to punktene vil skape.
        // Hypotinus H^2 = k_y^2 + k_x^2    , der k vil vere verdien til y og x.
        // Formelen/koden for H vil da bli: Double H = sqrt(Math.pow(k_y, 2) + Math.pow(k_x, 2));
        // Eg bruker bare Math.hypot for å finne hypotinusen
        // da vil Comparator'en sjå slik ut.

        Comparator<Point> c_Hy = (p1, p2) ->
        {
            int d = (p1.x*p1.x + p1.y*p1.y) - (p2.x*p2.x + p2.y*p2.y);    // forskjellen mellom Hypotenus lengden
            if (d != 0) return d;
            return p1.y - p2.y;     // forskjellen mellom y-koordinatene
        };

        // Utskriften blir for alle Comparatoren over:
        // (3,3) (5,6) (6,3) (2,5) (6,5) (1,2) (4,1) (7,4) (7,2) (4,4)
        // (1,2) (4,1) (3,3) (4,4) (2,5) (7,2) (6,3) (7,4) (6,5) (5,6)



        System.out.println("g)");
        // Denne komparatoren skal sortere punktene med minst vinkel med hensyn på linjen fra p og origo og x aksen.
        // Deretter kor nærme den er origo
        // Me finner vinkelen ved hjelp av cosinus.
        // Formelen: Vinkel = cos^-1*cos(Vinkel) = x/H
        Comparator<Point> c = (p1, p2) ->
        {
            int d = p2.x*p1.y - p1.x*p2.y;          // Finner minste vinkel
            if (d != 0) return d;                   // Hvis er lik
            if (p1.x != 0) return p1.x - p2.x;      // Hvis p1.x ikkje er lik 0 sjekk
            if (p1.y != 0) return p1.y - p2.y;

            // nå må p1 == (0,0)
            if (p2.x == 0 && p2.y == 0) return 0; // p1 == p2 == (0,0)
            return -1; // p1 == (0,0) og p2 != (0,0) gir p1 mindre enn p2
        };

        // Utskriften blir for alle Comparatoren over:
        // (3,3) (5,6) (6,3) (2,5) (6,5) (1,2) (4,1) (7,4) (7,2) (4,4)
        // (4,1) (7,2) (6,3) (7,4) (6,5) (3,3) (4,4) (5,6) (1,2) (2,5)
        for (Point p : punkt) System.out.print("(" + p.x + "," + p.y + ") "); // Usortert
        System.out.println();                    // linjeskift

        Tabell.innsettingssortering(punkt, c);
        for (Point p : punkt) System.out.print("(" + p.x + "," + p.y + ") "); // Sortert


         */
        // Oppgave 4
        System.out.println("Oppgave 4");
        System.out.println("Lagt inn i dato klassen");

        // Oppgave 5
        System.out.println("Oppgave 5");

        Klokkeslett[] k = new Klokkeslett[5];

        k[0] = new Klokkeslett("23:56");
        k[1] = new Klokkeslett("09:09");
        k[2] = new Klokkeslett("07:00");
        k[3] = new Klokkeslett("00:00");
        k[4] = new Klokkeslett("22:56");

        Tabell.innsettingssortering(k);
        for (Klokkeslett x : k) System.out.print(x + " ");
        System.out.println();

        // Utskrift: 00:00 07:00 09:09 22:56 23:59

        // Oppgave 6
        System.out.println("Oppgave 6");
        // Testprogram

        Tid[] tider = new Tid[4];

        tider[0] = new Tid(24,12,2014,"15:30");
        tider[1] = new Tid(24,12,2014,"12:00");
        tider[2] = new Tid(23,12,2014,"12:00");
        tider[3] = new Tid(23,12,2014,"09:00");

        Tabell.innsettingssortering(tider);

        for (Tid tid : tider) System.out.println(tid);
    }
}
