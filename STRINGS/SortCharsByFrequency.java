import java.util.*;
public class SortCharsByFrequency {
    public String frequencySort(String s) {
        HashMap<Character, Integer> mpp = new HashMap<>();
        for(char c : s.toCharArray()) mpp.put(c,mpp.getOrDefault(c,0)+1);
        TreeMap<Integer,List<Character>> grp = new TreeMap<>();
        for(char i : mpp.keySet()){
            int freq = mpp.get(i);
            List<Character> tp = grp.getOrDefault(freq,new ArrayList<>());
            tp.add(i);
            grp.put(freq,tp);
        }
        StringBuilder sb = new StringBuilder();
        for(int i : grp.descendingKeySet()){
                for(char c : grp.get(i)) 
                    for(int j=0;j<i;j++)
                        sb.append(c);
        }
        return sb.toString();
    }
} 