public class Main {
    public static void main(String[] args) {
        String fileDir = "./data/input.txt";
        CubeConundrum games = new CubeConundrum(fileDir);
        int sum = games.totalSumPossible(12, 14, 13);
        int sumMinMultiple = games.sumOfMinMultiples();
        System.out.println("Total sum: " + sum);
        System.out.println("Total sumMinMultiple: " + sumMinMultiple);
    }
}
