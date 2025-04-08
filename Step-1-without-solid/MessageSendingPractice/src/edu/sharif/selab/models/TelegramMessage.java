package edu.sharif.selab.models;

public class TelegramMessage extends Message {
    private String sourceTelegramId;
    private String targetTelegramId;

    public String getSourceTelegramId() {
        return sourceTelegramId;
    }

    public void setSourceTelegramId(String sourceTelegramId) {
        this.sourceTelegramId = sourceTelegramId;
    }

    public String getTargetTelegramId() {
        return targetTelegramId;
    }

    public void setTargetTelegramId(String targetTelegramId) {
        this.targetTelegramId = targetTelegramId;
    }
} 