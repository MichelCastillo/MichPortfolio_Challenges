package PreparationWeek.Day3;

/*

    Two players are playing a game of Tower Breakers! Player 1 always moves first, and both players always play optimally.The rules of the game are as follows:
        Initially there are n towers.
        Each tower is of height m.
        The players move in alternating turns.
        In each turn, a player can choose a tower of height x and reduce its height to y, where 1 <= y < x and y evenly divides x.
        If the current player is unable to make a move, they lose the game.

    Given the values of n and m, determine which player will win. If the first player wins, return 1. Otherwise, return 2.

    Example -> n = 2, m = 6

    Function Description
        towerBreakers has the following paramter(s):
        int n: the number of towers
        int m: the height of each tower

    Returns
        int: the winner of the game

    Input Format
        The first line contains a single integer t, the number of test cases.
        Each of the next t lines describes a test case in the form of 2 space-separated integers, n and m.

    Constraints
        1 <= t <= 100
        1 <= n, m <= pow(10, 6)

*/

public class C02_TowerBreakers {

    public static void main(String[] args) {

    }

    public static int towerBreakers(int n, int m) {
        // Write your code here
        return (m != 1 && n % 2 == 1) ? 1 : 2;
    }
}
