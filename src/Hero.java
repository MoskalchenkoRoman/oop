import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class Hero implements Game{
    Random random = new Random();
    private String name, type;
    protected int attack, defence, hp, newhp, speed;
    protected int[] damage;

    public Hero(String name, String type, int attack, int defence, int[] damage, int hp, int speed) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.defence = defence;
        this.damage = damage;
        this.hp = hp;
        this.newhp = this.hp - random.nextInt(hp);
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
                ", newhp=" + (newhp * 100/hp) + " %" +
                ", speed=" + speed;
    }

    public void step(){

    }

    @Override
    public String getInfo(){
        return type + " " + (newhp * 100/hp) + " %";
    }

    public abstract void step(ArrayList<Hero> listHeroes);
}
