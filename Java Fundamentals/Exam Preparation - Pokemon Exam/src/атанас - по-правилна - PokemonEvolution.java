import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PokemonEvolution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Pokemon> pokemons = new LinkedHashMap<>();

        while (true) {
            String[] tokens = reader.readLine().split(" -> ");
            if (tokens[0].equals("wubbalubbadubdub")) {
                break;
            } else if (tokens.length == 1) {
                String pokemonName = tokens[0];
                if (pokemons.containsKey(pokemonName)) {
                    System.out.printf("# %s%n", pokemonName);
                    for (Evolution evolution : pokemons.get(pokemonName).getEvolutions()) {
                        System.out.printf("%s <-> %d%n", evolution.getType(), evolution.getIndex());
                    }
                }
            } else {
                String pokemonName = tokens[0];
                String evolutionType = tokens[1];
                int evolutionIndex = Integer.parseInt(tokens[2]);
                Evolution evolution = new Evolution(evolutionType, evolutionIndex);
                if (pokemons.containsKey(pokemonName)) {
                    pokemons.get(pokemonName).getEvolutions().add(evolution);
                } else {
                    Pokemon pokemon = new Pokemon(pokemonName, new ArrayList<>());
                    pokemon.getEvolutions().add(evolution);
                    pokemons.put(pokemonName, pokemon);
                }
            }
        }
        for (Pokemon pokemon : pokemons.values()) {
            System.out.printf("# %s%n", pokemon.getName());
            pokemon.getEvolutions().sort(Comparator.comparing(Evolution::getIndex, Comparator.reverseOrder()));
            for (Evolution evolution : pokemon.getEvolutions()) {
                System.out.printf("%s <-> %s%n", evolution.getType(), evolution.getIndex());
            }
        }
    }

    static class Pokemon {
        private String name;
        private ArrayList<Evolution> evolutions;

        Pokemon(String name, ArrayList<Evolution> evolutions) {
            this.name = name;
            this.evolutions = evolutions;
        }

        public String getName() {
            return name;
        }

        public ArrayList<Evolution> getEvolutions() {
            return evolutions;
        }
    }

    static class Evolution {
        private String type;
        private int index;

        Evolution(String type, int index) {
            this.type = type;
            this.index = index;
        }

        public String getType() {
            return type;
        }

        public int getIndex() {
            return index;
        }
    }
}

