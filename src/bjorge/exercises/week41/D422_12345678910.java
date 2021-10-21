package bjorge.exercises.week41;

import bjorge.eksempelKlasser.Kø;
import bjorge.eksempelKlasser.Stakk;
import bjorge.eksempelKlasser.TabellKø;
import bjorge.eksempelKlasser.TabellStakk;
import jdk.swing.interop.SwingInterOpUtils;

public class D422_12345678910 {
    public static void main(String[] args) {
        TabellKø<Character> s = new TabellKø<>();


        s.leggInn('A');
        s.leggInn('B');
        s.leggInn('C');
        s.leggInn('D');
        s.leggInn('E');
        s.leggInn('F');
        s.leggInn('G');
        s.leggInn('H');
        s.leggInn('I');
        s.leggInn('J');

        // Tar ut 5 verdier
        for (int i = 0; i < 5; i++){
            s.taUt();
        }
        System.out.println(s.toString());
        System.out.println(s.antall());

        s.leggInn('K');
        s.leggInn('L');
        s.leggInn('M');
        s.leggInn('N');
        s.leggInn('O');
        s.leggInn('P');
        s.leggInn('Q');
        s.leggInn('R');
        s.leggInn('S');
        s.leggInn('T');

        for (int i = 0; i < 3; i++){
            s.taUt();
        }

        System.out.println(s.toString());
        System.out.println(s.antall());

        while(!(s.tom())){
            s.taUt();
        }

        System.out.println(s.toString());
        System.out.println(s.antall());
        // Las gjennom oppgavene fort, det er ting eg har vert igjennom før så gjor dei ikkje.

    }
}
