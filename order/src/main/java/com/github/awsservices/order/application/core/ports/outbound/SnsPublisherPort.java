package com.github.awsservices.order.application.core.ports.outbound;

import com.github.awsservices.order.application.core.domain.OrderEvent;

public interface SnsPublisherPort {

    void publish(OrderEvent orderEvent);
}
