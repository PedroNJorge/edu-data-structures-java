import java.util.*;

public class ED237 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int n = scanner.nextInt(); scanner.nextLine();
        MyQueue<Process> Q = new LinkedListQueue<>();
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().trim().split(" ");
            Q.enqueue(new Process(line[0], Integer.parseInt(line[1])));
        }
        scanner.close();

        int currTime = 0, numIter = 1;
        MyQueue<ProcessResult> R = new LinkedListQueue<>();
        while (!Q.isEmpty()) {
            Process temp = Q.dequeue();
            if (temp.time <= T) {
                currTime += temp.time;
                R.enqueue(new ProcessResult(temp.name, currTime, numIter));
            } else {
                currTime += T;
                temp.time -= T;
                Q.enqueue(temp);
            }
            numIter++;
        }

        while (!R.isEmpty()) {
            ProcessResult temp = R.dequeue();
            System.out.printf("%s %d %d\n", temp.name, temp.time, temp.iter);
        }
    }

    static class Process {
        String name;
        int time;

        Process(String name, int time) {
            this.name = name;
            this.time = time;
        }
    }

    static class ProcessResult {
        String name;
        int time;
        int iter;

        ProcessResult(String name, int time, int iter) {
            this.name = name;
            this.time = time;
            this.iter = iter;
        }
    }
}
