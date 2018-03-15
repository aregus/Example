package heapPKG;
/**
 * This Class creates a Network Entry node and all its associated variables and perform several functions on the node.
 * @author Andreas Regus
 * PIN: B26
 */




public class NetworkEntry {

	private String nodeLabel;
	private int cost;
	private StringListExt predList;
	private StringListExt succList;

	/**
	 * NetworkEntry
	 *
	 * Set the node name and cost
	 * Create the predList and succList
	 * Insert the predecessor parameter into the predList
	 *
	 * @param name node
	 * @param val cost
	 * @param pred predecessor
	 */

	NetworkEntry (String name, int val, String pred) {
		nodeLabel = name;
		cost = val;
		predList = new StringListExt ();
		predList.insert(pred);
		succList = new StringListExt ();
	}

	/**
	 * addSucc
	 *
	 * insert the node name into the successor list
	 *
	 * @param succ name of successor
	 */

	public void addSucc (String succ) {
		succList.insert(succ);
	}

	/**
	 * addPred
	 *
	 * insert the node name into the predecessor list
	 *
	 * @param pred name of the predecessor
	 */
	public void addPred (String pred) {
		predList.insert(pred);
	}

	/**
	 * getPredList
	 *
	 * return list of predecessors
	 *
	 * @return predList
	 */

	public StringListExt getPredList () {
		return predList;
	}

	/**
	 * getSuccList
	 *
	 * return list of successors
	 *
	 * @return succList
	 */

	public StringListExt getSuccList () {
		return succList;
	}

	/**
	 * getLabel
	 *
	 * return node name
	 *
	 * @return nodeLable
	 */

	public String getLabel() {
		return nodeLabel;
	}

	/**
	 * getCost
	 *
	 * return integer value
	 *
	 * @return cost
	 */
	public int getCost () {
		return cost;
	}

	/**
	 * toString
	 *
	 * return contents of NetworkEntry as a string
	 *
	 * @return string
	 */

	public String toString () {

		String result = nodeLabel + " " + cost + " " + "Pred ";

		for (int pos = 0; pos < predList.length(); pos++)
			result += predList.get(pos) + " ";

		result += "Succ ";
		for (int pos = 0; pos < succList.length(); pos++)
			result += succList.get(pos) + " ";

		return result;

	}
}


