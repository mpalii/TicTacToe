package tictactoe.data;

public class Cell {
    private static int count = 9;
    private char value;
    private boolean wasSetted;

    public Cell() {
        value = '.';
        wasSetted = false;
    }

    public boolean getSet() {
        return wasSetted;
    }

    public void setCell(char value) {
        if (!wasSetted) {
            this.value = value;
            wasSetted = true;
            count--;
        }
    }

    public char getValue() {
        return value;
    }

    public static int getCount() {
        return count;
    }
}
