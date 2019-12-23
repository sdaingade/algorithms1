package algos.util;

/*
 * Comparable allows us to sort using the types natural order
 * 
 * Comparator interface allows us to sort using an alternate order.
 * 
 * See video 9.1 Implementing equals for user-defined types
 */
public final class  Date implements Comparable<Date> {
	
	private int _day;
	
	private int _month;
	
	private int _year;
	
	public Date(int day, int month, int year) {
		_day = day;
		_month = month;
		_year = year;
	}

	public int compareTo(Date that) {

		if (_year < that._year) return -1;
		else if (_year > that._year) return 1;
		else if(_month < that._month) return -1;
		else if(_month > that._month) return 1;
		else if (_day < that._day) return -1;
		else if (_day > that._day) return 1;
		else return 0;
	}
	
	public boolean equals(Object y) { // must be Object
		if (y == this) return true;
		
		if (y == null) return false;
		
		if(y.getClass() != this.getClass()) return false;
		
		Date that = (Date) y;

		if (_day != that._day) return false;
		if (_month != that._month) return false;
		if(_year != that._year) return false;
		return true;
	}
	
}