package heapPKG;
/**
 * This Class creates and performs several functions on a ArrayList specified for Strings.
 * @author Andreas Regus
 * PIN: B26
 */



import java.util.*;


class StringList {

	/**
	 * Class level variable to store Strings
	 */
	
	protected ArrayList <String> list;
	
	/**
	 * StringList - create a new ArrayList of String
	 * 
	 */
	
	StringList () {
		list = new ArrayList <String>();
	}
	
	/**
	 * search - find the first occurrence of the String parameter in the list
	 * @param item
	 * @return location of String in list
	 */
	
	public int search (String item) {
		
		int index = -1;
		
		if (list.size() > 0) {
			index = 0;
			boolean cont = true;
			
			while (index < list.size() && cont) 
				if (list.get(index).equals(item))
					cont = false;
				else
					index++;
			if (cont)
				index = -1;
		}
		
		return index;
	}
	
	/**
	 * toString - return the ArrayList as String.  All String are followed by a single space.
	 * @return String representation of ArrayList
	 */
	
	public String toString (){
		
		String str = "";
		
		for (int index = 0; index < list.size(); index++)
			str += list.get(index) + " ";
		return str;
	}
	
	/**
	 * insert - insert the String parameter in the list so that the Strings are in order and 
	 * there are not duplicate values
	 * 
	 * @param item
	 */
	
	public void insert (String item) {
	
		if (list.size() == 0 || list.get(0).compareTo(item) > 0)
			list.add(0, item);
		else {
			int pos = 0;
			while (pos < list.size() && list.get(pos).compareTo(item) < 0)
				pos++;
				if (pos == list.size())
					list.add(item);
				else
					if (!list.get(pos).equals(item))
						list.add(pos, item);
		}
	}
	
}