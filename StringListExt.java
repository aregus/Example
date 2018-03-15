package heapPKG;
/**
 * This Class is a subclass of StringList and performs several functions on a ArrayList specified for Strings.
 * @author Andreas Regus
 * PIN: B26
 */




import heapPKG.StringList;

public class StringListExt extends StringList{

	/**
	 * add new item to end of list
	 *
	 * @param item
	 */
	public void add (String item) {
		list.add(item);
	}

	/**
	 * get copy of String at position
	 *
	 * @param pos
	 * @return String value
	 */
	public String get (int pos){

		String ret = "";

		if (list.size() > 0)
			ret = list.get(pos);
		return ret;
	}

	/**
	 * return number of items in list
	 *
	 * @return length of list
	 */
	public int length () {

		return list.size();
	}

	/**
	 * return last item in list.  If list is empty, return empty String
	 *
	 * @return last item in list
	 */
	public String getLast () {

		String val = "";
		if (list.size() > 0)
			val = list.get(list.size() - 1);
		return val;
	}

	/**
	 * find occurrence of String in list and remove from list.  If String is not
	 * present, then nothing is done.
	 *
	 * @param str to find and remove
	 */
	public void remove (String str) {
		int pos = search (str);

		if (pos != -1)
			list.remove(pos);
	}
}