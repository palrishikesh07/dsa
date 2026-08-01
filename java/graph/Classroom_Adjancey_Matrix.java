/**
 * Classroom_Adjancey_Matrix
 */
public class Classroom_Adjancey_Matrix {

     public static void main(String[] args) {
        int V=4;

        int[][] graph = new int[V][V];

        graph[0][2] = 1;
        
        graph[1][2]=1;
        graph[1][3]=1;

        graph[2][0]=1;
        graph[2][1]=1;
        graph[2][3]=1;

        graph[3][1]=1;
        graph[3][2]=1;

        for(int i=0;i<V;i++){
            for(int j=0; j<V; j++){
                System.out.print(graph[i][j]+ " ");
            }
            System.out.println("");
        }
        
     }


}


/*
| Operation         | Complexity |
| ----------------- | ---------- |
| Space             | O(E)       |
| Check edge exists | O(E)       |

*/