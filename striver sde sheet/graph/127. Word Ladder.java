class Solution {
    public class Pair{
        String word;
        int step;
        Pair(String _word,int _step)
        {
            word=_word;
            step=_step;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        HashSet<String> set=new HashSet<>(wordList); // just to make O(1) operations for contains and remove functions
        
        while(!queue.isEmpty())
        {
            Pair node=queue.poll();
            String word=node.word;
            int step=node.step;
            if(word.equals(endWord)==true)
            return step;
            char ch;
            int l=word.length();

            for(int j=0;j<l;j++)
            {
                char ar[]=word.toCharArray();
                ch=ar[j];// copy of character if not found in the wordlist
                for(int i=97;i<=122;i++)
                {
                    ar[j]=(char)i;
                    String newString=new String(ar);
                    if(set.contains(newString))
                    {
                        queue.add(new Pair(newString,step+1));
                        set.remove(newString);
                    }
                }
                ar[j]=ch;
            }
            
        }
        return 0;
        
    }
}