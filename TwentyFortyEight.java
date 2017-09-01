
import java.util.Random;
import java.util.Scanner;

public class TwentyFortyEight {
    //This instance variable represents the board. Use this to make changes.
    private int[][] board;
    //This variable keeps track of the current score.
    private int score;
    private int boardWidth;

    //Part - 1
    //Constructor
    public void placeRandom() {
        // TODO
        Random random = new Random();
        int rand_num = random.nextInt(numBlanks());
        int index = 0;
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardWidth; j++) {
                if (board[i][j] == 0) {
                    index++;
                    if(index == rand_num)
                        board[i][j] = 2;
                }
            }
        }
    }

    public TwentyFortyEight(int boardWidth) {
        // TODO
        this.boardWidth = boardWidth;
        int[][] board = new int[boardWidth][boardWidth];
        this.board = board;
        score = 0;
        placeRandom();
    }

    //This function resets the board to its initial state
    public void reset() {
        // TODO
        for (int i = 0; i < boardWidth; i++) { // Reset all squares on the board to 0
            for (int j = 0; j < boardWidth; j++) {
                board[i][j] = 0;
            }
        }
        score = 0; //Reset the score to 0
        placeRandom(); //Place a 2 randomly on the board
    }

    //This function returns the total number of blank spaces on the board
    public int numBlanks() {
        // TODO
        int blank = 0;
        for(int i = 0 ; i < boardWidth; i++){
            for (int j = 0; j < boardWidth; j++){
                if (board[i][j] == 0){
                    blank++;
                }
            }
        }
        return blank;
    }

    //This function places a 2 at a random blank space on the board.
    //It does nothing if there are no blank spaces.


    //This function attempts to move a cell at coordinates fromboardWidth,fromCol to
    //the cell toboardWidth,toCol. Refer to the handout for movement rules.
    public boolean moveTo(int fromboardWidth, int fromCol, int toboardWidth, int toCol) {
        // TODO
        if (fromboardWidth<0 || toboardWidth<0 || fromCol<0 || toCol<0 ||
                fromboardWidth>board.length-1 || toboardWidth>board.length-1 ||
                fromCol>board.length-1 || toCol>board.length-1 ||
                board[fromboardWidth][fromCol]==0){
            return false;
        }else if ((Math.abs(fromboardWidth-toboardWidth)==1 && Math.abs(fromCol-toCol)==0) ||
                (Math.abs(toboardWidth-fromboardWidth)==0 && Math.abs(toCol-fromCol)==1)){
            if (board[toboardWidth][toCol] == 0){
                board[toboardWidth][toCol] = board[fromboardWidth][fromCol];
                board[fromboardWidth][fromCol] = 0;
                return true;
            }else if (board[toboardWidth][toCol] == board[fromboardWidth][fromCol]){
                board[toboardWidth][toCol] = 2 * board[toboardWidth][toCol];
                board[fromboardWidth][fromCol] = 0;
                return true;
            }else return false;
        }else return false;
    }

    //The following four functions move the board in a single direction.
    public boolean moveUp() {
        //TODO
        int maxValue = 0;
        boolean result = false;
        for (int x = board.length-1; x > 0; x--){
            for (int y = 0; y < board[x].length; y++){
                if (moveTo(x,y,x-1,y)){
                    result = true;
                }
            }
        }
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] > maxValue){
                    maxValue = board[x][y];
                    if (maxValue > score){
                        score = maxValue;
                    }
                }
            }
        }
        return result;
    }

    public boolean moveDown() {
        // TODO
        int maxValue = 0;
        boolean result = false;
        for (int x = board.length-1; x >= 0; x--){
            for (int y = 0; y < board[x].length; y++){
                if (moveTo(x,y,x+1,y)){
                    //move element down
                    result = true;
                }
            }
        }
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] > maxValue){
                    maxValue = board[x][y];
                    if (maxValue > score){
                        score = maxValue;
                    }
                }
            }
        }
        //System.out.println(result);
        return result;
    }

    public boolean moveRight() {
        // TODO
        int maxValue = 0;
        boolean result = false;
        for (int x = 0; x < board.length; x++){
            for (int y = 0; y < board[x].length-1; y++){
//                moveTo(x,y,x,y+1);
                if (moveTo(x,y,x,y+1)){
                    result = true;
                }
            }
        }
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] > maxValue){
                    maxValue = board[x][y];
                    if (maxValue > score){
                        score = maxValue;
                    }
                }
            }
        }
        //System.out.println(result);
        return result;
    }
    public boolean moveLeft() {
        // TODO
        int maxValue = 0;
        boolean result = false;
        for (int x = 0; x < board.length; x++){
            for (int y = 1; y < board.length; y++){
//                moveTo(x,y,x,y-1);
                if (moveTo(x,y,x,y-1)){
                    result = true;
                }
            }
        }
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++) {
                if (board[x][y] > maxValue){
                    maxValue = board[x][y];
                    if (maxValue > score){
                        score = maxValue;
                    }
                }
            }
        }
        //System.out.println(result);
        return result;
    }

    ////////////////////////////////////////////////////////////////////////
    // Do not edit the methods below, they are for testing and running the
    // program.
    ////////////////////////////////////////////////////////////////////////
    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] newBoard) {
        board = newBoard;
    }


    public void showBoard() {
        for (int x = 0; x < boardWidth * 6 + 1; x++) {
            System.out.print("-");
        }
        System.out.println();

        for (int x = 0; x < boardWidth; x++) {
            for (int y = 0; y < boardWidth; y++) {
                String square = (board[x][y] == 0) ? "" : board[x][y] + "";
                System.out.printf("|%5s", square);
            }
            System.out.println("|");

            for (int y = 0; y < boardWidth * 6 + 1; y++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public int getScore() {return score;}


    /**
     * The main will allow you to play the game.
     *
     * @param args
     */
    public static void main(String args[]) {
        TwentyFortyEight tfe = new TwentyFortyEight(4);

        Scanner s = new Scanner(System.in);
        int bestScore = 0;
        boolean resetFlag = false;

        while (true) {
            System.out.println("Current score: " + tfe.getScore() + " | Best score: " + bestScore);
            tfe.showBoard();

            System.out.println("Enter up, down, left or right to move in that direction.");
            System.out.println("Enter reset to reset the game or quit to exit.");
            String line = s.nextLine();

            switch (line) {
                case "up":
                    while (tfe.moveUp()) {
                        // do nothing
                    }
                    break;
                case "down":
                    while (tfe.moveDown()) {
                        // do nothing
                    }
                    break;
                case "left":
                    while (tfe.moveLeft()) {
                        // do nothing
                    }
                    break;
                case "right":
                    while (tfe.moveRight()) {
                        // do nothing
                    }
                    break;
                case "reset":
                    tfe.reset();
                    resetFlag = true;
                    break;
                case "quit":
                    return;
                default:
                    System.out.println("Invalid move, Please try again!!!!\n");
                    continue;

            }

            bestScore = Math.max(bestScore, tfe.getScore());
            if (!resetFlag) {
                tfe.placeRandom();
                resetFlag = false;
            }
        }
    }

}