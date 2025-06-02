package services;

import model.dao.EquipoDAO;
import model.entities.Equipo;
import model.factory.DatabaseFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class EquipoAction implements IAction {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String cadDestino = "";
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "FIND_ALL":
                cadDestino = findAll(request, response);
                break;
            case "SEARCH_FIND":
                cadDestino = searchAndFind(request, response);
                break;
        }
        return cadDestino;
    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) {
        EquipoDAO equipoDAO = new EquipoDAO(DatabaseFactory.POSTGRE);
        ArrayList<Equipo> equipos = equipoDAO.findAll(null);
        return Equipo.toArrayJSon(equipos);
    }

    private String searchAndFind(HttpServletRequest request, HttpServletResponse response) {
        EquipoDAO equipoDAO = new EquipoDAO(DatabaseFactory.POSTGRE);
        String categoria = request.getParameter("CATEGORIA");
        String search = request.getParameter("SEARCH");
        ArrayList<Equipo> equipos = equipoDAO.searchAndFind(categoria, search);
        return Equipo.toArrayJSon(equipos);
    }

}
