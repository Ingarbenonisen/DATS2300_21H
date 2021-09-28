package bjorge.structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TabellTest {

    @Test
    void maks_generic() {
    }

    @Test
    void testMaks_generic() {
        Integer[] a = { 1 ,4 , 5 ,6 ,7 ,5, 11};
        System.out.println(Tabell.maks_generic(a));
    }
}