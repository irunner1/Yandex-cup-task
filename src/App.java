import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static String shiftLeft(String[] a, int shift) {
        if (a != null) {
            int length = a.length;
            String[] b = new String[length];
            System.arraycopy(a, shift, b, 0, length - shift);
            System.arraycopy(a, 0, b, length - shift, shift);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < b.length; i++) {
                stringBuilder.append(b[i]);
            }
            String joinedString = stringBuilder.toString();
            return joinedString;
        } else {
            return null;
        }
    }

    public static String decoding(String str) {
        String resultString = "";
        int i = 0, tmpSum = 0;
        char tmp = ' ';
        while (i != str.length() - 1) {
            if (Character.isDigit(str.charAt(i)) && Character.isDigit(tmp)) {
                tmpSum += Character.getNumericValue(str.charAt(i)) * 10;
            }
            if (Character.isDigit(str.charAt(i)) && !Character.isDigit(tmp)) {
                tmp = str.charAt(i);
                tmpSum += Character.getNumericValue(str.charAt(i));
            }
            if (!Character.isDigit(str.charAt(i))) {
                tmp = 0;
                tmpSum = 0;
            }
            if (!Character.isDigit(str.charAt(i)) && !Character.isDigit(str.charAt(i + 1))) {
                tmpSum = 1;
            }
            if (!Character.isDigit(str.charAt(i + 1))) {
                for(int j = 0 ; j < tmpSum ; j++) {
                    resultString += str.charAt(i + 1);
                }
            }
            i++;
        }
        return resultString;
    }

    public static String encoding(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            if (count != 1) stringBuilder.append(count);
            stringBuilder.append(str.charAt(i));
        }
        String joinedString = stringBuilder.toString();
        return joinedString;
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = bufferedReader.readLine();
            bufferedReader.close();
            String[] s2 = s.split(" ");
            int length = Integer.parseInt(s2[0]);
            int shift = Integer.parseInt(s2[1]);
            String inputstr = s2[2];
            // System.out.println(length + shift + inputstr);
            String str = decoding(inputstr);
            // System.out.println(str);
            String strAfter = shiftLeft(str.split(""), shift);
            System.out.println(encoding(strAfter));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
