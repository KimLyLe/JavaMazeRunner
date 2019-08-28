package javaFX;

import searcher.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class SearchManager {
    private final List<String> searchNames = new ArrayList<>();
    private final List<Function<Random, IMoveAlgorithm>> searches = new ArrayList<>();

    public SearchManager() {
        register("Random mouse", (r) -> new RandomMouseAlgorithm(r));
        register("Mountain climbing", (r) -> new HillClimbingAlgorithm(r));
        register("Wall follower (Depthpriority)", (r) -> new WallFollowerAlgorithm());
        register("Wideness priority", (r) -> new BreadthFirstAlgorithm());
        register("Adachi Rule", (r) -> new AdachiAlgorithm(r));
    }

    private void register(String key, Function<Random, IMoveAlgorithm> search) {
        searchNames.add(key);
        searches.add(search);
    }

    public String[] getSearchNames() {
        return searchNames.toArray(new String[searchNames.size()]);
    }

    public Function<Random, IMoveAlgorithm> getSearch(int index) {
        return searches.get(index);
    }
}
