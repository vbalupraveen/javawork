public interface Graph {
	/* adds edge(UnDirected)/edges(Directed) between vertexOne and veterxTwo */
	void addEdge(int vertexOne, int vertexTwo);

	/* gets adjacent vertices to vertex */
	public Iterable<Integer> getAdjacentVertices(Integer vertex);

	/* gets total number of vertices */
	int getNumberOfVertices();

	/* gets total number of edges */
	int totalEdges();

	/* gets degree of vertex */
	int degree(int vertex);
}
