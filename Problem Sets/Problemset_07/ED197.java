public class ED197 {
    public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b) {
        MyQueue<Integer> result = new LinkedListQueue<>();

        Integer elemA = a.dequeue();
        Integer elemB = b.dequeue();
        
        while (elemA != null && elemB != null) {
            if (elemA < elemB) {
                result.enqueue(elemA);
                elemA = a.isEmpty() ? null : a.dequeue();
            } else {
                result.enqueue(elemB);
                elemB = b.isEmpty() ? null : b.dequeue();
            }
        }
        
        if (elemA != null) result.enqueue(elemA);
        if (elemB != null) result.enqueue(elemB);

        while (!a.isEmpty()) { result.enqueue(a.dequeue()); }
        while (!b.isEmpty()) { result.enqueue(b.dequeue()); }

        return result;
    }
}
