package bricks.graph;

import com.sun.istack.internal.NotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */

public class Vertex<T> {
    private Set<Vertex<T>> in;
    private Set<Vertex<T>> out;
    private T object;
    private int weight;

    public Vertex(@NotNull T object) {
        this.object = object;
        this.in = new HashSet<Vertex<T>>();
        this.out = new HashSet<Vertex<T>>();
    }

    public T getObject() {
        return object;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void addIn(Vertex<T> vertex) {
        in.add(vertex);
    }

    public void addIn(Collection<Vertex<T>> vertices) {
        in.addAll(vertices);
    }

    public void addOut(Vertex<T> vertex) {
        out.add(vertex);
    }

    public void addOut(Collection<Vertex<T>> vertices) {
        out.addAll(vertices);
    }

    public Set<Vertex<T>> getIn() {
        return in;
    }

    public Set<Vertex<T>> getOut() {
        return out;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Vertex vertex = (Vertex)obj;
        return this.object.equals(vertex.object);
    }

    @Override
    public int hashCode() {
        return object.hashCode();
    }
}
