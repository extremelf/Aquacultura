package com.aquacultura.controllers;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.aquacultura.BLL.ClienteBLL;
import com.aquacultura.DAL.ClienteEntity;

import java.io.IOException;
import java.util.List;

public class Controller extends Application {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public TableView tabelaCliente;
    @FXML
    public TextField emailfield;
    @FXML
    public PasswordField passwordfield;
    @FXML
    public TableColumn idRow;
    @FXML
    public TableColumn nomeRow;
    @FXML
    public TableColumn moradaRow;
    @FXML
    public TableColumn contactoRow;
    @FXML
    public TableColumn ccRow;
    @FXML
    public TableColumn contaCorrenteRow;



    private ObservableList<ClienteEntity> data;
    public TableView getTabelaCliente() {
        return tabelaCliente;
    }

    public void startTabela(){
        data = FXCollections.observableArrayList();
        try{
            List<ClienteEntity> listaClientes = ClienteBLL.readAll();

            for(ClienteEntity lista: listaClientes){
                ClienteEntity cliente = new ClienteEntity();
                cliente.setIdcliente(lista.getIdcliente());
                cliente.setNome(lista.getNome());
                cliente.setNomerua(lista.getNomerua());
                cliente.setContacto(lista.getContacto());
                cliente.setCc(lista.getCc());
                cliente.setContacorrente(lista.getContacorrente());

                System.out.println("2");
                data.add(cliente);
                System.out.println(data);
            }
            tabelaCliente.setItems(data);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

    @Override
    public void start(Stage primaryStage){

    }

    public void pressButton(ActionEvent event) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("/Tanques.fxml"));
       stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();

        System.out.println(emailfield.getText() + " " + passwordfield.getText());
    }

    public void logout(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
