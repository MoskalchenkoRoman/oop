import java.util.ArrayList;
import java.util.Arrays;

public abstract class Hero implements Game{
    private String name, type;
    private int attack, defence, hp, newhp, speed;
    private int[] damage;

    public Hero(String name, String type, int attack, int defence, int[] damage, int hp, int speed) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.defence = defence;
        this.damage = damage;
        this.hp = hp;
        this.newhp = this.hp;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public String getType() {return type;}

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int[] getDamage() {
        return damage;
    }

    public int getHp() {
        return hp;
    }

    public int getSpeed() {return speed; }

    @Override
    public String toString() {
        return "Name=" + name +
                ", type=" + type +
                ", attack=" + attack +
                ", defence=" + defence +
                ", damage=" + Arrays.toString(damage) +
                ", hp=" + hp +
                ", newhp=" + newhp +
                ", speed=" + speed;
    }

    public void step(){

    }

    @Override
    public String getInfo(){

        return type + name + " Имеет здоровья: " + newhp + " из " + hp;
    }

    public abstract void step(ArrayList<Hero> listHeroes);
}
