package drawer;

import bricks.Command;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.event.GraphEvent;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import sun.tools.tree.Node;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Collection;
import java.util.Properties;

public interface IDrawer {
    void draw(Collection<Command> graph); //в каком виде мне будет даваться граф????

//    public static void main(String [] args) {
//        DirectedSparseGraph g = new DirectedSparseGraph();
//    }

}

