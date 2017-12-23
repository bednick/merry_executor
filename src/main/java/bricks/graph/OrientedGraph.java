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

    public void addVertex(T vertex, int weight) {
        if (vertices.containsKey(vertex)) {
            return;
        }
        Vertex<T> v = new Vertex<T>(vertex);
        v.setWeight(weight);
        vertices.put(vertex, v);
        root.add(v);
        leaf.add(v);
    }

    public void addEdge(T start, T finish) {
        addVertex(start, 0);
        addVertex(finish, 0);

        Vertex<T> v1 = vertices.get(start);
        Vertex<T> v2 = vertices.get(finish);

        leaf.remove(v1);
        root.remove(v2);

        v1.addOut(v2);
        v2.addIn(v1);
    }

    public void addEdge(Pair<T, T> edge) {
        addEdge(edge.getKey(), edge.getValue());
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
