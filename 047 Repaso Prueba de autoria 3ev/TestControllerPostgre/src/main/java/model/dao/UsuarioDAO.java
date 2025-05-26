package model.dao;

import model.entities.Direccion;
import model.entities.Usuario;
import model.factory.DatabaseFactory;
import model.motorsql.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import services.util.PasswordUtil;
import services.util.PasswordUtil;


public class UsuarioDAO implements DAO<Usuario, Integer> {

    private MotorSQL motorSql;

    public UsuarioDAO(String db) {
        motorSql = DatabaseFactory.getDatabase(db);
    }

    // REGISTRO de usuario (alias de add)
    @Override
    public int add(Usuario usuario) {
        return register(usuario);
    }

    // Metodo real de registro
    public int register(Usuario usuario) {
        int filasModificadas = 0;

        String sql = "INSERT INTO USUARIO (correo, contrasena, nombre, apellido, telefono, id_rol, fecha_nacimiento) VALUES (" +
                "'" + usuario.getCorreo() + "', " +
                "'" + usuario.getContrasena() + "', " +
                "'" + usuario.getNombre() + "', " +
                "'" + usuario.getApellido() + "', " +
                "'" + usuario.getTelefono() + "', " +
                usuario.getIdRol() + ", " +
                "'" + usuario.getFechaNacimiento() + "'" +
                ")";

        try {
            motorSql.connect();
            filasModificadas = motorSql.execute(sql);
        } catch (Exception e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return filasModificadas;
    }

    // LOGIN de usuario
    public Usuario login(String correo, String contrasena) {
        Usuario usuario = null;

        String sql = "SELECT * FROM USUARIO WHERE correo = '" + correo + "'";

        try {
            motorSql.connect();
            ResultSet rs = motorSql.executeQuery(sql);

            if (rs.next()) {
                String hashedPassword = rs.getString("contrasena");

                // ✅ Usar la variable correcta
                if (PasswordUtil.checkPassword(contrasena, hashedPassword)) {
                    usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("id_usuario"));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setApellido(rs.getString("apellido"));
                    usuario.setTelefono(rs.getString("telefono"));
                    usuario.setIdRol(rs.getInt("id_rol"));
                    usuario.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                    usuario.setPuntos(rs.getInt("puntos"));
                    usuario.setContrasena(hashedPassword); // opcional
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en login: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return usuario;
    }

    public boolean cambiarPasswordSeguro(int idUsuario, String oldPassword, String newPassword) {
        boolean actualizado = false;

        try {
            motorSql.connect();

            // 1. Obtener hash actual desde la base de datos
            String sqlSelect = "SELECT contrasena FROM USUARIO WHERE id_usuario = " + idUsuario;
            ResultSet rs = motorSql.executeQuery(sqlSelect);

            if (rs.next()) {
                String hashActual = rs.getString("contrasena");

                // 2. Validar contraseña actual (BCrypt compara internamente con salt)
                if (PasswordUtil.checkPassword(oldPassword, hashActual)) {
                    // 3. Generar nuevo hash con salt aleatorio
                    String nuevoHash = PasswordUtil.hashPassword(newPassword);

                    // 4. Actualizar contraseña
                    String sqlUpdate = String.format(
                            "UPDATE USUARIO SET contrasena = '%s' WHERE id_usuario = %d",
                            nuevoHash, idUsuario
                    );

                    actualizado = motorSql.execute(sqlUpdate) > 0;
                    System.out.println("✅ Contraseña actualizada correctamente");
                } else {
                    System.out.println("❌ Contraseña actual incorrecta.");
                }
            } else {
                System.out.println("❌ Usuario no encontrado con ID: " + idUsuario);
            }

        } catch (Exception e) {
            System.err.println("❌ Error al cambiar contraseña: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return actualizado;
    }


    // MANEJO DE DIRECCIONES

    public ArrayList<Direccion> findDireccionesByUsuario(int idUsuario) {
        ArrayList<Direccion> lista = new ArrayList<>();
        String sql = "SELECT D.id_direccion, D.direccion, D.codigo_postal, D.provincia, D.region " +
                "FROM DIRECCION D " +
                "JOIN USUARIO_DIRECCION UD ON D.id_direccion = UD.id_direccion " +
                "WHERE UD.id_usuario = " + idUsuario;

        try {
            motorSql.connect();
            ResultSet rs = motorSql.executeQuery(sql);
            while (rs.next()) {
                Direccion d = new Direccion();
                d.setIdDireccion(rs.getInt("id_direccion"));
                d.setDireccion(rs.getString("direccion"));
                d.setCodigoPostal(rs.getString("codigo_postal"));
                d.setProvincia(rs.getString("provincia"));
                d.setRegion(rs.getString("region"));
                lista.add(d);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener direcciones: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }
        return lista;
    }

    public boolean addDireccion(int idUsuario, String direccion, String codigoPostal, String provincia, String region) {
        boolean resultado = false;

        try {
            motorSql.connect();

            // ✅ Insertar solo en DIRECCION sin id_usuario
            String insertDireccion = String.format(
                    "INSERT INTO DIRECCION (direccion, codigo_postal, provincia, region) " +
                            "VALUES ('%s', '%s', '%s', '%s') RETURNING id_direccion",
                    direccion, codigoPostal, provincia, region
            );

            ResultSet rs = motorSql.executeQuery(insertDireccion);
            if (rs.next()) {
                int idDireccion = rs.getInt("id_direccion");

                // ✅ Insertar relación en tabla intermedia
                String insertRelacion = String.format(
                        "INSERT INTO USUARIO_DIRECCION (id_usuario, id_direccion) VALUES (%d, %d)",
                        idUsuario, idDireccion
                );

                int filas = motorSql.execute(insertRelacion);
                resultado = filas > 0;
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al añadir dirección: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return resultado;
    }

    public boolean deleteDireccion(int idUsuario, int idDireccion) {
        boolean resultado = false;

        try {
            motorSql.connect();

            String deleteRelacion = "DELETE FROM USUARIO_DIRECCION WHERE id_usuario = " + idUsuario + " AND id_direccion = " + idDireccion;
            motorSql.execute(deleteRelacion);

            String deleteDireccion = "DELETE FROM DIRECCION WHERE id_direccion = " + idDireccion;
            motorSql.execute(deleteDireccion);

            resultado = true;
        } finally {
            motorSql.disconnect();
        }

        return resultado;
    }

    public boolean updateDireccion(int idDireccion, String direccion, String codigoPostal, String provincia, String region) {
        boolean exito = false;

        String sql = String.format(
                "UPDATE DIRECCION SET direccion = '%s', codigo_postal = '%s', provincia = '%s', region = '%s' " +
                        "WHERE id_direccion = %d",
                direccion, codigoPostal, provincia, region, idDireccion
        );

        try {
            motorSql.connect();
            exito = motorSql.execute(sql) > 0;
        } catch (Exception e) {
            System.out.println("❌ Error al actualizar dirección: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return exito;
    }


    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM USUARIO WHERE id_usuario = " + id;
        int resp = 0;

        try {
            motorSql.connect();
            resp = motorSql.execute(sql);
        } catch (Exception e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return resp;
    }

    @Override
    public int update(Usuario usuario) {
        int resp = 0;

        String sql = "UPDATE USUARIO SET " +
                "correo = '" + usuario.getCorreo() + "', " +
                "contrasena = '" + usuario.getContrasena() + "', " +
                "nombre = '" + usuario.getNombre() + "', " +
                "apellido = '" + usuario.getApellido() + "', " +
                "telefono = '" + usuario.getTelefono() + "', " +
                "id_rol = " + usuario.getIdRol() + ", " +
                "fecha_nacimiento = '" + usuario.getFechaNacimiento() + "' " +
                "WHERE id_usuario = " + usuario.getIdUsuario();

        try {
            motorSql.connect();
            resp = motorSql.execute(sql);
        } catch (Exception e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return resp;
    }

    @Override
    public ArrayList<Usuario> findAll(Usuario filtro) {
        ArrayList<Usuario> lista = new ArrayList<>();
        String sql = "select * from usuario;";
        ResultSet rs = null;

        try {
            motorSql.connect();
            rs = motorSql.executeQuery(sql);

            if (rs == null) {
                System.out.println("Error: ResultSet nulo. Posible fallo de conexión o consulta.");
                return lista; // Devuelve lista vacía en lugar de explotar
            }

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setIdRol(rs.getInt("id_rol"));
                usuario.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                lista.add(usuario);
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar usuarios: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return lista;
    }

    public Usuario findById(int idUsuario) {
        Usuario usuario = null;

        String sql = "SELECT * FROM USUARIO WHERE id_usuario = " + idUsuario;

        try {
            motorSql.connect();
            ResultSet rs = motorSql.executeQuery(sql);

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setIdRol(rs.getInt("id_rol"));
                usuario.setFechaNacimiento(rs.getString("fecha_nacimiento"));
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al buscar usuario por ID: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return usuario;
    }

    public boolean modificarPuntos(int idUsuario, int puntos, boolean sumar) {
        boolean exito = false;

        String operacion = sumar ? "+" : "-";
        String sql = "UPDATE USUARIO SET puntos = GREATEST(0, puntos " + operacion + " " + puntos + ") WHERE id_usuario = " + idUsuario;

        try {
            motorSql.connect();
            exito = motorSql.execute(sql) > 0;
        } catch (Exception e) {
            System.err.println("❌ Error al modificar puntos: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return exito;
    }

    public int getPuntos(int idUsuario) {
        int puntos = -1;
        String sql = "SELECT puntos FROM USUARIO WHERE id_usuario = " + idUsuario;

        try {
            motorSql.connect();
            ResultSet rs = motorSql.executeQuery(sql);
            if (rs.next()) {
                puntos = rs.getInt("puntos");
            }
        } catch (Exception e) {
            System.err.println("❌ Error al obtener puntos: " + e.getMessage());
        } finally {
            motorSql.disconnect();
        }

        return puntos;
    }


}