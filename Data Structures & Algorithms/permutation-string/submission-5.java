class Solution {
    public boolean checkInclusion(String s1, String s2) {
         int[] freq1 = new int[26];
    int[] freq2 = new int[26];

    if (s1.length() > s2.length()) return false;

    for (int i = 0; i < s1.length(); i++) {
        freq1[s1.charAt(i) - 'a']++;
    }

    int n = s1.length();
    for (int i = 0; i < s2.length(); i++) {
        freq2[s2.charAt(i) - 'a']++; // add new character to window

        if (i >= n) {
            freq2[s2.charAt(i - n) - 'a']--; // remove old character from window
        }

        if (i >= n - 1) {
            boolean isEqual = true;
            for (int j = 0; j < 26; j++) {
                if (freq1[j] != freq2[j]) {
                    isEqual = false;
                    break;
                }
            }
            if (isEqual) return true;
        }
    }

    return false;

        
    }
}
