package kafkatest;

import java.util.*;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;



public class test01 { 
public static void main(String[] args) {
	Properties props = new Properties();
	// Kafka����˵��������Ͷ˿ں�
	props.put("bootstrap.servers", "test1:9092");
	// key���л�
	props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	// value���л�
	props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	  
	//����������
	  /*���԰���key�������*/
	Producer<String, String> p = new KafkaProducer<>(props);
	 for(int i=0;i<20;i++) {
	        p.send(new ProducerRecord<String, String>("myorder", Integer.toString(i),"hello-" +i ));
	        
	  }
	  p.close();
}
}
