/*

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".


*/


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s == null || s.length() == 0 || s.length() < p.length() || s.equals(p)){
            return list;
        }
        
        int arr1[] = new int[26];
        for(char c : p.toCharArray()){
            arr1[c - 'a']++;
        }
        
        int arr2[] = new int[26];
        int left = 0, right = 0;
        while(right < p.length()){
            arr2[s.charAt(right) - 'a']++;
            right++;
        }
        right--;
        
        while(right < s.length()){
            if(Arrays.equals(arr1,arr2)){
                list.add(left);
            }
            right++;
            if(right != s.length()){
                arr2[s.charAt(right) -'a'] += 1;
            }
            arr2[s.charAt(left) -'a'] -= 1;
            left++;
        }
        return list;
    }
}