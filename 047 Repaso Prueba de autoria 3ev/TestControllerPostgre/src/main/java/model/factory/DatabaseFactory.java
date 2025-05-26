package model.factory;

import model.motorsql.MotorPostgre;
import model.motorsql.MotorSQL;

public class DatabaseFactory {
    public static final String MYSQL = "MYSQL";
    public static final String ORACLE = "ORACLE";
    public static final String POSTGRE = "POSTGRE";

    public static MotorSQL getDatabase(String tipo) {
        switch (tipo.toUpperCase()) {
            case MYSQL:
                //return new MotorMySQL();
            case ORACLE:
                //return new MotorOracle();
            case POSTGRE:
            case "POSTGRESQL":  // <-- añade esta línea
                return new MotorPostgre();
            default:
                throw new IllegalArgumentException("Tipo de base de datos no soportado");
        }
    }

}
