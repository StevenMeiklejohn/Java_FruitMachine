package example.codeclan.com.fruitmachine;

/**
 * Created by user on 30/06/2017.
 */

public class User {

    private float money;
    private String name;

    public User(String name, float money){
        this.name = name;
        this.money = money;
    }

    public void spendMoney(double spend){
        this.money += spend;
     }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
