package Generator;

import Data.MazeData;

public interface IMazeBuilder {
    void buildFill();
    void buildFrame();
    void buildMaze();
    MazeData getMazeData();
}
