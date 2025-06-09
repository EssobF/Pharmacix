package org.example.pharmacix;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;

public class VenteTotaleController {
    @FXML
    private TableView<VenteTotale> tableVenteTotale;

    @FXML
    private TableColumn<VenteTotale, String> fk_numMedicamentColumn;
    @FXML
    private TableColumn<VenteTotale, String> fk_nomMedicamentColumn;
    @FXML
    private TableColumn<VenteTotale, Integer> TotalVenduColumn;

    private final venteTotaleDAO venteTotaleDAO = new venteTotaleDAO();
    private final ObservableList<VenteTotale> venteTotaleList = FXCollections.observableArrayList();



    @FXML
    public void initialize() {
        fk_nomMedicamentColumn.setCellValueFactory(new PropertyValueFactory<>("fk_nomMedicament"));
        fk_numMedicamentColumn.setCellValueFactory(new PropertyValueFactory<>("fk_numMedicament"));
        TotalVenduColumn.setCellValueFactory(new PropertyValueFactory<>("TotalVendu"));
        rafraichirTable();
    }
    public void rafraichirTable() {
        venteTotaleList.setAll(venteTotaleDAO.getAllVenteTotale());
        tableVenteTotale.setItems(venteTotaleList);
    }

    @FXML
    public void venteview(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/pharmacix/BoutonAccueil/VenteMenu.fxml"));
        if (loader.getLocation() == null) {
            System.err.println("File not found: /org/example/pharmacix/BoutonAccueil/VenteMenu.fxml");
            return;
        }
        Parent root = loader.load();

        // Récupérer la fenêtre actuelle et changer la scène
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void menuview(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/pharmacix/Menu.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
