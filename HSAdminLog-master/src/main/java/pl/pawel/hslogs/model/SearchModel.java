package pl.pawel.hslogs.model;

public class SearchModel {

    private String date;
    private String ipAddress;
    private String timeStart;
    private String timeStop;

    public SearchModel() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeStop() {
        return timeStop;
    }

    public void setTimeStop(String timeStop) {
        this.timeStop = timeStop;
    }

    @Override
    public String toString() {
        return "SearchModel{" +
                "date='" + date + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", timeStart='" + timeStart + '\'' +
                ", timeStop='" + timeStop + '\'' +
                '}';
    }
}
