class Solution {
    public boolean isValid(String s) {
        final Stack<Character> bracketStack = new Stack<>();
        for (char character : s.toCharArray()) {
            if (character == '(' || character == '{'|| character == '[') {
                bracketStack.push(character);
            } else if (character == ')') {
                if (!isPrevBracketCorrect(bracketStack, '(')) {
                    return false;
                }
            }  else if (character == '}') {
                if (!isPrevBracketCorrect(bracketStack, '{')) {
                    return false;
                }
            } else if (character == ']') {
                if (!isPrevBracketCorrect(bracketStack, '[')) {
                    return false;
                }
            }
        }
        return bracketStack.isEmpty();
    }

    private boolean isPrevBracketCorrect(Stack<Character> bracketStack, char correctBracket) {
        if (bracketStack.isEmpty()) { // no prev bracket
            return false;
        }

        final Character prevBracket = bracketStack.pop();
        return prevBracket == correctBracket;
    }
}