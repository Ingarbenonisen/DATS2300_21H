package bjorge.exercises.week35.section121;

import bjorge.structure.Tabell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class A15Test {
    int [] a = {2, 3, 4, 5,};
    @Test
    void minHalvaapentI() {

        System.out.println(Tabell.minHalvaapentI(a,1,3));
        assertEquals(1, Tabell.minHalvaapentI(a, 1, 3));
    }

    @Test
    void minTabell() {

        System.out.println(Tabell.minTabell(a));
        assertEquals(0, Tabell.minTabell(a));

    }

    @Test
    void maksHalvaapentI3(){
        assertEquals(1, Tabell.maksHalvaapentI3(a, 1, 3));
    }
    @Test
    void main(){
        int[] a = {1,2,3,4,5,6,7,8,9,10};

        for (int k : a) System.out.print(k + " ");

    }
}