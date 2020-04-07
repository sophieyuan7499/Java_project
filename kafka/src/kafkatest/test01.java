package kafkatest;

import java.util.*;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;



public class test01 { 
public static void main(String[] args) {
	Properties props = new Properties();
	// Kafka服务端的主机名和端口号
	props.put("bootstrap.servers", "test1:9092");
	// key序列化
	props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	// value序列化
	props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	  
	//创建生产者
	  /*可以按照key计算分区*/
	Producer<String, String> p = new KafkaProducer<>(props);
	 for(int i=0;i<20;i++) {
	        p.send(new ProducerRecord<String, String>("myorder", Integer.toString(i),"hello-" +i ));
	        
	  }
	  p.close();
}
}
