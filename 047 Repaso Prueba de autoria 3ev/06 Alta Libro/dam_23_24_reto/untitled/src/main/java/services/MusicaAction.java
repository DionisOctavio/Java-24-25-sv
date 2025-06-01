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
            case "ADD":
                cadDestino = add(request, response);
                break;
            case "FIND":
                cadDestino = findAll(request, response);
                break;
        }
        return cadDestino;
    }

    private String add(HttpServletRequest request, HttpServletResponse response) {
        String nombre = request.getParameter("NOMBRE");
        if (nombre == null || nombre.trim().isEmpty()) {
            return "{\"error\": \"El nombre no puede estar vacío\"}";
        }
        Musica musica = new Musica();
        musica.setNombre(nombre);
        MusicaDAO musicaDAO = new MusicaDAO(DatabaseFactory.POSTGRE);
        int resultado = musicaDAO.add(musica);
        if (resultado > 0) {
            return "{\"success\": true, \"message\": \"Música añadida correctamente\"}";
        } else {
            return "{\"success\": false, \"message\": \"Error al añadir la música\"}";
        }
    }

    private String findAll(HttpServletRequest request, HttpServletResponse response) {
        MusicaDAO musicaDAO = new MusicaDAO(DatabaseFactory.POSTGRE);
        ArrayList<Musica> musicas = musicaDAO.findAll(null);
        return Musica.toArrayJSon(musicas);
    }

}
