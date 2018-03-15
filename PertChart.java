package heapPKG;
/**
 * This Class is used to discover all possible paths in a 2d data set of heaps and will print how much each path costs.
 * @author Andreas Regus
 * PIN: B26
 */



public class PertChart {
	/*
	 * Private class variables 
	 * 
	 * table - table to store all the entries from the input 2d array
	 * paths - store all the different paths available in the ArrayHeap
	 * 
	 */
	private NetworkTable table;
	private ArrayHeap paths;
	
	
	
	/**
	 * Constructor
	 *
	 * take in 2d array and input data into table
	 */
	PertChart(String [][] data){	
		table = new NetworkTable();
		
		for(int row = 0; row<data.length; row++){
			table.add(data[row][0], Integer.parseInt(data[row][1]), data[row][2]);
		}		
		
		table.setSuccessors();
		findPaths();
		
	}
	/*
	 * This method will look through the table and find all the different possible paths and calculate the total cost
	 */
	private void findPaths(){
		int cost = 0;
		int newCost = 0;
		ArrayHeapEntry topHeapEntry;
		NetworkEntry netFirstEntry;
		StringListExt entryList;
		StringListExt newEntryList = new StringListExt();
		NetworkEntry succEntry;
		
		//#1
		paths = new ArrayHeap();
		
		//#2
		boolean succAvail = true;
		
		//#3
		netFirstEntry = table.getFirst();
		newCost = netFirstEntry.getCost();
		StringListExt inputFirstLabel = new StringListExt();
		inputFirstLabel.add(netFirstEntry.getLabel());
		paths.insert(newCost,inputFirstLabel);
		
		//#4
		while(succAvail){
			//#a
			succAvail = false;
			
			//#b
			ArrayHeap tempHeap = new ArrayHeap();
			
			//#c
			while(paths.numEntries()>0){
				//#i
				topHeapEntry = paths.remove();
				entryList = topHeapEntry.getList();
				
				//#ii
				String lastEntryName = entryList.getLast();
				
				//#iii
				StringListExt succList = table.getEntry(lastEntryName).getSuccList();
				
				//#iv
				for(int index = 0; index < succList.length();index++){					
					
					for(int position = 0; position <topHeapEntry.getList().length() - 1;position++){
						newEntryList.add(topHeapEntry.getList().get(position));
					}
					newEntryList.add(lastEntryName);
					
					//#1
					String succName = succList.get(index);
					succEntry = table.getEntry(succName);
					
					//#2
					cost += topHeapEntry.getKey() + succEntry.getCost();
					
					//#3			
					newEntryList.add(succName);				
					
					//#4
					tempHeap.insert(cost, newEntryList);
					newEntryList = new StringListExt();
					cost = 0;
					
					//#5
					if(succEntry.getSuccList().length()>0)
						
						//#a
						succAvail = true;					
				}						
			}

			//#d			
			paths = tempHeap;
			
		}
	}
	
	/**
	 * printAllPaths - calls the ArrayHeap.java printAll() method and prints all the heap paths
	 */
	public void printAllPaths(){
		paths.printAll();
	}
}
