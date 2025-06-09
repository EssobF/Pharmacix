package org.example.pharmacix;

public class VenteTotale {
    private String fk_numMedicament;
    private Integer TotalVendu;
    private String fk_nomMedicament;

    public VenteTotale(String fk_numMedicament, Integer TotalVendu, String fk_nomMedicament) {
        this.fk_numMedicament = fk_numMedicament;
        this.TotalVendu = TotalVendu;
        this.fk_nomMedicament = fk_nomMedicament;
    }

    public String getFk_numMedicament() { return fk_numMedicament; }
    public void setFk_numMedicament(String fk_numMedicament) { this.fk_numMedicament = fk_numMedicament; }

    public String getFk_nomMedicament() { return fk_nomMedicament; }
    public void setFk_nomMedicament(String fk_nomMedicament) { this.fk_nomMedicament= fk_nomMedicament; }

    public Integer getTotalVendu() { return TotalVendu; }
    public void setTotalVendu(Integer TotalVendu) { this.TotalVendu = TotalVendu; }
}
