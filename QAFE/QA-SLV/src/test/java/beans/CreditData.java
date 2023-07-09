package beans;

import java.io.Serializable;

public class CreditData implements Serializable {
    private CcData ccData;

    public CcData getCcData() {
        return ccData;
    }

    public void setCcData(CcData ccData) {
        this.ccData = ccData;
    }

    @Override
    public String toString() {
        return "CreditData{" +
                "ccData=" + ccData +
                '}';
    }
}
