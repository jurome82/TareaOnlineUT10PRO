/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author jurome
 */
public class RodriguezMendezJuan_UT9PRO extends Application {
    
    // Definimos constantes - Nombre de las vistas.
    private final String VENTANA_PRINCIPAL = "Vista.fxml" ;
    private final String VENTANA_ALTA = "VistaModificarBD.fxml" ;
    
    // Zona de variables   
    private Stage escenarioPrincipal;    
    
    
    
    @Override
    public void start(Stage stagePrincipal) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("Vista.fxml"));
//        
//        Scene scene = new Scene(root);
//        
//        stage.setScene(scene);
//        stage.show();

        // Guardamos el escenario principal de la aplicación
        this.escenarioPrincipal = stagePrincipal;
        lanzarVentanaPrincipal();
    }
    
 ////////////////////////////////////////////////   
    
    /**
     * Cargar la ventana principal. Tenemos acceso al controlador de la vista.
     * Así podemos enviar parámetros a los métodos que definiremos en el
     * controlador. En este caso será el método asociaModelo()
     * con el método cque reamos la comunicación entre el controlador y el
     * programa principal (Modelo).
     */
    private void lanzarVentanaPrincipal() {
        AnchorPane panelRaiz ;
        try {
            // Recoger el grafo resultante.
            FXMLLoader loader = new FXMLLoader(RodriguezMendezJuan_UT9PRO.class.getResource(VENTANA_PRINCIPAL));
            // Carga la jerarquía de objetos desde un documento FXML.
            panelRaiz = (AnchorPane) loader.load() ;
            
            // Añadir el panel a la escena
            Scene scene = new Scene(panelRaiz) ;
            // Establecer el título del escenario
            escenarioPrincipal.setTitle("Ventana Principal") ;
            // Asignamos la escena al escenario
            escenarioPrincipal.setScene(scene) ;
            
            // Obtener el controlador asociado
            VistaController controller = loader.getController();
            //Le pasamos al controlador el modelo para que pueda acceder a métodos cuando lo necesite.
            controller.asociaModelo(this);
            // Mostrar ventana
            escenarioPrincipal.show();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Muestra la ventana secundaria, la ventana para dar de alta.
     * El método asignaEscenario nos permitirá acceder al escenario 
     * desde el controller para poder cerrarlo cuando se necesite.
     */
    protected void lanzarVentanaSecundaria() {
        try {
            // Recoger el grafo resultante.
            FXMLLoader loader = new FXMLLoader(RodriguezMendezJuan_UT9PRO.class.getResource(VENTANA_ALTA));
            // Crear un panel contenedor
            AnchorPane panel = (AnchorPane) loader.load();
            // Crear nueva ventana
            Stage nuevaEscenario = new Stage() ;
            // Título de la ventana
            nuevaEscenario.setTitle("Alta de una persona");
            // Especifica el propietario de esta ventana.
            nuevaEscenario.initOwner(escenarioPrincipal);
            
            // Añadir panel a la escena
            Scene scene = new Scene(panel);
            // Asignamos la escena al escenario
            nuevaEscenario.setScene(scene);
            
            // Obtener el controlador asociado
            VistaModificarBDController controller = loader.getController();
            //Le pasamos al controlador el escenario que contendrá a la vista.
            controller.asignaEscenario(nuevaEscenario);
            // Denimimos la ventana modal.
            nuevaEscenario.initModality(Modality.WINDOW_MODAL);
            // Mostrar la ventana
            nuevaEscenario.show();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }    
    

    
 //////////////////////////////////////////////// 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
