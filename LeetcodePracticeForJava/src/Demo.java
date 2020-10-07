import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mckay
 * @create 2020-09-20
 * @description
 **/
public class Demo {

    String str = new String("dahua");
    char[] ch = {'a', 'b', 'c'};

    public void change(String str, char ch[]) {
        str = "test success";
        ch[0] = 'g';
    }

    public static void main(String[] args) throws IOException {
//        System.out.println("ABC".toLowerCase() == "abc");
////        System.out.println((byte)300 == (byte)100 + (short)200);
////        System.out.println("abc1234".matches("[a-c]\\d+"));
////        int x = 1,y=2,z=3;
////        y+=z--/x++;
////        System.out.println(y);
//        int []num = {1,2,3,4,5,6,7,8,9,10};
//        System.out.println(binarySearch(num, 8));
        double a = 4.0;
        double b = 3.0;
        int num = 100; // 保留bai多少位小数du
        double c = new BigDecimal("" + a / b).setScale(num, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(c);
        System.out.println(c);

    }

    static int binarySearch(int a[], int goal) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int middle = (high - low) / 2 + low;
            if (a[middle] == goal) {
                return middle;
            } else if (a[middle] > goal) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }

        }
        return -1;
    }

    private static void writeFile(String fileName, List<String> list) throws IOException {
        FileWriter fw = new FileWriter(fileName);

        for (String str : list) {
            fw.write(str + "\n");
        }
        fw.close();
    }

    private static List<String> readFile(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fr);
        List<String> list = new ArrayList<>();
        String tmpStr;
        while ((tmpStr = bufferedReader.readLine()) != null) {
            list.add(tmpStr);
            System.out.println(tmpStr);
        }
        bufferedReader.close();
        fr.close();
        return list;
    }
}
