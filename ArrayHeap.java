package heapPKG;
/**
 * This Class is a subclass of StringList and performs several functions on a ArrayList specified for Strings.
 * @author Andreas Regus
 * PIN: B26
 */



import java.util.*;


public class ArrayHeap {

	/**
	 * Constructor
	 *
	 * Create an empty heap
	 */

	private ArrayList<ArrayHeapEntry> table;

	ArrayHeap () {
		table = new ArrayList<ArrayHeapEntry> ();
	}

	/**
	 * insert
	 *
	 * Create an entry from the parameters and then insert the entry into
	 * the last position.  The heap is then reconstructed.
	 *
	 * @param val
	 * @param list
	 */

	public void insert (int val, StringListExt list) {

		ArrayHeapEntry temp = new ArrayHeapEntry (val, list);

		table.add(temp);

		reheap (table.size() - 1);
	}

	/*
	 * reheap
	 *
	 * Private method to assist in insert into the heap.  The entry in the
	 * heap is compared to the parent and moved up the array.
	 *
	 */

	private void reheap (int lastPos) {

		int parent = (lastPos - 1) / 2;

		if (parent >= 0) {
			if (table.get(parent).getKey() < table.get(lastPos).getKey()) {
				swap (parent, lastPos);
				reheap (parent);
			}
		}
	}

	/*
	 * swap
	 *
	 * Exchange the entries at the positions indicated.
	 *
	 */

	private void swap (int pos1, int pos2) {

		ArrayHeapEntry temp = table.get(pos1);
		table.set(pos1, table.get(pos2));
		table.set(pos2, temp);
	}

	/**
	 * newEntries
	 *
	 * Return the current size of the array
	 *
	 * @return count of items in array
	 */

	public int numEntries() {
		return table.size();
	}

	/*
	 * heapDown
	 *
	 * Method to help with the delete method.  An entry is compared to
	 * its children and swapped if needed.
	 *
	 */
	private void heapDown (int pos) {

		int size = table.size();
		int leftPos = (pos + 1) * 2 - 1;
		int rightPos = (pos + 1) * 2;
		int swapPos = leftPos;

		if (leftPos < size) {
			if (rightPos < size)
				if (table.get(leftPos).getKey() < table.get(rightPos).getKey())
					swapPos = rightPos;
			if (table.get(pos).getKey() < table.get(swapPos).getKey()) {
				swap (pos, swapPos);
				heapDown (swapPos);
			}
		}
	}

	/**
	 * remove
	 *
	 * The first entry in the array is returned and then the heap
	 * is adjusted.
	 *
	 * @return first entry
	 */

	public ArrayHeapEntry remove () {

		ArrayHeapEntry entry = null;
		int size = table.size();

		if (size >= 1) {
			entry = table.get(0);
			table.set(0, table.get(size - 1));
			table.remove(size - 1);
			heapDown (0);
		}

		return entry;
	}
	
	/**print - traverse the ArrayHeap and print all entries
	 */
	public void print(){
		for(int index = 0; index < table.size(); index++){
			System.out.println(table.get(index).toString());
		}
		System.out.println("");
	}
	
	/**printAll - traverse the ArrayHeap and print all entries from largest to smallest key
	 */
	public void printAll(){
		for(int index = 0; index < table.size(); index++){
			System.out.println(table.get(index).toString());
		}
		System.out.println("");
		
	}

}