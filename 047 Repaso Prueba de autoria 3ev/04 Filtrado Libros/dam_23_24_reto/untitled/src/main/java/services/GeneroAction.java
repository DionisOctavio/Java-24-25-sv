package services;

import model.dao.GeneroDAO;
import model.dao.LibroDAO;
import model.entities.Genero;
import model.entities.Libro;
import model.factory.DatabaseFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class GeneroAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String cadDestino = "";
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "FIND_ALL":
                cadDestino = findAll(request, response);
                break;
        }
        return cadDestino;
    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) {
        GeneroDAO generoDAO = new GeneroDAO(DatabaseFactory.POSTGRE);
        ArrayList<Genero> generos = generoDAO.findAll(null);
        return Genero.toArrayJSon(generos);
    }

}
