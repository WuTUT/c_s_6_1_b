package lab11.graphs;

/**
 * @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */

    private boolean founded;

    public MazeCycles(Maze m) {
        super(m);
        founded = false;
    }

    @Override
    public void solve() {
        for (int i = 0; i < maze.V(); i++) {
            if (!marked[i]) {
                distTo[i] = 0;
                edgeTo[i] = i;
                dfs(i, -1);
                if (founded) {
                    break;
                }
            }
        }
       //System.out.println(founded);
    }

    private void dfs(int v, int fa) {
        if (founded) {
            //announce();
            return;
        }
        if(marked[v]){
            return;
        }
        marked[v] = true;

        for (int w : maze.adj(v)) {
            if (marked[w] && w != fa) {
                founded = true;
                edgeTo[w] = v;
                distTo[w] = distTo[v] + 1;
                return;
            }
            dfs(w, v);
        }
    }
    // Helper methods go here
}

