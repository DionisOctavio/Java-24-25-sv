package services;

import model.dao.CategoriaDAO;
import model.dao.EquipoDAO;
import model.entities.Categoria;
import model.entities.Equipo;
import model.factory.DatabaseFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class CategoriaAction implements IAction {
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
        CategoriaDAO categoriaDAO = new CategoriaDAO(DatabaseFactory.POSTGRE);
        ArrayList<Categoria> categorias = categoriaDAO.findAll(null);
        return Categoria.toArrayJSon(categorias);
    }
}
