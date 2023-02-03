import java.util.ArrayList;

public class Warriors extends BaseHero {
    public Warriors(ArrayList<BaseHero> myTeam, String name, int hp, int attack, int defence, int[] damage, int speed, int x, int y) {
        super(myTeam, name, hp, attack, defence, damage, speed, x, y);
    }

    @Override
    public String toString() {
        return String.format("%s %11s", super.toString()," ");
    }

    public void step(ArrayList<BaseHero> teamList) {
        if (this.hp == 0) {
            System.out.println(AnsiColors.ANSI_RED + this.name + " " + this.getClass().getSimpleName() + " is dead ❌☠️" + AnsiColors.ANSI_RESET);
            return;
//
        }
        float min = Float.MAX_VALUE;
        int index = 0;
        int damage;
        for (int i = 0; i < teamList.size(); i++) {
            if (teamList.get(i).hp != 0) {
                if (min > getDistance(teamList.get(i).position.x, teamList.get(i).position.y)) {
                    min = getDistance(teamList.get(i).position.x, teamList.get(i).position.y);
                    index = i;
                }
            }
        }
        float posX = this.position.x - teamList.get(index).position.x;
        float posY = this.position.y - teamList.get(index).position.y;
        if (posX == 0){
            if (posY < 0){
                this.position.y += 1;
            } else {
                this.position.y -= 1;
            }
        }
        if (posX > 0){
            this.position.x -= 1;
        } else {
            this.position.x += 1;
        }
    }
}
