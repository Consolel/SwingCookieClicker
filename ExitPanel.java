package ConsolesCookieClicker;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants; 
public class ExitPanel extends JPanel {
    private JLabel exitText; 
    private JButton exitButton;
    public ExitPanel() {
        setLayout(new GridLayout(2,0));
        exitText = new JLabel("<html><center> Exit Now? <br/> Remember To Save! <html>", SwingConstants.CENTER); 
        exitButton = new JButton("Exit"); 
        exitButton.addActionListener(e -> {System.exit(0);});
        Frame.buttonify(exitButton, 40);
        Frame.labelify(exitText, 30); 
        add(exitText);
        add(exitButton); 
    }
}
