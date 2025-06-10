import controlador.Controlador;
import vista.Vista;

import javax.swing.*;
/*Ruben fernandez mata 1DAM*/
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Vista vista = new Vista();
            new Controlador(vista);
        });
    }

}