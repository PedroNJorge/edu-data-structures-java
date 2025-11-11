public class ED195 {
    public static boolean balanced(String line) {
        MyStack<Character> s = new LinkedListStack<>();
        for (int j = 0; j < line.length(); j++) {
            char c = line.charAt(j);
            switch (c) {
                case '(':
                case '[':
                    s.push(c);
                    break;

                case ')':
                    if (s.isEmpty() || s.pop() != '(') return false;
                    break;

                case ']':
                    if (s.isEmpty() || s.pop() != '[') return false;
                    break;

                default:
                    continue;
            }
        }
        if (!s.isEmpty()) return false;
        return true;
    }
}
