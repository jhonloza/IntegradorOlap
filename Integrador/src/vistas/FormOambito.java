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
public class FormOambito {
    private Label titulo;
    private Label codigo;
    private Label nombre;
    private Label observacion;
    private Label estado;
    private TextField tcodigo;
    private TextField tnombre;
    private TextArea tobservacion;
    private TextField testado;
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
    public FormOambito(){
        titulo=new Label("Obtener Ambito");
        titulo.setPadding(new Insets(10));
        titulo.setFont(Font.font("Arial Black", 20));
        codigo=new Label("codigo");
        codigo.setPadding(new Insets(10));
        codigo.setFont(Font.font("Arial Black", 20));
        nombre=new Label("Nombre: ");
        nombre.setPadding(new Insets(10));
        nombre.setFont(Font.font("Arial Black", 16));
    observacion=new Label("Observacion: ");
    observacion.setPadding(new Insets(10));
    observacion.setFont(Font.font("Arial Black", 16));
    estado=new Label("Estado: ");
    estado.setPadding(new Insets(10));
    estado.setFont(Font.font("Arial Black", 16));
    tnombre=new TextField();
    tnombre.setPadding(new Insets(10));
    tnombre.setEditable(false);
    tcodigo=new TextField();
    tobservacion=new TextArea();
    tobservacion.setPadding(new Insets(10));
    tobservacion.setMinSize(200, 100);
    tobservacion.setMaxSize(200, 100);
    tobservacion.setWrapText(true);
    tobservacion.setEditable(false);
    testado=new TextField();
    testado.setPadding(new Insets(10));
    testado.setEditable(false);
    bingresar=new Button("Buscar");
    bingresar.setPadding(new Insets(10));
    bingresar.setFont(Font.font("Arial Black", 14));
    bLimpiar=new Button("Limpiar");
    bLimpiar.setPadding(new Insets(10));
    bLimpiar.setFont(Font.font("Arial Black", 14));
//    bbuscar=new Button("Buscar");
//    bbuscar.setPadding(new Insets(10));
//    bbuscar.setFont(Font.font("Arial Black", 14));
    pPrincipal=new VBox();
    m1=new HBox();
    m2=new HBox();
    m3=new HBox();
    m4=new HBox();
    m5=new HBox();
    m6=new HBox();
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
    m6.getChildren().addAll(codigo, tcodigo);
    pPrincipal.getChildren().addAll(m1, m6, m2, m4, m3, m5);
    pPrincipal.setBackground(new Background(new BackgroundFill(Color.CYAN, CornerRadii.EMPTY, Insets.EMPTY)));
    pPrincipal.setMinSize(350, 300);
//    bbuscar.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                Ambitos ambito=null;
//                try {
//                    ambito=new Ambitos();
//                    if(ambito!=null){
//                        ambito=AmbitoImpl.ObtenerAmbitosDadoCodigo(Integer.parseInt(tcodigo.getText()));
//                    tnombre.setText(ambito.getNombre());
//                    tobservacion.setText(ambito.getObservacion());
//                    testado.setText(Integer.toString(ambito.getEstado()));
//                    }
//                    else {
//                        System.out.println("Error al buscar ambito");
//                    }
//                } catch (Exception e) {
//                    System.out.println("Error: "+e.getMessage());
//                }
//            }
//        });
    bingresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Ambitos ambito=null;
                try {
                    ambito=AmbitoImpl.ObtenerAmbitosDadoCodigo(Integer.parseInt(tcodigo.getText()));
                    if(ambito!=null){
                        tnombre.setText(ambito.getNombre());
                        tobservacion.setText(ambito.getObservacion());
                        testado.setText(Integer.toString(ambito.getEstado()));
                        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("INFORMACION DEL SISTEMA");
            alerta.setHeaderText(null);
            alerta.setContentText("Busqueda Correcta ");
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
                    tcodigo.setText("");
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
