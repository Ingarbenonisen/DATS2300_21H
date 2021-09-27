package bjorge.exercises.week35.section121;

import bjorge.structure.Tabell;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


class A15Test {
    int [] a = {2, 3, 4, 5,};
    @Test
    void min() {

        System.out.println(Tabell.min(a,1,3));
        assertEquals(1, Tabell.min(a, 1, 3));
    }

    @Test
    void minTabell() {

        System.out.println(Tabell.minTabell(a));
        assertEquals(0, Tabell.minTabell(a));

    }

    @Test
    void maks3(){
        assertEquals(1, Tabell.maks3(a, 1, 3));
    }
    @Test
    void main(){
        int[] a = {1,2,3,4,5,6,7,8,9,10};

        for (int k : a) System.out.print(k + " ");

    }
}