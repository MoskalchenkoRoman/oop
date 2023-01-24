import java.util.ArrayList;
import java.util.Random;

public class Magic extends Hero{
    private int magic;

    public Magic(String name, String type, int attack, int defence, int[] damage, int hp, int speed, int magic) {
        super(name, type, attack, defence, damage, hp, speed);
        this.magic = magic;
    }

    @Override
    public String toString() {
        return super.toString() +
                " magic= " + magic;
    }


    @Override
    public void step(ArrayList<Hero> listHeroes) {
        int remainsHp = 100;
        int idHero = 0;
        for (int i = 0; i < listHeroes.size(); i++) {
            String[] obge = listHeroes.get(i).getInfo().split(" ");
            if (Integer.parseInt(obge[1]) < 100) {
                int injury = Integer.parseInt(obge[1]);
                if (injury < remainsHp){
                    remainsHp = injury;
                    idHero = i;

                }
            }
        }
        listHeroes.get(idHero).newhp -= damage[0];
        if (listHeroes.get(idHero).newhp > listHeroes.get(idHero).hp){
            listHeroes.get(idHero).newhp = listHeroes.get(idHero).hp;
        }
        System.out.println();
        System.out.println("Спасен: " + listHeroes.get(idHero));

    }
}
