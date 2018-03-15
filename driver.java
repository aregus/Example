package heapPKG;
/**
 * This Class is my driver class.
 * 
 * 
 * @author Andreas Regus
 * PIN: B26
 */
public class driver 
{
public static void main(String[] args){
		
		String [][] data1 = {
				{"A", "2", "-"},
				{"B", "3", "A"}
		};

		String [][] data2 = {
				{"B", "1", "A"},
				{"C", "2", "B"},
				{"F", "3", "C"},
				{"F", "3", "E"},
				{"E", "4", "B"},
				{"E", "4", "D"},
				{"D", "5", "A"},
				{"A", "6", "-"}	
		};		
		
		String [][] data3 = {
				{"A", "2", "-"},
				{"B", "3", "A"},
				{"E", "4", "B"},
				{"F", "6", "E"},
				{"F", "6", "D"},
				{"G", "8", "F"},
				{"H", "5", "F"},
				{"I", "3", "H"},
				{"I", "3", "G"},
				{"C", "4", "A"},
				{"D", "2", "C"}	
		};

		PertChart graph = new PertChart (data1);
		graph.printAllPaths();
		System.out.println();

		graph = new PertChart (data2);
		graph.printAllPaths();
		System.out.println();

		graph = new PertChart (data3);
		graph.printAllPaths();
		System.out.println();
	
		System.out.println("done");
	}

}
