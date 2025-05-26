package services;

import model.dao.ValoracionDAO;
import model.entities.Valoracion;
import model.factory.DatabaseFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValoracionAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("ACTION").split("\\.")[1];
        String resultado;

        switch (action) {
            case "ADD":
                resultado = add(request);
                break;
            case "UPDATE":
                resultado = update(request);
                break;
            case "DELETE":
                resultado = delete(request);
                break;
            case "FIND_BY_USUARIO_PRODUCTO":
                resultado = findValoracionByUsuarioAndProducto(request);
                break;
            case "FIND_MEDIA_BY_PRODUCTO":
                resultado = findMediaByProducto(request);
                break;
            default:
                resultado = "{\"error\": \"Acción no válida para VALORACION\"}";
        }

        return resultado;
    }

    private String add(HttpServletRequest request) {
        ValoracionDAO dao = new ValoracionDAO(DatabaseFactory.POSTGRE);

        int idUsu = Integer.parseInt(request.getParameter("ID_USUARIO"));
        int idProd = Integer.parseInt(request.getParameter("ID_PRODUCTO"));
        int puntuacion = Integer.parseInt(request.getParameter("PUNTUACION"));
        String comentario = request.getParameter("COMENTARIO");

        Valoracion v = new Valoracion(0, idUsu, idProd, puntuacion, comentario);
        int filas = dao.add(v);

        if (filas == -1) {
            return "{\"error\": \"No se pudo insertar valoración. Verifica que el usuario y producto existan y que no haya duplicados.\"}";
        }

        return "{\"filas_afectadas\": " + filas + "}";
    }


    private String update(HttpServletRequest request) {
        ValoracionDAO dao = new ValoracionDAO(DatabaseFactory.POSTGRE);

        int idUsu = Integer.parseInt(request.getParameter("ID_USUARIO"));
        int idProd = Integer.parseInt(request.getParameter("ID_PRODUCTO"));
        int puntuacion = Integer.parseInt(request.getParameter("PUNTUACION"));
        String comentario = request.getParameter("COMENTARIO");

        Valoracion v = new Valoracion(0, idUsu, idProd, puntuacion, comentario);
        int filas = dao.update(v);

        return "{\"filas_afectadas\": " + filas + "}";
    }

    private String delete(HttpServletRequest request) {
        ValoracionDAO dao = new ValoracionDAO(DatabaseFactory.POSTGRE);

        int idUsu = Integer.parseInt(request.getParameter("ID_USUARIO"));
        int idProd = Integer.parseInt(request.getParameter("ID_PRODUCTO"));

        int filas = dao.delete(idUsu, idProd);

        return "{\"filas_afectadas\": " + filas + "}";
    }

    private String findValoracionByUsuarioAndProducto(HttpServletRequest request) {
        try {
            int idUsu = Integer.parseInt(request.getParameter("ID_USUARIO"));
            int idProd = Integer.parseInt(request.getParameter("ID_PRODUCTO"));

            ValoracionDAO dao = new ValoracionDAO(DatabaseFactory.POSTGRE);
            Valoracion v = dao.findByUsuarioAndProducto(idUsu, idProd);

            if (v != null) {
                return "{" +
                        "\"id_valoracion\": " + v.getIdValoracion() + "," +
                        "\"id_usuario\": " + v.getIdUsuario() + "," +
                        "\"id_producto\": " + v.getIdProducto() + "," +
                        "\"puntuacion\": " + v.getPuntuacion() + "," +
                        "\"comentario\": \"" + v.getComentario().replace("\"", "\\\"") + "\"" +
                        "}";
            } else {
                return "{}";
            }

        } catch (Exception e) {
            return "{\"error\": \"Error al buscar valoración: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }

    private String findMediaByProducto(HttpServletRequest request) {
        try {
            int idProd = Integer.parseInt(request.getParameter("ID_PRODUCTO"));
            ValoracionDAO dao = new ValoracionDAO(DatabaseFactory.POSTGRE);
            double media = dao.findMediaByProducto(idProd);

            return "{\"media\": " + String.format("%.2f", media) + "}";
        } catch (Exception e) {
            return "{\"error\": \"Error al calcular media: " + e.getMessage().replace("\"", "'") + "\"}";
        }
    }
}
