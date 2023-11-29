import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + emailAddress;
    }
}

class AddressBook {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(String name) {
        contacts.removeIf(contact -> contact.getName().equals(name));
    }

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public void displayAllContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}

public class AddressBookSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search for Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();

                    System.out.print("Enter email address: ");
                    String emailAddress = scanner.nextLine();

                    // Input validation
                    if (!name.isEmpty() && !phoneNumber.isEmpty() && !emailAddress.isEmpty()) {
                        Contact newContact = new Contact(name, phoneNumber, emailAddress);
                        addressBook.addContact(newContact);
                        System.out.println("Contact added successfully!");
                    } else {
                        System.out.println("Error: Name, phone number, and email address cannot be empty.");
                    }
                    break;

                case 2:
                    System.out.print("Enter name to remove: ");
                    String removeName = scanner.nextLine();
                    addressBook.removeContact(removeName);
                    System.out.println("Contact removed successfully!");
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    Contact foundContact = addressBook.searchContact(searchName);
                    if (foundContact != null) {
                        System.out.println("Contact found: " + foundContact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    System.out.println("All Contacts:");
                    addressBook.displayAllContacts();
                    break;

                case 5:
                    System.out.println("Exiting Address Book System bye");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
