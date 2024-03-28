package vink.mqttshield.core;

import java.util.UUID;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class MqttConnManager {
    private MqttClient client = null;
    private MqttConnectOptions ops = null;
    

    public MqttConnManager(String url ,String clientid , String username , String password ) throws  MqttException{
        client = new MqttClient(url, clientid);
        ops = new MqttConnectOptions();
        ops.setCleanSession(true);
        client.setCallback(new CallbackManager());
        if ( username != null && password != null )
        {
            ops.setUserName(username);
            ops.setPassword(password.toCharArray());
        }
    }
    
    public MqttConnManager(String host , int port ,String clientid , String username , String password ) throws  MqttException{
        this("tcp://"+host+":"+port , clientid , username , password);
    }

    public MqttConnManager(String host , int port , String username , String password ) throws  MqttException{
        this(host, port , UUID.randomUUID().toString() , username , password);
    }

    public MqttConnManager(String host , int port ) throws  MqttException{
        this(host, port , UUID.randomUUID().toString() , null , null);
    }


    public void connect() throws MqttException {
        client.connect(ops);
        System.out.println("Connected");
    }

    public void connect(MqttConnectOptions opts) throws MqttException {
        client.connect(opts);
        System.out.println("Connected with opts");
    }

    public void disconnect() throws MqttException {
        client.disconnect();
        System.out.println("Disconnected");
    }
    

    public MqttClient getClient() {
        return client;
    }

    }

