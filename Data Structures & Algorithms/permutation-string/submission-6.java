class Solution {
    public boolean checkInclusion(String s1, String s2) {
  if (s1.length() > s2.length()) return false;

    int[] freq1 = new int[26];
    int[] freq2 = new int[26];

    for (int i = 0; i < s1.length(); i++) {
        freq1[s1.charAt(i) - 'a']++;
        freq2[s2.charAt(i) - 'a']++; // initialize freq2 with the first window
    }

    // Check first window
    if (matches(freq1, freq2)) return true;

    for (int i = s1.length(); i < s2.length(); i++) {
        freq2[s2.charAt(i) - 'a']++; // Add new character
        freq2[s2.charAt(i - s1.length()) - 'a']--; // Remove old character

        if (matches(freq1, freq2)) return true;
    }

    return false;
}

private boolean matches(int[] a, int[] b) {
    for (int i = 0; i < 26; i++) {
        if (a[i] != b[i]) return false;
    }
    return true;
}
}