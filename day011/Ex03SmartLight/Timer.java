package Ex03SmartLight;

import java.time.LocalDateTime;

public class Timer {
    private LocalDateTime endTime;

    public void set(int minutes) {
        this.endTime = LocalDateTime.now().plusMinutes(minutes);
    }

    public void cancel() {
        this.endTime = null;
    }

    public boolean isExpired() {
        return endTime != null && LocalDateTime.now().isAfter(endTime);
    }
}
