import java.util.*;

public class ED89 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int flag = scanner.nextInt();

        TreeMap<Integer, Integer> areaMoney = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            scanner.nextInt(); scanner.nextLine();
            scanner.nextLine().trim();
            scanner.nextLine().trim();
            int code = scanner.nextInt();
            int rendimentos = scanner.nextInt();
            if (areaMoney.containsKey(code)) {
                areaMoney.put(code, areaMoney.get(code) + rendimentos);
            } else areaMoney.put(code, rendimentos);
        }
        scanner.close();

        switch (flag) {
            case 0:
                System.out.println(areaMoney.size());                
                break;

            case 1:
                for (Integer code : areaMoney.keySet()) {
                    System.out.printf("%d %d\n", code, areaMoney.get(code));
                }
                break;
        }
    }
}
