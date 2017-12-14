package eu.side.thomaspiron.android.events;

/**
 * Created by mdupierreux1 on 26/08/15.
 */
public class LotsSyncedEvent {
    private String message;

    public LotsSyncedEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
