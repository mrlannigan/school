import java.util.Random;

public class TwoDArrays {
    public static final char SAND = '.';
    public static final char TREASURE = 'X';

    public static void main(String[] args) {
        /**
         * Build the map with a random treasure location
         */
        char [][]map = buildMap(20, 20);

        /**
         * Display the user the map with row and column headers
         */
        displayMap(map);

        /**
         * Find the position of the treasure and output to the user
         */
        findTreasure(map);
    }

    /**
     * Build and place the treasure in a random location
     * @param rows number of rows on the map
     * @param cols number of columns on the map
     * @return a 2d treasure map
     */
    public static char[][] buildMap(int rows, int cols) {
        // Init the map
        char [][]map = new char[rows][cols];

        // Select a random location for the treasure
        Random rand = new Random();
        int rowPos = rand.nextInt(rows);
        int colPos = rand.nextInt(cols);

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                // if the row and col positions match, set the treasure
                if (rowPos == i && colPos == j) {
                    map[i][j] = TREASURE;
                } else {
                    // otherwise, output sand.
                    map[i][j] = SAND;
                }
            }
        }

        return map;
    }

    /**
     * Display the map with position headers
     * @param map 2d treasure map
     */
    public static void displayMap(char[][] map) {
        // loop over the rows
        for (int rowIndex = 0; rowIndex < map.length; rowIndex++) {
            // if the first row, output the column header positions
            if (rowIndex == 0) {
                // leave room for the row positions
                System.out.print(" \t");
                // loop the first row
                for (int i = 0; i < map[rowIndex].length; i++) {
                    // output the column header position
                    System.out.print((i + 1) + "\t");
                }
                // next line
                System.out.println();
            }

            // loop over the columns in the current row
            for (int colIndex = 0; colIndex < map[rowIndex].length; colIndex++) {
                // on first column, first output the row position header
                if (colIndex == 0) {
                    System.out.print((rowIndex + 1) + "\t");
                }
                // output the value of this position
                System.out.print(map[rowIndex][colIndex] + "\t");
            }

            // next line
            System.out.println();
        }
    }

    /**
     * Find the treasure given a 2d map
     * @param map 2d treasure map
     */
    public static void findTreasure(char[][] map) {
        // init found positions
        // We could add error handling so that if at the end of the loops
        // either position is -1, we could throw an error
        int rowPos = -1;
        int colPos = -1;

        // Loop rows then columns
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                // record the position if the value is the treasure
                if (map[i][j] == TREASURE) {
                    rowPos = i;
                    colPos = j;
                }
            }
        }

        // output the treasure position
        System.out.printf("Treasure is located at row %d and col %d.\n", rowPos + 1, colPos + 1);
    }
}
