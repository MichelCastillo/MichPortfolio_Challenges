package PreparationWeek.Day3;


/*

    Julius Caesar protected his confidential information by encrypting it using a cipher.
    Caesar's cipher shifts each letter by a number of letters. If the shift takes you past the end of the alphabet,
        just rotate back to the front of the alphabet. In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.

    Original alphabet:      abcdefghijklmnopqrstuvwxyz
    Alphabet rotated +3:    defghijklmnopqrstuvwxyzabc

    Example
        s = There's-a-starman-waiting-in-the-sky
        k = 3

    The alphabet is rotated by , matching the mapping above. The encrypted string is Wkuh'v-d-vwdupdq-zdlwlqj-lq-wkh-vnb

    Note: The cipher only encrypts letters; symbols, such as -, remain unencrypted.

    Function Description
        caesarCipher has the following parameter(s):
            string s: cleartext
            int k: the alphabet rotation factor

    Returns
        string: the encrypted string

    Input Format
        The first line contains the integer, n, the length of the unencrypted string.
        The second line contains the unencrypted string, s.
        The third line contains k, the number of letters to rotate the alphabet by.

     Constraints
        1<= n <= 100
        0 <= k <= 100
        s is a valid ASCII string without any spaces.

     Sample Input
           middle-Outz 2

     Sample output
            okffng-Qwvb
* */

import java.util.Arrays;
import java.util.List;

public class C03_CaesarCipher {

    public static void main(String[] args) {
        String cadena = "middle-Outz";
        int k = 2;

        System.out.println(caesarCipher(cadena, k));
    }

    public static String caesarCipher(String s, int k) {
        // Write your code here
        List<Character> abc = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'
                , 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't'
                , 'u', 'v', 'w', 'x', 'y', 'z');

        StringBuilder result = new StringBuilder();

        if (abc.size() < k) k %= abc.size();

        for (char ch : s.toCharArray()) {
            if(Character.isLetter(ch)){
                int chi = abc.indexOf(Character.toLowerCase(ch));
                int index = chi + k;

                if(index > abc.size() - 1) index = index - (abc.size());

                if(Character.isUpperCase(ch)){
                    result.append(Character.toUpperCase(abc.get(index)));
                } else {
                    result.append(abc.get(index));
                }

            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static String caesarCipherDiego(String s, int k){
        String cadenaEncriptada = "";
        String cadena = s;

        int key = k;
        int longitudCadena = cadena.length();
        int nuevoAscii = 0;
        int ascii2 = 0;

        for(int x=0; x<longitudCadena;x++)
        {
            if (cadena.charAt(x)>=97 && cadena.charAt(x)<=122)
            {
                nuevoAscii= (int)cadena.charAt(x);
                if (nuevoAscii==122)
                {
                    ascii2= 96+key;
                    cadenaEncriptada=cadenaEncriptada+(char)ascii2;

                }
                else
                {
                    if (nuevoAscii+key>122)
                    {
                        ascii2= (nuevoAscii+key-26);
                        cadenaEncriptada=cadenaEncriptada+(char)ascii2;

                    }
                    else
                    {
                        cadenaEncriptada=cadenaEncriptada+(char)(cadena.charAt(x)+key);
                    }


                }
            }
            else
            {
                if (cadena.charAt(x)>=65 && cadena.charAt(x)<=90)
                {

                    nuevoAscii= (int)cadena.charAt(x);
                    if (nuevoAscii==90)
                    {
                        ascii2= (nuevoAscii-90)+64+key;
                        cadenaEncriptada=cadenaEncriptada+(char)ascii2;

                    }
                    else
                    {
                        if (nuevoAscii+key>90)
                        {
                            ascii2= (nuevoAscii+key-26);
                            cadenaEncriptada=cadenaEncriptada+(char)ascii2;

                        }
                        else
                        {
                            cadenaEncriptada=cadenaEncriptada+(char)(cadena.charAt(x)+key);
                        }
                    }


                }
                else
                {
                    cadenaEncriptada=cadenaEncriptada+(char)(cadena.charAt(x));
                }
            }
        }
        return cadenaEncriptada;
    }
}
