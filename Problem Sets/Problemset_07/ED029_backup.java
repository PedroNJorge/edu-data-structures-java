import java.util.*;

public class ED029 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt(); scanner.nextLine();
        for (int x = 0; x < c; x++) {
            int L = scanner.nextInt();
            int A = scanner.nextInt(); scanner.nextLine();
            MyQueue<Plane> levanta = new LinkedListQueue<>();
            MyQueue<Plane> aterra = new LinkedListQueue<>();
            List<Plane> results = new ArrayList<>();

            // Get input
            for (int i = 0; i < L; i++) {
                String[] line = scanner.nextLine().trim().split(" ");
                Plane temp = new Plane(line[0], Integer.parseInt(line[1]), false);
                levanta.enqueue(temp);
            }

            for (int i = 0; i < A; i++) {
                String[] line = scanner.nextLine().trim().split(" ");
                Plane temp = new Plane(line[0], Integer.parseInt(line[1]), true);
                aterra.enqueue(temp);
            }

            // Simulate
            int time = 0;
            while (!levanta.isEmpty() || !aterra.isEmpty()) {
                time++;

                Plane tempL = (!levanta.isEmpty() && levanta.first().time <= time) ? levanta.first() : null;
                Plane tempA = (!aterra.isEmpty() && aterra.first().time <= time) ? aterra.first() : null;
                if (tempL == null && tempA == null) continue;

                // Chose correct plane
                Plane chosen;
                if (tempL != null && tempA != null) {
                    int t_aterra = time - tempA.time;
                    int t_levanta = time - tempL.time;
                    chosen = t_levanta < t_aterra ? tempL : tempA;
                } else if (tempL != null) chosen = tempL;
                else chosen = tempA;

                // Update plane with delay
                int delay = time - chosen.time;
                results.add(new Plane(chosen.name, delay, chosen.landing));

                if (chosen.landing) aterra.dequeue();
                else levanta.dequeue();
            }

            System.out.printf("%d %d\n", L, A);
            for (Plane p : results) {
                if (!p.landing) System.out.printf("%s %d\n", p.name, p.time);
            }

            for (Plane p : results) {
                if (p.landing) System.out.printf("%s %d\n", p.name, p.time);
            }
        }
        scanner.close();
    }

    static class Plane {
        String name;
        int time;
        boolean landing;

        Plane(String name, int time, boolean landing) {
            this.name = name;
            this.time = time;
            this.landing = landing;
        }
    }
}
