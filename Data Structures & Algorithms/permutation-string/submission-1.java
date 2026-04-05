class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // BRUTE FORCE
        if(s1.length() > s2.length()) return false; // edge case

        // s1 = "abc" -> [a,b,c] => [a,b,c] => abc
        // s2 = "lecabee" -> for i -> s2.length() - s1.length();
        // s2.substring(i , i+1) // i= 0; lec -> cel ,,eca -> ace cab -> abc
        char []arr = s1.toCharArray();
        Arrays.sort(arr);
        s1 = new String(arr);
        int n1 = s2.length();
        int n2 = s1.length();   
        for(int i = 0 ; i <= n1 - n2; i++) {
            String temp = s2.substring(i, i + n2);
            char []array = temp.toCharArray();
            Arrays.sort(array);
            temp = new String(array);

            if(temp.equals(s1))  return true;
        }
        return false;

        
    }
}
