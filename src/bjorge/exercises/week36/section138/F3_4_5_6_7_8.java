package bjorge.exercises.week36.section138;

import bjorge.structure.Tabell;

public class F3_4_5_6_7_8 {
    //Oppgave 3 unnagjort, satt meg litt inn i copyArrayOfRaange etc

    //oppgave 4
    public static void main(String[] args) {
        /*
        int[] a = {3,5,6,10,10,11,13,14,16,20,0,0,0,0,0};  // en tabell
        int antall = 10;                                   // antall verdier

        if (antall >= a.length) throw new IllegalStateException("Tabellen er full");

        int nyverdi = 10;                                  // ny verdi
        int k = Tabell.binærsøk(a, 0, antall, nyverdi);    // søker i a[0:antall>
        if (k < 0) k = -(k + 1);                           // innsettingspunkt



        //for (int i = antall; i > k; i--) a[i] = a[i-1];    // forskyver
        System.arraycopy(a, k, a, k + 1, antall - k); //forskyves med arraycopy
        a[k] = nyverdi;                                    // legger inn
        antall++;                                          // øker antallet

        Tabell.skrivln(a, 0, antall);  // Se Oppgave 4 og 5 i Avsnitt 1.2.2

         */
        // Oppgave 5 snakker om gjennomsnittlig sammenligninger
        // Oppgave 6
        /*
        int[] a = Tabell.randPerm(100000);
        int[] b = a.clone();
        long tid1 = System.currentTimeMillis();
        Tabell.utvalgssortering(a);
        tid1 = System.currentTimeMillis() - tid1;

        long tid2 = System.currentTimeMillis();
        Tabell.innsettingssortering(b);
        tid2 = System.currentTimeMillis() - tid2;

        System.out.println("Utvalgssortering: " + tid1);
        System.out.println("Innsettingssortering: " + tid2);
         */
        // Oppgave 7
        /*
        public static void innsettingssortering(int[] a, int fra, int til)
        {
            Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)

            for (int i = fra + 1; i < til; i++)  // a[fra] er første verdi
            {
                int temp = a[i];  // flytter a[i] til en hjelpevariabel

                // verdier flyttes inntil rett sortert plass i a[fra:i> er funnet
                int j = i-1; for (; j >= fra && temp < a[j]; j--) a[j+1] = a[j];

                a[j+1] = temp;  // verdien settes inn på rett sortert plass
            }
        }
        */
        // oppgave 8
        //Innsettingssortering er stabil
    }
}
