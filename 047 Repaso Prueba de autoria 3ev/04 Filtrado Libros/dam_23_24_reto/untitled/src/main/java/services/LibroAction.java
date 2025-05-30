package services;

import model.dao.LibroDAO;

import model.entities.Libro;
import model.factory.DatabaseFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class LibroAction implements IAction {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String cadDestino = "";
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "FIND_BY_GENERO":
                cadDestino = findByGenero(request, response);
                break;
            case "FIND_ALL":
                cadDestino = findAll(request, response);
                break;
        }
        return cadDestino;
    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) {
        LibroDAO libroDAO = new LibroDAO(DatabaseFactory.POSTGRE);
        ArrayList<Libro> libros = libroDAO.findAll(null);
        return Libro.toArrayJSon(libros);
    }

    private String findByGenero(HttpServletRequest request, HttpServletResponse response) {
        LibroDAO libroDAO = new LibroDAO(DatabaseFactory.POSTGRE);
        String genero = request.getParameter("GENERO");
        Libro libro = new Libro();
        libro.setNombre(genero);
        ArrayList<Libro> libros = libroDAO.findByGenero(genero);
        return Libro.toArrayJSon(libros);
    }

}
