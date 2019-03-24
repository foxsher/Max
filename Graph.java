import java.util.LinkedList;
import java.util.Queue;
public class Graph {
      private boolean adjMatrix[][];
      private int numVertices;
 
      public Graph(int numVertices) {
          this.numVertices = numVertices;
          adjMatrix = new boolean[numVertices][numVertices];
    }
 
      public void addEdge(int i, int j) {
                adjMatrix[i][j] = true;
                adjMatrix[j][i] = true;
    }
 
      public void removeEdge(int i, int j) {
                adjMatrix[i][j] = false;
                adjMatrix[j][i] = false;
    }
 
      public boolean isEdge(int i, int j) {
                  return adjMatrix[i][j];
    }
	public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (boolean j : adjMatrix[i]) {
                s.append((j?1:0) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
	public int[][] DFSTree(int index) {
		//Empty tree
		int res[][] = new int[topNum()][topNum()];
		//Stack
		Stack<Integer> stack = new Stack<>();
		int visit[] = new int[topNum()];
		ArrayList<Integer> listVS = new ArrayList<>();
		
		visit[index] = 1;
		stack.push(index);
		listVS.add(index);

		while(!stack.isEmpty()){
			int i=stack.peek();
			int count=0;
			for (int j = 0; j < visit.length; j++) {
				if(this.matrixA[i][j]>0 && visit[j]!=1){
					
					res[i][j]=1;
					res[j][i]=1;
					stack.push(j);
					visit[j]=1;
					listVS.add(j);
					break;
				}else{
					count++;
				}
			}
			if(count==visit.length) stack.pop();
			if(listVS.size()==topNum()) {
				
				graphToString(listVS);
				return res;
			}
		}
		return res;

	}
}