package com.payjoy.integration.kafka;

import org.springframework.messaging.Message;

/**
 * @anthor liu.songgao
 * @date 2015-3-26
 * @spring-integration service-activator
 */
public interface ServiceActivator {
	
	/**
	 * 消息
	 * @param message
	 */
	public void execute(Message<?> message);
}
