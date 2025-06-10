package vista;

import modelo.Pedidos;

import javax.swing.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Vista {
    private JPanel panel1;
    private JButton BotonHacerPedido;
    private JComboBox comboBoxModelo;
    private JComboBox comboBoxMotor;
    private JComboBox comboBoxColor;
    private JComboBox comboBoxRuedas;
    private JComboBox comboBoxPilotAuto;
    private JButton BotonVisualizarPedidos;
    private JButton BotonBaja;
    private JList list1;

    //constructor
    public Vista() {
        JFrame frame = new JFrame("coches");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //metodo que recibe un arrayList y llena el combobox
    public void setComboBoxModelo(ArrayList<String> opcionModelo) {
        this.comboBoxModelo.removeAllItems();
        for (String s : opcionModelo) {
            this.comboBoxModelo.addItem(s);
        }
    }

    //metodo que recibe un arraylist y rellena el combobox
    public void setComboBoxMotor(ArrayList<String> opcionMotor) {
        this.comboBoxMotor.removeAllItems();
        for (String s : opcionMotor) {
            this.comboBoxMotor.addItem(s);
        }
    }

    //metodo que recibe un arraylist y rellena el combobox
    public void setComboBoxColor(ArrayList<String> opcionColor) {
        this.comboBoxColor.removeAllItems();
        for (String s : opcionColor) {
            this.comboBoxColor.addItem(s);
        }
    }

    //metodo que recibe un arraylist y rellena el combobox
    public void setComboBoxRuedas(ArrayList<Integer> opcionRuedas) {
        this.comboBoxRuedas.removeAllItems();
        for (Integer s : opcionRuedas) {
            this.comboBoxRuedas.addItem(s);
        }
    }

    //metodo que recibe un arraylist y rellena el combobox
    public void setComboBoxPilotAuto(ArrayList<Boolean> opcionPilotoAuto) {
        this.comboBoxPilotAuto.removeAllItems();
        for (Boolean s : opcionPilotoAuto) {
            this.comboBoxPilotAuto.addItem(s);
        }
    }

    //boton para hacer pedido
    public JButton getBotonHacerPedido() {
        return BotonHacerPedido;
    }

    public String getModeloSeleccionado() {
        return String.valueOf(comboBoxModelo.getSelectedItem());
    }

    public String getMotorSeleccionado() {
        return String.valueOf(comboBoxMotor.getSelectedItem());
    }

    public String getColorSeleccionado() {
        return String.valueOf(comboBoxColor.getSelectedItem());
    }

    public int getRuedasSeleccionado() {
        return (int) comboBoxRuedas.getSelectedItem();
    }

    //get piloto automatico
    public Byte getPilotoAutoSeleccionado() {
        byte seleccion = 1;
        if (String.valueOf(comboBoxPilotAuto.getSelectedItem()).equalsIgnoreCase("false")) {
            seleccion = 0;
        }
        return seleccion;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(panel1, mensaje);
    }

    public int mensajeConfirmacion(String texto1, String texto2) {
        int opcion = JOptionPane.showConfirmDialog(
                null,
                texto1,
                texto2,
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE

        );
        return opcion;
    }


    // Rellena el JList con la lista de objetos Pedidos
    public void setListaPedidos(List<Pedidos> pedidos) {
        DefaultListModel<Pedidos> modelo = new DefaultListModel<>();
        for (Pedidos p : pedidos) {
            modelo.addElement(p);
        }
        list1.setModel(modelo);
    }

    // Devuelve la lista de objetos que el usuario ha seleccionado /
    public List<Pedidos> getPedidosSeleccionados() {
        return list1.getSelectedValuesList();

    }

    //boton para dar de baja
    public JButton getBotonBaja() {
        BotonBaja.setEnabled(false);
        return BotonBaja;
    }

    //boton visualizar pedidos
    public JButton getBotonVisualizarPedidos() {
        return BotonVisualizarPedidos;
    }

    //el jlist de pedidos
    public JList<Pedidos> getListaPedidos() {
        return list1;
    }


}


