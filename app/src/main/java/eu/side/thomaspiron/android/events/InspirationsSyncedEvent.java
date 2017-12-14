package eu.side.thomaspiron.android.events;

public class InspirationsSyncedEvent{
    private String errorMsg;
    public InspirationsSyncedEvent(){}

    public InspirationsSyncedEvent(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
