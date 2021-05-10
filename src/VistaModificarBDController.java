/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jurome
 */
public class VistaModificarBDController implements Initializable {
    private Stage escenario;
    
    @FXML private TextField textServidor;
    @FXML private TextField textPuerto;
    @FXML private TextField textBaseDeDatos;
    @FXML private TextField textUsuario;
    @FXML private TextField textContraselia;
    
    
    @FXML private Button btGuardaCambio;
    @FXML private Button btCerra;
    
    public void asignaEscenario(Stage stagePrincipal) {
        this.escenario = stagePrincipal;
    }
    
    @FXML
    private void CerrarVentanaSecundaria(ActionEvent event) {
        // Cerrar esta ventana
        escenario.close();
    }    
    

    @FXML
    private void GuardarCambiosBD(ActionEvent event) {
    }


    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
}
