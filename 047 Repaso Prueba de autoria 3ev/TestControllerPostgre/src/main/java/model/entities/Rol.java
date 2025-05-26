package model.entities;

public class Rol {
    private int idRol;
    private String nombreRol;

    public Rol() {}

    public Rol(int idRol, String nombreRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public static String fromObjectToJson(Rol rol) {
        return String.format("{\"idRol\": %d, \"nombreRol\": \"%s\"}", rol.idRol, rol.nombreRol);
    }

    public static String fromListToJson(java.util.List<Rol> roles) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < roles.size(); i++) {
            sb.append(fromObjectToJson(roles.get(i)));
            if (i < roles.size() - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}
