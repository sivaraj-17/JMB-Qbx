package beans;

import java.io.Serializable;

public class CcData implements Serializable {

    private String cdName;
    private String cdNumber;
    private String monthV;
    private int year;
    private String code;

    public String getCdName() {
        return cdName;
    }

    public void setCdName(String cdName) {
        this.cdName = cdName;
    }

    public String getCdNumber() {
        return cdNumber;
    }

    public void setCdNumber(String cdNumber) {
        this.cdNumber = cdNumber;
    }

    public String getMonthV() {
        return monthV;
    }

    public void setMonthV(String monthV) {
        this.monthV = monthV;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "CcData{" +
                "cdName='" + cdName + '\'' +
                ", cdNumber='" + cdNumber + '\'' +
                ", monthV='" + monthV + '\'' +
                ", year=" + year +
                ", code=" + code +
                '}';
    }
}
