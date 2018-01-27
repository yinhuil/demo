package leetCode;

import java.util.List;

public class ReplaceWords {
 /*   In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

    Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

    You need to output the sentence after the replacement.

            Example 1:
    Input: dict = ["cat", "bat", "rat"]
    sentence = "the cattle was rattled by the battery"
    Output: "the cat was rat by the bat"*/

    public class TrieNode{
        boolean isword;
        TrieNode[] next;
        public TrieNode(){
            next=new TrieNode[26];
        }
    }
    TrieNode root=new TrieNode();
    public void add (String word){
        TrieNode cur=root;
        for(int i=0;i<word.length();i++){
            int c=word.charAt(i)-'a';
            if(cur.next[c]==null){
                cur.next[c]=new TrieNode();
            }
            cur=cur.next[c];
        }
        cur.isword=true;
    }
    public String findRoot(String word){
        TrieNode cur=root;
        for(int i=0;i<word.length();i++){
            int c=word.charAt(i)-'a';
            if(cur.next[c]==null) return word;
            if(cur.next[c].isword) return word.substring(0,i+1);
            cur=cur.next[c];
        }
        return word;
    }
    public String replacewordS(List<String> dict,String sentence){
        for(int i=0;i<dict.size();i++){
            add(dict.get(i));
        }
        String[] str=sentence.split(" ");
        for(int i=0;i<str.length;i++){
            str[i]=findRoot(str[i]);
        }
        return String.join(" ",str);
    }

}
