package heapPKG;
/**
 * This Class is creates a ArrayList of the NetworkEntry elements and perform server methods on the list.
 * @author Andreas Regus
 * PIN: B26
 */




import java.util.*;

public class NetworkTable {

	private ArrayList<NetworkEntry> table;
	private StringListExt lookup;

	/**
	 * GraphTable
	 *
	 * Create an empty table and lookup list
	 */

	NetworkTable () {
		table = new ArrayList<NetworkEntry>();
		lookup = new StringListExt();
	}

	/**
	 * print
	 *
	 * Print all entries in the table, one entry per line
	 *
	 */

	public void print() {

		for (int pos = 0; pos < table.size(); pos++)
			System.out.println(table.get(pos).toString());
	}

	/**
	 * add
	 *
	 * Add the information on a node into the table.  If the node already appears, add the
	 * predecessor to its predecessor list
	 *
	 * @param name - name of node
	 * @param val - weight of the node
	 * @param pred - name of a node that precedes the node
	 *
	 */

	public void add (String name, int val, String pred) {

		NetworkEntry entry;

		int loc = lookup.search (name);
		if (loc == -1) {  // node is not in table
			entry = new NetworkEntry (name, val, pred);

			table.add(entry);
			if (lookup.search(name) == -1)
				lookup.add(name);
		}
		else {
			entry = table.get(loc);
			entry.addPred (pred);
		}
	}

	/**
	 * setSuccessors
	 *
	 * Work through the table and set all successors for each node
	 *
	 */

	public void setSuccessors () {

		for (int pos = 0; pos < table.size(); pos++){

			String nodeName = table.get(pos).getLabel();
			StringListExt predList = table.get(pos).getPredList();

			for (int predPos = 0; predPos < predList.length(); predPos++) {

				String pred = predList.get(predPos);

				if (!pred.equals("-")) {

					int tempPos = lookup.search(pred);
					if (tempPos != -1)
						table.get(tempPos).addSucc(nodeName);
				}
			}
		}
	}
	/*
	 * getFirst - will return first entry in the Network
	 */
	public NetworkEntry getFirst(){
		int location = 0;
		for(int index = 0; index < table.size(); index++){
			if(table.get(index).getPredList().get(0).compareToIgnoreCase("-") == 0){
				location = index;
			}
		}
		return table.get(location);		
	}
	
	/*
	 * getEntry - will return entry that matches the string passed in
	 * @param name - name of string to be found
	 */
	public NetworkEntry getEntry(String name){
		int location = 0;
		for(int index = 0; index < table.size(); index++){
			if(table.get(index).getLabel().compareToIgnoreCase(name) == 0){
				location = index;
			}
		}
		return table.get(location);	
	}
}
