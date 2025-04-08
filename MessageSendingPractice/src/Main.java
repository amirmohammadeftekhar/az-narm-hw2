import edu.sharif.selab.models.EmailMessage;
import edu.sharif.selab.models.Message;
import edu.sharif.selab.models.SmsMessage;
import edu.sharif.selab.models.TelegramMessage;
import edu.sharif.selab.services.MessageProcessor;
import edu.sharif.selab.services.ServiceLocator;

import java.util.Scanner;

/**
 * Main class for the messaging application
 * Uses the new architecture that follows SOLID principles
 */
public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Initialize services
        ServiceLocator.initialize();
        
        // Get the message processor from the service locator
        MessageProcessor messageProcessor = ServiceLocator.get(MessageProcessor.class);
        
        System.out.println("Hello and Welcome to SE Lab Messenger.");
        int userAnswer = 0;
        
        do {
            System.out.println("In order to send Sms message enter 1");
            System.out.println("In order to send Email message enter 2");
            System.out.println("In order to send Telegram message enter 3");
            System.out.println("In order to Exit, Enter 0");

            userAnswer = scanner.nextInt();

            if (userAnswer == 0) {
                break;
            }

            // Create message based on user choice
            Message message = createMessage(userAnswer);
            
            if (message != null) {
                try {
                    // Process the message
                    messageProcessor.processMessage(message);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else {
                System.out.println("Invalid option selected.");
            }

        } while (true);
        
        System.out.println("Thank you for using SE Lab Messenger. Goodbye!");
    }
    
    /**
     * Creates a message based on user input
     * @param messageType The type of message to create
     * @return The created message
     */
    private static Message createMessage(int messageType) {
        String source;
        String target;
        String content;
        
        switch (messageType) {
            case 1:
                SmsMessage smsMessage = new SmsMessage();
                System.out.print("Enter source phone: ");
                source = scanner.next();
                smsMessage.setSourcePhoneNumber(source);
                System.out.print("Enter target phone: ");
                target = scanner.next();
                smsMessage.setTargetPhoneNumber(target);
                System.out.println("Write Your Message: ");
                scanner.nextLine(); // Consume newline
                content = scanner.nextLine();
                smsMessage.setContent(content);
                return smsMessage;
                
            case 2:
                EmailMessage emailMessage = new EmailMessage();
                System.out.print("Enter source email: ");
                source = scanner.next();
                emailMessage.setSourceEmailAddress(source);
                System.out.print("Enter target email: ");
                target = scanner.next();
                emailMessage.setTargetEmailAddress(target);
                System.out.println("Write Your Message: ");
                scanner.nextLine(); // Consume newline
                content = scanner.nextLine();
                emailMessage.setContent(content);
                return emailMessage;
                
            case 3:
                TelegramMessage telegramMessage = new TelegramMessage();
                System.out.print("Enter source Telegram ID (e.g., @username): ");
                source = scanner.next();
                telegramMessage.setSourceTelegramId(source);
                System.out.print("Enter target Telegram ID (e.g., @username): ");
                target = scanner.next();
                telegramMessage.setTargetTelegramId(target);
                System.out.println("Write Your Message: ");
                scanner.nextLine(); // Consume newline
                content = scanner.nextLine();
                telegramMessage.setContent(content);
                return telegramMessage;
                
            default:
                return null;
        }
    }
}