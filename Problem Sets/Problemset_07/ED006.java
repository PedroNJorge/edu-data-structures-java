import java.util.*;

public class ED006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            int len = scanner.nextLine().trim().split(" ").length;
            scanner.nextInt();
            String[] people = scanner.nextLine().trim().split(" ");

            CircularLinkedList<String> circle = new CircularLinkedList<>();
            for (String p : people) { circle.addLast(p); }

            while (circle.size() > 1) {
                for (int j = 0; j < len; j++) { circle.rotate(); }
                circle.removeLast();
            }
            String last = circle.getLast();
            if (last.equals("Carlos")) System.out.println("O Carlos nao se livrou");
            else System.out.printf("O Carlos livrou-se (coitado do %s!)\n", last);
        }
        scanner.close();
    }
}
