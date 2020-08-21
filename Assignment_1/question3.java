import java.util.*;

public class ques3{

	static class Edge{

		int src, dest, cost;

		Edge(int s, int d, int c){

			src = s;

			dest = d;

			cost = c;

		}

	}

	public static void print(String msg){

		System.out.print(msg);

	}

	public static String bellmanFord(ArrayList<Edge> edges, int n, int src, int dest){

		int dist[] = new int[n];

		Arrays.fill(dist,Integer.MAX_VALUE);

		dist[src] = 0;

		int previous[] = new int[n];

		Arrays.fill(previous,-1);

		for(int i = 1;i<n;i++){

			for(Edge edge:edges){

				int u = edge.src;

				int v = edge.dest;

				int w = edge.cost;

				if(dist[u]!=Integer.MAX_VALUE&&dist[v]>dist[u]+w){

					dist[v] = dist[u]+w;
					previous[v] = u;

				}

			}

		}

		for(Edge edge:edges){

			int u = edge.src;

			int v = edge.dest;

			int w = edge.cost;

			if(dist[u] != Integer.MAX_VALUE && dist[u]+w<dist[v]){

				return "Negative cycles exist";

			}

		}

		if(dist[dest]!=Integer.MAX_VALUE) {

			print("Shortest path between source and destination is: ");
			int node=dest;
			ArrayList<Integer> shortestpath = new ArrayList<Integer>();
			shortestpath.add(dest);
			while(node!=src){
                shortestpath.add(previous[node]);
                node=previous[node];
			}
			for(int p=(shortestpath.size()-1); p>-1; p--){
			    System.out.print(shortestpath.get(p));
			    if(p!=0)
			        print("->");
			}
		}

		print("\n");

		return dist[dest]==Integer.MAX_VALUE?"No path":String.valueOf(dist[dest]);

	}

    public static void main(String args[]){

    	Scanner sc = new Scanner(System.in);

    	print("Enter the number of vertices in graph:\n");

    	int n = sc.nextInt();

    	print("Enter the number of edges in graph:\n");

    	int m = sc.nextInt();

    	ArrayList<Edge> edges = new ArrayList<Edge>(m);

    	print("Enter the details of edges in the following format:\nSource Destination Cost\n");

    	for(int i = 0;i<m;i++){

    		edges.add(new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt()));

    	}

    	print("Enter source vertex:\n");

    	int src = sc.nextInt();

    	print("Enter destination vertex:\n");

    	int dest = sc.nextInt();

    	String ans = bellmanFord(edges,n,src,dest)+"\n";

    	print(ans);

    }   

                             

}


//Yes, this can be extended to include all the possible paths between two nodes using techniques like DFS.