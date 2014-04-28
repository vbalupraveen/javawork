import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GraphMain {

	public static void main(String[] args) {
		In in = null;
		try {
			in = new In(new File("Resources/GraphData.txt"));
			int striker = 6;
			int destination = 10;
			System.out.println("-------------------GRAPH-------------------");
			UndirectedGraph graph = new UndirectedGraph(in);
			for (int v = 0; v < graph.getNumberOfVertices(); v++) {
				for (int w : graph.getAdjacentVertices(v))
					StdOut.println(w + "-" + v);
			}
			System.out.println("Degree of " + striker + ":"
					+ graph.degree(striker));
			System.out.println("Total number of Edges:" + graph.totalEdges());
			System.out.println("------------BREATH FIRST SEARCH------------");
			BreadthFirstSearch search = new BreadthFirstSearch(graph);
			System.out.println("Number of edges from " + striker + " to "
					+ destination + " is:"
					+ search.getDistance(striker, destination));
			// search.print();
			System.out.println("------------DEPTH FIRST SEARCH------------");
			DepthFirstSearch dsearch = new DepthFirstSearch(graph);
			System.out.println("Number of edges from " + striker + " to "
					+ destination + " is:"
					+ dsearch.getDistance(striker, destination));
			// dsearch.print();
			System.out.println("------------CONNECTED COMPONENTS------------");
			ConnectedComponents components = new ConnectedComponents(graph);
			components.generateNetworks();
			components.print();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("IO error.");
		}

	}

}
