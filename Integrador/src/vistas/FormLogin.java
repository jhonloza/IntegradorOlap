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
import rnegocio.entidad.*;
import vistas.FormPrincipal;
import accesodatos.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;

/**
 *
 * @author jloza
 */
public class FormLogin {

    private VBox pPrincipal;
    private HBox botones;
    private HBox presentacion;
    private HBox centro;
    private VBox f1;
    private VBox f2;
    private ImageView imagen;
    private Label titulo;
    private Label usuario;
    private Label contraseña;
    private TextField tusuario;
    private TextField tcontraseña;
    private Button blogin;
    private Button bcancelar;
    private String vusuario;
    private String vclave;
    public MenuItem desconectar;

    public FormLogin(MenuBar menuPrincipal) {
        desconectar = new MenuItem("Desconectar");
        pPrincipal = new VBox();
        botones = new HBox();
        presentacion = new HBox();
        centro = new HBox();
        f1 = new VBox();
        f2 = new VBox();
        titulo = new Label("Ingreso de sesion");
        titulo.setAlignment(Pos.CENTER);
        titulo.setFont(Font.font("Arial Black", 20));
        usuario = new Label("Usuario: ");
        usuario.setAlignment(Pos.CENTER);
        usuario.setFont(Font.font("Arial Black", 16));
        contraseña = new Label("Contraseña: ");
        contraseña.setAlignment(Pos.CENTER);
        contraseña.setFont(Font.font("Arial Black", 16));
        tusuario = new TextField();
        tusuario.setAlignment(Pos.CENTER);
        tcontraseña = new TextField();
        tcontraseña.setAlignment(Pos.CENTER);
        blogin = new Button("Ingresar");
        blogin.setAlignment(Pos.CENTER);
        blogin.setPadding(new Insets(5));
        bcancelar = new Button("Cancelar");
        bcancelar.setAlignment(Pos.CENTER);
        bcancelar.setPadding(new Insets(5));
        f1.getChildren().addAll(usuario, contraseña);
        f1.setAlignment(Pos.CENTER);
        f2.getChildren().addAll(tusuario, tcontraseña);
        f2.setAlignment(Pos.CENTER);
        botones.getChildren().addAll(blogin, bcancelar);
        botones.setAlignment(Pos.CENTER);
        centro.getChildren().addAll(f1, f2);
        centro.setAlignment(Pos.CENTER);
        //imagen=new ImageView(new Image("file:src/recursos/siget-071.jpg", 300, 300, true, true));
        // presentacion.getChildren().addAll(imagen, centro);
        presentacion.getChildren().addAll(centro);
        titulo.setPadding(new Insets(10));
        presentacion.setPadding(new Insets(10));
        botones.setPadding(new Insets(5));
        pPrincipal.getChildren().addAll(titulo, presentacion, botones);
        pPrincipal.setAlignment(Pos.CENTER);
        pPrincipal.setStyle("-fx-border-color: black; -fx-background-color: honeydew ");
        Scene escenario = new Scene(pPrincipal);
        Stage estage = new Stage();
        estage.setScene(escenario);
        estage.show();
        blogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    ArrayList<Login> lstLog = new ArrayList<>();
                    lstLog = loginImpl.obtenerLogin(new Login(0, vusuario, vclave));
                    if (lstLog != null) {
                        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                        alerta.setTitle("INFORMACION DEL SISTEMA");
                        alerta.setHeaderText(null);
                        alerta.setContentText("Inicio de sesion Correcto ");
                        alerta.showAndWait();
                        cerrar(estage);
                        Usuario_rol userRol = new Usuario_rol();
                        for (Login login : lstLog) {
                            userRol = new Usuario_rol(0, 0, login.getCodigo(), 0);
                        }
                        ArrayList<Usuario_rol> listaUR = new ArrayList<>();
                        listaUR = UsuarioRolImpl.obtenerLogin(userRol);
                        if (listaUR.size() != 1) {
                            ObservableList<Menu> items = null;
                            items = menuPrincipal.getMenus();
                            items.get(1).setDisable(false);
                            items.get(6).setDisable(false);
                            items.get(7).setDisable(false);
                            items.get(0).getItems().add(1, desconectar);

                        }
                    }
                } catch (Exception e) {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("INFORMACION DEL SISTEMA");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Error de inicio de sesion" + e.getMessage());
                    alerta.showAndWait();
                }
            }
        });
        bcancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                estage.close();
            }
        });
        desconectar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                desconectar(menuPrincipal);
            }
        });
    }

    public VBox getPPrincipal() {
        return pPrincipal;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void cerrar(Stage estage) {
        estage.close();
    }

    public void desconectar(MenuBar items) {
        ObservableList<Menu> submenus = null;
        submenus = items.getMenus();
        submenus.get(1).setDisable(true);
        submenus.get(6).setDisable(true);
        submenus.get(7).setDisable(true);
        submenus.get(0).getItems().remove(1);
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("INFORMACION DEL SISTEMA");
        alerta.setHeaderText(null);
        alerta.setContentText("Sesion cerrada Correctamente");
        alerta.showAndWait();
    }
}
