package services;

import model.dao.UsuarioDAO;
import model.entities.Usuario;
import model.factory.DatabaseFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String cadDestino = "";
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "LOGIN":
                cadDestino = login(request, response);
                break;
        }
        return cadDestino;
    }

    private String login(HttpServletRequest request, HttpServletResponse response) {
        String usuario = request.getParameter("USUARIO");
        String contrasenia = request.getParameter("CONTRASENIA");
        UsuarioDAO usuarioDAO = new UsuarioDAO(DatabaseFactory.POSTGRE);
        Usuario usuarios = usuarioDAO.login(usuario, contrasenia);
        return Usuario.fromObjectToJSON(usuarios) ;
    }

}
