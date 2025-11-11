public class ED194 {
    public static void reverse(MyStack<Integer> s, int n) {
        int[] buffer = new int[n];
        for (int i = 0; i < n; i++) { buffer[i] = s.pop(); }
        for (int i = 0; i < n; i++) { s.push(buffer[i]); }
    }
}
