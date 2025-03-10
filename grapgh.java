// 0 -> 1 2 
// 1 -> 0 2 3 
// 2 -> 0 1 
// 3 -> 1 4 
// 4 -> 3 
import java.util.*;
class GraphAdjList {
    private Map<Integer,ArrayList<Integer>> adjList;
    
    public GraphAdjList(){
        adjList = new HashMap<>();
    }
    
    public void addEdge(int v,int u){
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.get(v).add(u); 
        adjList.get(u).add(v); 
    }
    public void printGraph(){
        for(var entry: adjList.entrySet()){
            System.out.print(entry.getKey() + " -> ");
            for(var i:entry.getValue()){
                System.out.print(i + ",");
            }
             System.out.println();
        }
    }
    
    public static void main(String[] args){
        GraphAdjList graph=new GraphAdjList();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.printGraph();
    }

}


-----------------------------------------------------------



// 0 -> 1 2 
// 1 -> 0 2 3 
// 2 -> 0 1 
// 3 -> 1 4 
// 4 -> 3 
import java.util.*;
class GraphAdjArray {
    private int[][] adjArray;
    private int size;
    
    public GraphAdjArray(int size){
        this.size = size;
        adjArray = new int[size][size];
    }
    
    public void addEdge(int v,int u){
       adjArray[v][u]=1;
       adjArray[u][v]=1; 
    }
    public void printGraph(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(adjArray[i][j] + " ");
            }
             System.out.println();
        }
    }
    
    public static void main(String[] args){
        GraphAdjArray graph=new GraphAdjArray(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.printGraph();
    }

}


-----------------------------------------------------
//      (0)
//     /   \
//   (1) - (2)
//   |
//   (3)
//   |
//   (4)
import java.util.*;
class GraphAdjList {
    private Map<Integer,ArrayList<Integer>> adjList;
    
    public GraphAdjList(){
        adjList = new HashMap<>();
    }
    
    public void addEdge(int v,int u){
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.get(v).add(u); 
        adjList.get(u).add(v); 
    }
    public void printGraph(){
        for(var entry: adjList.entrySet()){
            System.out.print(entry.getKey() + " -> ");
            for(var i:entry.getValue()){
                System.out.print(i + ",");
            }
             System.out.println();
        }
    }
    
    
    public void bfs(int start,Map<Integer,ArrayList<Integer>> adjList){
        Queue<Integer> queue =new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        while(!queue.isEmpty()){
            int node =queue.poll();
            System.out.print(node+"");
            for(Integer neigbour: adjList.get(node)){
                if(!visited.contains(neigbour)){
                    queue.add(neigbour);
                    visited.add(neigbour);
                }
            }
            
        }
    }

    public void shortestPath(int start,Map<Integer,ArrayList<Integer>> adjListMap){
        Queue<Integer> queue =new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer,Integer> distance =new HashMap<>();
        queue.add(start);
        visited.add(start);
        distance.put(start,0);
        while(!queue.isEmpty()){
            int node =queue.poll();
            int getDistance =distance.get(node);
            for(Integer neigbour: adjList.get(node)){
                if(!visited.contains(neigbour)){
                    queue.add(neigbour);
                    visited.add(neigbour);
                    distance.put(neigbour,getDistance+1);
                }
            }
            
        }
        for(Integer key:distance.keySet()){
            System.out.println("distnace btw "+start+" and "+key+"->"+distance.get(key));
        }
    }
    
        public void dfs(int start,Map<Integer,ArrayList<Integer>> adjList){
        Stack<Integer> stack =new Stack<>();
        Set<Integer> visited = new HashSet<>();
        stack.add(start);
        visited.add(start);
        while(!stack.isEmpty()){
            int node =stack.pop();
            System.out.print(node+"");
            for(Integer neigbour: adjList.get(node)){
                if(!visited.contains(neigbour)){
                    stack.add(neigbour);
                    visited.add(neigbour);
                }
            }
            
        }
    }
    
    public static void main(String[] args){
        GraphAdjList graph=new GraphAdjList();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.printGraph();
        System.out.println("bfs------------------");
        graph.bfs(0,graph.adjList);
        System.out.println("dfs------------------");
        graph.dfs(0,graph.adjList);
        
    }

}
