package edu.sharif.selab.services;

import edu.sharif.selab.models.TelegramMessage;

/**
 * Service for sending Telegram messages
 */
public class TelegramMessageService implements MessageService<TelegramMessage> {
    
    @Override
    public void sendMessage(TelegramMessage telegramMessage) {
        if (validateTelegramId(telegramMessage.getSourceTelegramId()) && 
            validateTelegramId(telegramMessage.getTargetTelegramId())) {
            System.out.println("Sending Telegram message from " + telegramMessage.getSourceTelegramId() + 
                             " to " + telegramMessage.getTargetTelegramId() + 
                             " with content: " + telegramMessage.getContent());
        } else {
            throw new IllegalArgumentException("Invalid Telegram ID!");
        }
    }

    private boolean validateTelegramId(String telegramId) {
        // Telegram IDs typically start with @ and contain letters, numbers, and underscores
        return telegramId != null && telegramId.matches("^@[a-zA-Z0-9_]+$");
    }

    @Override
    public void sendEmailMessage(TelegramMessage telegramMessage) {
        // This method is not used for Telegram messages
        throw new UnsupportedOperationException("Email sending is not supported for Telegram messages");
    }
} 