package model.factory;

import model.motorsql.MotorPostgre;
import model.motorsql.MotorSQL;

public class dbFactory {

    public static final String POSTGRE = "POSTGRE";

    public static MotorSQL getDataBase(String tipoDB){

        switch(tipoDB){
            case POSTGRE:
                return new MotorPostgre();
            default:
                throw new IllegalArgumentException("BASE DE DATOS NO REGISTRADA");
        }
    }
}