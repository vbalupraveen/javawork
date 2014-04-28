public class DepthFirstSearch {
	UndirectedGraph graph;
	private Integer[] edgeTo;
	private int size;
	boolean[] marked;

	public DepthFirstSearch(UndirectedGraph graph) {
		this.graph = graph;
		this.size = graph.getNumberOfVertices();
		edgeTo = new Integer[size];
		marked = new boolean[size];
	}

	public Integer[] generateNetwork(int vertex) {
		marked[vertex] = true;
		generatePaths(vertex);
		return edgeTo;
	}

	private void generatePaths(int vertex) {
		for (int index : graph.getAdjacentVertices(vertex)) {
			if (!marked[index]) {
				// System.out.println(index + "\t");
				marked[index] = true;
				edgeTo[index] = vertex;
				generatePaths(index);
			}
		}
	}
	public int getDistance(int from, int to) {
		int count = 0;
		try{
			for (int i = 0; i <generateNetwork(from).length; i++) {
				System.out.print(to+"\t");
				if (from == to){
					count = i;
					break;
				}
				to = edgeTo[to];
			}
			}catch(NullPointerException e){
				count=0;
			}
		System.out.println();
		return count;
	}
	public void print() {
		for (int i = 0; i < graph.getNumberOfVertices(); i++) {
			System.out.print(i + "\t");
			System.out.print(edgeTo[i] + "\t");
			System.out.print(marked[i] + "\n");
		}
	}
}
