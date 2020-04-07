package kafkatest;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class test02 {
public static void main(String[] args) {
	Properties props = new Properties();
	// ����kakfa ����ĵ�ַ������Ҫ������brokerָ���� 
	props.put("bootstrap.servers", "test1:9092");
	// �ƶ�consumer group 
	props.put("group.id", "test");
	// key�����л���
	props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	// value�����л��� 
	props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	// ����consumer 
	KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
	// �����߶��ĵ�topic, ��ͬʱ���Ķ�� 
	consumer.subscribe(Arrays.asList("myorder"));
	while (true) {
	// ��ȡ���ݣ���ȡ��ʱʱ��Ϊ100ms 
	ConsumerRecords<String, String> records = consumer.poll(100);
	for (ConsumerRecord<String, String> record : records)
		System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
	}

}
}
