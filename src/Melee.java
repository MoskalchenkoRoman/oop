import java.util.ArrayList;

public class Melee extends Hero{
    public Melee(String name, String type, int attack, int defence, int[] damage, int hp, int speed) {
        super(name, type, attack, defence, damage, hp, speed);
    }

    @Override
    public void step(ArrayList<Hero> listHeroes) {

    }
}
