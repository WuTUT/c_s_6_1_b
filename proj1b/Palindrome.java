public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    private boolean helperIsPalindrome(Deque<Character> d) {
        if (d.size() == 1 || d.size() == 0) {
            return true;
        }
        char a = d.removeFirst();
        char b = d.removeLast();
        if (a != b) {
            return false;
        }
        return helperIsPalindrome(d);
    }

    public boolean isPalindrome(String word) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        Deque<Character> d = wordToDeque(word);

        return helperIsPalindrome(d);
    }

    private boolean helperIsPalindrome(Deque<Character> d, CharacterComparator cc) {
        if (d.size() == 1 || d.size() == 0) {
            return true;
        }
        char a = d.removeFirst();
        char b = d.removeLast();
        if (!cc.equalChars(a, b)) {
            return false;
        }
        return helperIsPalindrome(d, cc);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        Deque<Character> d = wordToDeque(word);
        return helperIsPalindrome(d, cc);
    }
}
