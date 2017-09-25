package com.payjoy.integration.kafka;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

/**
 * Kafka
 * @author  liu.songgao
 * @date 2015-3-25
 */
public class KafkaMessageTransformer {
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageTransformer.class) ;
	
	/**
	 *  PayLoad json JSONObject
	 * @param message
	 * @return
	 */
	public Message<?> transformer(Message<?> message){
		MessageHeaders headers = message.getHeaders();
		String json = (String)message.getPayload();
		Object obj = JSON.parse(json);
		MessageBuilder<?> mb = MessageBuilder.withPayload(obj);
		if(headers.containsKey(KafkaHeaders.TOPIC)){
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("kafka message transformer");
			}
			mb.setHeader(KafkaHeaders.TOPIC, headers.get(KafkaHeaders.TOPIC));
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(json);
			}
		}
		return mb.build();
	}
	
}
