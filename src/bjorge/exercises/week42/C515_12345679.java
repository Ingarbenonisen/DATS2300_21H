package bjorge.exercises.week42;

import bjorge.structure.BinTre;

// 5.1.5  Datarepresentasjon av noder og binære trær
public class C515_12345679 {
    public static void main(String[] args) {
        int[] posisjon = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,17,18,19,21,23,26,27,29};
        Character[] verdi = {'A','B','C','D','E','F','G','H','I','J','K',
                'L','M','N','O','P','Q','R','S','T','U','V'};

        BinTre<Character> tre = new BinTre<>(posisjon, verdi);  // den nye konstruktøren
        // Oppgave 2
        int[] posisjon1 = {1,2,3,5,6,7,10,11,12,13,21,24,25,42,43};
        Character[] verdi1 = {'D','I','H','L','O','B','A','E','N','G','K','M','J','F','C'};

        BinTre<Character> tre1 = new BinTre<>(posisjon1, verdi1);

        // Oppgave 5
        BinTre<Integer> tre5 = new BinTre<>();

        int n = 15;
        for (int i = 1; i <= n; i++) tre5.leggInn(i,i);

        // Oppgave 6
        // Kan lages på denne noe tungvinte måten:

        int[] p = {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384};
        Integer[] v = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        BinTre<Integer> tre6 = new BinTre<>(p,v);


        // Dette er en enklere og mer generell måte:

        BinTre<Integer> tre6b = new BinTre<>();

        n = 15;
        int k = 1;
        for (int i = 1; i <= n; i++)
        {
            tre6b.leggInn(k,i);
            k *= 2;
        }
        // Oppgave 7
        // Kan lages på denne måten:

        int[] p7 = {1,2,3,4,7,8,15,16,31,32,63,64,127,128,255};
        Integer[] v7 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        BinTre<Integer> tre7 = new BinTre<>(p7,v7);


        // Dette er en mer generell måte:

        BinTre<Integer> tre7g = new BinTre<>();

        tre7g.leggInn(1,1);    // lager rotnoden

        n = 7;
        k = 2; // starter å posisjon 2

        for (int i = 1; i <= n; i++)
        {
            tre7g.leggInn(k,2*i);
            tre7g.leggInn(2*k-1,2*i+1);
            k *= 2;
        }


    }
}
