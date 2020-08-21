import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getRich' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. LONG_INTEGER initialEnergy
     *  2. INTEGER_ARRAY energy
     *  3. INTEGER_ARRAY coins
     */

    static int res = 0;

    static void solve(long initialEnergy, int i, int tot, int n, List<Integer> energy, List<Integer> coins){
        if (i == n){
            res = Math.max(res, tot);
            return;
        } else {
            if (initialEnergy == 0) {
                solve(initialEnergy+energy.get(i), i+1, tot, n, energy, coins);
            } else {
                solve(initialEnergy+energy.get(i), i+1, tot, n, energy, coins);
                solve(initialEnergy-1, i+1, tot+coins.get(i), n, energy, coins);
            }
        }
        return;
    }

    public static int getRich(long initialEnergy, List<Integer> energy, List<Integer> coins) {
        // Write your code here

        int n = energy.size();
        int ans = 0;
        if (initialEnergy >= n){
            for (Integer e:energy){
                ans += e;
            }
        } else {

           if (initialEnergy == 0){
               solve(initialEnergy+energy.get(0), 1, 0, n, energy, coins);
           } else {
               solve(initialEnergy, 0, 0, n, energy, coins);
           }
           ans = res;


        }

        return ans;

    }

}

public class CoinsAndEnergy {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        long initialEnergy = Long.parseLong(bufferedReader.readLine().trim());

        int energyCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> energy = IntStream.range(0, energyCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int coinsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> coins = IntStream.range(0, coinsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.getRich(initialEnergy, energy, coins);
        System.out.println(result);

        bufferedReader.close();
    }
}
