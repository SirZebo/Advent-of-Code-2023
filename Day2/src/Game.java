import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

public class Game {
    List<Round> rounds;

    public Game(String line) {
        this.rounds = parseGame(line);
    }

    public List<Round> parseGame(String line) {
        List<Round> rounds = new ArrayList<>();
        line = line.substring(7, line.length());
        String[] parts = line.split(";", 0);

        for (int i = 0; i < parts.length; ++i) {
            String[] dices = parts[i].split(",", 0);
            rounds.add(new Round(dices));
        }

        return rounds;
    }

    public boolean isPossible(int red, int blue, int green) {
        for (Round r : this.rounds) {
            if (r.red > red) {
                return false;
            } else if (r.blue > blue) {
                return false;
            } else if (r.green > green) {
                return false;
            }
        }
        return true;
    }

    public int getMinMultiple() {
        int minR = 0;
        int minB = 0;
        int minG = 0;
        for (Round r : this.rounds) {
            minR = max(r.red, minR);
            minB = max(r.blue, minB);
            minG = max(r.green, minG);
        }
        return minR * minB * minG;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Round round : rounds) {
            sb.append(round.toString()).append(";");
        }
        return sb.toString();
    }


    private class Round {
        int red = 0;
        int blue = 0;
        int green = 0;

        public Round(String[] dices) {

            for (String dice : dices) {
                if (dice.contains("blue")) {
                    this.blue = Integer.parseInt(dice.replaceAll("\\D+", ""));
                } else if (dice.contains("red")) {
                    this.red = Integer.parseInt(dice.replaceAll("\\D+", ""));
                } else if (dice.contains("green")) {
                    this.green = Integer.parseInt(dice.replaceAll("\\D+", ""));
                }
            }
        }

        public Round(int red, int blue, int green) {
            this.red = red;
            this.blue = blue;
            this.green = green;
        }

        public String toString() {
            return "Red: " + red + ", Blue: " + blue + ", Green: " + green;
        }
    }
}
