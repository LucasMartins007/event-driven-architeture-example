package com.github.awsservices.notification.application.core.ports.inbound;


import com.github.awsservices.notification.application.core.domain.OrderEvent;

public interface NotificationHandlerPort {

    void sendOrderConfirmation(OrderEvent orderEvent);
}
