package com.tlabs.eve.map;

import org.jgrapht.EdgeFactory;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.SimpleDirectedGraph;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class UniverseMap extends SimpleDirectedGraph<SolarSystem, Jump> {
    private static final long serialVersionUID = -2393159504475366045L;

    private static final class UniverseEdgeFactory implements EdgeFactory<SolarSystem, Jump>, Serializable {

        private static final long serialVersionUID = 2523151441485341520L;

        public Jump createEdge(SolarSystem from, SolarSystem to) {
            final Jump jump = new Jump(from, to);
            //jump.setWeight(Math.max(0d, from.getSecurityStatus()));
            return jump;
        }
    }

    private Map<Long, SolarSystem> solarSystems;

    public UniverseMap() {
        super(new UniverseEdgeFactory());
        this.solarSystems = new HashMap<>();
    }

    @Override
    public boolean addVertex(SolarSystem v) {
        final boolean added = super.addVertex(v);
        if (added) {
            this.solarSystems.put(v.getSolarSystemID(), v);
        }
        return added;
    }

    public SolarSystem getVertex(final long id) {
        final SolarSystem s = this.solarSystems.get(id);
        if (null == s) {
            throw new IllegalArgumentException("SolarSystem not found " + id);
        }
        return s;
    }

    //FIXME return List<SolarSystem> and hide the Jump class
    public final List<Jump> findShortestPath(final long from, final long to) {
        return findShortestPath(this, from, to);
    }

    //FIXME return List<SolarSystem> and hide the Jump class
    public static List<Jump> findShortestPath(final UniverseMap graph, final long from, final long to) {
        final SolarSystem fromSystem = graph.getVertex(from);
        final SolarSystem toSystem = graph.getVertex(to);

        return DijkstraShortestPath.findPathBetween(graph, fromSystem, toSystem);
    }
}
