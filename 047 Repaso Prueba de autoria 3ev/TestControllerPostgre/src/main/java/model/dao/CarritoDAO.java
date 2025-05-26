package model.dao;

import model.entities.CarritoLista;
import model.entities.Direccion;
import model.entities.Usuario;
import model.motorsql.MotorPostgre;
import model.motorsql.MotorSQL;
import services.util.EmailUtil;

import java.sql.*;
import java.util.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CarritoDAO {
    private final MotorSQL motor = new MotorPostgre();

    public void agregarProductoACarrito(int idUsuario, int idProducto, int cantidad) {
        motor.connect();
        try {
            System.out.println("🧪 [DAO] Buscando o creando carrito para usuario: " + idUsuario);
            int idCarrito = obtenerOCrearCarrito(idUsuario);
            System.out.println("🧺 [DAO] ID carrito: " + idCarrito);

            String sqlBuscarProducto = "SELECT cantidad FROM carrito_lista WHERE id_carrito = " + idCarrito + " AND id_producto = " + idProducto;
            ResultSet rsProd = motor.executeQuery(sqlBuscarProducto);

            if (rsProd.next()) {
                int nuevaCantidad = rsProd.getInt("cantidad") + cantidad;
                String sqlUpdate = "UPDATE carrito_lista SET cantidad = " + nuevaCantidad + " WHERE id_carrito = " + idCarrito + " AND id_producto = " + idProducto;
                System.out.println("🔄 [DAO] Actualizando cantidad a: " + nuevaCantidad);
                motor.execute(sqlUpdate);
            } else {
                String sqlInsert = "INSERT INTO carrito_lista (id_carrito, id_producto, cantidad) VALUES (" + idCarrito + ", " + idProducto + ", " + cantidad + ")";
                System.out.println("➕ [DAO] Insertando nuevo producto al carrito: " + sqlInsert);
                motor.execute(sqlInsert);
            }
        } catch (SQLException e) {
            System.err.println("❌ [DAO] Error al agregar producto al carrito:");
            e.printStackTrace();
        } finally {
            motor.disconnect();
        }
    }

    public List<Map<String, Object>> listarTodosCarritos() {
        List<Map<String, Object>> lista = new ArrayList<>();
        String sql = """
        SELECT c.id_carrito, c.fecha_creacion, u.nombre, u.apellido, u.correo
        FROM carrito c
        JOIN usuario u ON c.id_usuario = u.id_usuario
        ORDER BY c.fecha_creacion DESC
    """;
        try {
            motor.connect();
            ResultSet rs = motor.executeQuery(sql);
            while (rs.next()) {
                Map<String, Object> carrito = new HashMap<>();
                carrito.put("idCarrito", rs.getInt("id_carrito"));
                carrito.put("fechaCreacion", rs.getString("fecha_creacion"));
                carrito.put("nombreUsuario", rs.getString("nombre") + " " + rs.getString("apellido"));
                carrito.put("correoUsuario", rs.getString("correo"));
                lista.add(carrito);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            motor.disconnect();
        }
        return lista;
    }

    public List<CarritoLista> obtenerProductosPorCarrito(int idCarrito) {
        List<CarritoLista> lista = new ArrayList<>();
        String sql = """
        SELECT p.id_producto, p.nombre_producto, p.precio_producto, cl.cantidad
        FROM carrito_lista cl
        JOIN producto p ON cl.id_producto = p.id_producto
        WHERE cl.id_carrito = %d
    """.formatted(idCarrito);

        try {
            motor.connect();
            ResultSet rs = motor.executeQuery(sql);
            while (rs.next()) {
                CarritoLista item = new CarritoLista();
                item.setIdProducto(rs.getInt("id_producto"));
                item.setNombreProducto(rs.getString("nombre_producto"));
                item.setPrecioProducto(rs.getBigDecimal("precio_producto"));
                item.setCantidad(rs.getInt("cantidad"));
                lista.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            motor.disconnect();
        }
        return lista;
    }


    private int obtenerOCrearCarrito(int idUsuario) throws SQLException {
        String sqlBuscarCarrito = "SELECT id_carrito FROM carrito WHERE id_usuario = " + idUsuario;
        ResultSet rs = motor.executeQuery(sqlBuscarCarrito);
        if (rs.next()) return rs.getInt("id_carrito");

        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        String sqlCrear = "INSERT INTO carrito (id_usuario, fecha_creacion) VALUES (" + idUsuario + ", '" + fecha + "') RETURNING id_carrito";
        ResultSet rsNuevo = motor.executeQuery(sqlCrear);
        rsNuevo.next();
        return rsNuevo.getInt("id_carrito");
    }

    public List<CarritoLista> obtenerCarrito(int idUsuario) {
        List<CarritoLista> lista = new ArrayList<>();
        motor.connect();

        try {
            String sql = """
            SELECT cl.id_producto, p.nombre_producto, p.imagen_url, p.precio_producto, cl.cantidad
            FROM carrito c
            JOIN carrito_lista cl ON c.id_carrito = cl.id_carrito
            JOIN producto p ON p.id_producto = cl.id_producto
            WHERE c.id_usuario = %d
        """.formatted(idUsuario);

            System.out.println("📦 [CarritoDAO] Ejecutando SQL: " + sql);

            ResultSet rs = motor.executeQuery(sql);
            int contador = 0;
            while (rs.next()) {
                CarritoLista item = new CarritoLista();
                item.setIdProducto(rs.getInt("id_producto"));
                item.setNombreProducto(rs.getString("nombre_producto"));
                item.setImagenUrl(rs.getString("imagen_url"));
                item.setPrecioProducto(rs.getBigDecimal("precio_producto"));
                item.setCantidad(rs.getInt("cantidad"));
                lista.add(item);
                contador++;
            }

            System.out.println("🛒 [CarritoDAO] Total productos en carrito para usuario " + idUsuario + ": " + contador);

        } catch (SQLException e) {
            System.err.println("❌ [CarritoDAO] Error al obtener carrito:");
            e.printStackTrace();
        } finally {
            motor.disconnect();
        }

        return lista;
    }


    public void finalizarCompra(int idUsuario) {
        motor.connect();
        try {
            String sqlCarrito = "SELECT id_carrito FROM carrito WHERE id_usuario = " + idUsuario;
            ResultSet rs = motor.executeQuery(sqlCarrito);
            if (!rs.next()) return;

            int idCarrito = rs.getInt("id_carrito");

            String sqlProd = "SELECT id_producto, cantidad FROM carrito_lista WHERE id_carrito = " + idCarrito;
            ResultSet rsProd = motor.executeQuery(sqlProd);

            List<int[]> productosRaw = new ArrayList<>();
            while (rsProd.next()) {
                productosRaw.add(new int[]{rsProd.getInt("id_producto"), rsProd.getInt("cantidad")});
            }

            if (productosRaw.isEmpty()) return;

            String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            String sqlPedido = "INSERT INTO pedido (id_usuario, fecha_pedido, total) VALUES (" + idUsuario + ", '" + fecha + "', 0) RETURNING id_pedido";
            ResultSet rsPedido = motor.executeQuery(sqlPedido);
            rsPedido.next();
            int idPedido = rsPedido.getInt("id_pedido");

            BigDecimal total = BigDecimal.ZERO;
            List<CarritoLista> productos = new ArrayList<>();

            for (int[] prod : productosRaw) {
                int idProd = prod[0];
                int cantidad = prod[1];
                String sqlPrecio = "SELECT nombre_producto, precio_producto FROM producto WHERE id_producto = " + idProd;
                ResultSet rsPrecio = motor.executeQuery(sqlPrecio);

                if (rsPrecio.next()) {
                    BigDecimal precio = rsPrecio.getBigDecimal("precio_producto");
                    String nombre = rsPrecio.getString("nombre_producto");
                    total = total.add(precio.multiply(BigDecimal.valueOf(cantidad)));

                    CarritoLista item = new CarritoLista();
                    item.setIdProducto(idProd);
                    item.setNombreProducto(nombre);
                    item.setCantidad(cantidad);
                    item.setPrecioProducto(precio);
                    productos.add(item);
                }

                String sqlInsert = "INSERT INTO pedido_producto (id_pedido, id_producto, cantidad) VALUES (" + idPedido + ", " + idProd + ", " + cantidad + ")";
                motor.execute(sqlInsert);
            }

            String sqlTotal = "UPDATE pedido SET total = " + total + " WHERE id_pedido = " + idPedido;
            motor.execute(sqlTotal);

            // Obtener correo y nombre
            String sqlUsuario = "SELECT correo, nombre FROM usuario WHERE id_usuario = " + idUsuario;
            ResultSet rsUsuario = motor.executeQuery(sqlUsuario);
            String correo = "";
            String nombre = "";
            if (rsUsuario.next()) {
                correo = rsUsuario.getString("correo");
                nombre = rsUsuario.getString("nombre");
            }

            // Obtener dirección (una cualquiera asociada al usuario)
            String direccion = "Dirección no disponible";
            String sqlDir = """
            SELECT d.direccion, d.codigo_postal, d.provincia 
            FROM direccion d
            JOIN usuario_direccion ud ON ud.id_direccion = d.id_direccion
            WHERE ud.id_usuario = %d
            LIMIT 1
        """.formatted(idUsuario);
            ResultSet rsDir = motor.executeQuery(sqlDir);
            if (rsDir.next()) {
                direccion = "%s, %s (%s)".formatted(
                        rsDir.getString("direccion"),
                        rsDir.getString("codigo_postal"),
                        rsDir.getString("provincia")
                );
            }

            // Enviar correo personalizado
            try {
                EmailUtil.enviarCorreoConfirmacionPedidoCompleto(correo, nombre, direccion, productos, total, idPedido);
                System.out.println("📧 Correo enviado correctamente al usuario.");
            } catch (Exception e) {
                System.err.println("⚠️ Error al enviar correo de confirmación:");
                e.printStackTrace();
            }

            // Limpiar carrito
            motor.execute("DELETE FROM carrito_lista WHERE id_carrito = " + idCarrito);
            motor.execute("DELETE FROM carrito WHERE id_carrito = " + idCarrito);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            motor.disconnect();
        }
    }





    public void eliminarProductoDeCarrito(int idUsuario, int idProducto) {
        motor.connect();
        try {
            String sqlCarrito = "SELECT id_carrito FROM carrito WHERE id_usuario = " + idUsuario;
            ResultSet rs = motor.executeQuery(sqlCarrito);
            if (!rs.next()) return;

            int idCarrito = rs.getInt("id_carrito");
            String sqlDelete = "DELETE FROM carrito_lista WHERE id_carrito = " + idCarrito + " AND id_producto = " + idProducto;
            motor.execute(sqlDelete);
            System.out.println("🗑️ [DAO] Producto eliminado del carrito: " + sqlDelete);
        } catch (SQLException e) {
            System.err.println("❌ [DAO] Error al eliminar producto del carrito:");
            e.printStackTrace();
        } finally {
            motor.disconnect();
        }
    }

    public void actualizarCantidad(int idUsuario, int idProducto, int cantidad) {
        motor.connect();
        try {
            String sqlCarrito = "SELECT id_carrito FROM carrito WHERE id_usuario = " + idUsuario;
            ResultSet rs = motor.executeQuery(sqlCarrito);
            if (!rs.next()) return;

            int idCarrito = rs.getInt("id_carrito");
            String sqlUpdate = "UPDATE carrito_lista SET cantidad = " + cantidad +
                    " WHERE id_carrito = " + idCarrito + " AND id_producto = " + idProducto;

            System.out.println("✏️ [DAO] Actualizando cantidad: " + sqlUpdate);
            motor.execute(sqlUpdate);

        } catch (SQLException e) {
            System.err.println("❌ [DAO] Error al actualizar cantidad:");
            e.printStackTrace();
        } finally {
            motor.disconnect();
        }
    }


}
