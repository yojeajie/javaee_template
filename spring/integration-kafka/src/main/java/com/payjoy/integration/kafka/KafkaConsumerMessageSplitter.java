package com.payjoy.integration.kafka;

import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @anthor liu.songgao
 * @date 2015-3-26
 * @Kafka.Consumer
 */
public class KafkaConsumerMessageSplitter {
	
	/**
	 * kafka Map, Topic Message Header
	 * @param message kafka
	 * @return List
	 *
	 */
	public List<Message<?>> split(Message<?> message){
		List<Message<?>> msgList = new ArrayList<Message<?>>();
		Map<String, Map<Integer, List<Object>>> msgMap = (Map<String, Map<Integer, List<Object>>>) message.getPayload();
		Iterator<String> it_Topic = msgMap.keySet().iterator();
		while (it_Topic.hasNext()) {
			String topic = it_Topic.next();
			Map<Integer, List<Object>> map_Message = msgMap.get(topic);
			Iterator<Integer> it_Index = map_Message.keySet().iterator();
			while (it_Index.hasNext()) {
				Integer partIndex = it_Index.next();
				List<Object> list = map_Message.get(partIndex);
				for(Object obj : list){
					String msgString = (String)obj;
					MessageBuilder<?> mb = MessageBuilder.withPayload(msgString);
					mb.setHeader(KafkaHeaders.TOPIC, topic);
					Message<?> msg  = mb.build();
					msgList.add(msg);
				}
			}
		}
		return msgList;
	}
	
}
