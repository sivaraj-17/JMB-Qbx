package beans;

import java.io.Serializable;

public class InvalidPasswordData implements Serializable
{
    private PassData passData;

    public PassData getPassData() {
        return passData;
    }

    public void setPassData(PassData passData) {
        this.passData = passData;
    }

    @Override
    public String toString() {
        return "InvalidPasswordData{" +
                "passData=" + passData +
                '}';
    }

}

