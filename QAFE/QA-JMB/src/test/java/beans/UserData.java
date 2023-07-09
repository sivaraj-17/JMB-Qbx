package beans;

import java.io.Serializable;

public class UserData implements Serializable {
    private PersonalData personalData;
    public PersonalData getPersonalData() {
        return personalData;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "personalData=" + personalData +
               '}';
    }
/*
    @Override
    public String toString() {
        return "GuestData{" +
                "ccdata=" + ccData +
                ", addrData=" + addrData +
                '}';
    }
    */
}
