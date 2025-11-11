public class ED196 {
    public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b) {
        while (!q.isEmpty()) {
            String nome = q.dequeue();
            String fila = q.dequeue();

            switch (fila) {
                case "A":
                    a.enqueue(nome);
                    break;

                case "B":
                    b.enqueue(nome);
                    break;

                default:
                    if (a.size() < b.size()) a.enqueue(nome);
                    else if (b.size() < a.size()) b.enqueue(nome);
                    break;
            }
        }
    }
}
