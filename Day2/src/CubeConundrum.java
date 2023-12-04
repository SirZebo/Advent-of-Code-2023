import java.util.ArrayList;
import java.util.List;

public class CubeConundrum {

    List<Game> games;

    public CubeConundrum(String fileDir) {
        this.games = new ArrayList<>();
        ReadFiles line = new ReadFiles(fileDir);
        while (line.hasNextLine()) {
            this.games.add(new Game(line.nextLine()));
        }
    }

    public void printGames() {
        for (Game game : this.games) {
            System.out.println(game);
        }
    }

    public int totalSumPossible(int red, int blue, int green) {
        int sum = 0;
        for (int i = 0; i < games.size(); ++i) {
            Game curr = games.get(i);
            if (curr.isPossible(red, blue, green)) {
                sum += i + 1;
            }
        }
        return sum;
    }

    public int sumOfMinMultiples() {
        int sum = 0;
        for (Game curr : this.games) {
            int minMultiple = curr.getMinMultiple();
            System.out.println(minMultiple);
            sum += minMultiple;
        }
        return sum;
    }
}
