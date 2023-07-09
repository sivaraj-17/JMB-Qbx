package beans;
import java.io.Serializable;

public class AddressData implements Serializable {
    private AddrData addrData;

    public AddrData getAddrData() {
        return addrData;
    }

    public void setAddrData(AddrData addrData) {
        this.addrData = addrData;
    }

    @Override
    public String toString() {
        return "AddressData{" +
                "addrData=" + addrData +
                '}';
    }
}
