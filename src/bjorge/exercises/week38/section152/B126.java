package bjorge.exercises.week38.section152;

import java.io.PrintStream;
import java.util.Arrays;

//1.5.2  Hva skjer når en rekursiv metode kjøres?
public class B126 {
    public static int tverrsum(int n)
    {
        System.out.println("tverrsum(" + n + ") starter!");
        int sum = (n < 10) ? n : tverrsum(n / 10) + (n % 10);
        System.out.println("tverrsum(" + n + ") er ferdig!");
        return sum;
    }           // Programkode 1.5.2 c)
    public static int fib(int n)         // med utskriftssetninger
    {
        System.out.println("fib(" + n + ") starter!");
        int fib = n > 1 ? fib(n-1) + fib(n-2) : n;
        System.out.println("fib(" + n + ") er ferdig!");
        return fib;      // metoden er ferdig
    }

    //Den nye versjonen av tverrsum i Programkode 1.5.2 c) gir utskriften nedenfor:

    public static int euklid(int a, int b)
    {
        System.out.println("euklid(" + a + "," + b + ") starter!");
        if (b == 0)
        {
            System.out.println("euklid(" + a + "," + b + ") er ferdig!");
            return a;
        }
        int r = a % b;            // r er resten
        int k = euklid(b,r);       // rekursivt kall
        System.out.println("euklid(" + a + "," + b + ") er ferdig!");
        return k;
    }


    public static void main(String... args)
    {
        System.out.println("main() starter!");

        int sum = tverrsum(7295);
        int fib_tall = fib(4);

        // Programkode 1.5.2 d)

        // Oppgave 1
        System.out.println("Oppgave 1");
        tverrsum(111111);

        // Oppgave 2
        System.out.println("Oppgave 2");
        int a = 345, b = 25;
        int felles_div =euklid(a, b);
        String tekst = "Felles divosor til %d og %d er %s%n";
        System.out.printf(tekst, a, b, felles_div);

        // Oppgave 6
        System.out.println("Oppgave 6");
        // Gadd ikkje gjere den, du skulle bar telle noder liksom
        System.out.println("main() er ferdig!");

    }

}
