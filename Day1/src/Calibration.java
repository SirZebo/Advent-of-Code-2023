import java.util.ArrayList;
import java.util.List;

public class Calibration {

    List<Integer> calibrationVals;
    int totalCalibrationVal;

    public Calibration(String fileDir) {
        ReadFiles file = new ReadFiles(fileDir);
        this.calibrationVals = new ArrayList<>();
        while (file.hasNextLine()) {
            String line = file.nextLine();
            calibrationVals.add(calibrationVal(line));
        }

        this.totalCalibrationVal = calibrationVals.stream()
                .mapToInt(a -> a).sum();
    }

    private int calibrationVal(String line) {
//        line = replaceAllWordNumbers(line);
//        line = line.replaceAll("\\D+", "");
        int val = checkNum(line);
//        System.out.println(line);
//        int len = line.length();
//        int val = Character.getNumericValue(line.charAt(0)) * 10 + Character.getNumericValue(line.charAt(len - 1));
        System.out.println(val);
        return val;
    }

    private int checkNum(String line) {


        int len = line.length();
        int firstInt = -1;
        int lastInt = -1;
        for (int i = 0; i < len; ++i) {
            String curr = replaceAllWordNumbers(line.substring(0, i + 1));
            curr = curr.replaceAll("\\D+", "");
            if (curr.length() != 0) {
                firstInt = Character.getNumericValue(curr.charAt(0));
                break;
            }
        }
        for (int i = len; i >= 0; --i) {
            String curr = replaceAllWordNumbers(line.substring(i, len));
            curr = curr.replaceAll("\\D+", "");
            if (curr.length() != 0) {
                lastInt = Character.getNumericValue(curr.charAt(curr.length() - 1));
                break;
            }
        }

        return firstInt * 10 + lastInt;
    }

    private String replaceAllWordNumbers(String line) {
        line = line.replaceAll("one", "1");
        line = line.replaceAll("two", "2");
        line = line.replaceAll("three", "3");
        line = line.replaceAll("four", "4");
        line = line.replaceAll("five", "5");
        line = line.replaceAll("six", "6");
        line = line.replaceAll("seven", "7");
        line = line.replaceAll("eight", "8");
        line = line.replaceAll("nine", "9");
        //System.out.println(line);
        return line;
    }

    public int getTotalCalibrationVal() {
        return totalCalibrationVal;
    }

}
