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
import javafx.stage.*;
import javafx.scene.image.*;
import rnegocio.entidad.*;
import rnegocio.impl.*;
import accesodatos.*;

/**
 *
 * @author jhonloza
 */
public class FormEestudiante {

    private Label titulo;
    private Label codigo;
    private Label nombre;
    private Label apellido;
    private Label cedula;
    private Label codsicoa;
    private Label codperiodo;
    private Label codnivel;
    private TextField tcodigo;
    private TextField tnombre;
    private TextField tapellido;
    private TextField tcedula;
    private TextField tcodsicoa;
    private TextField tcodperiodo;
    private TextField tcodnivel;
    private Button bbuscar;
    private Button bingresar;
    private Button bLimpiar;
    private VBox pPrincipal;
    private HBox m1;
    private HBox m2;
    private HBox m3;
    private HBox m4;
    private HBox m5;
    private HBox m6;
    private HBox m7;
    private HBox m8;
    private HBox m9;

    public FormEestudiante() {
        titulo = new Label("ACTUALIZAR ESTUDIANTE");
        codigo = new Label("Codigo");
        tcodigo = new TextField();
        bbuscar = new Button("Buscar");
        titulo.setPadding(new Insets(10));
        titulo.setFont(Font.font("Arial Black", 20));
        nombre = new Label("Nombre: ");
        nombre.setPadding(new Insets(10));
        nombre.setFont(Font.font("Arial Black", 16));
        apellido = new Label("apelliodo: ");
        apellido.setPadding(new Insets(10));
        apellido.setFont(Font.font("Arial Black", 16));
        codsicoa = new Label("codigo sicoa: ");
        codsicoa.setPadding(new Insets(10));
        codsicoa.setFont(Font.font("Arial Black", 16));
        cedula = new Label("cedula: ");
        cedula.setPadding(new Insets(10));
        cedula.setFont(Font.font("Arial Black", 16));
        codperiodo = new Label("codigo periodo: ");
        codperiodo.setPadding(new Insets(10));
        codperiodo.setFont(Font.font("Arial Black", 16));
        codnivel = new Label("codigo nivel: ");
        codnivel.setPadding(new Insets(10));
        codnivel.setFont(Font.font("Arial Black", 16));
        tnombre = new TextField();
        tnombre.setPadding(new Insets(10));
        tapellido = new TextField();
        tapellido.setPadding(new Insets(10));
        tcedula = new TextField();
        tcedula.setPadding(new Insets(10));
        tcodsicoa = new TextField();
        tcodsicoa.setPadding(new Insets(10));
        tcodperiodo = new TextField();
        tcodperiodo.setPadding(new Insets(10));
        tcodnivel = new TextField();
        tcodnivel.setPadding(new Insets(10));
        bingresar = new Button("ingresar");
        bingresar.setPadding(new Insets(10));
        bingresar.setFont(Font.font("Arial Black", 14));
        bLimpiar = new Button("Limpiar");
        bLimpiar.setPadding(new Insets(10));
        bLimpiar.setFont(Font.font("Arial Black", 14));
        pPrincipal = new VBox();
        m1 = new HBox();
        m2 = new HBox();
        m3 = new HBox();
        m4 = new HBox();
        m5 = new HBox();
        m6 = new HBox();
        m7 = new HBox();
        m8 = new HBox();
        m9 = new HBox();
        m1.getChildren().addAll(titulo);
        m1.setAlignment(Pos.CENTER);
        m2.getChildren().addAll(nombre, tnombre);
        m2.setAlignment(Pos.CENTER);
        m3.getChildren().addAll(apellido, tapellido);
        m3.setAlignment(Pos.CENTER);
        m4.getChildren().addAll(cedula, tcedula);
        m4.setAlignment(Pos.CENTER);
        m5.getChildren().addAll(codsicoa, tcodsicoa);
        m5.setAlignment(Pos.CENTER);
        m6.getChildren().addAll(codperiodo, tcodperiodo);
        m6.setAlignment(Pos.CENTER);
        m7.getChildren().addAll(codnivel, tcodnivel);
        m7.setAlignment(Pos.CENTER);
        m8.getChildren().addAll(bingresar, bLimpiar);
        m8.setAlignment(Pos.CENTER);
        m9.getChildren().addAll(codigo, tcodigo, bbuscar);
        m9.setAlignment(Pos.CENTER);
        pPrincipal.getChildren().addAll(m9, m1, m2, m3, m4, m5, m6, m7, m8);
        pPrincipal.setBackground(new Background(new BackgroundFill(Color.CYAN, CornerRadii.EMPTY, Insets.EMPTY)));
        pPrincipal.setMinSize(350, 400);
        bbuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Estudiante ambito = null;
                try {
                    ambito = new Estudiante();
                    ambito=EstudianteImpl.ObtenerEstudianteDadoCodigo(Integer.parseInt(tcodigo.getText()));
                    if (ambito!=null) {
                        tnombre.setText(ambito.getNombre());
                        tapellido.setText(ambito.getApellido());
                        tcedula.setText(ambito.getCedula());
                        tcodsicoa.setText(Integer.toString(ambito.getCodigo_sicoa()));
                        tcodperiodo.setText(ambito.getPeriodo().getNombre());
                        tcodnivel.setText(ambito.getNivel().getNombre());
                    }
                } catch (Exception e) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("INFORMACION DEL SISTEMA");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Error al buscar Estudiante: " + e.getMessage());
                    alerta.showAndWait();
                }
            }
        });
        bingresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Estudiante ambito = null;
                try {
                    ambito = new Estudiante();
                    ambito.setCodigo(0);
                    ambito.setNombre(tnombre.getText());
                    ambito.setApellido(tapellido.getText());
                    ambito.setCodigo_sicoa(Integer.parseInt(tcodsicoa.getText()));
                    ambito.setPeriodo(PeriodoImpl.ObtenerPeriodoDadoCodigo(Integer.parseInt(tcodperiodo.getText())));
                    ambito.setNivel(NivelImpl.ObtenerNivelDadoCodigo(Integer.parseInt(tcodnivel.getText())));
                    if (EstudianteImpl.eliminar(ambito)) {
                        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                        alerta.setTitle("INFORMACION DEL SISTEMA");
                        alerta.setHeaderText(null);
                        alerta.setContentText("Eliminacion Correcta!");
                        alerta.showAndWait();
                    }
                } catch (Exception e) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("INFORMACION DEL SISTEMA");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Error: " + e.getMessage());
                    alerta.showAndWait();
                }
            }
        });
        bLimpiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    tnombre.setText("");
                    tapellido.setText("");
                    tcedula.setText("");
                    tcodsicoa.setText("");
                    tcodperiodo.setText("");
                    tcodnivel.setText("");
                } catch (Exception e) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("INFORMACION DEL SISTEMA");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Error: " + e.getMessage());
                    alerta.showAndWait();
                }
            }
        });
    }
    public VBox getPPrincipal() {
        return pPrincipal;
    }
}
