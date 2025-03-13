package Pokemons;

public class PokemonFactory {

    public static final String CHARMANDER = "CHARMANDER";
    public static final String CHARMELEON = "CHARMALEON";
    public static final String CHARIZAR = "CHARIZAR";
    public static final String SQUIRTEL = "SQUIRTEL";


    public static Pokemon crearPokemon(String tipo, String nombrePokemon, int nivel, int energia){

        switch (tipo){
            case CHARMANDER:
                return new Charmander(nombrePokemon, nivel, energia);
            case CHARMELEON:
                return new Charmeleon(nombrePokemon, nivel, energia);
            case CHARIZAR:
                return new Charizard(nombrePokemon, nivel, energia);
            case SQUIRTEL:
                return new Squirtle(nombrePokemon, nivel, energia);
        }
        return null;
    }


}
