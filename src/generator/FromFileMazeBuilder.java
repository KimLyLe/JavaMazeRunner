package generator;

import data.MazeData;

import java.io.File;
import java.util.Random;

public class FromFileMazeBuilder extends AbstractMazeBuilder {

    public FromFileMazeBuilder(int width, int height) {
        super(width, height);
    }

    @Override
    protected MazeData.Tile getFillTile() {
        return null;
    }

    @Override
    public void buildMaze() {
        fromFile();
    }

    protected void fromFile() {
        File file = new File("maze1.txt");

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        for ( int i = 2; i < getWidth()-2; i+=2 ) {
            for ( int j = 2; j < getHeight()-2; j+=2 ) {
                int d;
                if ( i == 2 ) {
                    d = 4;
                } else {
                    do {
                        d = 3;
                    } while(getData(i+dx[d], j+dy[d]) == MazeData.Tile.WALL);
                }
                setData(i, j, MazeData.Tile.WALL);
                setData(i+dx[d], j+dy[d], MazeData.Tile.WALL);
            }
        }
    }
}
