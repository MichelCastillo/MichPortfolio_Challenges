package challenge1;

public class Challenge3 {

    public static void main(String[] args) {
        countBits(13);
    }

    public static int countBits(int n){
        // Show me the code!
        int count = 0;
        int cociente = n;

        while (cociente != 0){

            if (cociente % 2 != 0){
                count++;
            }

            cociente = cociente / 2;
        }

        return count;
    }

    // Otras soluciones interesantes:

    /*
        public static int countBits(int n){

            return Integer.bitCount(n);
        }

        public static int countBits(int n){
            int ret = n % 2;
            while ((n /= 2) > 0) ret += n % 2;
            return ret;
          }

        public static int countBits(int n){
            return (int) Integer.toBinaryString(n).chars()
                      .filter(c -> c == '1')
                      .count();
          }

          public static int countBits(int n) {
            return Integer.toBinaryString(n).replaceAll("0","").length();
          }

          public static int countBits(int n){

            return Integer.bitCount(n);
          }
    */

}
