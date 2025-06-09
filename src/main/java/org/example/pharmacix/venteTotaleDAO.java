package org.example.pharmacix;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class venteTotaleDAO {
    public List<VenteTotale> getAllVenteTotale() {
        List<VenteTotale> ventesTotales = new ArrayList<>();
        String sql = "SELECT Medicament.numMedicament, Medicament.nom, " +
                "SUM(Vente.quantiteVendue) AS quantite_totale_vendue " +
                "FROM Vente " +
                "JOIN Medicament ON Vente.fk_numMedicament = Medicament.numMedicament " +
                "GROUP BY Medicament.numMedicament, Medicament.nom ORDER BY quantite_totale_vendue DESC;";
        try (Connection conn = connector.connectDb();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String fk_numMedicament = rs.getString("numMedicament");
                String  fk_nomMedicament = rs.getString("nom");
                System.out.println(fk_nomMedicament);
                int TotalVendu = rs.getInt("quantite_totale_vendue");

                VenteTotale ventetotale = new VenteTotale(fk_numMedicament, TotalVendu, fk_nomMedicament);
                ventesTotales.add(ventetotale);
            }

        } catch (SQLException e) {
            System.err.println("Error during SELECT operation: " + e.getMessage());
            e.printStackTrace();
        }
        return ventesTotales;
    }
}
