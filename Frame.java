package ConsolesCookieClicker;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Frame implements ActionListener, KeyListener {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Frame(); 
            }
        });
    }
    private JFrame frame;
    private JTabbedPane pane; 
    private javax.swing.Timer refresh; 
    private java.util.Timer tasks; 
    private ClickerPanel clicker;
    private GoldRushPanel goldRush;
    private StorePanel store; 
    private StatsPanel stats;
    private SavePanel saves;
    private InfoPanel info;
    private ExitPanel exit; 
    private DevPanel dev; 
    protected Stats statRec; 
    protected CookieTimer time; 
    protected Image icon; 
    protected Image goldIcon; 
    protected static Color cookieColor;
    protected static Color textColor;
    protected static Border b; 
    public Frame() {
        frame = new JFrame("Cookie Clicker by Console v1.1");
        frame.setSize(400,400); 
        frame.setResizable(false); 
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // so that the user is reminded to save the game before it closes. 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); 
        frame.setFocusable(false); 
        try{icon = ImageIO.read(getClass().getResource("/assets/Cookie.jpg"));} catch (Exception e) {System.exit(0);}
        try {goldIcon = ImageIO.read(getClass().getResource("/assets/GoldenCookie.jpg"));} catch (Exception e) {System.exit(0);} // e.printStackTrace(); DEBUG
        frame.setIconImage(icon);
        pane = new JTabbedPane(); 
        pane.addKeyListener(this); 
        frame.add(pane); 
        refresh = new javax.swing.Timer(1000, this); // -> calls actionPreformed every second. 
        refresh.start(); 
        tasks = new java.util.Timer(); // -> java util timer for scheduling something to happen later. 
        cookieColor = new Color(199, 161, 125); 
        textColor = new Color(59, 30, 0); 
        UIManager.put("TabbedPane.selected", Color.WHITE);
        UIManager.put("TabbedPane.contentAreaColor", cookieColor);
        UIManager.put("TabbedPane.darkShadow", textColor);
        UIManager.put("TabbedPane.borderHightlightColor", textColor);
        UIManager.put("TabbedPane.light", cookieColor);
        UIManager.put("TabbedPane.tabAreaBackground", textColor);
        UIManager.put("ToolTip.background", cookieColor);
        UIManager.put("ToolTip.border", b);     
        pane.setBackground(cookieColor);
        pane.setForeground(textColor);
        b = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, new Color(210, 180, 140), new Color(150, 75, 0));
        frame.addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent evt) {
             exit();
           }
        });
        
        statRec = new Stats(); // <- game variables 
        time = new CookieTimer(); // <- game timer
        clicker = new ClickerPanel(statRec, icon, tasks); 
        clicker.clicker.addActionListener(e -> {if (pane.indexOfTab("Gold") == -1 && statRec.getRawClicks() > 200 && (int) (Math.random() * 1000) == 1) {goldRush();}}); 
        store = new StorePanel(statRec);
        stats = new StatsPanel(statRec, time);
        goldRush = new GoldRushPanel(statRec, goldIcon); 
        JButton save = new JButton("Save");
        JButton load = new JButton("Load");
        save.addActionListener(e -> {save();});
        load.addActionListener(e -> {load();}); 
        saves = new SavePanel(save, load); // <- pass the jbuttons with the actionlistener already on them, so that the methods can be in this class. 
        info = new InfoPanel();
        exit = new ExitPanel(); 
        dev = new DevPanel(statRec);
        
        pane.add("Clicker", clicker);
        pane.add("Store", store);
        pane.add("Stats", stats);
        pane.add("Saves", saves);
        pane.add("Info", info); 
    }
    public void actionPerformed(ActionEvent e) {
        statRec.tick(); 
        time.tick(); 
        if(pane.getSelectedIndex() == pane.indexOfTab("Clicker")) {
            clicker.refresh();
        }
        else if(pane.getSelectedIndex() == pane.indexOfTab("Store")) {
            store.refresh();
        }
        else if(pane.getSelectedIndex() == pane.indexOfTab("Stats")) {
            stats.refresh(); 
        }
    }
    public void goldRush() {
        pane.insertTab("Gold", null, goldRush, null, 1);
        pane.setSelectedIndex(pane.indexOfTab("Gold")); 
        tasks.schedule(new TimerTask() {
            @Override
            public void run() {
                if (pane.getSelectedIndex() == pane.indexOfTab("Gold")) {
                    pane.setSelectedIndex(pane.indexOfTab("Clicker"));
                } 
                pane.remove(pane.indexOfTab("Gold")); 
                statRec.addCookies(goldRush.reset()); 
            }
        }, 10000);
    }
    public void exit() {
        if(pane.indexOfTab("Exit") == -1) {
            pane.add("Exit", exit);
            pane.setSelectedIndex(pane.indexOfTab("Exit"));
            tasks.schedule(new TimerTask() {        
                    @Override
                    public void run() {
                        if(pane.indexOfTab("Exit") > -1) {
                            pane.remove(pane.indexOfTab("Exit")); 
                        }
                    }   
            }, 5000);
        }
    }
    public static void labelify(JLabel label, int size) {
        label.setForeground(textColor); 
        label.setBackground(cookieColor);
        label.setFont(new Font("Mshtakan", Font.BOLD, size)); 
        label.setOpaque(true);
    }
    public static void buttonify(JButton button, int size) {
        button.setBorder(b); 
        button.setFont(new Font("Mshtakan", Font.BOLD, size)); 
        button.setBackground(cookieColor);
        button.setForeground(textColor); 
        button.setFocusPainted(false);
    }   
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER && e.isControlDown() && pane.getSelectedIndex() == pane.indexOfTab("Info")) {
            if(pane.indexOfTab("dev") == -1) {
                pane.add("dev", dev);
                pane.setSelectedIndex(pane.indexOfTab("dev")); 
            }
            else {
                pane.setSelectedIndex(pane.indexOfTab("Clicker")); 
                pane.remove(pane.indexOfTab("dev")); 
            }
        }
    } public void keyTyped(KeyEvent e) {} public void keyPressed(KeyEvent e) {}
    private void save() {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setPreferredSize(new Dimension(1000, 500    ));
            chooser.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int returnValue = chooser.showOpenDialog(null);
            if(returnValue == JFileChooser.APPROVE_OPTION) {
                File fileSelected = chooser.getSelectedFile();
                FileOutputStream fileOut = new FileOutputStream(fileSelected + ".ser");
                ObjectOutputStream save = new ObjectOutputStream(fileOut);
                save.writeObject(statRec);
                save.close(); 
            }
        }
        catch(IOException e) {}  // e.printStackTrace(); DEBUG
    }
    private void load() { 
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(new FileNameExtensionFilter("Text files", "ser")); 
            chooser.setPreferredSize(new Dimension(1000, 500));
            chooser.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
            int returnValue = chooser.showOpenDialog(null);
            if(returnValue == JFileChooser.APPROVE_OPTION) {
                File fileSelected = chooser.getSelectedFile();
                FileInputStream fileIn = new FileInputStream(fileSelected);
                ObjectInputStream input = new ObjectInputStream(fileIn);
                Stats load = (Stats) input.readObject();
                statRec.setCookies(load.getCookies());
                statRec.setCookiesMade(load.getCookiesMade());
                statRec.setCookiesSpent(load.getCookiesSpent());
                statRec.setRawClicks(load.getRawClicks());
                statRec.setWorkers(load.getWorkers());
                statRec.setBuisnessmen(load.getBuisnessmen());
                statRec.setScientists(load.getScientists());
                statRec.setStands(load.getStands());
                statRec.setFactories(load.getFactories());
                statRec.setExtraHands(load.getExtraHands());
                statRec.setTime(load.getTime()); 
                input.close(); 
            }
        }
        catch(IOException e) {}  // e.printStackTrace(); DEBUG
        catch(Exception e) {}
    }
}