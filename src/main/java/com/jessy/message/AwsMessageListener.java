package com.jessy.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class AwsMessageListener {
    @SqsListener(value = "${cloud.aws.sqs.queue.sqs-test-name}")
    private void receiveDriverInfo(@Headers Map<String, String> header, @Payload String message) {
        log.info(message);
    }
}