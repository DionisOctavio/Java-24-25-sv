import Armas.Llamarada;
import Pokemons.Charmander;
import Pokemons.PokemonFactory;
import Pokemons.Squirtle;

public class Main {
    public static void main(String[] args) {

        PokemonFactory.crearPokemon(PokemonFactory.CHARMANDER, "Cha", 50, 600);
        PokemonFactory.crearPokemon(PokemonFactory.CHARMELEON, "Cha", 50, 600);
        PokemonFactory.crearPokemon(PokemonFactory.CHARIZAR, "Cha", 50, 600);

        Charmander charmander = new Charmander("charmander", 60, 6000);
        Squirtle squirtel = new Squirtle("charmander", 60, 6000);

        Llamarada llamarada = new Llamarada("lanza fuego");

        charmander.equiparArma(llamarada);

        charmander.usarArma(squirtel);


    }
}