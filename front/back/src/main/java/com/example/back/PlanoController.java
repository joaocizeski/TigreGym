package com.example.back;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PlanoController {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtDescricao;

    @FXML
    private TextField txtValor;

    @FXML
    private TextField txtDuracaoEmMeses;

    @FXML
    public void salvarPlano(ActionEvent event) {

    }

    @FXML
    public void voltar(ActionEvent event) throws IOException {
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("/com/example/back/menu-view.fxml"));

        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
