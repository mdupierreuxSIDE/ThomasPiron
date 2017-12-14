package eu.side.thomaspiron.android.events;

public class ApartmentsSyncedEvent{
    private String errorMsg;
    public ApartmentsSyncedEvent(){}

    public ApartmentsSyncedEvent(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}

