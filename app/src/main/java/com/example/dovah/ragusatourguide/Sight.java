package com.example.dovah.ragusatourguide;

public class Sight {
    private String sightName;
    private String sightDescription;
    private String sightAddress;
    private int sightResourceId=-1;
    private String sightTelephone;
    private String sightSite;

    public String getSightName(){
        return sightName;
    }

    public String getSightDescription(){
        return sightDescription;
    }

    public String getSightAddress() {
        return sightAddress;
    }

    public int getSightResourceId(){
        return sightResourceId;
    }

    public String getSightSite() { return sightSite; }

    public String getSightTelephone() { return sightTelephone; }

    public Sight(String name, String description, String address, int resource){
        sightName=name;
        sightDescription=description;
        sightAddress=address;
        sightResourceId=resource;
    }

    public Sight(String name, String number, String site, String address, int resource){
        sightName=name;
        sightTelephone=number;
        sightSite=site;
        sightAddress=address;
        sightResourceId=resource;
    }

}
