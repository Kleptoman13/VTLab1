import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, IllegalAccessException {

        //System.out.println(getInRadix(564, 2));

        try {
            BufferedReader br = null;

            br = new BufferedReader(new FileReader("input.txt"));

            String line;
            while ((line  = br.readLine()) != null)
            {
                getNeedNumber(line);
            }

            br.close();
        } catch (IOException e)
        {
            System.out.println("Error" + e);
        }

    }

    public static void getNeedNumber(String str)
    {
        int sum = 0, a;
        int c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(str.length() - 1 - i);

            if (c == '1' || c == '0')
            {
                if (c == '1')
                {
                    a = 1;
                }
                else {
                    a = 0;
                }
            }
            else {
                System.out.println("Неверный код!");
                break;
            }
            sum += (a * Math.pow(2, i));
        }

        try {
            File file = new File("output.txt");

            if (!file.exists())
            {
                file.createNewFile();
            }

            PrintWriter pw = new PrintWriter(file);
            pw.println(sum);
            pw.close();
        } catch (IOException e) {
            System.out.println("Error" + e);
        }

        System.out.println(str + " -> " + sum);
    }

    public static String getInRadix(int number, int radix) throws IllegalAccessException {
        List<Character> digits = getDigitTable();
        if (radix < 2 || radix >= digits.size() || number < 0)
        {
            throw new IllegalAccessException();
        }
        StringBuilder valueStr = new StringBuilder();
        while (number > 0)
        {
            valueStr.insert(0, digits.get(number % radix));
            number = number / radix;
        }
        return valueStr.toString();
    }

    private static List<Character> getDigitTable()
    {
        ArrayList<Character> digits = new ArrayList<>();
        for (char i = '0'; i <='9' ; i++) {
            digits.add(i);
        }
        for (char i = 'A'; i < 'Z'; i++) {
            digits.add(i);
        }
        return digits;
    }

}
