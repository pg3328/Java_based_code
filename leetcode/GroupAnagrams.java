import javax.print.DocFlavor;
import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , HashSet<String>> map = new HashMap<>();
        for(String s : strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String str = new String(charArray);
            if(!(map.containsKey(str))){
                HashSet<String> set = new HashSet<>();
                set.add(s);
                map.put(str,set);
            }
            else{
                map.get(str).add(s);
            }
        }
        List<List<String>> outerList = new ArrayList<>();
        for(String string : map.keySet()){
            List<String> inner = new ArrayList<>(map.get(string));
            outerList.add(inner);
        }
        return outerList;
    }

    public static void main(String []args){
        GroupAnagrams ga = new GroupAnagrams();
        ga.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"});
    }
}
