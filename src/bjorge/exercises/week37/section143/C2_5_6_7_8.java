package bjorge.exercises.week37.section143;

import bjorge.structure.Tabell;

public class C2_5_6_7_8 {

    public static void main(String[] args) {
        // Oppgave 2 Binærkoden til -1 har 32 1-biter. Men det er tallet 4294967295 når vi ser bort fra fortegn.
        /*

        String s = Integer.toUnsignedString(-1);
        String t = Integer.toUnsignedString(Integer.MIN_VALUE);
        System.out.println(s + " " + t);  // 4294967295 2147483648

        int k1 = -1 / 10;                        // kvotient k1 = -(1/10) = 0
        int k2 = Integer.divideUnsigned(-1, 10);  // kvotient
        System.out.println(k1 + " " + k2);       // 0 429496729

        int d1 = Integer.compare(-1, 1);
        int d2 = Integer.compareUnsigned(-1, 1);
        System.out.println(d1 + " " + d2);       // -1 1

         */
        //Oppgave 5 metoder skriv, skrivln og bytt med parameter Object[] er lagt inn i Tabell klassen

        // Oppgave 7
        double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        Double[] b = new Double[d.length];

        // hvert element b lages som en instans av class Double
        for (int i = 0; i < b.length; i++) b[i] = d[i];  // autoboksing

        Tabell.innsettingssortering(b);
        Tabell.skrivln(b);  // se Oppgave 5

        // Oppgave 8
        //En kan bestemme hvem av dem som skal brukes ved å konvertere ett av tallene til en Integer:
        /*

        f(1, (Integer)1);  // nå brukes f(int a, Integer b)
        f((Integer)1,1);   // f(Integer a, int b)

         */
    }

}
