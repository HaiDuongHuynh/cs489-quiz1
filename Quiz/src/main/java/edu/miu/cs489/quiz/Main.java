package edu.miu.cs489.quiz;

import edu.miu.cs489.quiz.model.Contact;
import edu.miu.cs489.quiz.model.EmailAddress;
import edu.miu.cs489.quiz.model.PhoneNumber;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contact> contacts = sampleContact();

        printContactData(contacts);
    }
    public static List<Contact> sampleContact(){
        List<Contact> contacts = new ArrayList<>();
        List<PhoneNumber> davidPhone = new ArrayList<>();
        List<EmailAddress> davidEmail = new ArrayList<>();
        List<PhoneNumber> aliPhone = new ArrayList<>();
        List<EmailAddress> aliEmail = new ArrayList<>();
        davidPhone.add(new PhoneNumber("240-133-0011","Home"));
        davidPhone.add(new PhoneNumber("240-112-0123","Work"));
        aliPhone.add(new PhoneNumber("412-116-9988", "Work"));
        davidEmail.add(new EmailAddress("dave.sang@gmail.com", "Home"));
        davidEmail.add(new EmailAddress("dsanger@argos.com", "Work"));
        aliEmail.add(new EmailAddress("ali@bmi.com", "Work"));
        contacts.add(new Contact("David", "Sanger", "Argos LLC", "Sales Manager", davidEmail, davidPhone));
        contacts.add(new Contact("Carlos","Jimenez", "Zappos", "Director", null, null));
        contacts.add(new Contact("Ali", "Gafar", "BMI Services", "HR Manager", aliEmail, aliPhone));
        return contacts;
    }

    public static void printContactData(List<Contact> contacts){
        contacts.sort(Comparator.comparing(Contact::getLastName));
        System.out.println("[");
        for(Contact c: contacts){
            System.out.print("  {");
            System.out.print("\"first name\": " + c.getFirstName() + ",");
            System.out.print("\"last name\": " + c.getLastName() + ",");
            System.out.print("\"company\": " + c.getCompany() + ",");
            System.out.print("\"job title\": " + c.getJobTitle() + ",");
            System.out.print("\"phone numbers\": " + c.getPhones() + ",");
            System.out.print("\"email addresses\": " + c.getEmails() + ",");
            System.out.println("},");
        }
        System.out.println("]");
    }
}
