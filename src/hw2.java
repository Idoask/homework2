import java.util.Scanner;

public class hw2 {
    public static void main(String[] args) {

    }

    public static void gameManger() {
        char[] board = new char[9];
        for (int i = 0; i < board.length; i++) {
            board[i] = '-';
        }
        char correntplayer = 'x';
        char winner = checkWinner(board);
        while (winner == '-') {
            board[getPostionFromUser(board)] = correntplayer;
            printBoard(board);
            if (correntplayer == 'x') {
                correntplayer = '0';
            } else {
                correntplayer = 'x';
            }
            winner = checkWinner(board);
        }
        System.out.println(winner + " won the game");
    }

    public static boolean placeSymbolOnBoard(char[] board, int userchoice, char sign) {
        board[userchoice] = sign;
        printBoard(board);
        if (checkWinner(board) == '-') {
            return false;
        } else {
            return true;
        }
    }

    public static char checkWinner(char[] board) {
        if (winnerbyrow(board) == '-' && winnerbycolumn(board) == '-' && winnerbydiagonal(board) == '-') {
            return '-';
        } else {
            if (winnerbyrow(board) != '-')
                return winnerbyrow(board);
            if (winnerbycolumn(board) != '-')
                return winnerbycolumn(board);
            if (winnerbydiagonal(board) != '-')
                return winnerbydiagonal(board);
        }
        return '-';
    }

    public static char winnerbyrow(char[] board) {
        if (board[0] == board[1] && board[1] == board[2] && hadAssignment(board,1)) {
            return board[0];
        }
        if (board[3] == board[4] && board[4] == board[5] && hadAssignment(board,3)) {
            return board[3];
        }
        if (board[6] == board[7] && board[7] == board[8] && hadAssignment(board,6)) {
            return board[6];
        }
        return '-';
    }

    public static char winnerbydiagonal(char[] board) {
        if (board[0] == board[4] && board[4] == board[8] && hadAssignment(board,0)) {
            return board[0];
        }
        if (board[2] == board[4] && board[4] == board[6] && hadAssignment(board,2)) {
            return board[2];
        }
        return '-';
    }

    public static char winnerbycolumn(char[] board) {
        if (board[0] == board[3] && board[3] == board[6] && hadAssignment(board,0)) {
            return board[0];
        }
        if (board[1] == board[4] && board[4] == board[7] && hadAssignment(board,1)) {
            return board[1];
        }
        if (board[2] == board[5] && board[5] == board[8] && hadAssignment(board,2)) {
            return board[2];
        }
        return '-';
    }
    public static boolean hadAssignment(char[] board, int i){
        return board[i] != '-';
    }

    public static int getPostionFromUser(char[] board) {
        Scanner se = new Scanner(System.in);
        System.out.println("enter a number between 1-9 ");
        int userchoice = se.nextInt();
        while (userchoice < 1 || userchoice > 9) {
            System.out.println("enter a number between 1-9");
            userchoice = se.nextInt();
        }
        while (isAvailable(board, userchoice - 1) == false) {
            System.out.println("not available");
            userchoice = se.nextInt();
        }
        return userchoice - 1;
    }

    public static boolean isAvailable(char[] board, int index) {
        if (board[index] == 'x' || board[index] == '0') {
            return false;
        }
        return true;
    }

    public static void printBoard(char[] board) {
        for (int i = 0; i < board.length; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("");
            }
            System.out.print(board[i] + " ");
        }
        System.out.println("");
    }

    public static String phoneFormat(String original) {
        if (isformat2(original) == true) {
            return original;
        }
        if (isformat3(original)) {
            original = original.substring(0, 3) + '-' + original.substring(3, original.length());
            return original;
        }
        if (isformat1(original)) {
            original = "0" + original.substring(3, original.length());
            original = original.substring(0, 3) + '-' + original.substring(3, original.length());
            return original;
        }
        return "-1";
    }

    public static boolean isformat3(String number) {
        if (number.length() != 10) {
            return false;
        }
        if (number.substring(0, 2).equals("05") == false) {
            return false;
        }
        return true;
    }

    public static boolean isformat1(String number) {
        if (number.length() != 12) {
            return false;
        }
        if (number.substring(0, 4).equals("9725") == false) {
            return false;
        }
        return true;
    }

    public static boolean isformat2(String number) {
        if (number.length() != 11) {
            return false;
        }
        if (number.substring(0, 2).equals("05") == false) {
            return false;
        }
        if (number.charAt(3) != '-') {
            return false;
        }
        return true;
    }

    public static boolean stringInsidestring(String a, String b) {
        if (a.length() < b.length()) {
            return false;
        }
        int index = 0;
        for (int i = 0; i < a.length(); i++) {
            if (b.charAt(index) == a.charAt(i)) {
                index = index + 1;
            } else {
                index = 0;
            }
            if (index == b.length()) {
                return true;
            }
        }
        return false;
    }

    public static int arrayUpOrDown(int[] input) {
        int maxindex = maxNumInArray(input);
        if (isup(input, maxindex) && isdown(input, maxindex)) {
            return maxindex;
        }
        return -1;
    }

    public static boolean isdown(int[] input, int index) {
        for (int i = index; i < input.length - 1; i++) {
            if (input[i] <= input[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isup(int[] input, int index) {
        for (int i = 0; i < index - 1; i++) {
            if (input[i] >= input[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int maxNumInArray(int[] input) {
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < input.length; i++) {
            if (max < input[i]) {
                max = input[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static boolean ifintersection(int[] input, int[] input2) {
        if (intersection(input, input2).length == 0) {
            return true;
        }
        return false;
    }

    public static int[] intersection(int[] input, int[] input2) {
        int[] array = new int[Math.min(input.length, input2.length)];
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            if (ifNumIsInArray(input2, input[i]) && ifNumIsInArray(array, input[i]) == false) {
                array[index] = input[i];
                index = index + 1;
            }

        }
        int[] secondarray = new int[index];
        for (int i = 0; i < secondarray.length; i++) {
            secondarray[i] = array[i];
        }
        return secondarray;
    }

    public static boolean ifNumIsInArray(int[] input, int value) {
        for (int i = 0; i < input.length; i++) {
            if (value == input[i]) {
                return true;
            }
        }
        return false;
    }

    public static int[] noduplicactions(int[] input) {
        int[] secondarray = new int[input.length];
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            if (ifNumIsInArray(secondarray, input[i]) == false) {
                secondarray[index] = input[i];
                index = index + 1;
            }
        }
        int[] array3 = new int[index];
        int put = 0;
        for (int j = 0; j < array3.length; j++) {
            array3[j] = secondarray[j];

        }
        return array3;
    }

    public static void average() {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
            sum = sum + array[i];
        }
        double average = sum / array.length;
        for (int i = 0; i < array.length; i++) {
            if (average < array[i]) {
                System.out.println(array[i]);
            }
        }
    }


}
