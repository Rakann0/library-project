package member;

import java.util.Scanner;

public class LibrarySimulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Account Names & IDs
				final int accountId1 = 1;
				final String accountUsername1 = "User A";

				final int accountId2 = 2;
				final String accountUsername2 = "User B";

				final int accountId3 = 3;
				final String accountUsername3 = "User C";

				// Declare Variables
				int accountBorrowedBooks1 = 0;
				int accountBorrowedBooks2 = 0;
				int accountBorrowedBooks3 = 0;

				float totalRevenue = 0.0f;

				int totalBorrowOperations = 0;
				int totalReturnOperations = 0;

				int sessionTotalBorrowedBooks = 0;
				int sessionTotalReturnedBooks = 0;
				float sessionFeesPaid = 0.0f;
				
				boolean running = true;
				Scanner input = new Scanner(System.in);

				// Selected Account Variables
				boolean adminAccount = false;
				int selectedAccountIndex = -1;

				System.out.println("Welcome to Library !");

				// Main Loop
				while (running) {
					if (selectedAccountIndex >= 0 && selectedAccountIndex <= 2) { // User Operations Menu
						int accountId = 0;
						String accountUsername = "";

						int accountBorrowedBooks = 0;

						// Get Account ID, Name and Borrowed Books for the selected index
						switch (selectedAccountIndex) {
						case 0:
							accountId = accountId1;
							accountUsername = accountUsername1;
							accountBorrowedBooks = accountBorrowedBooks1;
							break;
						case 1:
							accountId = accountId2;
							accountUsername = accountUsername2;
							accountBorrowedBooks = accountBorrowedBooks2;
							break;
						case 2:
							accountId = accountId3;
							accountUsername = accountUsername3;
							accountBorrowedBooks = accountBorrowedBooks3;
							break;
						default:
							break;
						}

						// Display possible operations for user account
						System.out.println();
						System.out.println("- User: " + accountUsername + " (ID: " + accountId + ")");
						System.out.println("» Enter the number of one of the following operations:");
						System.out.println(" 1- Borrow Book");
						System.out.println(" 2- Return Book");
						System.out.println(" 3- View Borrowed Books Count");
						System.out.println(" 4- View Session Summary");
						System.out.println(" 5- Exit to Main Menu");

						// Read operation from user
						int operation = input.nextInt();

						// Apply operation
						switch (operation) {
						case 1: // Borrow Book
							if (accountBorrowedBooks >= 5) {
								System.out.println("✘ You can't borrow more than 5 books");
							} else {
								accountBorrowedBooks += 1;

								sessionTotalBorrowedBooks += 1;
								sessionFeesPaid += 0.5f;

								totalRevenue += 0.5f;
								totalBorrowOperations += 1;

								System.out.println("✔ A book has been borrowed successfully");
							}

							break;
						case 2: // Return Book
							if (accountBorrowedBooks >= 1) {
								accountBorrowedBooks -= 1;
								sessionTotalReturnedBooks += 1;

								totalReturnOperations += 1;
								System.out.println("✔ A book has been returned successfully");
							} else {
								System.out.println("✘ You don't have books to return");
							}

							break;
						case 3: // View Borrowed Books Count
							System.out.printf("- Borrowed Books Count: %d books\n", accountBorrowedBooks);
							break;
						case 4: // Session Summary
							System.out.println("Session Summary:");
							System.out.printf("- Total Borrowed Books: %d books\n", sessionTotalBorrowedBooks);
							System.out.printf("- Total Returned Books: %d books\n", sessionTotalReturnedBooks);
							System.out.printf("- Total Fees Incurred: %.2f credit fee\n", sessionFeesPaid);

							break;
						case 5: // Return to Main Menu
							selectedAccountIndex = -1;
							break;
						default:
							System.out.println("✘ Invalid operation: " + operation);
							break;
						}

						// Update account-specific variable for borrowed books
						switch (selectedAccountIndex) {
						case 0:
							accountBorrowedBooks1 = accountBorrowedBooks;
							break;
						case 1:
							accountBorrowedBooks2 = accountBorrowedBooks;
							break;
						case 2:
							accountBorrowedBooks3 = accountBorrowedBooks;
							break;
						default:
							break;
						}
					} else if (adminAccount) { // Admin Operations Menu
						// Display admin account operations
						System.out.println();
						System.out.println("» Enter the number of one of the following operations:");
						System.out.println(" 1- View Total Revenue");
						System.out.println(" 2- View Most Frequent Operation");
						System.out.println(" 3- Exit to Main Menu");

						// Read operation from user
						int operation = input.nextInt();

						// Apply operation
						switch (operation) {
						case 1: // View total revenue
							System.out.printf("- Total Revenue: %.2f credit fee\n", totalRevenue);
							break;
						case 2: // View most frequent operation
							if (totalBorrowOperations == totalReturnOperations) {
								System.out.println("- Borrow Operations: " + totalBorrowOperations + " operations");
								System.out.println("- Return Operations: " + totalReturnOperations + " operations");
							} else {
								System.out.println("- Borrow Operations (most frequent): " + totalBorrowOperations + " operations");
							}

							break;
						case 3: // Exit to main menu
							adminAccount = false;
							break;
						default:
							System.out.println("✘ Invalid operation: " + operation);
							break;
						}
					} else { // Main Menu
						// Display main menu
						System.out.println();
						System.out.println("» Enter the number of one of the following options to login or exit:");

						System.out.printf(" 1- %s (ID: %d)\n", accountUsername1, accountId1);
						System.out.printf(" 2- %s (ID: %d)\n", accountUsername2, accountId2);
						System.out.printf(" 3- %s (ID: %d)\n", accountUsername3, accountId3);

						System.out.println(" 4- Admin Account");
						System.out.println(" 5- Exit");

						// Read option from user
						int option = input.nextInt();

						// Do action based on option
						switch (option) {
						// Login as User
						case 1:
						case 2:
						case 3:
							selectedAccountIndex = option - 1;

							sessionTotalBorrowedBooks = 0;
							sessionTotalReturnedBooks = 0;
							sessionFeesPaid = 0.0f;

							break;
						case 4: // Login as Admin
							adminAccount = true;
							break;
						case 5: // Exit from Program
							running = false;
							break;
						default:
							System.out.println("✘ Invalid option: " + option);
							break;
						}
					}
				}
			}

}