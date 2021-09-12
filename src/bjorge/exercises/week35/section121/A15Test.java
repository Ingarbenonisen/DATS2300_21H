package bjorge.exercises.week35.section121;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class A15Test {

    @Test
    void minHalvaapentI() {
        int [] a = {2, 3, 4, 5,};
        System.out.println(A15.minHalvaapentI(a,1,3));
        assertEquals(1, A15.minHalvaapentI(a, 1, 3));
    }

    @Test
    void minTabell() {
        int [] a= {2, 3, 4, 5,};
        System.out.println(A15.minTabell(a));
        assertEquals(0, A15.minTabell(a));

    }
}