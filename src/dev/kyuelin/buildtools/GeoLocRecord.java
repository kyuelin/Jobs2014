package dev.kyuelin.buildtools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linken on 5/4/15.
 */
public class GeoLocRecord {
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    private double latitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    private double longitude;
    private String member = "mem1";

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    private List<String> messages = new ArrayList<String>() {
        {
            add("msg 1");
            add("msg 2");
            add("msg 3");
        }
    };

    @Override
    public String toString() {
        return "GeoLocRecord{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", member='" + member + '\'' +
                ", messages=" + messages +
                '}';
    }
}
