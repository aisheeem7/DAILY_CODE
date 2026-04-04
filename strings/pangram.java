class pangram {
    static boolean isPangram(String s) {
        boolean[] seen = new boolean[26];

        for (char c : s.toLowerCase().toCharArray())
            if (c >= 'a' && c <= 'z')
                seen[c - 'a'] = true;

        for (boolean b : seen)
            if (!b) return false;

        return true;
    }
}
