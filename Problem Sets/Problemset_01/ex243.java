import java.util.Scanner;

public class ex243 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        // Retrieve unwanted ingredients into I array
        int n = reader.nextInt();
        int[] I = new int[n];

        for (int i = 0; i < n; i++) {
            I[i] = reader.nextInt();
        }
        reader.nextLine();

        int p = reader.nextInt();
        reader.nextLine();

        int good_pizzas = p;
        int curr_ingredient;
        for (int i = 0; i < p; i++) {
            n = reader.nextInt();
            for (int j = 0; j < n; j++) {
                curr_ingredient = reader.nextInt();
                if (contains(I, curr_ingredient)) {
                    good_pizzas--;
                    reader.nextLine();
                    break;
                }
            }
        }

        System.out.println(good_pizzas);
        reader.close();
    }

    public static boolean contains(int[] array, int target) {
    for (int num : array) {
        if (num == target) {
            return true;
        }
    }
    return false;
}
}
