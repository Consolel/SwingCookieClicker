package ConsolesCookieClicker;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class ClickerPanel extends JPanel {
    protected JButton clicker;    
    private JLabel cookiesAmount;
    private Stats stats; 
    public ClickerPanel(Stats stats, Image image, java.util.Timer tasks) {
        this.stats = stats; 
        setBackground(Frame.cookieColor);
        setBorder(Frame.b); 
        GridBagLayout g = new GridBagLayout(); 
        GridBagConstraints c = new GridBagConstraints();
        setLayout(g); 
        cookiesAmount = new JLabel("<html><center>" + stats.getCookies() + " Cookies <br/> Per Second: " + stats.getCookiesPerSecond() + "</html>");
        Frame.labelify(cookiesAmount, 30); 
        ImageIcon cookieIcon = new ImageIcon(image.getScaledInstance(200, 200, Image.SCALE_SMOOTH)); 
        ImageIcon smallIcon = new ImageIcon(image.getScaledInstance(190, 190, Image.SCALE_SMOOTH));
        clicker = new JButton(cookieIcon); 
        clicker.setOpaque(false);
        clicker.setContentAreaFilled(false);
        clicker.setBorderPainted(false);
        clicker.setFocusPainted(false);
        clicker.setPreferredSize(new Dimension(200,200));  
        clicker.addActionListener(e -> {
            stats.click(); 
            cookiesAmount.setText("<html><center>" + stats.getCookies() + " Cookies <br/> Per Second: " + stats.getCookiesPerSecond() + "</html>");
            clicker.setIcon(smallIcon);
            tasks.schedule(new TimerTask() {        
                @Override
                public void run() {
                    clicker.setIcon(cookieIcon); 
                }
            }, 100);
        }); 
        c.gridy = 0;
        add(cookiesAmount, c);
        c.gridy = 1; 
        add(clicker, c);
    }
    public void refresh() {
        cookiesAmount.setText("<html><center>" + stats.getCookies() + " Cookies <br/> Per Second: " + stats.getCookiesPerSecond() + "</html>");
    }
}