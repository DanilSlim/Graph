package test.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * Класс реализует граф с не направленными ребрами т.е. ребро между вершинами 2-8 и 8-2 это
 * одно и то же ребро и оно не должно повторяться
*/
public class Graph<T extends Comparable<T>> {
	
	private Set<T> nodes; //Вершины графа
	
	private Set<Edge> edges;//Ребра графа
	
	public Graph() {
		
		this.nodes= new HashSet<T>();
		
		this.edges=new HashSet<Edge>();
	}
	
	 public Graph (Set<T>nodes){
		 
		 this.nodes=nodes;
		 
		 this.edges=new HashSet<Edge>();
	 }
	

	public Set<T> getAllNodes() { //Get all graph's nodes
		return nodes;
	}

	public Set<Edge> getAllEdges() { // Get all graph's edges
		return edges;
	}
	
	

	public void addNode(T node) { //Add node in graph
		if(this.nodes.add(node)) {
			System.out.println("Node "+node +" was added");
		}
		
		else {
			
			System.out.println("Node "+ node +" already exist");
		}
	}

	public void addEdge(T node1, T node2) { // Add edge in graph
		
		Set<T> edgeNodes = new HashSet<>(2);
		
		edgeNodes.add(node1);
		
		edgeNodes.add(node2);
		
		if(this.nodes.containsAll(edgeNodes)) {
			
			Edge edge=new Edge(node1, node2);
			
			System.out.println("Created edge : "+edge);
			
			if(this.edges.add(edge)) {
				 
				System.out.println("Edge "+edge+" was added");
			}
			else {
				
				System.out.println("Edge "+edge+" already exist");
			}			
		}
		else {
			
			System.out.println("Once from two nodes is not exist!");
		}
	}
	
	public void removeEdge(T node1, T node2) {
		
		Set<T> edgeNodes = new HashSet<>(2);
		
		edgeNodes.add(node1);
		
		edgeNodes.add(node2);
		
		if (this.nodes.containsAll(edgeNodes)) {
			
			Edge remooveEdge=new Edge(node1, node2);
			
			if(this.edges.remove(remooveEdge)) {
				
				System.out.println("Edge "+remooveEdge+" has been delete");
			}
			else {
				
				System.out.println("No edge "+remooveEdge+" in Set");
			}
			
		}
		else {
			
			System.out.println("Once from two nodes is not exist!");
		}
	}
	
	
	public void removeNode(T node) { //delete node from graph with its edges
		
		if(this.nodes.contains(node)) { //check node in graph
			
			ArrayList<Edge>edgesForRemove=new ArrayList<>(); //List edges for remove
			
			for (Edge edge:edges) {
				
				if(edge.hasEdgeNode(node)) { //check - this edge has this node
					
					edgesForRemove.add(edge); //get edges for delete
					
					//Remove all edge that has node before delete this node
					/*remooveEdge(edge.getNodesFromEdge().get(0), edge.getNodesFromEdge().get(1));
					System.out.println("Edge has been success remooved");*/
				}
				
			}
			
			edgesForRemove.forEach(t->this.edges.remove(t));//new delete edges
			
			
			/*if(edgesForRemove.size()!=0) { //delete edges
				
				for(int i=0; i<edgesForRemove.size();i++) {
					this.edges.remove(edgesForRemove.get(i));
				}
				
				System.out.println("All edges has been delete");
			}*/
			
			this.nodes.remove(node);
			System.out.println("Node "+node+" has been success delete");
		}
		else System.out.println("No such node in the graph!!!!");//if no node in graph
		
	}
	
	
	@Override
	public String toString() {
		return "Graph [nodes=" + nodes + ", edges=" + edges + "]";
	}
	
	
	
	
	
	private class Edge {
		
		
		private final T node1;
		
		private final T node2;
		
		
		Edge (T node1, T node2){
			
			this.node1=node1;
			
			this.node2=node2;
		}
		
		
	private boolean hasEdgeNode(T node) { //check that edge has node
		
		if(this.node1.equals(node)||this.node2.equals(node)) return true;
		
		return false;
	}
	
	    
		

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + ((node1 == null) ? 0 : node1.hashCode()) + ((node2 == null) ? 0 : node2.hashCode());
			//result = prime * result + ((node2 == null) ? 0 : node2.hashCode());
			return result;
		}

		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Edge other = (Edge) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (node1 == null) {
				if (other.node1 != null)
					return false;
			} else if (!node1.equals(other.node1) && !node1.equals(other.node2))
				return false;
			if (node2 == null) {
				if (other.node2 != null)
					return false;
			} else if (!node2.equals(other.node2) && !node2.equals(other.node1))
				return false;
			return true;
		}

		private Graph<T> getEnclosingInstance() {
			return Graph.this;
		}

		@Override
		public String toString() {
			return "Edge [node1 = " + node1 + " <------> node2 = " + node2 + "]";
		}
		
		
		
	}

	
	
	

}
