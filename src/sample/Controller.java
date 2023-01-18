package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.*;

public class Controller {
    @FXML
    TextField tfNISN;
    @FXML
    TextField tfNama;
    @FXML
    TextField tfAlamat;
    @FXML
    Button btnSubmit;
    @FXML
    TableView tvDataSiswa;
    @FXML
    Button btnsave;
    @FXML
    Button btnLoad;

    @FXML
    public void onButtonClicked(ActionEvent e) {
        if (e.getTarget().equals(btnSubmit)) {
            ObservableList<SiswaModel> data = tvDataSiswa.getItems();
            data.add(new SiswaModel(
                    tfNISN.getText(),
                    tfNama.getText(),
                    tfNama.getText()));
            tfNISN.setText("");
            tfNama.setText("");
            tfAlamat.setText("");
        } else if (e.getTarget().equals(btnsave)) {
            try {
                ObservableList<SiswaModel> data = tvDataSiswa.getItems();
                BufferedWriter writer = new BufferedWriter(new FileWriter("data-data.dat"));
                for (int i=0; 1<data.size(); i++) {
                    writer.write(String.valueOf(data.get(i).getNisn()) +
                            "," + String.valueOf(data.get(i).getNama()) +
                            "," + String.valueOf(data.get(i).getAlamat()));
                    writer.newLine();
                }
                writer.close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succes");
                alert.setContentText("Succes Save Data to File");
                alert.showAndWait();
            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Error IO Exception : " + ex.getMessage());
                alert.showAndWait();
            }
        } else if (e.getTarget().equals(btnLoad)) {
            try {
                ObservableList<SiswaModel> data = tvDataSiswa.getItems();
                data.clear();
                BufferedReader reader = new BufferedReader(new FileReader("data-siswa.dat"));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] temp = line.split(",");
                    SiswaModel siswaModel = new SiswaModel(temp[0], temp[1], temp[2]); data.add(siswaModel);
                }
                reader.close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setContentText("Success Load Data from Saved File");
                alert.showAndWait();
            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Error IO Exception : " + ex.getMessage());
                alert.showAndWait();
            }
        }
    }
}