package org.something;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.algorithms.practice.graph.Graph.Vertex;

public class BreadthFirstSearch extends Graph {
	public BreadthFirstSearch() {
		super();
	}

	public boolean search(final String input) {
		Map<Vertex, List<Vertex>> adjVertices = super.getAdjVertices();
		final Set<Vertex> visited = new HashSet<>();
		for (Entry<Vertex, List<Vertex>> e : adjVertices.entrySet()) {
			Vertex vertex = e.getKey();
			if (visited.contains(vertex) == false) {
				visited.add(vertex);
				if (visited.contains(new Vertex(input)) == true) {
					return true;
				}
				List<Vertex> adj = super.getAdjVertices(vertex.label);
				for (Vertex vertex2 : adj) {
					if (vertex2.label.equals(input)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean searchByQueue(final String input) {
		final Queue<Vertex> queue = new LinkedList<>();
		Map<Vertex, List<Vertex>> adjVertices = super.getAdjVertices();
		queue.add(adjVertices.entrySet().stream().findFirst().get().getKey());

		final Set<Vertex> visited = new HashSet<>();

		while (queue.isEmpty() == false) {
			Vertex v = queue.poll();
			visited.add(v);
			if (v.label.equals(input)) {
				return true;
			}
			adjVertices.get(v).stream().filter(el -> !visited.contains(el)).forEach(el -> queue.add(el));
		}
		return false;
	}
}
