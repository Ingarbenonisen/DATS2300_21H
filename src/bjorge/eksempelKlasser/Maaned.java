package bjorge.eksempelKlasser;

import java.util.Arrays;

public enum Maaned {
    JAN (1, "januar"),
    FEB (2, "februar"),
    MAR (3, "mars"),
    APR (4, "april"),
    MAI (5, "mai"),
    JUN (6, "juni"),
    JUL (7, "juli"),
    AUG (8, "august"),
    SEP (9, "september"),
    OKT (10, "oktober"),
    NOV (11, "november"),
    DES (12, "desember");

    private final int mndnr;
    private final String fulltnavn;

    Maaned(int mndnr, String fulltnavn) {
        this.mndnr = mndnr;
        this.fulltnavn = fulltnavn;
    }

    public int getMndnr() {
        return mndnr;
    }

    public String getFulltnavn() {
        return fulltnavn;
    }
    public static String toString(int mnd)
    {
        if (mnd < 1 || mnd > 12) throw
                new IllegalArgumentException("Ulovlig måndesnummer!");

        return values()[mnd - 1].toString();
    }

    public static Maaned[] vaar()
    {
        return Arrays.copyOfRange(values(),3,5);
    }

    public static Maaned[] sommer()
    {
        return Arrays.copyOfRange(values(),5,8);
    }

    public static Maaned[] haust()
    {
        return Arrays.copyOfRange(values(),8,10);
    }

    public static Maaned[] vinter()
    {
        return new Maaned[] { NOV, DES, JAN, FEB, MAR };
    }
}
