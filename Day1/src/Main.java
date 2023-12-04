public class Main {
    public static void main(String[] args) {
        String fileDir = "./data/file.txt";
        System.out.println("running");
        Calibration calibration = new Calibration(fileDir);
        System.out.println(calibration.getTotalCalibrationVal());
    }
}

