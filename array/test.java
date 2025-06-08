

import java.util.*;
public class test{

    static ArrayList<String> ans=new ArrayList<>();
    public static void generateParenthesis(int n) {
        helper("",n);
        System.out.println(ans);
        
    }
    public static void helper(String s,int n)
    {
        
        if(s.length()==n*2 && validParentheses(s))
        {
            ans.add(s);
            return;
           
        }
         
        helper(s+"(",n);
        helper(s+")",n);
    }
    public static boolean validParentheses(String s)
    {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            stack.push(ch);
            else if(ch==')')
            {
                if(stack.isEmpty())
                return false;
                stack.pop();
                
            }

        }     
        
        
        return true;
        
    }
    public static void main(String[] args) {
        generateParenthesis(3);
        
        
    }
}