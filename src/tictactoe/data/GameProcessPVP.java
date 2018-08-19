package tictactoe.data;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameProcessPVP {
    Area area;
    Player player1;
    Player player2;

    public GameProcessPVP(Player player1, Player player2, Area area) {
        this.player1 = player1;
        this.player2 = player2;
        this.area = area;
    }

    public void start() {
        while (true) {
            nextStep(player1, area);
            if (area.checkForLine()) {
                area.printField();
                System.out.println("Конец игры! Победитель - " + player1.getName());
                break;
            }

            if (Cell.getCount() == 0) {
                System.out.println("Конец игры! Ничья!");
                break;
            }

            nextStep(player2, area);
            if (area.checkForLine()) {
                area.printField();
                System.out.println("Конец игры! Победитель - " + player2.getName());
                break;
            }
            if (Cell.getCount() == 0) {
                System.out.println("Конец игры! Ничья!");
                break;
            }
        }

    }

    private void nextStep(Player player, Area area) {
        int x, y;
        area.printField();
        System.out.println("Ход игрока " + player.getName() + " - " + player.getMark() + ".");

        while (true) {
            System.out.println("Ведите номер строки, используя значения от 1 до 3: ");
            x = readUserInput();

            System.out.println("Ведите номер столбца, используя значения от 1 до 3: ");
            y = readUserInput();

            if (y < 0 || y > 2 || x < 0 || x > 2) {
                System.out.println("Неверный ввод данных. Повторите попытку.\n");
                continue;
            }
            if (area.getField(x, y).getSet()) {
                System.out.println("Выбранная ячейка уже помечена!\n");
                continue;
            }
            break;
        }

        area.setField(x, y, player.getMark());
    }

    private int readUserInput() {
        int x = -1;
        try {
            x = new Scanner(System.in).nextInt() - 1;
        } catch (InputMismatchException ex) {
        }
        return x;
    }

}

