package tictactoe.data;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameProcessPVM {
    private Area area;
    private Player player;

    public GameProcessPVM(Player player, Area area) {
        this.player = player;
        this.area = area;
    }

    public void start() {
        Random random = new Random();
        char computerMark;

        if (player.getMark() == 'X')
            computerMark = 'O';
        else
            computerMark = 'X';

        if (player.getMark() == 'X') {
            nextStep(player, area);
        }

        while (true) {
            // ход компьютера
            System.out.println("Компьютер сделал свой ход - " + computerMark + ".");
            while (true) {
                int x = random.nextInt(3);
                int y = random.nextInt(3);
                if (!area.getField(x, y).getSet()) {
                    area.setField(x, y, computerMark);
                    break;
                }
            }

            if (area.checkForLine()) {
                area.printField();
                System.out.println("Конец игры! Вы проиграли");
                break;
            }

            if (Cell.getCount() == 0) {
                System.out.println("Конец игры! Ничья!");
                break;
            }

            // ход игрока
            nextStep(player, area);
            if (area.checkForLine()) {
                area.printField();
                System.out.println("Конец игры! Победитель - " + player.getName());
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
