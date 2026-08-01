

class Edge{
    int src;
    int dest;

    Edge(int s, int d){
        this.src = s;
        this.dest = d;
    }
}

public class Edge_List {
    public static void main(String[] args) {
        Edge[] edges = {
            new Edge(0, 2),
            new Edge(1, 2),
            new Edge(1, 4),
            new Edge(2, 3)
        };

        for(Edge e: edges){
            System.out.println(e.src+" "+e.dest);
        }
    }
}



/*

| Operation         | Complexity |
| ----------------- | ---------- |
| Space             | O(E)       |
| Check edge exists | O(E)       |


*/