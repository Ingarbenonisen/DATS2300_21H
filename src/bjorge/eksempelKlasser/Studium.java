package bjorge.eksempelKlasser;

public enum Studium  // legges under package eksempelklasser
{
    Anvendt("Anvendt datateknologi"), // enumkonstanten Anvendt
    Data("Ingeniørfag - data"), // enumkonstanten Data
    Elektro("Ingeniørfag - elektronikk og informasjonsteknologi"),  // enumkonstanten Elektorfag
    Enkeltemne("Enkeltemnestudent"), // enumkonstanten Enkeltemne
    IT("Informasjonsteknologi") // enumkonstanten IT
    ;

    private final String fulltnavn;      // instansvariabel

    private Studium(String fulltnavn) {
        this.fulltnavn = fulltnavn;
    }

    @Override
    public String toString() {
        return fulltnavn;
    }
}

