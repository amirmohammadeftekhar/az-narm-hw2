package edu.sharif.selab.services;

import edu.sharif.selab.models.EmailMessage;
import edu.sharif.selab.models.Message;
import edu.sharif.selab.models.SmsMessage;
import edu.sharif.selab.models.TelegramMessage;

/**
 * Factory for creating message services based on message type
 * This addresses the Open-Closed Principle by centralizing the creation of services
 */
public class MessageServiceFactory {
    
    /**
     * Creates and returns the appropriate message service based on the message type
     * 
     * @param message The message that needs to be sent
     * @return A message service that can send the given message
     */
    @SuppressWarnings("unchecked")
    public static <T extends Message> MessageService<T> createService(T message) {
        if (message instanceof SmsMessage) {
            return (MessageService<T>) new SmsMessageService();
        } else if (message instanceof EmailMessage) {
            return (MessageService<T>) new EmailMessageService();
        } else if (message instanceof TelegramMessage) {
            return (MessageService<T>) new TelegramMessageService();
        } else {
            throw new IllegalArgumentException("Unknown message type: " + message.getClass().getName());
        }
    }
} 