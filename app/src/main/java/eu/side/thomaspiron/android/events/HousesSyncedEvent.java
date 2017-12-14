package eu.side.thomaspiron.android.events;

/**
 * Created by mdupierreux1 on 20/08/15.
 */
public class HousesSyncedEvent{
    private String errorMsg;
    public HousesSyncedEvent(){}

    public HousesSyncedEvent(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
