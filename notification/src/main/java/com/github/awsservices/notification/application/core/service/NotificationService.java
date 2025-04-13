package com.github.awsservices.notification.application.core.service;

import com.github.awsservices.notification.application.core.domain.OrderEvent;
import com.github.awsservices.notification.application.core.ports.inbound.NotificationHandlerPort;

public class NotificationService implements NotificationHandlerPort {
    @Override
    public void sendOrderConfirmation(OrderEvent orderEvent) {
        final String message = String.format(
                "Enviando e-mail para %s: Pedido #%s confirmado (R$ %.2f)",
                orderEvent.getCustomerEmail(),
                orderEvent.getOrderId(),
                orderEvent.getAmount()
        );
        System.out.println(message);
    }
}
