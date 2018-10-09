/*
* 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
* 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
* */
public class RegexMatch {
    public boolean match(char[] str, char[] pattern){
        if(str==null || pattern==null) return false;
        return match(str,0,pattern,0);  //设置两个游标i和j，从字符串数组开头和模式数组开头一一匹配
    }

    private boolean match(char[] str,int i,char[] pattern,int j){
        if(j==pattern.length) return i==str.length;  //如果模式数组已经遍历完，查看字符串数组是否遍历完，遍历完则完全匹配，没遍历完说明不匹配
        /*
        * 先看'*'，再看其他匹配。
        * （1）若当前字符存在下一个字符，看下一个字符是否是 '*'，如果是，有2种情况：
        * 1.当前匹配：
        * 1.1 match(str,i + 1,pattern,j) //跳过str
        * 1.2 match(str,i,pattern,j + 2) //跳过pattern
        * 1.3 match(str,i + 1,pattern,j + 2) //这一种可以省略，相当于 1.1 + 1.2
        * 2.当前不匹配：
        * match(str,i,pattern,j + 2) //跳过pattern
        * （2）下一个不是 *，若当前匹配：return match(str,i + 1,pattern,j + 1)
        * */
        if(j<pattern.length-1 && pattern[j+1]=='*'){  //j<pattern.length-1可以保证j+1的时候数组不会越界，当下一个模式数组元素为'*'时
            if(i!=str.length && (str[i]==pattern[j] || pattern[j]=='.')){  //如果str还没有遍历完，并且当前字符与pattern当前模式匹配，或者遇到匹配任何字符的'.'
                return match(str,i,pattern,j+2) || match(str,i+1,pattern,j);  //跳过'*'继续比较原字符，如果下一个模式没匹配当前字符，用下一个字符尝试匹配该模式
            }else{  //当前"X*"模式不匹配，跳过该模式匹配下一个模式
                return match(str,i,pattern,j+2);
            }
        }
        if(i!=str.length && (str[i]==pattern[j] || pattern[j]=='.')){  //在模式数组后一个元素不是'*'时，如果当前字符与当前模式匹配，则用下一个字符与下一个模式匹配
            return match(str,i+1,pattern,j+1);
        }
        return false;  //如果前两种匹配情况都不是，则不匹配
    }
}
