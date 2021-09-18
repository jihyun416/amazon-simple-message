package com.jessy.message;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessageApplicationTests {
    @Autowired
    AmazonMessage amazonMessage;

    @Test
    void SQS_TEST() {
        amazonMessage.sendMessage("sqs message send test");
    }

    @Test
    void SNS_TEST() {
        amazonMessage.publishMessage("sns message send test");
    }
}
