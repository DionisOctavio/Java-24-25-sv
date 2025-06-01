package services;

import model.dao.ComentarioDAO;
import model.entities.Comentario;
import model.factory.DatabaseFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ComentarioAction implements IAction {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String cadUser = "";
        String action = request.getParameter("ACTION");

        // Por si acaso el parámetro viene mal o es null:
        if (action == null || !action.contains(".")) {
            return "";
        }

        String[] arrayAction = action.split("\\.");

        switch (arrayAction[1].toUpperCase()) {
            case "ADD":
                cadUser = add(request, response);
                break;
        }

        return cadUser;
    }

    public String add(HttpServletRequest request, HttpServletResponse response) {
        try {
            Comentario c = new Comentario(0,
                    request.getParameter("texto"),
                    Integer.parseInt(request.getParameter("id_usuario")),
                    Integer.parseInt(request.getParameter("id_pelicula"))
            );

            ComentarioDAO dao = new ComentarioDAO(DatabaseFactory.POSTGRE);
            return dao.add(c) > 0
                    ? "{\"status\":\"ok\",\"msg\":\"Comentario añadido\"}"
                    : "{\"status\":\"error\",\"msg\":\"No se pudo añadir\"}";
        } catch (Exception e) {
            e.printStackTrace();  // para debugging, ojo quitar en producción
            return "{\"error\":\"Parámetros inválidos o error interno\"}";
        }
    }

}
