package vink.mqttshield.core;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttPubSub {

    public static void Publish ( MqttClient client , String topic , String content , int qos ) throws MqttException
    {
        MqttMessage message = new MqttMessage(content.getBytes());
        message.setQos(qos);
        client.publish(topic, message);

    }

    public static void SubScribe ( MqttClient client , String topic ) throws MqttException
    {
        client.subscribe(topic);
    }

}
