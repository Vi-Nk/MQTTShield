package vink.mqttshield.routines;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

import vink.mqttshield.core.ConnOpts;
import vink.mqttshield.core.MqttCallback;

public class SysInfoExtract  {
    private static final String[] SYS_TOPICS = new String[]
    {"$SYS/broker/version", 
     "$SYS/broker/uptime",
     "$SYS/broker/timestamp", 
     "$SYS/broker/clients/expired", 
     "$SYS/broker/clients/disconnected",
     "$SYS/broker/clients/maximum", 
     "$SYS/broker/clients/connected",
     "$SYS/broker/subscriptions/count"
    };


    public void trySysInfoTopics(MqttClient client , MqttConnectOptions opts) throws InterruptedException {

        try {
            client.connect(opts);
            MqttCallback gc = new MqttCallback();
            for ( String topic : SYS_TOPICS ) {
                try {
                    System.out.println("Subscribing to " + topic);
                    client.subscribe(topic , gc);
                } catch (MqttException e) {
                    System.out.println("something happened"+ e.getMessage());
                }
            }
        } catch (MqttSecurityException e) {
            e.printStackTrace();
        } catch (MqttException e) {
            e.printStackTrace();
        }
        
    }


}
