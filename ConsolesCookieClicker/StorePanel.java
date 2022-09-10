package ConsolesCookieClicker;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
public class StorePanel extends JPanel {
    private JButton buyWorker, buyBuisnessman, buyScientist, buyStand, buyFactory, buyExtraHand;
    private Stats statRec;
    // passing the stats object so that this can have a pointer to it, and access the stats as they get updated. 
    public StorePanel(Stats statRec) {
        this.statRec = statRec; 
        setLayout(new GridLayout(6,0)); 
        buyWorker = new JButton("Buy Worker: " + statRec.getWorkers().getPrice()); 
        buyStand = new JButton("Buy Cookie Stand: " + statRec.getStands().getPrice());
        buyBuisnessman = new JButton("Buy Buisnessman: " + statRec.getBuisnessmen().getPrice());
        buyScientist = new JButton("Buy Scientist: " + statRec.getScientists().getPrice());
        buyFactory = new JButton("Buy Factory: " + statRec.getFactories().getPrice()); 
        buyExtraHand = new JButton("Buy Extra Hand: " + statRec.getExtraHands().getPrice());
        Frame.buttonify(buyWorker, 25);
        Frame.buttonify(buyStand, 25);
        Frame.buttonify(buyBuisnessman, 25);
        Frame.buttonify(buyScientist, 25);
        Frame.buttonify(buyFactory, 25);
        Frame.buttonify(buyExtraHand, 25);
        buyWorker.addActionListener(e -> {buy(statRec.getWorkers(), buyWorker);});
        buyStand.addActionListener(e -> {buy(statRec.getStands(), buyStand);});
        buyBuisnessman.addActionListener(e -> {buy(statRec.getBuisnessmen(), buyBuisnessman);});
        buyScientist.addActionListener(e -> {buy(statRec.getScientists(), buyScientist);});
        buyFactory.addActionListener(e -> {buy(statRec.getFactories(), buyFactory);});
        buyExtraHand.addActionListener(e -> {buy(statRec.getExtraHands(), buyExtraHand);});
        add(buyWorker);
        add(buyBuisnessman);
        add(buyScientist);
        add(buyStand);
        add(buyFactory);
        add(buyExtraHand);
    }	
    public void refresh() {
        buyWorker.setText("Buy Worker: " + statRec.getWorkers().getPrice()); 
        buyStand.setText("Buy Cookie Stand: " + statRec.getStands().getPrice());
        buyBuisnessman.setText("Buy Buisnessman: " + statRec.getBuisnessmen().getPrice());
        buyScientist.setText("Buy Scientist: " + statRec.getScientists().getPrice());
        buyFactory.setText("Buy Factory: " + statRec.getFactories().getPrice()); 
        buyExtraHand.setText("Buy Extra Hand: " + statRec.getExtraHands().getPrice());
    }
    public boolean buy(Item item, JButton button) {
        int price = item.getPrice();
        // set the below if statement up a little weird. if the buy method on the item object goes through, then process the changes in the Stats object. 
        if (item.buy(statRec.getCookies())) {
            statRec.purchased(price); 
            return true; 
        }
        else {
            button.setText("Not Enough Money!"); 
            return false; 
        }
    }
}
