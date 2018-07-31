/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;
import javafx.application.Application;
import javafx.event.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import java.util.*;
import javafx.stage.Window;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import java.lang.reflect.*;
import java.text.*;
import javafx.beans.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.image.*;

public class BarraDeTitulo {
    private ImageView icono;
    private Image img;
    private BackgroundImage fondo;
    private BorderPane barra;

    public BarraDeTitulo(Node nombreVentana, Node cerrar) {
        cerrar.setStyle("-fx-background-color: red");
        barra = new BorderPane();
        barra.setCenter(nombreVentana);
        barra.setRight(cerrar);
        barra.setStyle("-fx-border-color: blue; -fx-border-width: 2px; -fx-background-color: lightgray  ");
    }

    public Node getBarra() {
        return barra;
    }

}