import controlador.Controlador;
import vista.Vista;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Vista vista = new Vista();
            new Controlador(vista);
        });
    }

}