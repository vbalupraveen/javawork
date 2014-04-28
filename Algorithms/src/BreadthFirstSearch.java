import java.util.LinkedList;

public class BreadthFirstSearch {
	private Integer[] edgeTo;
	private int size;
	UndirectedGraph graph;
	LinkedList<Integer> queue;
	static boolean[] marked;
	int distance = 0;

	public BreadthFirstSearch(UndirectedGraph graph) {
		this.size = graph.getNumberOfVertices();
		edgeTo = new Integer[size];
		this.graph = graph;
		queue = new LinkedList<Integer>();
		marked = new boolean[size];
	}

	private Integer[] generateNetwork(int vertex) {
		marked[vertex] = true;
		queue.addLast(vertex);
		generatePaths(vertex);
		return edgeTo;
	}

	private void generatePaths(int vertex) {
		for (int index : graph.getAdjacentVertices(vertex)) {
			if (!marked[index]) {
				queue.addLast(index);
				edgeTo[index] = vertex;
				marked[index] = true;
			}
		}
		try {
			generatePaths(queue.remove());
		} catch (Exception e) {
			return;
		}
	}

	public void print() {
		for (int i = 0; i < graph.getNumberOfVertices(); i++) {
			System.out.print(i + "\t");
			System.out.print(edgeTo[i] + "\t");
			System.out.print(marked[i] + "\n");
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
}
