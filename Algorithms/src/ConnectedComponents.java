public class ConnectedComponents {
	boolean[] marked;
	Integer[] result;
	int[] cc;
	UndirectedGraph graph;
	DepthFirstSearch search;

	public ConnectedComponents(UndirectedGraph graph) {
		this.graph = graph;
		cc=new int[graph.getNumberOfVertices()];
		search = new DepthFirstSearch(graph);
		marked = search.marked;
	}

	public Integer[] generateNetworks() {
		int groupNumber=0;
		for (int i = 0; i < marked.length; i++) {
			cc[i]=groupNumber;
			if (!marked[i]){
				groupNumber=i;
				result = search.generateNetwork(i);
			}
		}
		return result;
	}

	public void print() {
		for (int i = 0; i < graph.getNumberOfVertices(); i++) {
			System.out.print(i + "\t");
			System.out.print(result[i] + "\t");
			System.out.print(cc[i] + "\t");
			System.out.print(marked[i] + "\n");
		}
	}
}
