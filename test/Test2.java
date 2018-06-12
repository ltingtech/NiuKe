package test;

import java.util.*;

public class Test2 {
    private int count;
    public static void changeStr(String str){
    	str="welcome";
    }
	public static void main(String[] args) {
//		Test2 instance=new Test2(88);
//		System.out.println(instance.count);
//		String str="1234";
//		changeStr(str);
//		System.out.println(str);
//		int a=10;
//		int b=2;
//		int r=a&b;
//		System.out.println(r);
//		Stack<Integer> stack=new Stack<Integer>();
//		stack.push(3);
//		stack.push(4);
//		Iterator<Integer> iterator=stack.iterator();
//		while(iterator.hasNext()){
//			System.out.println(iterator.next());
//		}
		char[] charArr=new char[]{'e','b'};
		String str=new String(charArr);
		System.out.println(str);
		String[] strArr=new String[]{"abc","acb"};
		
	}
	Test2(int a)
	{
		count=a;
	}
	
//	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
//        if(root==null){
//            return null;
//        }
//        else{
//            ArrayList<Integer> result=new ArrayList<Integer>();
//            Queue<Integer> queue=new LinkedList<Integer>();
//            queue.add(root);
//            TreeNode tmp=null;
//            while(!queue.isEmpty()){
//                tmp=queue.poll();
//                if(tmp!=null){
//                    result.add(tmp.val);
//                }
//                if(tmp.left!=null){
//                    queue.add(tmp.left);
//                }
//                if(tmp.right!=null){
//                    queue.add(tmp.right);
//                }
//            }
//            return result;
//        }
//        
//    }
	

}
