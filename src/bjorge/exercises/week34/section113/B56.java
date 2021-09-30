package bjorge.exercises.week34.section113;
import bjorge.structure.Tabell;


public class B56 {
    //Metoden skal legge min og max i eit array inn i eit nytt 2 element array
    public static int[] minmaxPos(int[] a){

        int min = Tabell.min(a);
        int max = Tabell.maks(a);
        return new int[]{min, max};
    }

    public static long fak(int n){
        if (n<=1){
            return 1;
        }
        return n*fak(n-1);
    }


}
