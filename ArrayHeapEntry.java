package heapPKG;
/**
 * This Class is a subclass of StringList and performs several functions on a ArrayList specified for Strings.
 * @author Andreas Regus
 * PIN: B26
 */


public class ArrayHeapEntry {
	
	/*
	 * Private class variables 
	 * 
	 * key - integer value of the entry used for comparison
	 * nodeList - a list of Strings with additional information
	 */
	
	private int key;
	private StringListExt nodeList;
	
	/**
	 * ArrayHeapEntry
	 * 
	 * Create an entry from the parameters
	 * 
	 * @param keyVal
	 * @param list
	 */
	
	ArrayHeapEntry (int keyVal, StringListExt list) {
		key = keyVal;
		nodeList = new StringListExt();
		for (int pos = 0; pos < list.length(); pos++)
			nodeList.add(list.get(pos));
	}
	
	/**
	 * getKey
	 * 
	 * Return the key value
	 * 
	 * @return key
	 */
	
	public int getKey () {
		return key;
	}
	
	/**
	 * getList
	 * 
	 * Return the list of Strings
	 * 
	 * @return list
	 */
	
	public StringListExt getList () {
		return nodeList;
	}
	
	/**
	 * toString
	 * 
	 * Return the contents of the entry as a string
	 */
	
	public String toString () {
		return key + " " + nodeList.toString();
	}

}