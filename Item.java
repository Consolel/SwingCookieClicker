    package ConsolesCookieClicker;
import java.io.Serializable;
public class Item implements Serializable {
	private int price;
    private int level;    
    private int amount; 
    private int startingLevel;
    public Item(int price, int level) {
        this.price = price;
        this.level = level;
        this.startingLevel = level; 
        amount = 0; 
    }
    public int getPrice() {
        return price; 
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    // price goes up by level * 50 every time you buy. Level is determined by amount / 5. 
    public boolean buy(int cookies) {
        if(cookies >= price) {
            amount++;
            price += level * 50; 
            if(amount >= 5) {
                level = startingLevel + (amount / 5); 
            }
            return true;
        }
        else {
            return false;    
        }
    }
}