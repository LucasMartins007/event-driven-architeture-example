package com.github.awsservices.notification.adapters.inbound.config;

import com.github.awsservices.notification.application.core.ports.inbound.NotificationHandlerPort;
import com.github.awsservices.notification.application.core.service.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Bean
    public NotificationHandlerPort notificationHandlerPort() {
        return new NotificationService();
    }


}
