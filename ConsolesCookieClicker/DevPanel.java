package ConsolesCookieClicker;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
public class DevPanel extends JPanel {
    private JList<String> values;
    private SpinnerNumberModel model; 
    private JSpinner spinner; 
    private JButton setter;
    public DevPanel(Stats stats) {
        setLayout(new GridLayout(0,3));
        model = new SpinnerNumberModel(0, 0, 2147483647, 1);
        spinner = new JSpinner(model); 
        spinner.setFont(new Font("Courier", Font.BOLD, 40));
        values = new JList<String>(new String[] {"cookies", "cookiesMade", "cookiesSpent", "rawClicks", "workers", "buisnessmen", "scientists", "stands", "factories", "extraHands"});
        values.setFont(new Font("Courier", Font.BOLD, 15));
        setter = new JButton("Set Value"); 
        setter.addActionListener(e-> {
            int value = (int) model.getValue();
            switch(values.getSelectedIndex()) {
                case 0:
                    stats.setCookies(value); 
                    break;
                case 1:
                    stats.setCookiesMade(value);
                    break;
                case 2:
                    stats.setCookiesSpent(value);
                    break;
                case 3:
                    stats.setRawClicks(value); 
                    break;
                case 4:
                    stats.getWorkers().setAmount(value); 
                    break;
                case 5:
                    stats.getBuisnessmen().setAmount(value);
                    break;
                case 6:
                    stats.getScientists().setAmount(value);
                    break;
                case 7:
                    stats.getStands().setAmount(value); 
                    break;
                case 8:
                    stats.getFactories().setAmount(value);
                    break;
                case 9:
                    stats.getExtraHands().setAmount(value); 
                    break;
            }
        });
        add(values);
        add(spinner); 
        add(setter);
    }
}
