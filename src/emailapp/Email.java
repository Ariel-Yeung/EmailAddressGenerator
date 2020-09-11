package emailapp;
import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String campus;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String backupEmail;
	private String universitySuffix = "drexel.edu";
	
	// Constructor
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("New Student: " + this.firstName + " " + this.lastName);
		
		this.campus = setCampus();
		
		this.password = randomPasswordGenerator(defaultPasswordLength);

		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + campus + "." + universitySuffix;
	}
	
	// determine college
	private String setCampus() {
		System.out.print("CAMPUS CODE\n1 for University City\n2 for Center City\n3 for Queen Lane\n4 for Academy of Natural Sciences\nEnter your campus code: ");
		Scanner in = new Scanner(System.in);
		int campus = in.nextInt();
		if (campus == 1) {return "university_city"; }
		else if (campus == 2) {return "center_city"; }
		else if (campus == 3) {return "queen_lane"; }
		else if (campus == 4) {return "academy_of_natural_sciences"; }
		else {return "";}		
	}
	
	// generate default password
	private String randomPasswordGenerator(int length) {
		String potentialChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHJIKLMNOPQRSTUVWXYZ1234567890@#$%!";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int randIndex = (int) (Math.random() * potentialChar.length());
			password[i] = potentialChar.charAt(randIndex);
		}
		return new String(password);
	}
	
	// Get the mailbox capacity
	public int getMailboxCapacity() {
		return this.mailboxCapacity;
	}
	
	// Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// Get the backup email
	public String getBackupEmail() {
		return this.backupEmail;
	}
	// Set a backup email address
	public void setbackupEmail(String otherEmail) {
		this.backupEmail = otherEmail;
	}
	
	// Get password
	public String getPassword() {
		return this.password;
	}
	// Change user password
	public void changePassword(String newPassword) {
		this.password = newPassword;
	}
	
	public String getInfo() {
		return "STUDENT NAME: " + this.firstName + " " + this.lastName +
				"\nCAMPUS: " + this.campus +
				"\nUUNIVERSITY EMAIL: " + this.email + " " +
				"\nMAILBOX CAPACITY: " + this.mailboxCapacity;
	}
}