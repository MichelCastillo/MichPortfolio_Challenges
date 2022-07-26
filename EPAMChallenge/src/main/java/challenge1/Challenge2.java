package challenge1;

public class Challenge2 {

    public static boolean isValid(char[] walk) {
        // Insert brilliant code here
        return walk.length == 10 && comeBack(walk);
    }

    public static boolean comeBack(char[] walk){
        int n = 0;
        int s = 0;
        int e = 0;
        int w = 0;

        for (int i = 0; i < walk.length; i++) {
            if (walk[i] == 'n'){
                n++;
            } else if (walk[i] == 's'){
                s++;
            } else if (walk[i] == 'e'){
                e++;
            } else {
                w++;
            }
        }
        return n == s && e == w;
    }

    /////////////////////////////////////////////////////////////////////
    /*
    * Soluciones interesantes
    *
    * import java.awt.Point;

    public class TenMinWalk {
      public static boolean isValid(char[] walk) {
        Point point = new Point(0,0);
        for (char c : walk) {
                switch (c) {
                    case 'n': point.translate(1,0); break;
                    case 'e': point.translate(0,1); break;
                    case 's': point.translate(-1,0); break;
                    case 'w': point.translate(0,-1); break;
                }
            }
            return point.equals(new Point(0,0)) && walk.length == 10;
      }
    }
    *
    * public class TenMinWalk {
          public static boolean isValid(char[] walk) {
            if (walk.length != 10) return false;

            int x = 0, y = 0;
            for (char c: walk) {
              switch (c) {
                case 'n': y++; break;
                case 's': y--; break;
                case 'w': x++; break;
                case 'e': x--; break;
              }
            }

            return x == 0 && y == 0;
          }
        }
    *
    * */

}
