import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PokemonEvolution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" -> ");

        String pokemonName, evolutionType;
        int evolutionIndex;

        List<Pokemon> pokemons = new ArrayList<>();

        while (true){
            if (input[0].equals("wubbalubbadubdub")) { break; }

            if (input.length == 1) {
                pokemonName = input[0];
                if (PokemonIsInTheList(pokemons,pokemonName)) {
                    int index = GetIndexOfPokemonInTheList(pokemons,pokemonName);
                    pokemons.get(index).printPokemonEvolutions();
                }
            } else {
                pokemonName = input[0];
                evolutionType = input[1];
                evolutionIndex = Integer.parseInt(input[2]);

                if (PokemonIsInTheList(pokemons,pokemonName)){
                    int index = GetIndexOfPokemonInTheList(pokemons,pokemonName);
                    if (pokemons.get(index).evolutions.containsKey(evolutionType)){
                        pokemons.get(index).evolutions.get(evolutionType).add(evolutionIndex);
                    } else {
                        pokemons.get(index).EnterAnEvolution(evolutionType, evolutionIndex);
                    }
                 } else {
                    Pokemon pokemon = new Pokemon(pokemonName);
                    pokemon.EnterAnEvolution(evolutionType,evolutionIndex);
                    pokemons.add(pokemon);
                }
            }

            input = reader.readLine().split(" -> ");
        }

        for (Pokemon pokemon : pokemons) {
            pokemon.printPokemonEvolutionsSorted();
        }
    }

    static int GetIndexOfPokemonInTheList (List<Pokemon> pokemons, String name) {
        int index = 0;

        for (Pokemon pokemon : pokemons) {
            if (pokemon.getName().equals(name)){
                return index;
            } else {
                index ++;
            }
        }

        return index;
    }

    static boolean PokemonIsInTheList (List<Pokemon> pokemons, String name){
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    static class Pokemon {
        public String name;
        public LinkedHashMap<String,List<Integer>> evolutions;

        public Pokemon (String name) {
            this.name = name;
            this.evolutions = new LinkedHashMap<>();
        }

        public String getName() {
            return name;
        }

        public void EnterAnEvolution (String evolutionType, int evolutionIndex){
            evolutions.put(evolutionType,new ArrayList<>());
            evolutions.get(evolutionType).add(evolutionIndex);
        }

        public void printPokemonEvolutions (){
            System.out.printf("# %s\n", name);
            for (Map.Entry<String, List<Integer>> stringIntegerEntry : evolutions.entrySet()) {
                for (Integer index : stringIntegerEntry.getValue()){
                    System.out.printf("%s <-> %d\n",stringIntegerEntry.getKey(), index);
                }
            }
        }

        public void printPokemonEvolutionsSorted (){
            System.out.printf("# %s\n", name);

            evolutions.entrySet().stream()
                    .sorted(Comparator.comparing(a -> a.getValue().stream().mapToInt(Integer::valueOf).sum(), Comparator.reverseOrder()))
                    .forEach(a -> {
                        Collections.sort(a.getValue());
                        Collections.reverse(a.getValue());
                        for (Integer index : a.getValue()){
                            System.out.printf("%s <-> %d\n",a.getKey(), index);
                    }});

            /*for (Map.Entry<String, List<Integer>> stringIntegerEntry : evolutions.entrySet()) {
                Collections.sort(stringIntegerEntry.getValue());
                Collections.reverse(stringIntegerEntry.getValue());
                for (Integer index : stringIntegerEntry.getValue()){
                    System.out.printf("%s <-> %d\n",stringIntegerEntry.getKey(), index);
                }
            }*/
        }
    }
}
