package com.example.shuttlerental;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class FraudListener {

    private String lastFraudName;

    @StreamListener(FraudChannels.INPUT)
    public void onFraudMessage(Fraud fraud) {
        lastFraudName = fraud.name();
        System.out.println(lastFraudName);
    }

    public String getLastFraudName() {
        return lastFraudName;
    }
}
