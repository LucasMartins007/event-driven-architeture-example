package com.github.awsservices.order.application.core.services;

import com.github.awsservices.order.application.core.domain.OrderEvent;
import com.github.awsservices.order.application.core.ports.outbound.SnsPublisherPort;

public class OrderService {

    private final SnsPublisherPort snsPublisherPort;

    public OrderService(SnsPublisherPort snsPublisherPort) {
        this.snsPublisherPort = snsPublisherPort;
    }

    public void confirmOrder(OrderEvent orderEvent) {
        snsPublisherPort.publish(orderEvent);
    }
}
