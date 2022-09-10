package ConsolesCookieClicker;
import java.io.Serializable;
public class Stats implements Serializable {
    private int cookies;
    private int cookiesMade;
    private int cookiesSpent;
    private int rawClicks;
    private int cookiesPerSecond; 
    private Item workers;
    private Item buisnessmen;
    private Item scientists;
    private Item stands;
    private Item factories;
    private Item extraHands;
    private CookieTimer time;
    // constructor for loading stats from a save. 
    public Stats(int cookies, int cookiesMade, int cookiesSpent, int rawClicks, Item workers, Item buisnessmen, Item scientists, Item stands, Item factories, Item extraHands, CookieTimer time) {
        this.cookies = cookies;
        this.cookiesMade = cookiesMade; 
        this.cookiesSpent = cookiesSpent;
        this.rawClicks = rawClicks; 
        this.workers = workers;
        this.buisnessmen = buisnessmen;
        this.scientists = scientists;
        this.stands = stands;
        this.factories = factories;
        this.extraHands = extraHands; 
        this.time = time; 
    }
    // constructor for when the game starts. 
    public Stats() {
        cookies = 0;
        cookiesMade = 0;
        cookiesSpent = 0;
        rawClicks = 0;
        cookiesPerSecond = 0; 
        workers = new Item(50, 1); 
        buisnessmen = new Item(100, 1); 
        scientists = new Item(200, 2); 
        stands = new Item(400, 2); 
        factories = new Item(800, 3); 
        extraHands = new Item(800, 4); 
    }
    // every second, add the amount of cookies made by all the items, and then update the variable for the label. 
    public void tick() {
        cookiesPerSecond = workers.getAmount() + buisnessmen.getAmount() * 2 + scientists.getAmount() * 4 + stands.getAmount() * 6 + factories.getAmount() * 8; 
        cookies += cookiesPerSecond;
        cookiesMade += cookiesPerSecond; 
    }
    public void click() {
        int amount = 1 + extraHands.getAmount(); 
        cookies += amount;
        cookiesMade += amount; 
        rawClicks++; 
    }
    public void purchased(int amount) {
        cookies -= amount;
        cookiesSpent += amount; 
    }
    public int getCookies() {return cookies;}
    public int getCookiesMade() {return cookiesMade;}
    public int getCookiesSpent() {return cookiesSpent;}
    public int getRawClicks() {return rawClicks;}
    public int getCookiesPerSecond() {return cookiesPerSecond;} 
    public Item getWorkers() {return workers;}
    public Item getBuisnessmen() {return buisnessmen;}
    public Item getScientists() {return scientists;}
    public Item getStands() {return stands;}
    public Item getFactories() {return factories;}
    public Item getExtraHands() {return extraHands;}
    public CookieTimer getTime() {return time;} 
    public void addCookies(int cookies) {this.cookies += cookies;}
    public void setCookies(int cookies) {this.cookies = cookies;}
    public void setCookiesMade(int cookiesMade) {this.cookiesMade = cookiesMade;}
    public void setCookiesSpent(int cookiesSpent) {this.cookiesSpent = cookiesSpent;}
    public void setRawClicks(int rawClicks) {this.rawClicks = rawClicks;}
    public void setWorkers(Item workers) {this.workers = workers;}
    public void setBuisnessmen(Item buisnessmen) {this.buisnessmen = buisnessmen;}
    public void setScientists(Item scientists) {this.scientists = scientists;}
    public void setStands(Item stands) {this.stands = stands;}
    public void setFactories(Item factories) {this.factories = factories;}
    public void setExtraHands(Item extraHands) {this.extraHands = extraHands;}
    public void setTime(CookieTimer time) {this.time = time;} 
}
