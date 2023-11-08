import Figures.Bishop;
import Figures.Figure;
import Figures.King;
import Figures.Knight;
import Figures.Pawn;
import Figures.Queen;
import Figures.Rook;

import java.util.ArrayList;

public class Board {
//TODO: Список фигур и начальное положение всех фигур
    private Figure  fields[][] = new Figure[8][8];
    private ArrayList<String> takeWhite = new ArrayList(16);
    private ArrayList<String> takeBlack = new ArrayList(16);

    public char getColorGaming() {
        return colorGaming;
    }

    public void setColorGaming(char colorGaming) {
        this.colorGaming = colorGaming;
    }

    private char colorGaming;

    public void init(){
        this.fields[0] = new Figure[]{
                new Rook("R", 'w'), new Knight("N", 'w'),
                new Bishop("B", 'w'), new Queen("Q", 'w'),
                new King("K", 'w'), new Bishop("B", 'w'),
                new Knight("N", 'w'),new Rook("R", 'w')
        };
        this.fields[1] = new Figure[]{
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
                new Pawn("P", 'w'),    new Pawn("P", 'w'),
        };

        this.fields[7] = new Figure[]{
                new Rook("R", 'b'), new Knight("N", 'b'),
                new Bishop("B", 'b'), new Queen("Q", 'b'),
                new King("K", 'b'), new Bishop("B", 'b'),
                new Knight("N", 'b'),new Rook("R", 'b')
        };
        this.fields[6] = new Figure[]{
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
                new Pawn("P", 'b'),    new Pawn("P", 'b'),
        };
    }

    public String getCell(int row, int col){
        Figure figure = this.fields[row][col];
        if (figure == null){
            return "    ";
        }
        return " "+figure.getColor()+figure.getName()+" ";
    }

    public ArrayList<String> getTakeWhite() {
        return takeWhite;
    }

    public ArrayList<String> getTakeBlack() {
        return takeBlack;
    }

    public boolean move_figure(int row1, int col1, int row2, int col2 ){

        Figure figure =  this.fields[row1][col1];

        //ход фигур с учетом препятствий
        if(!this.path_clear(row1, col1, row2, col2)){
            return false;
        }

        if (figure.canMove(row1, col1, row2, col2) && this.fields[row2][col2]==null){
            System.out.println("move");
            this.fields[row2][col2] = figure;
            this.fields[row1][col1] = null;
            return true;
        } else if (figure.canAttack(row1, col1, row2, col2) && this.fields[row2][col2] != null
                && this.fields[row2][col2].getColor() != this.fields[row1][col1].getColor() ){
            System.out.println("attack");
            //Условие запрета на атаку короля
            if(this.fields[row2][col2] instanceof King){
                return false;
            }

           switch (this.fields[row2][col2].getColor()){
            case 'w': this.takeWhite.add(this.fields[row2][col2].getColor()+this.fields[row2][col2].getName());break;
            case 'b': this.takeBlack.add(this.fields[row2][col2].getColor()+this.fields[row2][col2].getName());break;
            }
            this.fields[row2][col2] = figure;
            this.fields[row1][col1] = null;
            return true;
        }
        return false;





    }

    public void print_board(){
        System.out.println(" +----+----+----+----+----+----+----+----+");
        for(int row = 7; row > -1; row--){
            System.out.print(row);
            for(int col = 0; col< 8; col++){
                System.out.print("|"+getCell(row, col));
             }
            System.out.println("|");
            System.out.println(" +----+----+----+----+----+----+----+----+");
        }

        for(int col = 0; col < 8; col++){
            System.out.print("    "+col);
        }


    }
    //функция проверки на препятствия
    private boolean path_clear(int row, int col, int row1, int col1) {
        int startRow = Math.min(row, row1);
        int endRow = Math.max(row, row1);
        int startCol = col;
        int endCol = col1;

        if (startRow == endRow) {
            for (int c = Math.min(startCol, endCol) + 1; c < Math.max(startCol, endCol); c++) {
                if (fields[startRow][c] != null) {
                    return false;
                }
            }
        } else if (startCol == endCol) {
            for (int r = startRow + 1; r < endRow; r++) {
                if (fields[r][startCol] != null) {
                    return false;
                }
            }
        }

        return true;
    }
    //функция шаха
    public boolean Check() {
        char selected_color=this.getColorGaming();
        int kingRow = 0;int kingCol = 0;
        boolean f_king = false;
        for (int row = 0; row < 8 && !f_king; row++) {
            for (int col = 0; col < 8 && !f_king; col++) {
                if (fields[row][col] != null && fields[row][col].getColor() == selected_color && fields[row][col] instanceof King) {
                    kingRow = col;
                    kingCol = row;
                    f_king = true;
                }
            }
        }
        if (!f_king) return false;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (fields[row][col] != null && fields[row][col].getColor() != selected_color) {
                    if (fields[row][col].canAttack(row, col, kingCol, kingRow)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //функция мата
    public boolean CheckMate() {
        char selected_color=this.getColorGaming();
        if (!Check()) return false;
        for (int row = 0; row < 8; row++) {
            for (int col = 0;col< 8; col++) {
                if (fields[row][col] != null && fields[row][col].getColor() == selected_color) {
                    Figure figure = fields[row][col];
                    for (int Col = 0; Col < 8; Col++) {
                        for (int Row = 0; Row < 8; Row++) {
                            if (figure.canMove(row, col, Row, Col)) {
                                Figure occup_cell = fields[Col][Row];
                                fields[Col][Row] = figure;
                                fields[row][col] = null;
                                boolean inCheck = Check();
                                fields[row][col] = figure;
                                fields[Col][Row] = occup_cell;
                                if (!inCheck) return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
