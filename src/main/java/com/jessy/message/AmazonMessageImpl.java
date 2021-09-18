package com.jessy.message;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AmazonMessageImpl implements AmazonMessage {
    private final ObjectMapper objectMapper;
    private final AmazonSNS amazonSNS;
    private final AmazonSQS amazonSQS;

    @Value("${cloud.aws.sqs.queue.sqs-test-url}")
    public String sqsTestUrl;
    @Value("${cloud.aws.sns.topic.sns-test-arn}")
    public String snsTestUrl;

    @Override
    public SendMessageResult sendMessage(String message) {
        SendMessageRequest sendMessageRequest = new SendMessageRequest(sqsTestUrl, message);
        return amazonSQS.sendMessage(sendMessageRequest);
    }

    public PublishResult publishMessage(String message) {
        PublishRequest publishRequest = new PublishRequest();
        return amazonSNS.publish(snsTestUrl, message);
    }
}