import java.util.Scanner;

public class ex121 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = reader.nextInt();
        System.out.println(n);
        reader.nextLine();
            for (int j = 0; j < n; j++) {
            String line = reader.nextLine();

            line = line.replaceAll("[^a-zA-Z]", "").toLowerCase();

            boolean isPalindrome = true;
            int m = line.length();

            for (int i = 0; i < m/2 && isPalindrome; i++) {
                if (line.charAt(i) != line.charAt(m-i-1)) isPalindrome = false;
            }

            System.out.println(isPalindrome ? "sim" : "nao");

        }

        reader.close();
    }
}
