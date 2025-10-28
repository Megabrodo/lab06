package it.unibo.generics.graph.api;
import java.util.*;

public class GraphImpl<N> implements Graph<N> {

    private HashSet<N> nodes = new HashSet<>();
    private Map<N, HashSet<N>> map = new HashMap<>();
    private ArrayList<N> path = new ArrayList<>();
    private Set<N> visited = new HashSet<>();

    public void addNode(N node){
        if (node != null || !nodes.contains(node)){
            nodes.add(node);
        }    
    }
    
    public void addEdge(N source, N target){
        if (source != null && target!=null){
            if (!map.containsKey(source)){
                map.put(source, new HashSet<>());   
            }
            map.get(source).add(target);
        }
    }

    public Set<N> nodeSet(){
        return nodes;
    }

    public Set<N> linkedNodes(N node){
        return map.get(node);
    }

    public List<N> getPath(N source, N target, int decision){
        if (source!=null && target!=null && map.containsKey(source)){
            if (decision==0){
            return getPathDFS(source, target);
            }
            else{
                return getPathBFS(source, target);
            }
        }
        else{
            return Collections.emptyList();
        }
    }

//////////////////////////DFS IMPLEMENTATION\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    private List<N> getPathDFS(N source, N target) {
        if (dfs(source, target, path, visited)) {
            return path;
        } else {
            return Collections.emptyList(); // nessun percorso trovato
        }
    }

    // Metodo di supporto ricorsivo
    private boolean dfs(N current, N target, List<N> path, Set<N> visited) {
        if (current == null || visited.contains(current)) {
            return false;
        }

        visited.add(current);
        path.add(current);

        // Caso base: trovato il target
        if (current.equals(target)) {
            return true;
        }

        // Esplora tutti i vicini
        Set<N> neighbors = map.get(current);
        if (neighbors != null) {
            for (N next : neighbors) {
                if (dfs(next, target, path, visited)) {
                    return true; // percorso trovato
                }
            }
        }

        // Backtrack se non trovi nulla
        path.remove(path.size() - 1);
        return false;
    }
//////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
/////////////////////////////BFS IMPLEMENTATION\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    private List<N> getPathBFS(N source, N target) {
        Queue<N> queue = new LinkedList<>();
        Map<N, N> parent = new HashMap<>();
        Set<N> visited = new HashSet<>();

        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            N current = queue.poll();

            if (current.equals(target)) {
                return buildPath(parent, source, target);
            }

            Set<N> neighbors = map.get(current);
            if (neighbors != null) {
                for (N next : neighbors) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        parent.put(next, current);
                        queue.add(next);
                    }
                }
            }
        }
        return Collections.emptyList();
    }

    // Ricostruisce il percorso trovato dalla BFS
    private List<N> buildPath(Map<N, N> parent, N source, N target) {
        LinkedList<N> path = new LinkedList<>();
        N current = target;
        while (current != null) {
            path.addFirst(current);
            current = parent.get(current);
        }
        if (!path.getFirst().equals(source)) {
            return Collections.emptyList();
        }
        return path;
    }

}
