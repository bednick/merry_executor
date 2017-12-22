package bricks.graph;

import bricks.Pair;

import java.util.*;

/**
 *
 */
public class OrientedGraph<T> {
    private Map<T, Vertex<T>> vertices;
    private Set<Vertex<T>> root;
    private Set<Vertex<T>> leaf;

    public OrientedGraph() {
        vertices = new HashMap<>();
        root = new HashSet<>();
        leaf = new HashSet<>();
    }

    public void addVertex(T vertex) {
        if (vertices.containsKey(vertex)) {
            return;
        }
        Vertex<T> v = new Vertex<T>(vertex);
        vertices.put(vertex, v);
        root.add(v);
        leaf.add(v);
    }

    public void addEdge(Pair<T, T> edge) {
        Vertex<T> v1 = vertices.get(edge.getKey());
        Vertex<T> v2 = vertices.get(edge.getValue());

        leaf.remove(v1);
        root.remove(v2);

        v1.addOut(v2);
        v2.addIn(v1);
    }

    public Set<Vertex<T>> getRoot() {
        return root;
    }

    public Set<Vertex<T>> getLeaf() {
        return leaf;
    }

    public Vertex<T> getVertex(T object) {
        return vertices.get(object);
    }
}
