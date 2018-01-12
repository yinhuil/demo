package leetCode;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
    public static List<String> removeComments(String[] source) {
        String[] s = String.join("\n",source).replaceAll("//.*|/\\*(.|\n)*?\\*/", "").split("\n");
        List<String> ans = new ArrayList<>();
        for(String str : s) if(!str.equals("")) ans.add(str);
        return ans;
    }

    public static void main(String[] args) {
        String[] str={"a/*comment", "line", "more_comment*/b"};
        System.out.println(removeComments(str));
    }
}
