package challenge1;

import java.util.List;

public class Challenge5 {

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {

        int value = 0;

        for (int i = 0; i < binary.size(); i++) {
            value += binary.get(i) * Math.pow(2, binary.size()-i-1);
        }

        return value;

    }

    /*

    Otras soluciones:

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {

        String res = "";

        for (int i : binary)
                res += i;

        return Integer.parseInt(res, 2);
     }

     public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        return binary.stream().reduce((x, y) -> x * 2 + y).get();
    } -> Este codigo es tremando


    */
}
