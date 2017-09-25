package com.payjoy.integration.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;


/**
 * @author wangbin
 * 创建时间: 20151216
 * 描述：Kafka.Producer发送消息实现类
 */
public class KafkaProducerServiceImpl implements KafkaProducerService {

	private static Logger LOGGER = LoggerFactory.getLogger(KafkaProducerServiceImpl.class);
	
	
	private MessageChannel messageChannel;
	
	/**
	 * 向kafka指定Topic发送json消息
	 */
	@Override
	public boolean send(String topic, String message) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("kafka producer [ {} ]: {}", topic, message);
		}
		MessageBuilder<?> mb = MessageBuilder.withPayload(message);
		mb.setHeader(KafkaHeaders.TOPIC, topic);
		mb.setHeader(KafkaHeaders.MESSAGE_KEY, "");
		return getMessageChannel().send(mb.build());
	}

	public MessageChannel getMessageChannel() {
		return messageChannel;
	}

	public void setMessageChannel(MessageChannel messageChannel) {
		this.messageChannel = messageChannel;
	}
}