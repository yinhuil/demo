package Stack;

import java.util.Stack;

public class SimplifyPath {

	public static String simplifyPath(String path) {
		if(path==null) return null;
		if(path.length()==1 && path.charAt(0)=='/') return "/";
		Stack<String> sta=new Stack<String>();
		for(int i=0;i<path.length()-1;i++){
			char temp=path.charAt(i);
			if(temp=='/') {
				if(!sta.isEmpty()) sta.pop();
				continue;
			}
			else{
				if(sta.isEmpty()) sta.push(temp+"");
				else {
					sta.push(sta.pop()+""+temp);
				}
			}
		}
	
	 return sta.isEmpty()? "/":"/"+sta.pop();
	}

	public static String simplifyPath1(String path) {
        if(path==null || path.length()==0 || path.equals("/")) return path;
        String[] folders = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(String folder : folders){
            if(folder.length()==0){
                continue;
            } else if(folder.charAt(0)=='.' ){
                if(folder.length()>2 && folder.length()>stack.size()+1) {
                    stack.push(folder);
                } else {
                    for(int i=1; !stack.isEmpty() && i<folder.length(); i++) {
                        stack.pop();
                    }
                }
            } else {
                stack.push(folder);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String folder : stack) {
            sb.append("/"+folder);
        }
        if(sb.length()==0) return "/";
        return sb.toString();
        }

	public static void main(String[] args) {
//		String str="/a/./b/../c/";
//		System.out.println(simplifyPath1(str));
		Stack<Integer> sta=new Stack<Integer>();
		sta.push(1);
		sta.push(2);
		sta.push(3);
		for(int i=1;i<=3;i++){
			System.out.println(sta.pop());
		}
		
		
	}

}
