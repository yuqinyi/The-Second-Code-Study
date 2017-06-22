package com.rdx64.chapter13;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by RDX64 on 2017/6/18.
 */

public class PersonP implements Parcelable {

    public static final Parcelable.Creator<PersonP> CREATOR = new Parcelable.Creator<PersonP>() {
        @Override
        public PersonP createFromParcel(Parcel parcel) {
            PersonP personP = new PersonP();
            personP.name = parcel.readString();
            personP.age = parcel.readInt();
            return personP;
        }

        @Override
        public PersonP[] newArray(int i) {
            return new PersonP[i];
        }
    };

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(age);
    }
}
