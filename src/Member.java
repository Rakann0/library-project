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
		this.numViewBorrowed = 0;
		this.numBorrows = 0;
		this.numReturns = 0;
		this.sessionFees = 0.0;
	}
	
	// A method to check if member can borrow (not more than 5)
	private boolean canBorrow() {
		if (borrowedCount < 5) {
			return true;
		} else {	
			return false;
		}
	}
	
	// A method to check if member can return (must have at least 1 book)
	private boolean canReturn() {
		if (borrowedCount > 0) {
			return true;
		} else 
			return false;
		}

	
	// A method that displays borrowed count
	public void viewBorrowedCount() {
		this.numViewBorrowed += 1;
		TotalViewBorrowed += 1;
		
		System.out.println("- Borrowed Books Count: " + borrowedCount + " books");
	}
	
	// A method that tries to borrow one book
	public boolean borrowOne() {
		if (!canBorrow()) {
			return false;
		}
		
		this.borrowedCount += 1;

		this.numBorrows += 1;
		this.sessionFees += 0.5f;

		TotalRevenue += 0.5f;
		TotalBorrows += 1;
		return true;
	}
	
	// A method that tries to return one book
	public boolean returnOne() {
		if (!canReturn()) {
			return false;
		}
		
		this.borrowedCount -= 1;
		this.numReturns += 1;
		
		TotalReturns += 1;
		return true;
	}
	
	// A method that displays member's session statistics
	public void displayStatistics() {
		System.out.println("Session Summary for " + name + ":");
		System.out.println("- Times viewed borrowed books: " + numViewBorrowed);
		System.out.println("- Books borrowed this session: " + numBorrows);
		System.out.println("- Books returned this session: " + numReturns);
		System.out.printf("- Total fees incurred: %.2f credits%n", sessionFees);
	}
	
	// A method that resets the statistics
	public void reset() {
		this.numViewBorrowed = 0;
		this.numBorrows = 0;
		this.numReturns = 0;
		this.sessionFees = 0.0;
	}

	// Getters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getBorrowedCount() {
		return borrowedCount;
	}


}
