package ConsolesCookieClicker;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
public class StatsPanel extends JPanel {
    private JLabel cookieAmount, cookiesMade, cookiesSpent, rawClicks, workers, buisnessmen, scientists, stands, factories, extraHands, time;
    private Stats statRec; 
    private CookieTimer timer; 
    public StatsPanel(Stats statRec, CookieTimer timer) {
        this.statRec = statRec; 
        this.timer = timer;
        setLayout(new GridLayout(10, 0)); 
        cookieAmount = new JLabel("Cookies: " + statRec.getCookies(), SwingConstants.CENTER);
        cookiesMade = new JLabel("Total Cookies Made: " + statRec.getCookiesMade(), SwingConstants.CENTER);
        cookiesSpent = new JLabel("Total Cookies Spent: " + statRec.getCookiesSpent(), SwingConstants.CENTER); 
        rawClicks = new JLabel("Raw Clicks: " + statRec.getRawClicks(), SwingConstants.CENTER);
        workers = new JLabel("Workers: " + statRec.getWorkers().getAmount(), SwingConstants.CENTER); 
        buisnessmen = new JLabel("Buisnessmen: " + statRec.getBuisnessmen().getAmount(), SwingConstants.CENTER); 
        scientists = new JLabel("Scientists: " + statRec.getScientists().getAmount(), SwingConstants.CENTER);
        stands = new JLabel("Cookie Stands: " + statRec.getStands().getAmount(), SwingConstants.CENTER); 
        factories = new JLabel("Factories: " + statRec.getFactories().getAmount(), SwingConstants.CENTER); 
        extraHands = new JLabel("Extra Hands: " + statRec.getExtraHands().getAmount(), SwingConstants.CENTER); 
        time = new JLabel(timer.toString(), SwingConstants.CENTER);
        Frame.labelify(cookieAmount, 22); 
        Frame.labelify(cookiesMade, 22); 
        Frame.labelify(cookiesSpent, 22); 
        Frame.labelify(rawClicks, 22); 
        Frame.labelify(workers, 22); 
        Frame.labelify(buisnessmen, 22); 
        Frame.labelify(scientists, 22); 
        Frame.labelify(stands, 22); 
        Frame.labelify(factories, 22); 
        Frame.labelify(extraHands, 22); 
        Frame.labelify(time, 22);
        add(cookieAmount);
        add(cookiesMade);
        add(cookiesSpent);
        add(rawClicks);
        add(workers);
        add(scientists);
        add(stands);
        add(factories);
        add(extraHands); 
        add(time); 
    }
    public void refresh() {
        cookieAmount.setText("Cookies: " + statRec.getCookies());
        cookiesMade.setText("Total Cookies Made: " + statRec.getCookiesMade());
        cookiesSpent.setText("Total Cookies Spent: " + statRec.getCookiesSpent()); 
        rawClicks.setText("Raw Clicks: " + statRec.getRawClicks());
        workers.setText("Workers: " + statRec.getWorkers().getAmount()); 
        buisnessmen.setText("Buisnessmen: " + statRec.getBuisnessmen().getAmount()); 
        scientists.setText("Scientists: " + statRec.getScientists().getAmount());
        stands.setText("Cookie Stands: " + statRec.getStands().getAmount()); 
        factories.setText("Factories: " + statRec.getFactories().getAmount()); 
        extraHands.setText("Extra Hands: " + statRec.getExtraHands().getAmount()); 
        time.setText(timer.toString());
    }
}