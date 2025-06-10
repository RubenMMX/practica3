package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PedidosDAO {

    //metodo que inserta pedido en la base de datos
    public static int insertarpedido(Pedidos p) throws SQLException {
        Connection conex = Conexion.getConexion();

        int result;
        String modelo = p.getModelo();
        String motor = p.getMotor();
        String color = p.getColor();
        int ruedas = p.getRuedas();
        byte pilotoAuto = p.getPilotoAutomatico();
        PreparedStatement pt = conex.prepareStatement("INSERT INTO pedidos VALUES(default,?,?,?,?,?)");
        pt.setString(1, modelo);
        pt.setString(2, motor);
        pt.setString(3, color);
        pt.setInt(4, ruedas);
        pt.setByte(5, pilotoAuto);
        result = pt.executeUpdate();
        pt.close();
        return result;

    }

    //metodo que recoge en un arraylist los datos de la tabla pedidos
    public static ArrayList<Pedidos> getPedidos() throws SQLException {
        Connection conex = Conexion.getConexion();
        PreparedStatement pt = conex.prepareStatement("SELECT * FROM pedidos");
        ResultSet rs = pt.executeQuery();

        ArrayList<Pedidos> listaPedidos = new ArrayList<>();
        while (rs.next()) {
            Pedidos p = new Pedidos(
                    rs.getInt("id"),
                    rs.getString("modelo"),
                    rs.getString("motor"),
                    rs.getString("color"),
                    rs.getInt("ruedas"),
                    rs.getByte("pilotoAutomatico")
            );
            listaPedidos.add(p);
        }
        rs.close();
        pt.close();
        return listaPedidos;
    }

    //metodo que borra los pedidos de la base de datos
    public static int borraPedido(Pedidos p) throws SQLException {
        int respuesta;
        Connection conex = Conexion.getConexion();
        PreparedStatement pt = conex.prepareStatement("DELETE FROM pedidos where id = ?");
        pt.setInt(1, p.getId());
        respuesta = pt.executeUpdate();
        pt.close();
        return respuesta;
    }


}
