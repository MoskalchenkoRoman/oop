import java.util.*;

public class Main {
    public static void main(String[] args) {

//        ArrayList<Hero> heroes = new ArrayList<>();
        ArrayList<Hero> heroesParty1 = new ArrayList<>();
        ArrayList<Hero> heroesParty2 = new ArrayList<>();
//        GetHeroes(heroes);
//        System.out.println("=======ВЕСЬ СПИСОК======");
//        allHeroes(heroes);
//        System.out.println("=======ВЫБОРКА ПО КЛАССУ======");
//        parseHeroes(heroes,"Monk");
//        GetHeroes(heroesParty1, 1);
        GetHeroes(heroesParty2, 2);
//        allHeroes(heroesParty2);
        heroesParty2.sort(Comparator.comparing(Hero::getType));
        heroesParty2.forEach(n -> System.out.println(n.getInfo() + " ; "));
        heroesParty2.forEach(n -> n.step(heroesParty2));

    }

    public static String getRandomString(int length) {
        String str = "ЙФЯЧЫЦУВСМАКЕПИТРНГОЬБЛШЩДЮЖЗХ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(21);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    private static String[] NameHero(int size){
        String [] nameHeroes = new String[size];
        for (int i = 0; i < nameHeroes.length; i++) {
            nameHeroes[i] = getRandomString(nameHeroes.length);
        }
        return nameHeroes;
    }

    private static void GetHeroes(ArrayList<Hero> listHeroes, int numParty) {
        String [] nameHeroes = NameHero(10);
        System.out.println(Arrays.toString(nameHeroes));
        Random random = new Random();

        for (int i = 0; i < nameHeroes.length; i++) {
            int rand = random.nextInt(4);
            if (numParty == 1) {
                if (rand == 0) {
                    listHeroes.add(new Peasant(nameHeroes[i]));
                } else if (rand == 1) {
                    listHeroes.add(new Outlaw(nameHeroes[i]));
                } else if (rand == 2) {
                    listHeroes.add(new Sniper(nameHeroes[i]));
                } else if (rand == 3) {
                    listHeroes.add(new Sorcerer(nameHeroes[i]));
                }
            }
            else {
                if (rand == 0) {
                    listHeroes.add(new Peasant(nameHeroes[i]));
                } else if (rand == 1) {
                    listHeroes.add(new Spearman(nameHeroes[i]));
                } else if (rand == 2) {
                    listHeroes.add(new Crossbowman(nameHeroes[i]));
                } else if (rand == 3) {
                    listHeroes.add(new Monk(nameHeroes[i]));
                }
            }



//            if (rand == 0) {
//                listHeroes.add(new Peasant(nameHeroes[i]));
//            } else if (rand == 1) {
//                listHeroes.add(new Outlaw(nameHeroes[i]));
//            } else if (rand == 2) {
//                listHeroes.add(new Sniper(nameHeroes[i]));
//            } else if (rand == 3) {
//                listHeroes.add(new Sorcerer(nameHeroes[i]));
//            } else if (rand == 4) {
//                listHeroes.add(new Spearman(nameHeroes[i]));
//            } else if (rand == 5) {
//                listHeroes.add(new Crossbowman(nameHeroes[i]));
//            } else {
//                listHeroes.add(new Monk(nameHeroes[i]));
//            }
        }


    }

    private static void parseHeroes(ArrayList<Hero> listHeroes, String heroes) {
        for (Hero hero : listHeroes) {
            if (hero.getClass().getName().equals(heroes)) {
                System.out.println(hero);
            }
        }
    }
    private static void allHeroes(ArrayList<Hero> listHeroes) {
        for (Hero hero : listHeroes) {
                System.out.println(hero);
        }
    }
}
