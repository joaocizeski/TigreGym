package com.example.back;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MatriculaController {

    @FXML
    private TextField txtAluno;

    @FXML
    private TextField txtPlano;

    @FXML
    private TextField txtDataInicio;

    @FXML
    private TextField txtDataVencimento;

    @FXML
    public void salvarMatricula(ActionEvent event) throws Exception {

        // Validar dados

        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String dataInicio =
                LocalDate.parse(txtDataInicio.getText(), formatoData).atStartOfDay().toString();

        String dataVencimento =
                LocalDate.parse(txtDataVencimento.getText(), formatoData).atStartOfDay().toString();

        String jsonRequest = String.format("{\n"
                        + "\"aluno_id\": %s,\n"
                        + "\"plano_id\": %s,\n"
                        + "\"dataInicio\": \"%s\",\n"
                        + "\"dataVencimento\": \"%s\"\n"
                        + "}",
                txtAluno.getText(),
                txtPlano.getText(),
                dataInicio,
                dataVencimento);

        int respostaAPI = executaMetodoAPI("http://localhost:8080/matriculas",jsonRequest,"POST");

        if (respostaAPI==200){
            showMessage(Alert.AlertType.INFORMATION, "Matricula salva com sucesso!");
            voltar(event);
        } else {
            showMessage(Alert.AlertType.ERROR,"Erro ao salvar matricula!");
        }

    }

    @FXML
    public void voltar(ActionEvent event) throws IOException {
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("/com/example/back/menu-view.fxml"));

        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    private int executaMetodoAPI(String url,String json,String protocoloHttp)
            throws Exception {


        URL urlAPI = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlAPI.openConnection();
        connection.setRequestMethod(protocoloHttp);
        connection.setDoOutput(true);


        if(!json.isEmpty()){
            connection.setRequestProperty("Content-Type","application/json");

            try (OutputStream os = connection.getOutputStream()){
                os.write(json.getBytes());
            }

        }
        return connection.getResponseCode();

    }

    private void showMessage(Alert.AlertType type, String msg){
        Alert alerta = new Alert(type);


        alerta.setTitle("Mensagem do Sistema");
        alerta.setHeaderText(null);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }
}
