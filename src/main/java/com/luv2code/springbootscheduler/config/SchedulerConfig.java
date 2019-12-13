package com.luv2code.springbootscheduler.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@ConditionalOnProperty(name ="scheduling.enabled" , matchIfMissing = true)
@Configuration
public class SchedulerConfig {

}
