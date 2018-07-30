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
public class FormNambito {

    private Label titulo;
    private Label nombre;
    private Label observacion;
    private Label estado;
    private TextField tnombre;
    private TextArea tobservacion;
    private TextField testado;
    private Button bingresar;
    private Button bLimpiar;
    private VBox pPrincipal;
    private HBox m1;
    private HBox m2;
    private HBox m3;
    private HBox m4;
    private HBox m5;

    public FormNambito() {
        titulo = new Label("Nuevo Ambito");
        titulo.setPadding(new Insets(10));
        titulo.setFont(Font.font("Arial Black", 20));
        nombre = new Label("Nombre: ");
        nombre.setPadding(new Insets(10));
        nombre.setFont(Font.font("Arial Black", 16));
        observacion = new Label("Observacion: ");
        observacion.setPadding(new Insets(10));
        observacion.setFont(Font.font("Arial Black", 16));
        estado = new Label("Estado: ");
        estado.setPadding(new Insets(10));
        estado.setFont(Font.font("Arial Black", 16));
        tnombre = new TextField();
        tnombre.setPadding(new Insets(10));
        tobservacion = new TextArea();
        tobservacion.setPadding(new Insets(10));
        tobservacion.setMinSize(200, 100);
        tobservacion.setMaxSize(200, 100);
        tobservacion.setWrapText(true);
        testado = new TextField();
        testado.setPadding(new Insets(10));
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
        m1.getChildren().addAll(titulo);
        m1.setAlignment(Pos.CENTER);
        m2.getChildren().addAll(nombre, tnombre);
        m2.setAlignment(Pos.CENTER);
        m3.getChildren().addAll(observacion, tobservacion);
        m3.setAlignment(Pos.CENTER);
        m4.getChildren().addAll(estado, testado);
        m4.setAlignment(Pos.CENTER);
        m5.getChildren().addAll(bingresar, bLimpiar);
        m5.setAlignment(Pos.CENTER);
        pPrincipal.getChildren().addAll(m1, m2, m4, m3, m5);
        pPrincipal.setBackground(new Background(new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, Insets.EMPTY)));
        pPrincipal.setMinSize(350, 300);
        bingresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Ambitos ambito = null;
                try {
                    ambito = new Ambitos();
                    ambito.setCodigo(0);
                    ambito.setNombre(tnombre.getText());
                    ambito.setObservacion(tobservacion.getText());
                    ambito.setEstado(Integer.parseInt(testado.getText()));
                    if (AmbitoImpl.Insertar(ambito)) {
                        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                        alerta.setTitle("INFORMACION DEL SISTEMA");
                        alerta.setHeaderText(null);
                        alerta.setContentText("Actualizacion Correcta ");
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
                    tobservacion.setText("");
                    testado.setText("");
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
