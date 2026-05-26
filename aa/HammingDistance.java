// 檔案名稱：HammingDistance.java
public class HammingDistance {
    
    public static int calculate(String s1, String s2) {
        if (s1.length() != s2.length()) {
            throw new IllegalArgumentException("字串長度必須相同");
        }
        
        int distance = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        System.out.println("--- Assignment 2: Hamming Distance ---");
        
        // 投影片 Page 9 範例
        String bin1 = "1011101";
        String bin2 = "1001001";
        System.out.println("Distance of (" + bin1 + ") and (" + bin2 + ") is: " 
                           + calculate(bin1, bin2));
                           
        String word1 = "toned";
        String word2 = "roses";
        System.out.println("Distance between (" + word1 + ") and (" + word2 + ") is: " 
                           + calculate(word1, word2));

        System.out.println("\n[Time Complexity]");
        System.out.println("Time Complexity: O(N), where N is the length of the string/binary data.");
        System.out.println("Space Complexity: O(1)");
    }
}