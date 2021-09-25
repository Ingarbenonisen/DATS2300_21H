package bjorge.exercises.week35.section1213;

import bjorge.structure.BinTree;

import java.util.Arrays;

public class J124 {
    public static void main(String[] args) {
        //Oppgave 1
        int[] a = {7, 5, 21, 15, 27, 23, 13, 31, 8, 9, 18, 14, 3};
        int []  b = BinTree.nestMaks(a);
        System.out.println(Arrays.toString(b));

    }
}
