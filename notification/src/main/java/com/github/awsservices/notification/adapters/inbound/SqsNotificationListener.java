package com.github.awsservices.notification.adapters.inbound;

import com.github.awsservices.notification.application.core.domain.OrderEvent;
import com.github.awsservices.notification.application.core.ports.inbound.NotificationHandlerPort;
import com.github.awsservices.notification.application.core.ports.inbound.SqsNotificationListenerPort;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class SqsNotificationListener implements SqsNotificationListenerPort {

    private final NotificationHandlerPort notificationHandlerPort;

    public SqsNotificationListener(NotificationHandlerPort notificationHandlerPort) {
        this.notificationHandlerPort = notificationHandlerPort;
    }


    @Override
    @SqsListener("sqs.queue.order")
    public void listen(OrderEvent orderEvent) {
        notificationHandlerPort.sendOrderConfirmation(orderEvent);
    }
}
