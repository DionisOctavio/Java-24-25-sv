package services;
import model.dao.HackatonDAO;
import model.entities.Hackaton;
import model.factory.DatabaseFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class HackatonAction  implements  IAction{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String cadDestino = "";
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "FILTER":
                cadDestino = findByFilter(request, response);
                break;
        }
        return cadDestino;
    }
    private String findByFilter(HttpServletRequest request, HttpServletResponse response) {
        HackatonDAO hackatonDAO = new HackatonDAO(DatabaseFactory.getDatabase(DatabaseFactory.POSTGRE));
        String category = request.getParameter("CATEGORY");
        String search = request.getParameter("SEARCH");
        ArrayList<Hackaton> lst = hackatonDAO.findAllByCateg(category, search);
        return Hackaton.toArrayJSon(lst);
    }
}
