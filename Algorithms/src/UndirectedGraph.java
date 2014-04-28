import java.io.IOException;
import java.util.regex.Pattern;

/*
 * Input instructions:
 * The Graph Structure should have vertices count in the first line 
 * followed by the edge connections with '-' delimiter. edge pair must be in new line.
 * Ex: to construct 
 *  	3
 * 	   / \
 *    2 - 1 - 0
 * Graph data should be
 * 3 
 * 0-1 1-2 1-3 2-3
 * 
 * */
public class UndirectedGraph implements Graph {
	int verticesCount;
	Bag<Integer>[] vertexArray;

	/* Create an Empty Graph */
	private UndirectedGraph(int verticesCount) {
		this.verticesCount = verticesCount;
		vertexArray = new Bag[verticesCount];
		for (int i = 0; i < verticesCount; i++) {
			vertexArray[i] = new Bag<Integer>();
		}
	}

	UndirectedGraph(In in) throws IOException {
		this(Integer.parseInt(in.readLine()));
		while (in.hasNextLine()) {
			String[] data = in.readLine().split(Pattern.quote("-"));
			addEdge(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
		}
	}

	/* connecting two nodes (redundant) */
	@Override
	public void addEdge(int vertexOne, int vertexTwo) {
		vertexArray[vertexOne].add(vertexTwo);
		vertexArray[vertexTwo].add(vertexOne);
	}

	@Override
	public int getNumberOfVertices() {
		return verticesCount;
	}

	@Override
	public int totalEdges() {
		int count = 0;
		for (int vertex = 0; vertex < verticesCount; vertex++)
			count += degree(vertex);
		return count / 2;
	}

	@Override
	public int degree(int vertex) {
		int count = 0;
		for (int w : getAdjacentVertices(vertex))
			++count;
		/*
		 * while(getAdjecentVertices(vertex).iterator().hasNext())
		 * System.out.println(getAdjecentVertices(vertex).iterator().next());
		 */
		return count;
	}

	@Override
	public Iterable<Integer> getAdjacentVertices(Integer vertex) {
		return vertexArray[vertex];
	}
}
