import java.util.*;

public class ED282 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int n = scanner.nextInt(); scanner.nextLine();

        MyQueue<Cliente> Q = new LinkedListQueue<>();
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().trim().split(" ");
            Q.enqueue(new Cliente(line[0], Integer.parseInt(line[1])));
        }
        scanner.close();

        int numDia = 1, totalTVS = 0, tvsDia = 0;
        MyQueue<ClientR> R = new LinkedListQueue<>();
        while(!Q.isEmpty()) {
            Cliente temp = Q.dequeue();
            if (temp.lastSeen == numDia) {
                numDia++;
                tvsDia = 0;
            }
            temp.lastSeen = numDia;

            if (temp.tvs <= T) {
                totalTVS += temp.tvs;
                tvsDia += temp.tvs;
                R.enqueue(new ClientR(temp.name, temp.lastSeen, tvsDia, totalTVS));
            } else {
                temp.tvs -= T;
                totalTVS += T;
                tvsDia += T;
                Q.enqueue(temp);
            }
        }

        while (!R.isEmpty()) {
            ClientR temp = R.dequeue();
            System.out.printf("%s %d %d %d\n", temp.name, temp.lastSeen, temp.tvs, temp.totalTVS);
        }
    }

    static class Cliente {
        String name;
        int tvs;
        int lastSeen;

        Cliente(String name, int tvs) {
            this.name = name;
            this.tvs = tvs;
            this.lastSeen = 0;
        }
    }

    static class ClientR {
        String name;
        int lastSeen;
        int tvs;
        int totalTVS;

        ClientR(String name, int lastSeen, int tvs, int totalTVS) {
            this.name = name;
            this.lastSeen = lastSeen;
            this.tvs = tvs;
            this.totalTVS = totalTVS;
        }
    }
}
