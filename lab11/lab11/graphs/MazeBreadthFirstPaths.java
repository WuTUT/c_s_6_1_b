package lab11.graphs;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s, t;
    private boolean targetFound = false;
    private Queue<Integer> q;

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        // Add more variables here!
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
        q = new LinkedList<>();
    }

    /**
     * Conducts a breadth first search of the maze starting at the source.
     */
    private void bfs() {
        // TODO: Your code here. Don't forget to update distTo, edgeTo, and marked, as well as call announce()
        q.add(s);
        marked[s] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            if (x == t) {
                targetFound = true;
                break;
            }
            for (int nx : maze.adj(x)) {
                if (!marked[nx]) {
                    marked[nx] = true;
                    q.add(nx);
                    edgeTo[nx] = x;

                    distTo[nx] = distTo[x] + 1;
                    announce();
                }
            }
        }
    }


    @Override
    public void solve() {
        bfs();
    }
}

