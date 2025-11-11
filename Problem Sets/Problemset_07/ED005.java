import java.util.*;

public class ED005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().strip();
            String[] tokens = line.split(" ");
            MyStack<Integer> s = new LinkedListStack<>();
            boolean isInvalid = false;

            for (String token : tokens) {
                if (isInvalid) break;
                if (isNumber(token)) {
                    s.push(Integer.parseInt(token));
                } else if (s.size() >= 2) {
                    // token is of size 1
                    int a = s.pop();
                    int b = s.pop();
                    switch (token.charAt(0)) {
                        case '+':
                            s.push(b + a);
                            break;

                        case '*':
                            s.push(b * a);
                            break;

                        case '-':
                            s.push(b - a);
                            break;

                        case '/':
                            if (a == 0) {
                                isInvalid = true;
                                break;
                            }
                            s.push(b / a);
                    }
                } else isInvalid = true;
            }
            if (isInvalid || s.size() > 1) System.out.println("Expressao Incorrecta");
            else System.out.println(s.top());
        }
        scanner.close();
    }

    static boolean isNumber(String s) { return s.matches("-?\\d+"); }
}
