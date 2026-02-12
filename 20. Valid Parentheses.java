import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> bracketsConverter = new HashMap<>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        for (char character : s.toCharArray()) {
            if (bracketsConverter.values().contains(character)) {
                stack.push(character);
            } else if (stack.peek() == bracketsConverter.get(character)) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}