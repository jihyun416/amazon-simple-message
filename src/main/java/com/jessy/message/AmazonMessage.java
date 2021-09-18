package com.jessy.message;

import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sqs.model.SendMessageResult;

public interface AmazonMessage {
    SendMessageResult sendMessage(String message);
    PublishResult publishMessage(String message);
}
