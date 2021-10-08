package bjorge.eksempelKlasser;

public enum Studium  // legges under package eksempelklasser
{
    Anvendt ("Anvendt datateknologi"),   // enumkonstanten Anvendt
    Data ("Ingeniørfag - data"),         // enumkonstanten Data
    IT ("Informasjonsteknologi"),        // enumkonstanten IT
    Elektro ("Ingeniørfag - elektronikk og informasjonsteknologi"),
    Enkeltemne ("Enkeltemnestudent");    // enumkonstanten Enkeltemne

    private final String fulltnavn;      // instansvariabel

    private Studium(String fulltnavn) { this.fulltnavn = fulltnavn; }

    public String toString() { return fulltnavn; }
}
