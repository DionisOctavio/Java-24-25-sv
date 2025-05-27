package services;

import model.dao.UsuarioDAO;
import model.entities.Usuario;
import model.factory.dbFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioAction implements Action {

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


    public String login(HttpServletRequest req) {
        String user = req.getParameter("USER");
        String password = req.getParameter("PASSWORD");
        UsuarioDAO usuarioDAO = new UsuarioDAO(dbFactory.POSTGRE);
        Usuario usuario = usuarioDAO.login(user, password);
        return Usuario.fromObjectToJSON(usuario);
    }

    //http://sdflgkfdgjhd/Controller?ACTION=USUARIO.login&EMAIL=yeray0303@gmail.com&PASSWORD=1234

}
