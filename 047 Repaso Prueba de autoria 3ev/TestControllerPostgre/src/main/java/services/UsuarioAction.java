package services;

import model.dao.UsuarioDAO;
import model.entities.Direccion;
import model.entities.Usuario;
import model.factory.DatabaseFactory;
import services.util.EmailUtil;
import services.util.PasswordUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class UsuarioAction implements IAction {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("ACTION");

        if (action == null || action.isEmpty()) {
            return "{\"error\": \"Parámetro ACTION no proporcionado\"}";
        }

        String[] arrayAction = action.split("\\.");

        if (arrayAction.length < 2) {
            return "{\"error\": \"Acción incompleta\"}";
        }

        switch (arrayAction[1]) {
            case "LOGIN":
                return login(request);
            case "REGISTER":
                return register(request);
            case "DELETE":
                return deleteUsuario(request);
            case "UPDATE":
                return updateUsuario(request);
            case "CHANGE_PASSWORD":
                return cambiarContrasena(request);
            case "FIND_ALL":
                return findAll();
            case "FIND_BY_ID":
                return findById(request);
            case "FIND_DIRECCIONES":
                return findDireccionesByUsuario(request);
            case "ADD_DIRECCION":
                return addDireccion(request);
            case "DELETE_DIRECCION":
                return deleteDireccion(request);
            case "UPDATE_DIRECCION":
                return updateDireccion(request);
            case "PUNTOS":
                if (arrayAction.length < 3) {
                    return "{\"error\": \"Acción de puntos no especificada\"}";
                }

                switch (arrayAction[2]) {
                    case "ADD_POINT":
                        return addPuntos(request);
                    case "REMOVE_POINT":
                        return removePuntos(request);
                    case "GET_BY_ID":
                        return getPuntos(request);
                    default:
                        return "{\"error\": \"Acción de puntos no válida\"}";
                }

            default:
                return "{\"error\": \"Acción no válida\"}";
        }
    }


    private String login(HttpServletRequest request) {
        String correo = request.getParameter("EMAIL");
        String passwordPlano = request.getParameter("PASSWORD");

        UsuarioDAO usuarioDAO = new UsuarioDAO(DatabaseFactory.POSTGRE);
        Usuario usuario = usuarioDAO.login(correo, passwordPlano);

        if (usuario != null) {
            return Usuario.fromObjectToJSON(usuario);
        } else {
            return "{\"error\": \"Correo o contraseña incorrectos\"}";
        }
    }

    private String register(HttpServletRequest request) {
        Usuario usuario = new Usuario();
        usuario.setCorreo(request.getParameter("EMAIL"));

        String passwordPlano = request.getParameter("PASSWORD");
        usuario.setContrasena(PasswordUtil.hashPassword(passwordPlano));

        usuario.setNombre(request.getParameter("NOMBRE"));
        usuario.setApellido(request.getParameter("APELLIDO"));
        usuario.setTelefono(request.getParameter("TELEFONO"));
        usuario.setFechaNacimiento(request.getParameter("FECHA"));
        usuario.setIdRol(Integer.parseInt(request.getParameter("ID_ROL")));

        UsuarioDAO usuarioDAO = new UsuarioDAO(DatabaseFactory.POSTGRE);
        int resultado = usuarioDAO.register(usuario);

        if (resultado > 0) {
            try {
                // ✉️ Enviar correo de bienvenida
                EmailUtil.enviarCorreoConfirmacionRegistro(usuario.getCorreo());

            } catch (Exception e) {
                System.err.println("⚠️ No se pudo enviar el correo de bienvenida: " + e.getMessage());
            }

            return "{\"message\": \"Usuario registrado con éxito\"}";
        } else {
            return "{\"error\": \"No se pudo registrar el usuario. Quizá el correo ya está en uso\"}";
        }
    }

    private String cambiarContrasena(HttpServletRequest request) {
        try {
            int idUsuario = Integer.parseInt(request.getParameter("ID_USUARIO"));
            String actual = request.getParameter("OLD_PASSWORD");
            String nueva = request.getParameter("NEW_PASSWORD");

            UsuarioDAO dao = new UsuarioDAO(DatabaseFactory.POSTGRE);
            boolean exito = dao.cambiarPasswordSeguro(idUsuario, actual, nueva);

            return exito
                    ? "{\"success\": true}"
                    : "{\"error\": \"Contraseña incorrecta o no se pudo actualizar\"}";
        } catch (Exception e) {
            return "{\"error\": \"Error interno: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }




    private String findAll() {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO(DatabaseFactory.POSTGRE);
            ArrayList<Usuario> usuarios = usuarioDAO.findAll(null);
            return Usuario.fromArrayListToJson(usuarios);
        } catch (Exception e) {
            return "{\"error\": \"Error interno: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }

    private String findById(HttpServletRequest request) {
        try {
            String idStr = request.getParameter("ID_USUARIO");
            System.out.println("📦 ID_USUARIO recibido: " + idStr);  // DEBUG

            if (idStr == null || idStr.isEmpty()) {
                return "{\"error\": \"ID_USUARIO es obligatorio\"}";
            }

            int idUsuario = Integer.parseInt(idStr);
            UsuarioDAO usuarioDAO = new UsuarioDAO(DatabaseFactory.POSTGRE);
            Usuario usuario = usuarioDAO.findById(idUsuario);

            if (usuario == null) {
                return "{\"error\": \"Usuario no encontrado\"}";
            }

            return Usuario.fromObjectToJSON(usuario);
        } catch (Exception e) {
            e.printStackTrace(); // más detalle
            return "{\"error\": \"Error interno: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }



    // MANEJO DE DIRECCIONES

    private String findDireccionesByUsuario(HttpServletRequest request) {
        String idUsuarioStr = request.getParameter("ID_USUARIO");
        if (idUsuarioStr == null) {
            return "{\"error\": \"Parámetro ID_USUARIO obligatorio\"}";
        }

        try {
            int idUsuario = Integer.parseInt(idUsuarioStr);
            UsuarioDAO dao = new UsuarioDAO(DatabaseFactory.POSTGRE);
            ArrayList<Direccion> direcciones = dao.findDireccionesByUsuario(idUsuario);
            return Direccion.fromArrayListToJson(direcciones);
        } catch (Exception e) {
            return "{\"error\": \"Error interno: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }

    private String addDireccion(HttpServletRequest request) {
        try {
            int idUsuario = Integer.parseInt(request.getParameter("ID_USUARIO"));
            String direccion = request.getParameter("DIRECCION");
            String codigoPostal = request.getParameter("CODIGO_POSTAL");
            String provincia = request.getParameter("PROVINCIA");
            String region = request.getParameter("REGION");

            if (direccion == null || codigoPostal == null || provincia == null || region == null) {
                return "{\"error\": \"Faltan campos obligatorios\"}";
            }

            UsuarioDAO dao = new UsuarioDAO(DatabaseFactory.POSTGRE);
            boolean exito = dao.addDireccion(idUsuario, direccion, codigoPostal, provincia, region);
            return exito ? "{\"success\": true}" : "{\"error\": \"No se pudo insertar la dirección\"}";
        } catch (Exception e) {
            return "{\"error\": \"Error interno: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }

    private String deleteDireccion(HttpServletRequest request) {
        try {
            int idUsuario = Integer.parseInt(request.getParameter("ID_USUARIO"));
            int idDireccion = Integer.parseInt(request.getParameter("ID_DIRECCION"));

            UsuarioDAO dao = new UsuarioDAO(DatabaseFactory.POSTGRE);
            boolean exito = dao.deleteDireccion(idUsuario, idDireccion);
            return exito ? "{\"success\": true}" : "{\"error\": \"No se pudo eliminar la dirección\"}";
        } catch (Exception e) {
            return "{\"error\": \"Error interno: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }

    private String updateDireccion(HttpServletRequest request) {
        try {
            int idDireccion = Integer.parseInt(request.getParameter("ID_DIRECCION"));
            String direccion = request.getParameter("DIRECCION");
            String codigoPostal = request.getParameter("CODIGO_POSTAL");
            String provincia = request.getParameter("PROVINCIA");
            String region = request.getParameter("REGION");

            if (direccion == null || codigoPostal == null || provincia == null || region == null) {
                return "{\"error\": \"Faltan campos obligatorios\"}";
            }

            UsuarioDAO dao = new UsuarioDAO(DatabaseFactory.POSTGRE);
            boolean exito = dao.updateDireccion(idDireccion, direccion, codigoPostal, provincia, region);
            return exito ? "{\"success\": true}" : "{\"error\": \"No se pudo actualizar la dirección\"}";
        } catch (Exception e) {
            return "{\"error\": \"Error interno: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }


    // MANJO DE PNTOS

    private String addPuntos(HttpServletRequest request) {
        try {
            int idUsuario = Integer.parseInt(request.getParameter("ID_USUARIO"));
            int puntos = Integer.parseInt(request.getParameter("PUNTOS"));

            UsuarioDAO dao = new UsuarioDAO(DatabaseFactory.POSTGRE);
            boolean exito = dao.modificarPuntos(idUsuario, puntos, true);
            return exito ? "{\"success\": true}" : "{\"error\": \"No se pudieron añadir puntos\"}";
        } catch (Exception e) {
            return "{\"error\": \"Error interno: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }

    private String removePuntos(HttpServletRequest request) {
        try {
            int idUsuario = Integer.parseInt(request.getParameter("ID_USUARIO"));
            int puntos = Integer.parseInt(request.getParameter("PUNTOS"));

            UsuarioDAO dao = new UsuarioDAO(DatabaseFactory.POSTGRE);
            boolean exito = dao.modificarPuntos(idUsuario, puntos, false);
            return exito ? "{\"success\": true}" : "{\"error\": \"No se pudieron restar puntos\"}";
        } catch (Exception e) {
            return "{\"error\": \"Error interno: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }

    private String getPuntos(HttpServletRequest request) {
        try {
            int idUsuario = Integer.parseInt(request.getParameter("ID_USUARIO"));

            UsuarioDAO dao = new UsuarioDAO(DatabaseFactory.POSTGRE);
            int puntos = dao.getPuntos(idUsuario);
            return "{\"puntos\": " + puntos + "}";
        } catch (Exception e) {
            return "{\"error\": \"Error interno: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }

    private String deleteUsuario(HttpServletRequest request) {
        try {
            int idUsuario = Integer.parseInt(request.getParameter("ID_USUARIO"));
            UsuarioDAO dao = new UsuarioDAO(DatabaseFactory.POSTGRE);
            int filas = dao.delete(idUsuario);
            return filas > 0 ? "{\"success\": true}" : "{\"error\": \"No se pudo eliminar el usuario\"}";
        } catch (Exception e) {
            return "{\"error\": \"Error interno: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }

    private String updateUsuario(HttpServletRequest request) {
        try {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(Integer.parseInt(request.getParameter("ID_USUARIO")));
            usuario.setCorreo(request.getParameter("EMAIL"));
            usuario.setNombre(request.getParameter("NOMBRE"));
            usuario.setApellido(request.getParameter("APELLIDO"));
            usuario.setTelefono(request.getParameter("TELEFONO"));
            usuario.setFechaNacimiento(request.getParameter("FECHA"));
            usuario.setIdRol(Integer.parseInt(request.getParameter("ID_ROL")));

            // Puedes mantener la contraseña previa si no se actualiza
            UsuarioDAO dao = new UsuarioDAO(DatabaseFactory.POSTGRE);
            Usuario actual = dao.findById(usuario.getIdUsuario());
            usuario.setContrasena(actual.getContrasena());

            int actualizado = dao.update(usuario);
            return actualizado > 0 ? "{\"success\": true}" : "{\"error\": \"No se pudo actualizar el usuario\"}";
        } catch (Exception e) {
            return "{\"error\": \"Error interno: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }


}

