package edu.sharif.selab.services;

import edu.sharif.selab.models.EmailMessage;
import edu.sharif.selab.models.SmsMessage;

/**
 * Service for sending SMS messages
 */
public class SmsMessageService implements MessageService<SmsMessage> {
    
    @Override
    public void sendMessage(SmsMessage smsMessage) {
        if (validatePhoneNumber(smsMessage.getSourcePhoneNumber()) && 
            validatePhoneNumber(smsMessage.getTargetPhoneNumber())) {
            System.out.println("Sending SMS message from " + smsMessage.getSourcePhoneNumber() + 
                             " to " + smsMessage.getTargetPhoneNumber() + 
                             " with content: " + smsMessage.getContent());
        } else {
            throw new IllegalArgumentException("Invalid phone number!");
        }
    }

    @Override
    public void sendEmailMessage(EmailMessage emailMessage) {
        //Empty Body!
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        // Simple validation for phone numbers
        return phoneNumber != null && phoneNumber.matches("^[0-9]{10,15}$");
    }
}