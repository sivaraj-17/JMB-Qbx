package beans;

import java.io.Serializable;
import java.util.ArrayList;

public class InvalidPasswordInfo implements Serializable
{
    private ArrayList<InvalidPasswordData> passwordInfo;
    public ArrayList<InvalidPasswordData> getPasswordInfo() {
        return passwordInfo;
    }

    public void setpasswordInfo(ArrayList<InvalidPasswordData> passwordInfo) {
        this.passwordInfo = passwordInfo;
    }

    @Override
    public String toString() {
        return "passwordInfo{" +
                "passwordInfo=" + passwordInfo +
                '}';
    }

}

