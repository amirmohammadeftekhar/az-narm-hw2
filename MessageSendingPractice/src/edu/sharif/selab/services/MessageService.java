package edu.sharif.selab.services;

import edu.sharif.selab.models.Message;

/**
 * General interface for message services
 * This addresses the Interface Segregation Principle by being a focused interface
 */
public interface MessageService<T extends Message> {
    /**
     * Sends a message
     * @param message the message to be sent
     */
    void sendMessage(T message);
}