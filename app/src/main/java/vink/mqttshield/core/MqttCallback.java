package vink.mqttshield.core;

import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttCallback implements IMqttMessageListener{

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        System.out.println("arruived " 
        + topic + " " + message.toString() );
    }

}
