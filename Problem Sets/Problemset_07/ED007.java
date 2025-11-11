import java.util.*;

public class ED007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            Stack<Character> s = new Stack<>();
            boolean error = false;
            for (int j = 0; j < line.length() && !error; j++) {
                char c = line.charAt(j);
                switch (c) {
                    case '(':
                    case '[':
                        s.push(c);
                        break;

                    case ')':
                        if (s.empty() || s.pop() != '(') {
                            System.out.printf("Erro na posicao %d\n", j);
                            error = true;
                        }
                        break;

                    case ']':
                        if (s.empty() || s.pop() != '[') {
                            System.out.printf("Erro na posicao %d\n", j);
                            error = true;
                        }
                        break;

                    default:
                        continue;
                }
            }
            if (!s.empty() && !error) System.out.println("Ficam parenteses por fechar");
            else if (!error) System.out.println("Expressao bem formada");
        } 
        scanner.close();
    }
}
