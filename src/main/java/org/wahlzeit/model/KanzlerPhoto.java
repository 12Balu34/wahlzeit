package org.wahlzeit.model;


import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class KanzlerPhoto extends Photo {

    private String name;
    private int yearOfBirth;
    private int yearOfDeath;
    private int yearEnteringOffice;
    private int yearLeavingOffice;
    private String party;


    public KanzlerPhoto() {
    }

    public KanzlerPhoto(PhotoId myId) {
        super(myId);
    }

    public KanzlerPhoto(String name, int yearOfBirth, int yearOfDeath, int yearEnteringOffice, int yearLeavingOffice, String party) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.yearOfDeath = yearOfDeath;
        this.yearEnteringOffice = yearEnteringOffice;
        this.yearLeavingOffice = yearLeavingOffice;
        this.party = party;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getYearOfDeath() {
        return yearOfDeath;
    }

    public void setYearOfDeath(int yearOfDeath) {
        this.yearOfDeath = yearOfDeath;
    }

    public int getYearEnteringOffice() {
        return yearEnteringOffice;
    }

    public void setYearEnteringOffice(int yearEnteringOffice) {
        this.yearEnteringOffice = yearEnteringOffice;
    }

    public int getYearLeavingOffice() {
        return yearLeavingOffice;
    }

    public void setYearLeavingOffice(int yearLeavingOffice) {
        this.yearLeavingOffice = yearLeavingOffice;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }
}
