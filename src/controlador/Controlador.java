package controlador;

import modelo.OpcionesDAO;
import modelo.Pedidos;
import modelo.PedidosDAO;
import vista.Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controlador {


    private Vista vista;

    //constructor
    public Controlador(Vista vista) {
        this.vista = vista;
        cargarDatosIniciales();
        configurarEventos();
    }

    //cargamos datos iniciales a los combobox
    private void cargarDatosIniciales() {
        try {
            ArrayList<String> modelo = OpcionesDAO.opcionesModelo();
            vista.setComboBoxModelo(modelo);
            ArrayList<String> motor = OpcionesDAO.opcionesMotor();
            vista.setComboBoxMotor(motor);
            ArrayList<String> color = OpcionesDAO.opcionesColor();
            vista.setComboBoxColor(color);
            ArrayList<Integer> Ruedas = OpcionesDAO.opcionesRuedas();
            vista.setComboBoxRuedas(Ruedas);
            ArrayList<Boolean> pilotoAuto = OpcionesDAO.opcionesPilotoAutomatico();
            vista.setComboBoxPilotAuto(pilotoAuto);
        } catch (SQLException e) {
            System.out.println("Error al cargar la lista al comboBox");
            e.printStackTrace();
        }
    }

    private void configurarEventos() {
        //boton hacer pedido
        vista.getBotonHacerPedido().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //declaracionde variables
                String modelo = "";
                String motor = "";
                String color = "";
                int ruedas = 0;
                byte pilotAuto = 0;
                //pedimos datos para llenar las variables
                modelo = vista.getModeloSeleccionado();
                motor = vista.getMotorSeleccionado();
                color = vista.getColorSeleccionado();
                ruedas = vista.getRuedasSeleccionado();
                pilotAuto = vista.getPilotoAutoSeleccionado();
                //creamos un objeto pedido
                Pedidos p = new Pedidos(1, modelo, motor, color, ruedas, pilotAuto);
                String textoMensaje = "¿Desea encargar el coche?";
                String textoVentana = "Selecciona una opcion";
                // llamada almetodo que lanza el emnsaje de confirmacioan
                int opcion = vista.mensajeConfirmacion(textoMensaje, textoVentana);
                //swich de eleccion del mensaje de confirmacion
                switch (opcion) {

                    case JOptionPane.YES_OPTION -> {
                        //llamada al metodo que inserta los pedidos
                        try {
                            int respuesta = PedidosDAO.insertarpedido(p);
                            if (respuesta == 1) {
                                vista.mostrarMensaje("Pedido realizado correctamente");
                            }

                        } catch (SQLException ex) {
                            vista.mostrarMensaje("No se ha podido insertar el pedido");
                            ex.printStackTrace();
                            vista.mostrarMensaje(ex.getMessage());
                        }

                    }
                    case JOptionPane.NO_OPTION -> {
                        vista.mostrarMensaje("has elegido NO!");

                    }
                    case JOptionPane.CANCEL_OPTION -> {
                        vista.mostrarMensaje("Has elegido CANCELAR!");

                    }
                }

            }

        });

        vista.getBotonVisualizarPedidos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Pedidos> listaPedidos;

                try {
                    listaPedidos = PedidosDAO.getPedidos();
                    if (listaPedidos.isEmpty()) {
                        vista.mostrarMensaje("No hay pedidos!");
                    } else {
                        vista.setListaPedidos(listaPedidos);
                    }

                } catch (SQLException ex) {
                    vista.mostrarMensaje("Error de conexion con base de datos");
                    ex.printStackTrace();
                    vista.mostrarMensaje(ex.getMessage());
                }

            }
        });
        vista.getBotonBaja().setEnabled(false);

// Añade un listener a la lista de pedidos
        vista.getListaPedidos().addListSelectionListener(e -> {
            // Verificamos si hay algún pedido seleccionado
            boolean haySeleccion = !vista.getPedidosSeleccionados().isEmpty();
            vista.getBotonBaja().setEnabled(haySeleccion);
        });

        vista.getBotonBaja().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List pedidos = vista.getPedidosSeleccionados();
                if (!(pedidos.isEmpty())) {
                    Pedidos p = (Pedidos) pedidos.get(0);
                    String textoMensaje = "¿Desea borrar el pedido con el numnero "+p.getId()+" ?";
                    String textoVentana = "Selecciona una opcion";
                    // llamada almetodo que lanza el emnsaje de confirmacioan
                    int opcion = vista.mensajeConfirmacion(textoMensaje, textoVentana);
                    //swich de eleccion del mensaje de confirmacion
                    switch (opcion) {

                        case JOptionPane.YES_OPTION -> {
                            try {
                                int respuesta = PedidosDAO.borraPedido(p);
                                ArrayList<Pedidos> listaPedidos;
                                listaPedidos = PedidosDAO.getPedidos();
                                vista.setListaPedidos(listaPedidos);
                                if (respuesta == 1) {
                                    vista.mostrarMensaje("Pedido borrado correctamente");
                                }

                            } catch (SQLException ex) {
                                vista.mostrarMensaje("No se ha podido borrar el pedido");
                                ex.printStackTrace();
                                vista.mostrarMensaje(ex.getMessage());
                            }

                        }
                        case JOptionPane.NO_OPTION -> {
                            vista.mostrarMensaje("has elegido NO!");

                        }
                        case JOptionPane.CANCEL_OPTION -> {
                            vista.mostrarMensaje("Has elegido CANCELAR!");

                        }
                    }


                } else {
                    vista.mostrarMensaje("No hay pedidos seleccionados!");

                }
            }
        });


    }


}
