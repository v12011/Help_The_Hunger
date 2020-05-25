package com.e.helpthehunger;

import android.os.Parcel;
import android.os.Parcelable;

public class Donar implements Parcelable {

    private String Name;
    private String Phone;
    private String Person;
    private String Address;
    private String Locality;
    private String State;
    private String Type;

    public Donar() {
    }

    public Donar(String name, String phone, String person, String address, String locality, String state, String type) {
        Name = name;
        Phone = phone;
        Person = person;
        Address = address;
        Locality = locality;
        State = state;
        Type = type;
    }

    protected Donar(Parcel in) {
        Name = in.readString();
        Phone = in.readString();
        Person = in.readString();
        Address = in.readString();
        Locality = in.readString();
        State = in.readString();
        Type = in.readString();
    }

    public static final Creator<Donar> CREATOR = new Creator<Donar>() {
        @Override
        public Donar createFromParcel(Parcel in) {
            return new Donar(in);
        }

        @Override
        public Donar[] newArray(int size) {
            return new Donar[size];
        }
    };

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPerson() {
        return Person;
    }

    public void setPerson(String person) {
        Person = person;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getLocality() {
        return Locality;
    }

    public void setLocality(String locality) {
        Locality = locality;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(Phone);
        dest.writeString(Person);
        dest.writeString(Address);
        dest.writeString(Locality);
        dest.writeString(State);
        dest.writeString(Type);
    }
}
