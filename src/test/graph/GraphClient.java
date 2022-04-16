package test.graph;

import java.util.HashSet;
import java.util.Set;

public class GraphClient {

	public static void main(String[] args) {
		
		
		Set <Integer>graphNodes = new HashSet<>();
		
		for(int i=1; i<=15; i++) {
			
			graphNodes.add(i);
		}
		
		
		Graph<Integer> graph= new Graph<>(graphNodes);
		
		System.out.println(graph);
		
		graph.addNode(12);
		
		graph.addNode(5);
		
		System.out.println(graph);
		
		graph.addEdge(2, 7);
		
		graph.addEdge(5, 7);
		
		graph.addEdge(6, 7);
		
		graph.addEdge(11, 2);
		
		graph.addEdge(7, 2);
		
		System.out.println(graph);
		
		graph.removeNode(7);
		
		System.out.println(graph);
		
		System.out.println("----------------------------------------------");
		
		
		
		Graph<Integer> graph2=new Graph<>();
		
		graph2.addNode(1);
		graph2.addNode(12);
		graph2.addNode(23);
		
		System.out.println(graph2);
		
		Graph<String> graph3=new Graph<>();
		
		graph3.addNode("one");
		graph3.addNode("two");
		graph3.addNode("three");
		
		System.out.println(graph3);
		
		graph3.addEdge("three", "one");
		
		graph3.addEdge("one", "three");
		
		graph3.addEdge("two", "six");
		
		
		graph3.addNode("six");
		
		
		graph3.addEdge("six", "one");
		
		graph3.addEdge("two", "one");
		
		System.out.println(graph3);
		System.out.println();
		System.out.println("---------------------------------------------------");
		
		graph3.removeNode("one");
		System.out.println(graph3);
		System.out.println();
		System.out.println("---------------------------------------------------");
		
		
		System.out.println();
		
		
		System.out.println(graph);
		
		graph.remooveEdge(2, 7);
		
		System.out.println(graph);
		
		graph.addEdge(2, 7);
		
		System.out.println(graph);
		
		graph.addEdge(2, 7);
		
		System.out.println(graph);
		
		graph.remooveEdge(7, 2);
		
		System.out.println(graph);
		
		System.out.println();
		
		System.out.println(graph3);
		
		graph3.remooveEdge("one", "three");
		
		System.out.println(graph3);
	}

}
