package model.dao;

import model.entities.CarritoLista;
import model.entities.Pedido;
import model.motorsql.MotorPostgre;
import model.motorsql.MotorSQL;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class PedidoDAO {

    private final MotorSQL motor = new MotorPostgre();

    // Obtener los productos de todos los pedidos de un usuario
    public List<CarritoLista> obtenerPedidosPorUsuario(int idUsuario) {
        List<CarritoLista> lista = new ArrayList<>();

        String sql = """
            SELECT p.id_pedido, pr.id_producto, pr.nombre_producto, pr.precio_producto, pp.cantidad
            FROM pedido p
            JOIN pedido_producto pp ON p.id_pedido = pp.id_pedido
            JOIN producto pr ON pr.id_producto = pp.id_producto
            WHERE p.id_usuario = %d
            ORDER BY p.id_pedido DESC
        """.formatted(idUsuario);


        try {
            motor.connect();
            ResultSet rs = motor.executeQuery(sql);
            while (rs.next()) {
                CarritoLista item = new CarritoLista();
                item.setIdProducto(rs.getInt("id_producto"));
                item.setNombreProducto(rs.getString("nombre_producto"));
                item.setPrecioProducto(rs.getBigDecimal("precio_producto"));
                item.setCantidad(rs.getInt("cantidad"));
                item.setIdPedido(rs.getInt("id_pedido"));
                lista.add(item);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al obtener pedidos por usuario: " + e.getMessage());
        } finally {
            motor.disconnect();
        }

        return lista;
    }

    // Nuevo método para obtener todos los pedidos sin filtro por usuario
    public List<CarritoLista> obtenerTodosPedidos() {
        List<CarritoLista> lista = new ArrayList<>();
        String sql = """
        SELECT p.id_pedido, pr.id_producto, pr.nombre_producto, pr.precio_producto, pp.cantidad
        FROM pedido p
        JOIN pedido_producto pp ON p.id_pedido = pp.id_pedido
        JOIN producto pr ON pr.id_producto = pp.id_producto
        ORDER BY p.id_pedido DESC
    """;

        try {
            motor.connect();
            ResultSet rs = motor.executeQuery(sql);
            while (rs.next()) {
                CarritoLista item = new CarritoLista();
                item.setIdProducto(rs.getInt("id_producto"));
                item.setNombreProducto(rs.getString("nombre_producto"));
                item.setPrecioProducto(rs.getBigDecimal("precio_producto"));
                item.setCantidad(rs.getInt("cantidad"));
                item.setIdPedido(rs.getInt("id_pedido"));
                lista.add(item);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al obtener todos los pedidos: " + e.getMessage());
        } finally {
            motor.disconnect();
        }

        return lista;
    }

    // Nuevo método para obtener resumen sin filtro usuario
    public Map<String, Object> getPedidoInfoExtendidoAdmin(int idPedido) {
        Map<String, Object> datos = null;
        String sql = """
    SELECT p.id_pedido, p.fecha_pedido, p.total,
           u.id_usuario, u.nombre, u.apellido, u.correo, u.telefono,
           SUM(pp.cantidad) AS num_articulos
    FROM pedido p
    JOIN usuario u ON p.id_usuario = u.id_usuario
    JOIN pedido_producto pp ON pp.id_pedido = p.id_pedido
    WHERE p.id_pedido = %d
    GROUP BY p.id_pedido, p.fecha_pedido, p.total,
             u.id_usuario, u.nombre, u.apellido, u.correo, u.telefono
    """.formatted(idPedido);

        try {
            motor.connect();
            ResultSet rs = motor.executeQuery(sql);

            if (rs.next()) {
                datos = new HashMap<>();
                datos.put("idPedido", rs.getInt("id_pedido"));
                datos.put("fechaPedido", rs.getString("fecha_pedido"));
                datos.put("total", rs.getDouble("total"));

                datos.put("idUsuario", rs.getInt("id_usuario"));
                datos.put("nombre", rs.getString("nombre"));
                datos.put("apellido", rs.getString("apellido"));
                datos.put("correo", rs.getString("correo"));
                datos.put("telefono", rs.getString("telefono"));

                datos.put("numArticulos", rs.getInt("num_articulos"));
            }
        } catch (SQLException e) {
            System.err.println("❌ Error en getPedidoInfoExtendidoAdmin: " + e.getMessage());
        } finally {
            motor.disconnect();
        }

        return datos;
    }


    // Obtener la info general de un pedido en formato clave-valor (idPedido, nombre, correo, total...)
    public Map<String, Object> getPedidoInfoExtendido(int idPedido, int idUsuario) {
        Map<String, Object> datos = null;

        String sql = """
        SELECT p.id_pedido, p.fecha_pedido, p.total,
               u.id_usuario, u.nombre, u.apellido, u.correo, u.telefono,
               SUM(pp.cantidad) AS num_articulos
        FROM pedido p
        JOIN usuario u ON p.id_usuario = u.id_usuario
        JOIN pedido_producto pp ON pp.id_pedido = p.id_pedido
        WHERE p.id_pedido = %d AND u.id_usuario = %d
        GROUP BY p.id_pedido, p.fecha_pedido, p.total,
                 u.id_usuario, u.nombre, u.apellido, u.correo, u.telefono
    """.formatted(idPedido, idUsuario);

        try {
            motor.connect();
            ResultSet rs = motor.executeQuery(sql);

            if (rs.next()) {
                datos = new HashMap<>();
                datos.put("idPedido", rs.getInt("id_pedido"));
                datos.put("fechaPedido", rs.getString("fecha_pedido"));
                datos.put("total", rs.getDouble("total"));

                datos.put("nombre", rs.getString("nombre"));
                datos.put("apellido", rs.getString("apellido"));
                datos.put("correo", rs.getString("correo"));
                datos.put("telefono", rs.getString("telefono"));

                datos.put("numArticulos", rs.getInt("num_articulos"));
            }
        } catch (SQLException e) {
            System.err.println("❌ Error en getPedidoInfoExtendido: " + e.getMessage());
        } finally {
            motor.disconnect();
        }

        return datos;
    }



    // Obtener productos específicos de un solo pedido
    public List<CarritoLista> getProductosByPedido(int idPedido) {
        List<CarritoLista> lista = new ArrayList<>();

        String sql = """
            SELECT pp.id_pedido, pr.id_producto, pr.nombre_producto, pr.precio_producto, pp.cantidad
            FROM pedido_producto pp
            JOIN producto pr ON pp.id_producto = pr.id_producto
            WHERE pp.id_pedido = %d
        """.formatted(idPedido);


        try {
            motor.connect();
            ResultSet rs = motor.executeQuery(sql);
            while (rs.next()) {
                CarritoLista item = new CarritoLista();
                item.setIdPedido(rs.getInt("id_pedido"));
                item.setIdProducto(rs.getInt("id_producto"));
                item.setNombreProducto(rs.getString("nombre_producto"));
                item.setPrecioProducto(rs.getBigDecimal("precio_producto"));
                item.setCantidad(rs.getInt("cantidad"));
                lista.add(item);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error en getProductosByPedido: " + e.getMessage());
        } finally {
            motor.disconnect();
        }

        return lista;
    }
}
