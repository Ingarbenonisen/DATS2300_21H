package bjorge.structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TabellTest {

    @Test
    void all_test(){
        int[] gap = {1,4,10,23,57,132,301,701,1577,3548,7984,17965,40423,90952,204642};
        int[] a = Tabell.randPerm(200_000);       // en tilfeldig tabell
        System.out.println(Tabell.erSortert(a));  // sjekker tabellen

        long tid = System.currentTimeMillis();    // starter klokken

        //Tabell.innsettingssortering(a);           // sorterer
        for (int i = gap.length - 1; i >= 0; i--) Tabell.shell(a,gap[i]);

        System.out.println(System.currentTimeMillis() - tid);  // tiden
        System.out.println(Tabell.erSortert(a));  // sjekker sorteringen
    }
    @Test
    void maks_generic() {
    }

    @Test
    void testMaks_generic() {
        Integer[] a = { 21 ,4 , 5 ,6 ,7 ,5, 11};
        System.out.println(Tabell.maks_generic(a));
    }
}