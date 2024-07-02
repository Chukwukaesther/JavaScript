package chibuzoTask;
import java.util.ArrayList;
import java.util.Scanner;

public class PhonebookApp {
    private static final Scanner input = new Scanner(System.in);
    private static final ArrayList<String[]> phonebook = new ArrayList<>();

    public static void main(String[] args) {
        options();
    }

    public static void options() {
        String menu = """
                WELCOME TO ESTHER'S PHONEBOOK
                1. add contact
                2. find contact by phone number
                3. find contact by first name
                4. find contact by last name
                5. edit contact
                """;
        System.out.print(menu);

        System.out.print("\nEnter your Option: ");
        int option = input.nextInt();
        switch (option) {
            case 1: addContact();
                break;
            case 2: findContactByPhoneNumber();
                break;
            case 3: findContactFirstName();
                break;
            case 4: findContactLastName();
                break;
            case 5: editContact();
                break;

        }

    }

    public static void addContact() {
        System.out.print("Enter your name: ");
        String name = input.next();
        System.out.print("Enter your last name: ");
        String lastName = input.next();
        System.out.print("Enter your phone number: ");
        String phoneNumber = input.next();
        phonebook.add(new String[]{name, lastName, phoneNumber});
        System.out.println(lastName + " \n" + name + " \n" + phoneNumber);
        System.out.println("CONTACT SAVED: ");
        options();


    }

    public static void findContactByPhoneNumber() {
        System.out.print("Enter your phone number: ");
        String contactNumber = input.next();
        for (String[] contact : phonebook) {
            if (contact[2].equals(contactNumber)) {
                System.out.print(contact[0] + " " + contact[1] + " " + contact[2]);
                options();
                return;
            }
        }
        System.out.println("Contact not found");
        options();



    }

         public static void findContactFirstName() {
             System.out.print("Enter your first name: ");
             String firstName = input.next();
             for (String[] contact : phonebook) {
                 if (contact[0].equals(firstName)) {
                     System.out.print("Contact found");
                     return;
                 }

             }
             System.out.println("Contact not found");
         }

    public static void findContactLastName() {
        System.out.print("Enter your first name: ");
        String lastName = input.next();
        for (String[] contact : phonebook) {
            if (contact[0].equals(lastName)) {
                System.out.print("Contact found");
                return;
            }

        }
        System.out.println("Contact not found");
    }


    public static void editContact(){
        System.out.print("Enter The name you want to edit: ");
        String name = input.next();
        System.out.print("Enter The last name you want to edit: ");
        String lastName = input.next();
        System.out.print("Enter The phone number you want to edit: ");
        String phoneNumber = input.next();
        for (String[] contact : phonebook) {
            if (contact[0].equals(phoneNumber)) {
                System.out.print("contact notfound");
            }else{
                contact[0] = name;
                contact[1] = lastName;
                contact[2] = phoneNumber;
                addContact();
            }
        }

    }

}
