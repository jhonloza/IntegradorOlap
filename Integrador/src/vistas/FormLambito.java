/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import java.util.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import java.lang.reflect.*;
import java.text.*;
import javafx.beans.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.stage.*;
import javafx.scene.image.*;
import rnegocio.entidad.*;
import rnegocio.impl.*;
import accesodatos.*;

/**
 *
 * @author jhonloza
 */
public class FormLambito {

    private TableView<Ambitos> tblAmbitos;
    private Label titulo;
    private TableColumn<Ambitos, Integer> colcodigos;
    private TableColumn<Ambitos, String> colnombres;
    private TableColumn<Ambitos, String> colobservacion;
    private TableColumn<Ambitos, Integer> colestado;
    private VBox pPrincipal;
    private ScrollPane listado;

    public FormLambito() {
        titulo = new Label("LISTADO DE AMBITOS");
        titulo.setPadding(new Insets(10));
        titulo.setFont(Font.font("Arial Black", 20));
        tblAmbitos=new TableView<>();
        colcodigos = new TableColumn<>("codigo");
        colnombres = new TableColumn<>("nombre");
        colobservacion = new TableColumn<>("observacion");
        colobservacion.setMaxWidth(200);
        colobservacion.setMinWidth(100);
        colestado = new TableColumn<>("estado");
        tblAmbitos.getColumns().addAll(colcodigos, colnombres, colobservacion, colestado);
        cargarDatos();
        pPrincipal = new VBox();
        listado=new ScrollPane(tblAmbitos);
        listado.autosize();
        pPrincipal.getChildren().addAll(titulo, listado);
        pPrincipal.setStyle("-fx-border-color: black");
        pPrincipal.setAlignment(Pos.CENTER);
        pPrincipal.setPadding(new Insets(10));
    }

    public Node getPPrincipal() {
        return pPrincipal;
    }

    public void cargarDatos() {
        List<Ambitos> listAmbitos = new ArrayList<>();
        try {
            listAmbitos = AmbitoImpl.ObtenerAmbitos();
            colcodigos.setCellValueFactory(new PropertyValueFactory<>("codigo"));
            colnombres.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            colobservacion.setCellValueFactory(new PropertyValueFactory<>("observacion"));
            colestado.setCellValueFactory(new PropertyValueFactory<>("estado"));
            tblAmbitos.getItems().addAll(listAmbitos);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}
