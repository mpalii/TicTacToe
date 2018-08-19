package tictactoe;

import tictactoe.data.Area;
import tictactoe.data.GameProcessPVM;
import tictactoe.data.GameProcessPVP;
import tictactoe.data.Player;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        int gameMode = -1;

        System.out.println("Выберите режим: " +
                "\n- одиночная игра (введите 1);" +
                "\n- игра вдвоем (введите 2).");

        while (true) {
            gameMode = readUserInput();
            if (gameMode == 1 || gameMode == 2)
                break;
            else
                System.out.println("Повторно выберите режим игры:");
        }

        if (gameMode == 2)
            launchTwoPlayerMode();
        else
            launchSinglePlayerMode();
    }


    private static int readUserInput() {
        int x = -1;
        try {
            x = new Scanner(System.in).nextInt();
        } catch (InputMismatchException ex) {
        }
        return x;
    }

    private static void launchTwoPlayerMode() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int firstPlayerNumber = random.nextInt(2) + 1;
        Player player1, player2;

        System.out.println("Введите имя первого игрока: ");
        String firstPlayerName = scanner.next();

        System.out.println("Введите имя второго игрока: ");
        String secondPlayerName = scanner.next();

        if (firstPlayerNumber == 1) {
            player1 = new Player(firstPlayerName, 'X');
            player2 = new Player(secondPlayerName, 'O');
        } else {
            player1 = new Player(secondPlayerName, 'X');
            player2 = new Player(firstPlayerName, 'O');
        }

        Area area = new Area();

        GameProcessPVP gameProcess = new GameProcessPVP(player1, player2, area);
        gameProcess.start();
    }

    private static void launchSinglePlayerMode() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int playerNumber = random.nextInt(2) + 1;
        Player player;

        System.out.println("Введите Ваше имя: ");
        String playerName = scanner.next();

        if (playerNumber == 1)
            player = new Player(playerName, 'X');
        else
            player = new Player(playerName, 'O');

        Area area = new Area();

        GameProcessPVM gameProcessPVMEasy = new GameProcessPVM(player, area);
        gameProcessPVMEasy.start();
    }

}
