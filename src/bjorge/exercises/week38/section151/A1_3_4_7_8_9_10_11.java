package bjorge.exercises.week38.section151;

import bjorge.eksempelKlasser.Dato;
import bjorge.eksempelKlasser.Komparator;
import bjorge.structure.Tabell;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public class A1_3_4_7_8_9_10_11 {
    public static void main(String[] args) {
        // Oppgave 1
        System.out.println("Oppgave 1");
        /*
        public static int a(int n)           // n må være et ikke-negativt tall
        {
            if (n == 0) return 1;              // a0 = 1
            else if (n == 1) return 2;         // a1 = 2
            else return 2*a(n-1) + 3*a(n-2);   // to rekursive kall
        }
        // Programkode 1.5.1 a)
         */
        // Lag en iterativ versjon av metoden a i Programkode 1.5.1 a).
        // an  =  2a_n−1  +  3a_n−2  , n ≥ 2     a0 = 1 ,  a1 = 2
        // a2 = 2a_1 + 3a_0 = 2·2 + 3·1 =

        // Oppgave 3
        System.out.println("Oppgave 3");
        /*
        public static int tverrsum(int n)              // n må være >= 0
        {
            if (n < 10) return n;                        // kun ett siffer
            else return tverrsum(n / 10) + (n % 10);     // metoden kalles
        }
        Programkode 1.5.1 b)
         */
        // Lag en iterativ versjon av metoden a i Programkode 1.5.1 b).
        System.out.println(tverrsum(1555));

        // Oppgave 4
        System.out.println("Oppgave 4");
        System.out.println(sifferrot(956847));

        // Oppgave 7
        System.out.println("Opgave 7");
        System.out.println(sumKvadrattall(3));

        // Oppgave 8
        System.out.println("Opgave 8");
        System.out.println(sum(3, 6));
        // Oppgave 9
        System.out.println("Opgave 9");
        int[] a = {1, 2, 3, 4, 5, 6};
        System.out.println(maks(a,2,5));
        // Oppgave 10
        System.out.println("Opgave 10");
        System.out.println(fakultet(3));
        // Oppgave 11
        // fib(20) = 6765, fib(30) = 832040, fib(40) = 102334155 og fib(50) = 12586269025.
        // Den siste verdien, dvs. fib(50), vil du ikke få. For det første vil programmet ta svært lang tid.
        // Kanskje så lang tid at du mister tålmodigheten. Men hvis du til slutt får ut et svar,
        // vil det være et negativt tall. Det kommer av at fib(50) er for stort for datatypen int.
        // Se Oppgave 12.
    }
    // Oppgave 10
    // Lag ein rekursiv metode som finner fakutleten n!
    public static int fakultet(int n)
    {
        return n < 2 ? 1 : fakultet(n-1)*n;
    }
    // Oppgave 9
    // Lag en rekursiv metode som returnerer posisjonen til den største blant de n
    // første verdiene i en heltallstabell. Kan du få det til ved en «splitt og hersk»-teknikk?
    public static int maks(int[] a, int v, int h)
    {
        if (v == h) return v;
        int m = (v + h)/2;  // midten
        int mv = maks(a,v,m);
        int mh = maks(a,m+1,h);

        return a[mv] >= a[mh] ? mv : mh;
    }

    public static int maks(int[] a) {
        return maks(a, 0, a.length - 1);
    }
    //Oppgave 8
    // Summen av heltallene fra k til n der k <= n.
    // Lag en metode public static int sum(int k, int n) som finner denne summen,
    // og gjør det ved å bruke «splitt og hersk».
    public static int sum(int k, int n)
    {
        if (n == k) return n;
        int m = (n + k)/2;
        return sum(k,m) + sum(m+1, n);
    }
    // n og k er byttet om i pensum og er feil kode
    // Pensum koden skriver ut 36 med k = 3 og n = 6, når den kal slrive ut 18.

    // Oppgave 7
    // // kvadrattallene fra 1 til n, dvs. finner summen 1^2 + 2^2 + 3^2 + . . . + n^2
    public static int sumKvadrattall(int n){
        if (n==1) return 1;
        return sumKvadrattall(n-1) + n*n;
    }  // Formel:  n*(n + 1)*(2*n + 1)/6
    // Oppgave 4
    /*
    public static int sifferrot(int n)
    {
        while (n >= 10) n = tverrsum(n);
        return n;
    }

     */
    //Bedre versjon
    public static int sifferrot(int n)
    {
        n %= 9;
        return n == 0 ? 9 : n;
    }
    // Oppgave 3
    public static int tverrsum(int n)              // n må være >= 0
    {
        if (n < 10) return n;                        // kun ett siffer
        int sum = 0;
        while (n > 10) {
            sum += n % 10;
            n /= 10;
        }
        return sum + n;
    }
    // Oppgave 1
    public static int a(int n)           // n et ikke-negativt tall
    {
        if (n < 0) throw new IllegalArgumentException("n er negativ!");

        int x = 0, y = 1, z = 1;

        for (int i = 0; i < n; i++)
        {
            z = 2*y + 3*x; x = y; y = z;
        }
        return z;
    }

}
