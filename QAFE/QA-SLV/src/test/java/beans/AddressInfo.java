package beans;
import java.io.Serializable;
import java.util.ArrayList;

public class AddressInfo implements Serializable {
    private ArrayList<AddressData> addressInfo;

    public ArrayList<AddressData> getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(ArrayList<AddressData> addressInfo) {
        this.addressInfo = addressInfo;
    }

    @Override
    public String toString() {
        return "AddressInfo{" +
                "addressInfo=" + addressInfo +
                '}';
    }
}
