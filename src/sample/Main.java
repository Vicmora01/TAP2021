package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.views.Calculadora;
import sample.views.Encriptador;
import sample.views.Rompecabezas;

public class Main extends Application implements EventHandler<WindowEvent> {

    private VBox vBox;
    private MenuBar mnbPrincipal;
    private Menu menCompetencia1, menCompetencia2, menCerrar;
    private MenuItem mitCalcu,mitRompecabezas, mitSalir, mitEncriptador, mitBDCanciones, mitCorredores, mitSocket;
    private Scene escena;

    @Override
    public void start(Stage primaryStage) throws Exception{
        vBox = new VBox();
        CrearMenu();
        CrearEscena();

        primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST,this );
        primaryStage.setTitle("Proyecto de clase Topicos avanzados de programacion 2021");
        primaryStage.setScene(escena);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    private void CrearMenu(){
        mnbPrincipal = new MenuBar();
        menCompetencia1 = new Menu("Competencia 1");
        menCompetencia2 = new Menu("Competencia 2");
        menCerrar = new Menu("Cerrar");
        mnbPrincipal.getMenus().addAll(menCompetencia1, menCompetencia2, menCerrar);

        mitCalcu = new MenuItem("Calculadora");
        mitCalcu.setOnAction(event -> opcionesMenu(1));
        mitRompecabezas = new MenuItem("Rompecabezas");
        mitRompecabezas.setOnAction(event -> opcionesMenu(2));
        mitEncriptador = new MenuItem("Encriptador");
        mitEncriptador.setOnAction(event -> opcionesMenu(3));
        mitBDCanciones = new MenuItem("BDCanciones");
        mitBDCanciones.setOnAction(event -> opcionesMenu(4));

        menCompetencia1.getItems().addAll(mitCalcu, mitRompecabezas, mitEncriptador,mitBDCanciones);

        mitCorredores = new MenuItem("Ejecuciond e hilos");
        mitCorredores.setOnAction(event -> opcionesMenu(5));

        mitSocket = new MenuItem("Manejo de Sockets");
        mitSocket.setOnAction(event -> opcionesMenu(6));
        menCompetencia2.getItems().addAll(mitCorredores, mitSocket);

        mitSalir = new MenuItem("Salir");
        mitSalir.setOnAction(event -> {System.exit(0);});
        menCerrar.getItems().add(mitSalir);
    }

    private void CrearEscena(){
        vBox.getChildren().add(mnbPrincipal);
        escena = new Scene(vBox, 300, 70);
        escena.getStylesheets().add(getClass().getResource("css/Styles.css").toExternalForm());
    }

    private void opcionesMenu(int opc) {
       switch (opc){
            case 1: new Calculadora(); break;
            case 2: new Rompecabezas(); break;
            case 3: new Encriptador(); break;
           // case 4: new FrmCanciones(); break;
           // case 5: new Pista(); break;
           // case 6: new ClienteSocket().connectToServer();
        }
    }



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(WindowEvent windowEvent) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Mensaje del sistema");
        alerta.setHeaderText("Gracias por usar el programa :D");
        alerta.setContentText("Vuelva Pronto");
        alerta.showAndWait();
    }
}
