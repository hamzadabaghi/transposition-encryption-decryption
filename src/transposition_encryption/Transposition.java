package transposition_encryption;

import java.util.ArrayList;
import java.util.Arrays;

public class Transposition {

    private final String string;
    private final Integer[] p;
    private String encryptedString = "";
    private String decryptedString = "";

    public Transposition(String string, Integer[] key) {
        this.p = key;
        this.string = string;
    }

    public String encryption() {
        int lines = 0;
        String[] letters = string.split("");
        lines = (letters.length / p.length) + (letters.length % p.length);
        ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < p.length; i++)
            matrix.add(new ArrayList<String>());
        int c = 0;
        int i = 0;
        int j = 0;
        while (c < lines) {
            c++;
            for (int k = 0; k < p.length; k++) {
                try {
                    matrix.get(k).add(letters[j++]);
                } catch (Exception e) {
                    break;
                }
            }
        }

        System.out.println(matrix);
        for (int f = 1; f <= p.length; f++) {
            encryptedString += String.join("", matrix.get(Arrays.asList(p).indexOf(f)));
        }
        return encryptedString;
    }

    public static String dechiffrement(String key, String text) {
        int[] arrange = arrangeKey(key);
        int lenkey = arrange.length;
        int lentext = text.length();

        int row = (int) Math.ceil((double) lentext / lenkey);

        String regex = "(?<=\\G.{" + row + "})";
        String[] get = text.split(regex);

        char[][] grid = new char[row][lenkey];

        for (int x = 0; x < lenkey; x++) {
            for (int y = 0; y < lenkey; y++) {
                if (arrange[x] == y) {
                    for (int z = 0; z < row; z++) {
                        grid[z][y] = get[arrange[y]].charAt(z);
                    }
                }
            }
        }

        String dec = "";
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < lenkey; y++) {
                dec = dec + grid[x][y];
            }
        }

        return dec;
    }
    public static int[] arrangeKey(String key) {
        //arrange position of grid
        String[] keys = key.split("");
        Arrays.sort(keys);
        int[] num = new int[key.length()];
        for (int x = 0; x < keys.length; x++) {
            for (int y = 0; y < key.length(); y++) {
                if (keys[x].equals(key.charAt(y) + "")) {
                    num[y] = x;
                    break;
                }
            }
        }

        return num;
    }

}
