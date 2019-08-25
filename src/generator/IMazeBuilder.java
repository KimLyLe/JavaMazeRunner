package generator;

import data.MazeData;

public interface IMazeBuilder {
    void buildFill();
    void buildFrame();
    void buildMaze();
    MazeData getMazeData();
}
