

import java.util.Collections;

public class ConsoleView {
    public static int step = 0;
    private static final String top10 = formatDiv("a ") + String.join("", Collections.nCopies(Main.TEAM_SIZE - 1, formatDiv("-b "))) + formatDiv("-c");
    private static final String mid10 = formatDiv("d ") + String.join("", Collections.nCopies(Main.TEAM_SIZE - 1, formatDiv("-e "))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g ") + String.join("", Collections.nCopies(Main.TEAM_SIZE - 1, formatDiv("-h "))) + formatDiv("-i");

    public static void view(){
        if (step++ == 0) {
            System.out.print(AnsiColors.ANSI_RED+"First step!"+AnsiColors.ANSI_RESET);
            System.out.print(AnsiColors.ANSI_BLUE +
                    String.join("", Collections.nCopies(40, formatDiv(" "))) + "Blue Team" + AnsiColors.ANSI_RESET);
            System.out.println(AnsiColors.ANSI_GREEN +
                    String.join("", Collections.nCopies(40, formatDiv(" "))) + "Green Team" + AnsiColors.ANSI_RESET);
        } else {
            System.out.print(AnsiColors.ANSI_RED + "Step: "+step+AnsiColors.ANSI_RESET);
            System.out.print(AnsiColors.ANSI_BLUE +
                    String.join("", Collections.nCopies(20, formatDiv(" "))) + "Blue Team" + AnsiColors.ANSI_RESET);
            System.out.println(AnsiColors.ANSI_GREEN +
                    String.join("", Collections.nCopies(20, formatDiv(" "))) + "Green Team" + AnsiColors.ANSI_RESET);
        }

        System.out.println(ConsoleView.top10);

        int npcIndex = 0;

        for (int i = 1; i <= Main.TEAM_SIZE - 1; i++) {
            for (int j = 1; j <= Main.TEAM_SIZE; j++) {
                System.out.print(getChar(new Vector2(i, j)));
            }
            System.out.print("|");
            System.out.println(PrintInfo(npcIndex));
            System.out.println(ConsoleView.mid10);
            npcIndex++;
        }

        for (int j = 1; j <= Main.TEAM_SIZE; j++) {
            System.out.print(getChar(new Vector2(10, j)));
        }
        System.out.print("|");
        System.out.println(PrintInfo(npcIndex));
        System.out.println(ConsoleView.bottom10);
    }

    private static String getChar(Vector2 position){

        String str = "|__";
        boolean alive = false;
        for (int i = 0; i < Main.TEAM_SIZE; i++) {
            if (Main.leftSide.get(i).getPosition().isEquals(position))
            {
                if(Main.leftSide.get(i).hp == 0)
                    str ="|"+AnsiColors.ANSI_RED+Main.leftSide.get(i).name.substring(0, 2)+AnsiColors.ANSI_RESET;
                else {
                    str ="|"+AnsiColors.ANSI_GREEN+Main.leftSide.get(i).name.substring(0, 2)+AnsiColors.ANSI_RESET;
                    alive = true;
                }
            }
            if (Main.rightSide.get(i).getPosition().isEquals(position) && !alive)
            {
                if(Main.rightSide.get(i).hp == 0)
                    str ="|"+AnsiColors.ANSI_RED+ Main.rightSide.get(i).name.substring(0, 2)+AnsiColors.ANSI_RESET;
                else str ="|"+AnsiColors.ANSI_BLUE+ Main.rightSide.get(i).name.substring(0, 2)+AnsiColors.ANSI_RESET;
            }
        }
        return str;
    }

    private static String PrintInfo(int npcIndex)
    {
        String str = "";

        if(Main.rightSide.get(npcIndex).hp == 0)
            str +="     " + AnsiColors.ANSI_RED+Main.rightSide.get(npcIndex).toString()+AnsiColors.ANSI_RESET;
        else str +="     " + AnsiColors.ANSI_BLUE+Main.rightSide.get(npcIndex).toString()+AnsiColors.ANSI_RESET;
        if(Main.leftSide.get(npcIndex).hp == 0)
            str +="     " + AnsiColors.ANSI_RED+Main.leftSide.get(npcIndex).toString()+AnsiColors.ANSI_RESET;
        else str +="     " + AnsiColors.ANSI_GREEN+Main.leftSide.get(npcIndex).toString()+AnsiColors.ANSI_RESET;

        return str;
    }

    private static String formatDiv(String str){
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500')
                .replace("s", "...")
                .replace("o", "___");
    }
}
