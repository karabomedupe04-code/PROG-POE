package com.mycompany.chatappregistation;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



/**
 *
 * @author Student
 */

import java.util.Scanner;

public class ChatAppRegistration {

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        //Scanner for ChatAppLogin
        login login = new login();
        
        //Registration Welcome Message
        System.out.println("-----Register-----");
        
        //User first name
        System.out.print("Please enter your first name: ");
        String firstName = input.nextLine();
        
        //User last name
        System.out.print("Please enter your last name: ");
        String lastName = input.nextLine();
        
        //Username Validation
        System.out.print("Please enter a username which is no more than 5 characters long and contains an underscore: ");
        String username = input.nextLine();

        //Password Validation
        System.out.print("Please enter a password which is at least eight characters long and contains a capital letter, a number and a special character: ");
        String password = input.nextLine();

        //Cellphone Number Validation
        System.out.print("Enter your cellphone number: ");
        String cellphoneNumber = input.nextLine();

        String result = login.registeredUser(username, password, cellphoneNumber);
        System.out.println(result);

        //login
         if (result.contains("successfully")) {
            System.out.println("\n--------Login-------");
            System.out.println("Enter your username to login: ");
            String loginUsername = input.nextLine();
            System.out.println("Enter password to login: ");
            String loginPassword = input.nextLine();
            System.out.println(login.returnLoginStatus(firstName, lastName, username, password, loginUsername, loginPassword));
         
            boolean status = login.loginUser(loginUsername, loginPassword, loginUsername, loginPassword);
            
            if (status){
            
                System.out.println("Welcome To QuickChat");
                System.out.println("option 1) send messages");
                System.out.println("option 2) Show recently sent messages - Coming Soon");
                System.out.println("option 3) Quit");
                
                int option = Integer.parseInt(input.nextLine());
                
                switch (option) {
                    
                    case 1 :
                        System.out.println("How many messages would you like to send? ");
                        
                        int total = Integer.parseInt(input.nextLine());
                        
                        for (int i = 1 ; i <= total; i++) {
                            System.out.println("");
                            System.out.println("=========== Message " + i + "============");
                            System.out.println("Enter recipient number: ");
                            String recipient = input.nextLine();
                            System.out.println("Enter message: ");
                            String messageText = input.nextLine();
                            
                            if (messageText.length() >250) {
                                System.out.println("Please enter a message of less than 250 characters.");
                                i--;
                                continue;
                                
                            }
                            Message msg = new Message( i,recipient, messageText);
                            
                            if (msg.checkMessageID()) {
                                System.out.println("Message ID successfully captured.");
                            }
                            System.out.println(msg.checkRecipientCell());
                            System.out.println("Message Hash: " + msg.createMessageHash());
                            System.out.println(msg.sentMessage());
                            System.out.println(msg.printMessages());
                        }
                        System.out.println("Total messages sent: " + Message.returnTotalMessages());
                        break;
                        
                    case 2 :
                        System.out.println("""
                                           
                                           STORED MESSAGE MENU
                                           
                                           a) Display the sender and reeceipient of all stored messages.
                                           b) Display the longest stored message.
                                           c) Search for a message ID and display the corresponding recipient and message.
                                           d) Search for all the messages stored for a particular recipient.
                                           e) Delete a message using the message hash.
                                           f) Display a report that lists the full details of all the stored messages.
                                           """);
                        
                        System.out.println("Select option: ");
                        
                        String reportChoice = input.nextLine().toLowerCase();
                        
                        switch(reportChoice) {
                            
                            case "a":
                                MessageReport.displaySenderRecipient();
                                break;
                                
                            case "b":
                                MessageReport.displayLongestMessage();
                                break;
                                
                            case "c":
                                System.out.println("Enter Message ID: ");
                                String id = input.nextLine();
                                MessageReport.searchMessageID(id);
                                break;
                                
                            case "d":
                                System.out.println("Enter Recipient: ");
                                String recipientSearch = input.nextLine();
                                MessageReport.searchRecipient(recipientSearch);
                                break;
                                
                            case "e":
                                System.out.println("Enter Message Hash: ");
                                String hash = input.nextLine();
                                MessageReport.deleteMessage(hash);
                                break;
                                
                            case "f":
                                MessageReport.displayReport();
                                break;
                                
                            default:
                                System.out.println("Invalid selection.");                                
                        }
                        break;
                        
                    case 3 :
                        System.out.println("Goodbye.");
                        System.exit(0);
                        break;
                        
                    default:
                        System.out.println("Invalid option entered, please enter correct option. ");
                        
                        
                        
                }
            }
}
        
    input.close();
                       
    }
}
