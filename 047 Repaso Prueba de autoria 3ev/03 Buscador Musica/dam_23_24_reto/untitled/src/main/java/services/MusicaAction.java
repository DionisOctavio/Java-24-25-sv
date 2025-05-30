package services;

import model.dao.MusicaDAO;
import model.entities.Musica;
import model.factory.DatabaseFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class MusicaAction implements IAction{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String cadDestino = "";
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "SEARCH":
                cadDestino = findBySearch(request, response);
                break;
            case "FIND":
                cadDestino = findAll(request, response);
                break;
        }
        return cadDestino;
    }

    private String findBySearch(HttpServletRequest request, HttpServletResponse response){
        MusicaDAO musicaDAO = new MusicaDAO(DatabaseFactory.POSTGRE);
        String search = request.getParameter("SEARCH");
        System.out.println(search);
        Musica musica = new Musica();
        System.out.println(musica);
        musica.setNombre(search);
        ArrayList<Musica> musicas = musicaDAO.findBySearch(search);
        System.out.println(musicas);
        return Musica.toArrayJSon(musicas);
    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) {
        MusicaDAO musicaDAO = new MusicaDAO(DatabaseFactory.POSTGRE);
        ArrayList<Musica> musicas = musicaDAO.findAll(null);
        return Musica.toArrayJSon(musicas);
    }

}
