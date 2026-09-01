class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()){
            return false;
        }

        Map<Character, Integer> map= new HashMap<>();

        for(char c: s.toCharArray()){
            map.merge(c, 1, Integer::sum);
        } 


        for(char c: t.toCharArray()){
            map.merge(c, -1 , Integer::sum);
            if(map.get(c) < 0){
                return false;
            }
        }
        return true;
    }
}