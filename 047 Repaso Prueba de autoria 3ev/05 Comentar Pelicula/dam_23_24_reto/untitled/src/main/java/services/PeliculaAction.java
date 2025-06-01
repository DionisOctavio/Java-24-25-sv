package services;

import model.dao.PeliculaDAO;
import model.entities.Pelicula;
import model.factory.DatabaseFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class PeliculaAction implements IAction {

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
        PeliculaDAO peliculaDAO = new PeliculaDAO(DatabaseFactory.POSTGRE);
        ArrayList<Pelicula> peliculas = peliculaDAO.findAll(null);
        return Pelicula.toArrayJSon(peliculas);
    }
}