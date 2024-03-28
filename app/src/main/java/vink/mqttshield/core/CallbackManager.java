package vink.mqttshield.core;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class CallbackManager implements MqttCallbackExtended{

    public static GenericCallback callback = null;

    public static void RegisterCallback ( GenericCallback cb)
    {
        callback = cb;
    }

    @Override
    public void connectionLost(Throwable cause) {
        System.out.println("Connection lost");
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        System.out.println("Message arrived: " + new String(message.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        System.out.println("Delivery complete");
    }

    @Override
    public void connectComplete(boolean reconnect, String serverURI) {
        System.out.println("Connect complete");
        callback.onCallback("Connected");
    }

}
