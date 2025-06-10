package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OpcionesDAO {
    //metodo de consulta en la base de datos las opciones del modelo
    public static ArrayList<String> opcionesModelo() throws SQLException {
        ArrayList<String> listaModelo = new ArrayList<>();
        //creamos una conexion
        Connection conex = Conexion.getConexion();
        PreparedStatement pt = conex.prepareStatement("select * from opcionesModelo");
        ResultSet rs = pt.executeQuery();
        //añadimos los modelos a un ArrayList
        while (rs.next()) {
            listaModelo.add(rs.getString(1));
        }
        return listaModelo;

    }

    //metodo de consulta en la base de datos las opciones del motor
    public static ArrayList<String> opcionesMotor() throws SQLException {
        ArrayList<String> listaMotor = new ArrayList<>();
        //creamos una conexion
        Connection conex = Conexion.getConexion();
        PreparedStatement pt = conex.prepareStatement("select * from opcionesMotor");
        ResultSet rs = pt.executeQuery();
        //añadimos los motores a un ArrayList
        while (rs.next()) {
            listaMotor.add(rs.getString(1));
        }
        return listaMotor;

    }

    //metodo de consulta en la base de datos las opciones del color
    public static ArrayList<String> opcionesColor() throws SQLException {
        ArrayList<String> listaColor = new ArrayList<>();
        //creamos una conexion
        Connection conex = Conexion.getConexion();
        PreparedStatement pt = conex.prepareStatement("select * from opcionesColor");
        ResultSet rs = pt.executeQuery();
        //añadimos los colores a un ArrayList
        while (rs.next()) {
            listaColor.add(rs.getString(1));
        }
        return listaColor;

    }

    //metodo de consulta en la base de datos las opciones de ruedas
    public static ArrayList<Integer> opcionesRuedas() throws SQLException {
        ArrayList<Integer> listaRudeas = new ArrayList<>();
        //creamos una conexion
        Connection conex = Conexion.getConexion();
        //añadimos las rudeas a un ArrayList
        PreparedStatement pt = conex.prepareStatement("select * from opcionesRuedas");
        ResultSet rs = pt.executeQuery();
        while (rs.next()) {
            listaRudeas.add(rs.getInt(1));
        }
        return listaRudeas;

    }

    //metodo de consulta en la base de datos las opciones del piloto automatico
    public static ArrayList<Boolean> opcionesPilotoAutomatico() throws SQLException {
        ArrayList<Boolean> listaPilotoAutomatico = new ArrayList<>();
        //creamos una conexion
        Connection conex = Conexion.getConexion();
        PreparedStatement pt = conex.prepareStatement("select * from opcionesPilotoAutomatico");
        ResultSet rs = pt.executeQuery();
        //añadimos las opciones de piloto automatico a un ArrayList

        while (rs.next()) {
            boolean pilotoAuto = false;
            if (rs.getByte(1) == 1) {
                pilotoAuto = true;
            }
            listaPilotoAutomatico.add(pilotoAuto);
        }
        return listaPilotoAutomatico;

    }

}
