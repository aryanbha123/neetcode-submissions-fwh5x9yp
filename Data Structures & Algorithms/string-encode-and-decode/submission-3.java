class Solution {

    // Encode: length_of_string + '|' + string_content
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String s : strs) {
            encoded.append(s.length()).append('|').append(s);
        }

        return encoded.toString();
    }

    // Decode using the length prefix
    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            // Find the separator '|'
            while (str.charAt(j) != '|') {
                j++;
            }

            // Length of the next string
            int length = Integer.parseInt(str.substring(i, j));
            j++; // move past '|'

            // Extract the string
            String s = str.substring(j, j + length);
            decoded.add(s);

            // Move to the next encoded block
            i = j + length;
        }

        return decoded;
    }
}
