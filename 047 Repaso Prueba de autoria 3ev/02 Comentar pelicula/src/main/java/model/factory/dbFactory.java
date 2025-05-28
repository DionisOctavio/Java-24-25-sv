package model.factory;

import model.motorsql.MotorPostgre;
import model.motorsql.MotorSQL;

public class dbFactory {

    public static final String POSTGRES = "POSTGRES";
    public static final String MYSQL = "MYSQL";
    public static final String ORACLE = "ORACLE";

    public static MotorSQL getDataBase(String tipoDB){

        switch (tipoDB){
            case POSTGRES:
                return new MotorPostgre();
            default:
                throw new IllegalArgumentException("BASE DE DATOS NO REGISTRADA");
        }

    }

}
