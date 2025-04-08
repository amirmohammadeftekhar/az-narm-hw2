package edu.sharif.selab.services;

import edu.sharif.selab.models.Message;

/**
 * Message processor that uses the Strategy Pattern
 * This addresses the Open-Closed Principle by allowing new message types
 * without modifying the processor
 */
public class MessageProcessor {
    
    /**
     * Processes and sends a message using the appropriate service
     * @param message The message to be sent
     * @param <T> The type of message
     */
    public <T extends Message> void processMessage(T message) {
        MessageService<T> service = MessageServiceFactory.createService(message);
        service.sendMessage(message);
    }
} 