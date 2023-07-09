package beans;
import java.io.Serializable;
import java.util.ArrayList;

public class CreditInfo implements Serializable {
    private ArrayList<CreditData> creditInfo;

    public ArrayList<CreditData> getCreditInfo() {
        return creditInfo;
    }

    public void setCreditInfo(ArrayList<CreditData> creditInfo) {
        this.creditInfo = creditInfo;
    }

    @Override
    public String toString() {
        return "CreditInfo{" +
                "creditInfo=" + creditInfo +
                '}';
    }
}
