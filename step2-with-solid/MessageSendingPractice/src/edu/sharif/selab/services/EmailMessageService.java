package edu.sharif.selab.services;

import edu.sharif.selab.models.EmailMessage;

/**
 * Service for sending Email messages
 */
public class EmailMessageService implements MessageService<EmailMessage> {
    
    @Override
    public void sendMessage(EmailMessage emailMessage) {
        if (validateEmail(emailMessage.getSourceEmailAddress()) && 
            validateEmail(emailMessage.getTargetEmailAddress())) {
            System.out.println("Sending Email message from " + emailMessage.getSourceEmailAddress() + 
                             " to " + emailMessage.getTargetEmailAddress() + 
                             " with content: " + emailMessage.getContent());
        } else {
            throw new IllegalArgumentException("Invalid email address!");
        }
    }

    private boolean validateEmail(String email) {
        // Simple email validation
        return email != null && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
}