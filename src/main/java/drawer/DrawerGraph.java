package drawer;

import bricks.Command;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.event.GraphEvent;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

/**
 * Created by Anastasia on 17.12.2017.
 */
public class DrawerGraph implements IDrawer {

    DirectedSparseGraph g;

	public DrawerGraph()
	{
	
	}
    
    @Override
    public void draw(Collection<Command> graph) {
        g = new DirectedSparseGraph();
        parse(graph);

        VisualizationImageServer vs =
                new VisualizationImageServer(
                        new CircleLayout(g), new Dimension(400, 400));

        vs.setBackground(Color.WHITE);
        vs.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller<GraphEvent.Edge>());
        vs.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Line<GraphEvent.Vertex, GraphEvent.Edge>());
        vs.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<GraphEvent.Vertex>());
        vs.getColorModel();
//        vs.getRenderer().getVertexLabelRenderer()
//                .setPosition(Renderer.VertexLabel.Position.CNTR);

        JFrame frame = new JFrame();
        frame.getContentPane().add(vs);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void parse(Collection<Command> graph){
        for(Command command: graph){
            g.addVertex(command.getCommand());
            for (String vertex: command.getInStates()){
                g.addVertex(vertex);
                g.addEdge(String.format("%s_%s", vertex, command.getCommand()), command.getCommand(), vertex);
            }
            for (String vertex: command.getOutStates()){
                g.addVertex(vertex);
                g.addEdge(String.format("%s_%s", vertex, command.getCommand()), vertex, command.getCommand());
            }
        }
    }
}
