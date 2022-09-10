package ConsolesCookieClicker;
import java.io.Serializable;
public class CookieTimer implements Serializable {
    private int days;
    private int hours;
    private int minutes;
    private int seconds;
    public CookieTimer(int days, int hours, int minutes, int seconds) {
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds; 
    }
    public CookieTimer() {
        days = 0;
        hours = 0;
        minutes = 0;
        seconds = 0; 
    }
    public void tick() {
        seconds++;
        if(seconds >= 60) {
            minutes++;
            seconds = 0;
        }
        if (minutes >= 60) {
            hours++;
            minutes = 0;
        }
        if (hours >= 24) {
            days++;
            hours = 0; 
        }
    }
    @Override
    public String toString() {
        return days + "d " + hours + "h " + minutes + "m " + seconds + "s";
    }
}
