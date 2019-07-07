import java.util.HashMap;

/*
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * */
public class FirstCharNotDuplicated {
    StringBuffer s = new StringBuffer();

    //Insert one char from String stream
    public void Insert(char ch) {
        s.append(ch);
    }

    //return the first appearance once char in current String stream
    public char firstAppearingOnce() {  //思路与FirstNotRepeatingChar.java相同
        char[] charArray = s.toString().toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();  //利用一个HashMap散列表存储每个字符出现的次数，字符为键次数为值
        int count;
        //遍历字符串，如果散列表中没有该字符的键就新建一个该字符的键，将值即出现次数设为1，若有说明该字符出现过，将值加一更新出现次数
        for (int i = 0; i < charArray.length; i++) {
            if (map.containsKey(charArray[i])) {
                count = map.get(charArray[i]);
                map.put(charArray[i], ++count);  //++在前是因为先将出现次数加1，再更新该字符的出现次数
            } else {
                map.put(charArray[i], 1);
            }
        }
        for (int i = 0; i < charArray.length; i++) {
            if (map.get(charArray[i]) == 1) {  //遍历字符数组，对每一个当前字符都去查找散列表对应键的值是不是1，找到就返回该字符
                return charArray[i];
            }
        }
        return '#';
    }
}
