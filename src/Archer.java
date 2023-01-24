import java.util.ArrayList;

public class Archer extends Hero {
    private int shoots;

    public Archer(String name, String type, int attack, int defence, int shoots, int[] damage, int hp, int speed) {
        super(name, type, attack, defence, damage, hp, speed);
        this.shoots = shoots;
    }

    @Override
    public String toString() {
        return super.toString() + " shoots= " + shoots;
    }

    @Override
    public void step(ArrayList<Hero> listHeroes) {
        for (int i = 0; i < listHeroes.size(); i++) {
            if (listHeroes.get(i).getType().equals("Peasant")) {
                if (((Peasant) listHeroes.get(i)).delivery > 0) {
                    ((Peasant) listHeroes.get(i)).delivery -= 1;
                    System.out.println(this.getType() + " стреляет и остакот стрел у него" + shoots);
                    return;
                } else {
                    continue;
                }
            }
        }
        shoots -= 1;
        System.out.println(this.getType() + " стреляет и остакот стрел у него" + shoots);

    }
}
