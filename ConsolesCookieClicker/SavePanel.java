package ConsolesCookieClicker;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
public class SavePanel extends JPanel {
    public SavePanel(JButton save, JButton load) {
        setLayout(new GridLayout(2,0));
        Frame.buttonify(save, 40);
        Frame.buttonify(load, 40);
        add(save);
        add(load);
    }
}
