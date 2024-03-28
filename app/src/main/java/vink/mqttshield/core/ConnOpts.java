package vink.mqttshield.core;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

public class ConnOpts {
    private MqttConnectOptions  opts = null;

    public ConnOpts(String username , String pass)
    {
        opts = new MqttConnectOptions();
        opts.setUserName(username);
        opts.setPassword(pass.toCharArray());
    }

    public MqttConnectOptions getOpts() {
        return opts;
    }

}
