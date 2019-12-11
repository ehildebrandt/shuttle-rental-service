package com.example.shuttlerental;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface FraudChannels {

    String INPUT = "fraud-input";

    @Input(INPUT)
    SubscribableChannel input();


}
