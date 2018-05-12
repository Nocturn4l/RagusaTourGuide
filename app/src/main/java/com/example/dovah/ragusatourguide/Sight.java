package com.example.dovah.ragusatourguide;

import android.os.Parcel;
import android.os.Parcelable;

public class Sight implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Sight createFromParcel(Parcel in) {
            return new Sight(in);
        }

        public Sight[] newArray(int size) {
            return new Sight[size];
        }
    };


    private String sightName;
    private String sightDescription;
    private String sightAddress;
    private int sightResourceId;
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
    // Parcelling part
    public Sight(Parcel in){
        this.sightResourceId = in.readInt();
        this.sightName = in.readString();
        this.sightDescription =  in.readString();
        this.sightAddress = in.readString();
        this.sightSite = in.readString();
        this.sightTelephone = in.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(sightResourceId);
        dest.writeString(sightName);
        dest.writeString(sightDescription);
        dest.writeString(sightAddress);
        dest.writeString(sightSite);
        dest.writeString(sightTelephone);
    }
}
