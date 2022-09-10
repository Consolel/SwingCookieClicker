package ConsolesCookieClicker;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
public class InfoPanel extends JPanel {
    private JLabel info;    
    public InfoPanel() {
        info = new JLabel("<html><center> Cookie Clicker. A game where you endlessly click a cookie, make cookies, and buy stuff, with a couple of twists. <br/> <br/> Made by Console August 2022 in BlueJ with Java Swing. Problems? <br/> Contact Me: discord.gg/geM5US4FFd <html>");
        Frame.labelify(info, 20); 
        setLayout(new BorderLayout()); 
        add(info, BorderLayout.CENTER); 
    }
}