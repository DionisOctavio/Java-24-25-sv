package services;

import model.dao.UsuarioDAO;
import model.entities.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import model.factory.dbFactory;

public class UsuarioAction implements Action{


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
            case "LOGIN":
                cadUser = login(request);
                break;
        }

        return cadUser;
    }

    public String login(HttpServletRequest request) {
        String username = request.getParameter("USER");
        String password = request.getParameter("PASSWORD");

        UsuarioDAO usuarioDAO = new UsuarioDAO(dbFactory.POSTGRES);
        Usuario usuario = usuarioDAO.login(username, password);
        return Usuario.fromObjectToJSON(usuario);
    }

}
