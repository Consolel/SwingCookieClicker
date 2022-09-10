package ConsolesCookieClicker;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class GoldRushPanel extends JPanel {
    private JButton goldClicker; 
    private JLabel cookiesGainedLabel; 
    private int cookiesGained; 
    public GoldRushPanel(Stats stats, Image image) {
        setLayout(null);
        setBackground(Frame.cookieColor); 
        setBorder(Frame.b); 
        ImageIcon goldIcon = new ImageIcon(image.getScaledInstance(50, 50, Image.SCALE_SMOOTH)); 
        goldClicker = new JButton(goldIcon); 
        cookiesGained = 0; 
        cookiesGainedLabel = new JLabel("<html><center> Cookies Gained: <html>" + cookiesGained);
        goldClicker.setOpaque(false);
        goldClicker.setContentAreaFilled(false);
        goldClicker.setBorderPainted(false);
        goldClicker.setFocusPainted(false);
        goldClicker.setBounds(150, 150, 50, 50);
        goldClicker.addActionListener(e -> {
            cookiesGained += (int) (Math.random() * (stats.getRawClicks() / 4)); 
            goldClicker.setBounds((int) (Math.random() * 280), (int) (Math.random() * 280), 50, 50); 
            cookiesGainedLabel.setText("<html><center> Cookies Gained: <html>" + cookiesGained);
        });
        cookiesGainedLabel.setBounds(80, 0, 300, 100); 
        cookiesGainedLabel.setFont(new Font("Courier", Font.BOLD, 20)); 
        cookiesGainedLabel.setForeground(Frame.textColor); 
        add(goldClicker); 
        add(cookiesGainedLabel); 
    }
    public int reset() {
        int returnNum = cookiesGained; 
        cookiesGained = 0;
        cookiesGainedLabel.setText("<html><center> Cookies Gained: <html>" + cookiesGained);
        goldClicker.setBounds(150, 150, 50, 50);
        return returnNum;
    }
}
