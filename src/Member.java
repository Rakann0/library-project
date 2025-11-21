public class Member {
	private int id;
	private String name;
	private int borrowedCount;
	
	private int numViewBorrowed;
	private int numBorrows;
	private int numReturns;
	
	private double sessionFees;

	public static double TotalRevenue = 0;
	public static int TotalViewBorrowed = 0;
	public static int TotalBorrows = 0;
	public static int TotalReturns = 0;

	// Constructor
	public Member(int id, String name, int borrowedCount) {
		this.id = id;
		this.name = name;
		this.borrowedCount = borrowedCount;
	}
	
	private boolean canBorrow() {
		return false;
	}
	
	private boolean canReturn() {
		return false;
	}
	
	public void viewBorrowedCount() {
		
	}
	
	public boolean borrowOne() {
		return false;
	}
	
	public boolean returnOne() {
		return false;
	}
	
	public void displayStatistics() {
		
	}
	
	public void reset() {
		
	}
}
