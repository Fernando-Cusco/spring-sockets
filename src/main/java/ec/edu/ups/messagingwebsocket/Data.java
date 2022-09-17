package ec.edu.ups.messagingwebsocket;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Data implements Serializable {
    private String applicationID;
    private String applicationName;
    private String deviceName;
    private String devEUI;
    private List<Map<String, Object>> rxInfo;

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDevEUI() {
        return devEUI;
    }

    public void setDevEUI(String devEUI) {
        this.devEUI = devEUI;
    }

    public List<Map<String, Object>> getRxInfo() {
        return rxInfo;
    }

    public void setRxInfo(List<Map<String, Object>> rxInfo) {
        this.rxInfo = rxInfo;
    }

    @Override
    public String toString() {
        return "Data{" +
                "applicationID='" + applicationID + '\'' +
                ", applicationName='" + applicationName + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", devEUI='" + devEUI + '\'' +
                ", rxInfo=" + rxInfo +
                '}';
    }
}
