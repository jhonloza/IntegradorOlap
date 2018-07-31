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
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class FormPrincipal extends Application {

    //Escenario
    public Image imagenPrincipal;
    public ImageView visorInicio;
    public Image imagenSecundaria;
    public ImageView visorFinal;
    public Scene escenario;
    //ventana General
    public Pane escritorio;
    public VBox superior;
    public HBox inferior;
    public BorderPane vPrincipal;

    //items menu
    public MenuBar menuPrincipal;
    public Menu mInicio;
    public Menu mEstudiante;
    public Menu mFacultades;
    public Menu mEscuelas;
    public Menu mPeriodos;
    public Menu mNiveles;
    public Menu mAmbitos;
    public Menu mModalidades;
    public Menu mManual;

    //items submenus
    public MenuItem smIniciarSesion;
    public MenuItem smSalir;
    public MenuItem smEstNuevo;
    public MenuItem smEstActualizar;
    public MenuItem smEstEliminar;
    public MenuItem smEstMostrarCodigo;
    public MenuItem smEstListado;
    public MenuItem smFacNuevo;
    public MenuItem smFacActualizar;
    public MenuItem smFacEliminar;
    public MenuItem smFacMostrarCodigo;
    public MenuItem smFacListado;
    public MenuItem smEscNuevo;
    public MenuItem smEscActualizar;
    public MenuItem smEscEliminar;
    public MenuItem smEscMostrarCodigo;
    public MenuItem smEscListado;
    public MenuItem smNivNuevo;
    public MenuItem smNivActualizar;
    public MenuItem smNivEliminar;
    public MenuItem smNivMostrarCodigo;
    public MenuItem smNivListado;
    public MenuItem smAmbNuevo;
    public MenuItem smAmbActualizar;
    public MenuItem smAmbEliminar;
    public MenuItem smAmbMostrarCodigo;
    public MenuItem smAmbListado;
    public MenuItem smModNuevo;
    public MenuItem smModActualizar;
    public MenuItem smModEliminar;
    public MenuItem smModMostrarCodigo;
    public MenuItem smModListado;
    public MenuItem smPerNuevo;
    public MenuItem smPerActualizar;
    public MenuItem smPerEliminar;
    public MenuItem smPerMostrarCodigo;
    public MenuItem smPerListado;
    public MenuItem smManualMostrar;

    @Override
    public void start(Stage primaryStage) {
        //Inicializar items
        imagenPrincipal = new Image("file:src/recursos/siget-011.jpg", 1280, 240, true, true);
        visorInicio = new ImageView(imagenPrincipal);
        imagenSecundaria = new Image("file:src/recursos/siget-031.jpg", 1280, 120, true, true);
        visorFinal = new ImageView(imagenSecundaria);
        vPrincipal = new BorderPane();
        menuPrincipal = new MenuBar();
        mInicio = new Menu("Inicio");
        mEstudiante = new Menu("Estudiantes");
        mFacultades = new Menu("Facultades");
        mEscuelas = new Menu("Escuelas");
        mPeriodos = new Menu("Periodos");
        mNiveles = new Menu("Niveles");
        mAmbitos = new Menu("Ambitos");
        mModalidades = new Menu("Modalidades");
        mManual = new Menu("manual de Usuario");
        mEstudiante.setDisable(false);
        mFacultades.setDisable(true);
        mEscuelas.setDisable(true);
        mPeriodos.setDisable(true);
        mNiveles.setDisable(true);
        mAmbitos.setDisable(false);
        mModalidades.setDisable(false);
        superior = new VBox();
        escritorio = new Pane();
        //Ingreso de subitems a los menus
        smIniciarSesion = new MenuItem("Iniciar Sesion");
        smIniciarSesion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sesion(event);
            }
        });
        smSalir = new MenuItem("Salir");
        smSalir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                salirEventHandler(event);
            }
        });
        smEstNuevo = new MenuItem("Estudiante Nuevo");
        smEstNuevo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane estudianteNuevo = new Pane();
                estudianteNuevo.getChildren().add(nEstudiante(event));
                escritorio.getChildren().add(estudianteNuevo);
            }
        });
        smEstActualizar = new MenuItem("Estudiante Actualizar");
        smEstActualizar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane estudianteActualizar = new Pane();
                estudianteActualizar.getChildren().add(aEstudiante(event));
                escritorio.getChildren().add(estudianteActualizar);
            }
        });
        smEstEliminar = new MenuItem("Estudiante Eliminar");
        smEstEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane estudianteEliminar = new Pane();
                estudianteEliminar.getChildren().add(eEstudiante(event));
                escritorio.getChildren().add(estudianteEliminar);
            }
        });
        smEstMostrarCodigo = new MenuItem("Estudiante por codigo");
        smEstMostrarCodigo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane estudiantemostrarCod = new Pane();
                estudiantemostrarCod.getChildren().add(oEstudiante(event));
                escritorio.getChildren().add(estudiantemostrarCod);
            }
        });
        smEstListado = new MenuItem("Estudiante Listado");
        smEstListado.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane estList = new Pane();
                estList.getChildren().add(lEstudiante(event));
                escritorio.getChildren().add(estList);
            }
        });
        smFacNuevo = new MenuItem("Facultad Nuevo");
        smFacActualizar = new MenuItem("Facultad Actualizar");
        smFacEliminar = new MenuItem("Facultad Eliminar");
        smFacMostrarCodigo = new MenuItem("Facultad por codigo");
        smFacListado = new MenuItem("Facultad Listado");
        smEscNuevo = new MenuItem("Escuela Nuevo");
        smEscActualizar = new MenuItem("Escuela Actualizar");
        smEscEliminar = new MenuItem("Escuela Eliminar");
        smEscMostrarCodigo = new MenuItem("Escuela por codigo");
        smEscListado = new MenuItem("Escuela Listado");
        smPerNuevo = new MenuItem("Periodo Nuevo");
        smPerActualizar = new MenuItem("Periodo Actualizar");
        smPerEliminar = new MenuItem("Periodo Eliminar");
        smPerMostrarCodigo = new MenuItem("Periodo por codigo");
        smPerListado = new MenuItem("Periodo Listado");
        smNivNuevo = new MenuItem("Nivel Nuevo");
        smNivActualizar = new MenuItem("Nivel Actualizar");
        smNivEliminar = new MenuItem("Nivel Eliminar");
        smNivMostrarCodigo = new MenuItem("Nivel por codigo");
        smNivListado = new MenuItem("Nivel Listado");
        smAmbNuevo = new MenuItem("Ambito Nuevo");
        smAmbNuevo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane ambitoNuevo = new Pane();
                ambitoNuevo.getChildren().add(nAmbito(event));
                escritorio.getChildren().add(ambitoNuevo);
            }
        });
        smAmbActualizar = new MenuItem("Ambito Actualizar");
        smAmbActualizar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane ambitoAct = new Pane();
                ambitoAct.getChildren().add(aAmbito(event));
                escritorio.getChildren().add(ambitoAct);
            }
        });
        smAmbEliminar = new MenuItem("Ambito Eliminar");
        smAmbEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane ambitoEli = new Pane();
                ambitoEli.getChildren().add(eAmbito(event));
                escritorio.getChildren().add(ambitoEli);
            }
        });
        smAmbMostrarCodigo = new MenuItem("Ambito por codigo");
        smAmbMostrarCodigo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane ambitoOb = new Pane();
                ambitoOb.getChildren().add(oAmbito(event));
                escritorio.getChildren().add(ambitoOb);
            }
        });
        smAmbListado = new MenuItem("Ambito Listado");
        smAmbListado.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane ambitoLis = new Pane();
                ambitoLis.getChildren().add(lAmbito(event));
                escritorio.getChildren().add(ambitoLis);
            }
        });
        smModNuevo = new MenuItem("Modalidad Nuevo");
        smModNuevo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane modalidadNuevo = new Pane();
                modalidadNuevo.getChildren().add(nModalidad(event));
                escritorio.getChildren().add(modalidadNuevo);
            }
        });
        smModActualizar = new MenuItem("Modalidad Actualizar");
        smModActualizar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane modalidadAct = new Pane();
                modalidadAct.getChildren().add(aModalidad(event));
                escritorio.getChildren().add(modalidadAct);
            }
        });
        smModEliminar = new MenuItem("Modalidad Eliminar");
        smModEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane modalidadEli = new Pane();
                modalidadEli.getChildren().add(eModalidad(event));
                escritorio.getChildren().add(modalidadEli);
            }
        });
        smModMostrarCodigo = new MenuItem("Modalidad por codigo");
        smModMostrarCodigo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane modalidadObt = new Pane();
                modalidadObt.getChildren().add(oModalidad(event));
                escritorio.getChildren().add(modalidadObt);
            }
        });
        smModListado = new MenuItem("Modalidad Listado");
        smModListado.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane modalidadList = new Pane();
                modalidadList.getChildren().add(lModalidad(event));
                escritorio.getChildren().add(modalidadList);
            }
        });
        smManualMostrar = new MenuItem("Mostrar Manual");
        //submenus
        mInicio.getItems().addAll(smIniciarSesion, smSalir);
        mEstudiante.getItems().addAll(smEstNuevo, smEstActualizar, smEstEliminar, new SeparatorMenuItem(), smEstMostrarCodigo, smEstListado);
        mFacultades.getItems().addAll(smFacNuevo, smFacActualizar, smFacEliminar, new SeparatorMenuItem(), smFacMostrarCodigo, smFacListado);
        mEscuelas.getItems().addAll(smEscNuevo, smEscActualizar, smEscEliminar, new SeparatorMenuItem(), smEscMostrarCodigo, smEscListado);
        mPeriodos.getItems().addAll(smPerNuevo, smPerActualizar, smPerEliminar, new SeparatorMenuItem(), smPerMostrarCodigo, smPerListado);
        mNiveles.getItems().addAll(smNivNuevo, smNivActualizar, smNivEliminar, new SeparatorMenuItem(), smNivMostrarCodigo, smNivListado);
        mAmbitos.getItems().addAll(smAmbNuevo, smAmbActualizar, smAmbEliminar, new SeparatorMenuItem(), smAmbMostrarCodigo, smAmbListado);
        mModalidades.getItems().addAll(smModNuevo, smModActualizar, smModEliminar, new SeparatorMenuItem(), smModMostrarCodigo, smModListado);
        mManual.getItems().addAll(smManualMostrar);
        mManual.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
     File path = new File ("dist/lib/MANUAL DE USUARIO.pdf");
     Desktop.getDesktop().open(path);
}catch (IOException ex) {
     ex.printStackTrace();
}
            }
        });
        //ingreso de items menu
        menuPrincipal.getMenus().addAll(mInicio, mEstudiante, mFacultades, mEscuelas, mPeriodos, mNiveles, mAmbitos, mModalidades, mManual);
        superior.getChildren().addAll(visorInicio, menuPrincipal);
        superior.setAlignment(Pos.CENTER);
        inferior=new HBox();
        inferior.getChildren().addAll(visorFinal);
        inferior.setAlignment(Pos.CENTER);
//Ingreso de item en ventana ordenado
        vPrincipal.setTop(superior);
        vPrincipal.setCenter(escritorio);
        vPrincipal.setBottom(inferior);
        escenario = new Scene(vPrincipal, 1280, 960, false);
        //ventana principal y configuracion
        primaryStage.setTitle("Integrador Gestion De Tutorias");
        primaryStage.setScene(escenario);
        primaryStage.setMaxWidth(vPrincipal.getWidth());
        primaryStage.setMaxHeight(vPrincipal.getHeight());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void sesion(ActionEvent event) {
        FormLogin loginNuevo=new FormLogin();
        
    }

    public VentanaInterna nAmbito(ActionEvent event) {
        BorderPane AmbN = new BorderPane();
        Label titulo = new Label("NUEVO AMBITO");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.BLACK);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        AmbN.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormNambito NAmb = new FormNambito();
        AmbN.setCenter(NAmb.getPPrincipal());
        //Creacion de Ventana interna
        VentanaInterna nuevo = new VentanaInterna();
        nuevo.setRoot(AmbN);
        nuevo.makeDragable(bTitulo.getBarra());
        nuevo.makeDragable(titulo);
        nuevo.makeResizable(20);
        nuevo.makeFocusable();
        nuevo.setCloseButton(cerrar);
        return nuevo;
    }

    public VentanaInterna aAmbito(ActionEvent event) {
        BorderPane AmbN = new BorderPane();
        Label titulo = new Label("ACTUALIZAR AMBITO");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.BLACK);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        AmbN.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormAambito NAmb = new FormAambito();
        AmbN.setCenter(NAmb.getPPrincipal());
        //Creacion de Ventana interna
        VentanaInterna nuevo = new VentanaInterna();
        nuevo.setRoot(AmbN);
        nuevo.makeDragable(bTitulo.getBarra());
        nuevo.makeDragable(titulo);
        nuevo.makeResizable(20);
        nuevo.makeFocusable();
        nuevo.setCloseButton(cerrar);
        return nuevo;
    }

    public VentanaInterna eAmbito(ActionEvent event) {
        BorderPane AmbN = new BorderPane();
        Label titulo = new Label("ELIMINAR AMBITO");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.BLACK);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        AmbN.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormEambito NAmb = new FormEambito();
        AmbN.setCenter(NAmb.getPPrincipal());
        //Creacion de Ventana interna
        VentanaInterna nuevo = new VentanaInterna();
        nuevo.setRoot(AmbN);
        nuevo.makeDragable(bTitulo.getBarra());
        nuevo.makeDragable(titulo);
        nuevo.makeResizable(20);
        nuevo.makeFocusable();
        nuevo.setCloseButton(cerrar);
        return nuevo;
    }

    public VentanaInterna oAmbito(ActionEvent event) {
        BorderPane AmbN = new BorderPane();
        Label titulo = new Label("OBTENER AMBITO");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.BLACK);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        AmbN.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormOambito NAmb = new FormOambito();
        AmbN.setCenter(NAmb.getPPrincipal());
        //Creacion de Ventana interna
        VentanaInterna nuevo = new VentanaInterna();
        nuevo.setRoot(AmbN);
        nuevo.makeDragable(bTitulo.getBarra());
        nuevo.makeDragable(titulo);
        nuevo.makeResizable(20);
        nuevo.makeFocusable();
        nuevo.setCloseButton(cerrar);
        return nuevo;
    }

    public VentanaInterna lAmbito(ActionEvent event) {
        BorderPane AmbN = new BorderPane();
        Label titulo = new Label("LISTADO AMBITO");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.BLACK);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        AmbN.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormLambito NAmb = new FormLambito();
        AmbN.setCenter(NAmb.getPPrincipal());
        //Creacion de Ventana interna
        VentanaInterna nuevo = new VentanaInterna();
        nuevo.setRoot(AmbN);
        nuevo.makeDragable(bTitulo.getBarra());
        nuevo.makeDragable(titulo);
        nuevo.makeResizable(20);
        nuevo.makeFocusable();
        nuevo.setCloseButton(cerrar);
        return nuevo;
    }

    public VentanaInterna nModalidad(ActionEvent event) {
        BorderPane AmbN = new BorderPane();
        Label titulo = new Label("NUEVA MODALIDAD");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.BLACK);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        AmbN.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormNmodalidad NAmb = new FormNmodalidad();
        AmbN.setCenter(NAmb.getPPrincipal());
        //Creacion de Ventana interna
        VentanaInterna nuevo = new VentanaInterna();
        nuevo.setRoot(AmbN);
        nuevo.makeDragable(bTitulo.getBarra());
        nuevo.makeDragable(titulo);
        nuevo.makeResizable(20);
        nuevo.makeFocusable();
        nuevo.setCloseButton(cerrar);
        return nuevo;
    }

    public VentanaInterna aModalidad(ActionEvent event) {
        BorderPane AmbN = new BorderPane();
        Label titulo = new Label("ACTUALIZAR MODALIDAD");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.BLACK);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        AmbN.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormAmodalidad NAmb = new FormAmodalidad();
        AmbN.setCenter(NAmb.getPPrincipal());
        //Creacion de Ventana interna
        VentanaInterna nuevo = new VentanaInterna();
        nuevo.setRoot(AmbN);
        nuevo.makeDragable(bTitulo.getBarra());
        nuevo.makeDragable(titulo);
        nuevo.makeResizable(20);
        nuevo.makeFocusable();
        nuevo.setCloseButton(cerrar);
        return nuevo;
    }

    public VentanaInterna eModalidad(ActionEvent event) {
        BorderPane AmbN = new BorderPane();
        Label titulo = new Label("ELIMINAR MODALIDAD");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.BLACK);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        AmbN.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormEmodalidad NAmb = new FormEmodalidad();
        AmbN.setCenter(NAmb.getPPrincipal());
        //Creacion de Ventana interna
        VentanaInterna nuevo = new VentanaInterna();
        nuevo.setRoot(AmbN);
        nuevo.makeDragable(bTitulo.getBarra());
        nuevo.makeDragable(titulo);
        nuevo.makeResizable(20);
        nuevo.makeFocusable();
        nuevo.setCloseButton(cerrar);
        return nuevo;
    }

    public VentanaInterna oModalidad(ActionEvent event) {
        BorderPane AmbN = new BorderPane();
        Label titulo = new Label("OBTENER AMBITO");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.BLACK);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        AmbN.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormOestudiante NAmb = new FormOestudiante();
        AmbN.setCenter(NAmb.getPPrincipal());
        //Creacion de Ventana interna
        VentanaInterna nuevo = new VentanaInterna();
        nuevo.setRoot(AmbN);
        nuevo.makeDragable(bTitulo.getBarra());
        nuevo.makeDragable(titulo);
        nuevo.makeResizable(20);
        nuevo.makeFocusable();
        nuevo.setCloseButton(cerrar);
        return nuevo;
    }
    public VentanaInterna lModalidad(ActionEvent event) {
        BorderPane AmbN = new BorderPane();
        Label titulo = new Label("LISTADO AMBITO");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.BLACK);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        AmbN.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormLmodalidad NAmb = new FormLmodalidad();
        AmbN.setCenter(NAmb.getPPrincipal());
        //Creacion de Ventana interna
        VentanaInterna nuevo = new VentanaInterna();
        nuevo.setRoot(AmbN);
        nuevo.makeDragable(bTitulo.getBarra());
        nuevo.makeDragable(titulo);
        nuevo.makeResizable(20);
        nuevo.makeFocusable();
        nuevo.setCloseButton(cerrar);
        return nuevo;
    }
    public VentanaInterna nEstudiante(ActionEvent event) {
        BorderPane AmbN = new BorderPane();
        Label titulo = new Label("NUEVA MODALIDAD");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.BLACK);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        AmbN.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormNestudiante NAmb = new FormNestudiante();
        AmbN.setCenter(NAmb.getPPrincipal());
        //Creacion de Ventana interna
        VentanaInterna nuevo = new VentanaInterna();
        nuevo.setRoot(AmbN);
        nuevo.makeDragable(bTitulo.getBarra());
        nuevo.makeDragable(titulo);
        nuevo.makeResizable(20);
        nuevo.makeFocusable();
        nuevo.setCloseButton(cerrar);
        return nuevo;
    }
//    

    public VentanaInterna aEstudiante(ActionEvent event) {
        BorderPane AmbN = new BorderPane();
        Label titulo = new Label("ACTUALIZAR MODALIDAD");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.BLACK);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        AmbN.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormAestudiante NAmb = new FormAestudiante();
        AmbN.setCenter(NAmb.getPPrincipal());
        //Creacion de Ventana interna
        VentanaInterna nuevo = new VentanaInterna();
        nuevo.setRoot(AmbN);
        nuevo.makeDragable(bTitulo.getBarra());
        nuevo.makeDragable(titulo);
        nuevo.makeResizable(20);
        nuevo.makeFocusable();
        nuevo.setCloseButton(cerrar);
        return nuevo;
    }

    public VentanaInterna eEstudiante(ActionEvent event) {
        BorderPane AmbN = new BorderPane();
        Label titulo = new Label("ELIMINAR ESTUDIANTE");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.BLACK);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        AmbN.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormEestudiante NAmb = new FormEestudiante();
        AmbN.setCenter(NAmb.getPPrincipal());
        //Creacion de Ventana interna
        VentanaInterna nuevo = new VentanaInterna();
        nuevo.setRoot(AmbN);
        nuevo.makeDragable(bTitulo.getBarra());
        nuevo.makeDragable(titulo);
        nuevo.makeResizable(20);
        nuevo.makeFocusable();
        nuevo.setCloseButton(cerrar);
        return nuevo;
    }
    public VentanaInterna oEstudiante(ActionEvent event) {
        BorderPane AmbN = new BorderPane();
        Label titulo = new Label("OBTENER AMBITO");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.BLACK);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        AmbN.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormOestudiante NAmb = new FormOestudiante();
        AmbN.setCenter(NAmb.getPPrincipal());
        //Creacion de Ventana interna
        VentanaInterna nuevo = new VentanaInterna();
        nuevo.setRoot(AmbN);
        nuevo.makeDragable(bTitulo.getBarra());
        nuevo.makeDragable(titulo);
        nuevo.makeResizable(20);
        nuevo.makeFocusable();
        nuevo.setCloseButton(cerrar);
        return nuevo;
    }
    public VentanaInterna lEstudiante(ActionEvent event) {
        BorderPane AmbN = new BorderPane();
        Label titulo = new Label("LISTADO AMBITO");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.BLACK);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        AmbN.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormLestudiantes NAmb = new FormLestudiantes();
        AmbN.setCenter(NAmb.getPPrincipal());
        //Creacion de Ventana interna
        VentanaInterna nuevo = new VentanaInterna();
        nuevo.setRoot(AmbN);
        nuevo.makeDragable(bTitulo.getBarra());
        nuevo.makeDragable(titulo);
        nuevo.makeResizable(20);
        nuevo.makeFocusable();
        nuevo.setCloseButton(cerrar);
        return nuevo;
    }

    public void salirEventHandler(ActionEvent event) {
        System.exit(0);
    }

}
