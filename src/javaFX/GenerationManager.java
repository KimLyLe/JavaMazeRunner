package javaFX;

import generator.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;

public class GenerationManager {
    private final List<String> generationNames = new ArrayList<>();
    private final List<BiFunction<int[], Random, IMazeBuilder>> generations = new ArrayList<>();

    public GenerationManager() {
        register("Stick-Down-Method", (wh, r) -> new DefeatStickMazeBuilder(wh[0], wh[1], r));
        register("Back-Track-Method", (wh, r) -> new DigHoleMazeBuilder(wh[0], wh[1], r));
        register("Stretch wall", (wh, r) -> new ExtendWallMazeBuilder(wh[0], wh[1], r));
        register("Recursive partitioning", (wh, r) -> new RecursiveDivisionMazeBuilder(wh[0], wh[1], r));
        register("Binary tree method", (wh, r) -> new BinaryTreeMazeBuilder(wh[0], wh[1], r));
        register("Kruskal method", (wh, r) -> new KruskalMazeBuilder(wh[0], wh[1], r));
        register("Prim-Method", (wh, r) -> new PrimMazeBuilder(wh[0], wh[1], r));
        register("Load from file", (wh, r) -> new FromFileMazeBuilder(wh[0], wh[1]));
    }

    private void register(String key, BiFunction<int[], Random, IMazeBuilder> generation) {
        generationNames.add(key);
        generations.add(generation);
    }

    public String[] getGenerationNames() {
        return generationNames.toArray(new String[generationNames.size()]);
    }

    public BiFunction<int[], Random, IMazeBuilder> getGeneration(int index) {
        return generations.get(index);
    }
}
