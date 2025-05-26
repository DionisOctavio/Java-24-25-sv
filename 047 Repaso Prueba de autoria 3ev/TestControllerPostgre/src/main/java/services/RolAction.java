package services;

import model.dao.RolDAO;
import model.entities.Rol;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class RolAction implements IAction {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("ACTION");
        if (action == null || action.isEmpty()) return "{\"error\": \"Acción no proporcionada\"}";

        String[] arrayAction = action.split("\\.");

        if (arrayAction.length < 2) return "{\"error\": \"Acción incompleta\"}";

        RolDAO dao = new RolDAO();

        switch (arrayAction[1]) {
            case "FIND_ALL":
                return Rol.fromListToJson(dao.findAll());

            case "ADD":
                String nuevoRol = request.getParameter("NOMBRE_ROL");
                if (nuevoRol == null || nuevoRol.length() < 3) {
                    return "{\"error\": \"Nombre de rol inválido\"}";
                }
                return dao.insert(nuevoRol) ? "{\"success\": true}" : "{\"error\": \"No se pudo añadir el rol\"}";

            case "UPDATE":
                int idUpdate = Integer.parseInt(request.getParameter("ID_ROL"));
                String nombreUpdate = request.getParameter("NOMBRE_ROL");
                return dao.update(idUpdate, nombreUpdate) ? "{\"success\": true}" : "{\"error\": \"No se pudo actualizar\"}";

            case "DELETE":
                int idDelete = Integer.parseInt(request.getParameter("ID_ROL"));
                return dao.delete(idDelete) ? "{\"success\": true}" : "{\"error\": \"No se pudo eliminar el rol\"}";

            default:
                return "{\"error\": \"Acción de rol no válida\"}";
        }
    }
}
