package tictactoe.data;

public class Area {
    private Cell[][] field;

    public Area() {
        field = new Cell[3][3];
        for (int i = 0; i < field.length; i++)
            for (int j = 0; j < field[i].length; j++)
                field[i][j] = new Cell();
    }

    public void printField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++)
                System.out.print("[" + field[i][j].getValue() + "]");
            System.out.println();
        }
    }

    public Cell getField(int x, int y) {
        return field[x][y];
    }

    public void setField(int x, int y, char mark) {
        field[x][y].setCell(mark);
    }

    public boolean checkForLine() {
        if (field[0][0].getValue() == 'O' &&
                field[0][1].getValue() == 'O' &&
                field[0][2].getValue() == 'O')
            return true;
        else if (field[1][0].getValue() == 'O' &&
                field[1][1].getValue() == 'O' &&
                field[1][2].getValue() == 'O')
            return true;
        else if (field[2][0].getValue() == 'O' &&
                field[2][1].getValue() == 'O' &&
                field[2][2].getValue() == 'O')
            return true;
        else if (field[0][0].getValue() == 'O' &&
                field[1][0].getValue() == 'O' &&
                field[2][0].getValue() == 'O')
            return true;
        else if (field[0][1].getValue() == 'O' &&
                field[1][1].getValue() == 'O' &&
                field[2][1].getValue() == 'O')
            return true;
        else if (field[0][2].getValue() == 'O' &&
                field[1][2].getValue() == 'O' &&
                field[2][2].getValue() == 'O')
            return true;
        else if (field[0][0].getValue() == 'O' &&
                field[1][1].getValue() == 'O' &&
                field[2][2].getValue() == 'O')
            return true;
        else if (field[0][2].getValue() == 'O' &&
                field[1][1].getValue() == 'O' &&
                field[2][0].getValue() == 'O')
            return true;
        else if (field[0][0].getValue() == 'X' &&
                field[0][1].getValue() == 'X' &&
                field[0][2].getValue() == 'X')
            return true;
        else if (field[1][0].getValue() == 'X' &&
                field[1][1].getValue() == 'X' &&
                field[1][2].getValue() == 'X')
            return true;
        else if (field[2][0].getValue() == 'X' &&
                field[2][1].getValue() == 'X' &&
                field[2][2].getValue() == 'X')
            return true;
        else if (field[0][0].getValue() == 'X' &&
                field[1][0].getValue() == 'X' &&
                field[2][0].getValue() == 'X')
            return true;
        else if (field[0][1].getValue() == 'X' &&
                field[1][1].getValue() == 'X' &&
                field[2][1].getValue() == 'X')
            return true;
        else if (field[0][2].getValue() == 'X' &&
                field[1][2].getValue() == 'X' &&
                field[2][2].getValue() == 'X')
            return true;
        else if (field[0][0].getValue() == 'X' &&
                field[1][1].getValue() == 'X' &&
                field[2][2].getValue() == 'X')
            return true;
        else if (field[0][2].getValue() == 'X' &&
                field[1][1].getValue() == 'X' &&
                field[2][0].getValue() == 'X')
            return true;
        else return false;
    }
}
