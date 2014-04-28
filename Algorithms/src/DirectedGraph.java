import java.io.IOException;
import java.util.regex.Pattern;


public class DirectedGraph implements Graph {

	int verticesCount;
	Bag<Integer>[] vertexArray;

	/* Create an Empty Directed Graph */
	private DirectedGraph(int verticesCount) {
		this.verticesCount = verticesCount;
		vertexArray = new Bag[verticesCount];
		for (int i = 0; i < verticesCount; i++) {
			vertexArray[i] = new Bag<Integer>();
		}
	}

	DirectedGraph(In in) throws IOException {
		this(Integer.parseInt(in.readLine()));
		while (in.hasNextLine()) {
			String[] data = in.readLine().split(Pattern.quote("-"));
			addEdge(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
		}
	}

	/* connecting two nodes */
	@Override
	public void addEdge(int vertexOne, int vertexTwo) {
		vertexArray[vertexOne].add(vertexTwo);
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
		return count;
	}

	@Override
	public Iterable<Integer> getAdjacentVertices(Integer vertex) {
		return vertexArray[vertex];
	}

}
