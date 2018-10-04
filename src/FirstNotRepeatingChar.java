import java.util.HashMap;

/*
* 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）。
* */
public class FirstNotRepeatingChar {
    public int firstNotRepeatingChar(String str) {
        if(str==null || str.length()==0) return -1;
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();  //利用一个HashMap散列表存储每个字符出现的次数，字符为键次数为值
        for(int i=0;i<str.length();i++){  //遍历字符串，如果散列表中没有该字符的键就新建一个该字符的键，将值即出现次数设为1，若有说明该字符出现过，将值加一更新出现次数
            if(map.containsKey(str.charAt(i))){
                int count=map.get(str.charAt(i));
                map.put(str.charAt(i),++count);  //++在前是因为先将出现次数加1，再更新该字符的出现次数
            }else{
                map.put(str.charAt(i),1);
            }
        }
        int pos=-1;
        for(int i=0;i<str.length();i++){  //遍历字符串，对每一个当前字符都去查找散列表对应键的值是不是1，找到就返回该字符在字符串中的位置
            if(map.get(str.charAt(i))==1) return i;
        }
        return pos;  //若没有找到只出现一次的字符，则返回-1
    }
}
