// From Princeton website
public class DepthFirstSearch{
    private boolean[] marked; // if there s-v path
    private int count; // No of vertices connected to s-v
    
    public DepthFirstSearch(Graph G, int s){
        marked = new marked[G.v()];
        dfs(G, s);
    }
    
    private void dfs(Graph G, int v){
        this.marked[v] = true;
        this.count++;
        for(int w: G.adj(v)){
            if(!marked[w]){
                dfs(G, w);
            }
        }
    }
    
    public boolean marked(int v){
        return this.marked[v];
    }
    
    public int count(){
        return this.count;
    } 
    
    public static void main(String[] args){
        In in = new In(arg[0]);
        Graph G = new Graph(in);
        int s = Integer.parseInt(args[1]);
        DepthFirstSearch search = new DepthFirstSearch(G, s);
        for(int v: G.v()){
            if (search.marked(v)){
                System.out.print(v + " ");
            }
        }
        System.out.println();
        if(search.count() == G.v()) System.out.println("Graph Connected!");
        else System.out.println("Graph Not Connected!");
    }
}