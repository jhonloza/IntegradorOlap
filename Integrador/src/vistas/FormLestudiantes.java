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
 * @author jloza
 */
public class FormLestudiantes {

    private TableView<Estudiante> tblAmbitos;
    private Label titulo;
    private TableColumn<Estudiante, Integer> colcodigos;
    private TableColumn<Estudiante, String> colnombres;
    private TableColumn<Estudiante, String> colapellidos;
    private TableColumn<Estudiante, String> colcedula;
    private TableColumn<Estudiante, Integer> colcodSicoa;
    private VBox pPrincipal;
    private ScrollPane listado;

    public FormLestudiantes() {
        titulo = new Label("LISTADO DE ESTUDIANTES");
        titulo.setPadding(new Insets(10));
        titulo.setFont(Font.font("Arial Black", 20));
        tblAmbitos = new TableView<>();
        colcodigos = new TableColumn<>("codigo");
        colnombres = new TableColumn<>("nombre");
        colapellidos = new TableColumn<>("apellido");
        colcedula = new TableColumn<>("cedula");
        colcodSicoa = new TableColumn<>("cod_Sicoa");
        tblAmbitos.getColumns().addAll(colcodigos, colnombres, colapellidos, colcedula, colcodSicoa);
        cargarDatos();
        pPrincipal = new VBox();
        listado = new ScrollPane(tblAmbitos);
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
        List<Estudiante> listAmbitos = new ArrayList<>();
        try {
            listAmbitos = EstudianteImpl.ObtenerEstudiantes();
            colcodigos.setCellValueFactory(new PropertyValueFactory<>("codigo"));
            colnombres.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            colapellidos.setCellValueFactory(new PropertyValueFactory<>("apellido"));
            colcedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
            colcodSicoa.setCellValueFactory(new PropertyValueFactory<>("codigo_sicoa"));
            tblAmbitos.getItems().addAll(listAmbitos);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}
