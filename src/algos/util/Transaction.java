package algos.util;

public class Transaction{
	private String _who;
	private Date _when;
	private double _amount;
	
	public Transaction(String who, Date when, double amount) {
		_who = who;
		_when = when;
		_amount = amount;
	}
	
	/*
	 * Standard recipe for computing hashCode of user defined types
	 * * Combine each significant field using the 31* hash + y.hashCode() rule
	 * * If the field is a primitive type, use wrapper types hashCode()
	 * * If a field is null, return 0.
	 * * If a field is a reference type, use hashCode() (apply this rule recursively)
	 * * If a field is an array, apply to each entry. (or use Arrays.deepHashCode())
	 */
	public int hashCode( ) {
		int hash = 17; //start with a prime number
		
		// Make sure every member field contributes to the hash
		hash = 31* hash + _who.hashCode();
		hash = 31* hash + _when.hashCode();
		hash = 31*hash + new Double(_amount).hashCode();
		
		return hash;
	}
}