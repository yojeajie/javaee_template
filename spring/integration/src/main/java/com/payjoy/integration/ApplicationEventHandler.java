package com.payjoy.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

public class ApplicationEventHandler {
    public static final Logger logger = LoggerFactory.getLogger(ApplicationEventHandler.class);

    public String type;
    private MessageChannel channel;

    public MessageChannel getChannel() {
        return channel;
    }

    public void setChannel(MessageChannel channel) {
        this.channel = channel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Message<String> receive(Message<String> message) {

        Message<String> result = MessageBuilder.fromMessage(message).build();
        if (logger.isDebugEnabled()) {
            logger.debug("{}", message);
        }
        return result;
    }

    public String send(String input) {
        Message<String> message = MessageBuilder.withPayload(input).build();
        this.getChannel().send(message);
        return "success";
    }
}
