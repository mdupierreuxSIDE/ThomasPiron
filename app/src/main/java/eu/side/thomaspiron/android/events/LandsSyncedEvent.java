package eu.side.thomaspiron.android.events;

public class LandsSyncedEvent{
    private String errorMsg;
    public LandsSyncedEvent(){}

    public LandsSyncedEvent(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
