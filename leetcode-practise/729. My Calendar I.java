class MyCalendar {

    Map<Integer, Integer> map;
    int allow;
    public MyCalendar() {
        map=new TreeMap<>();
        allow=1;
    }

    //here we are using treemap because it is sorted
    // we are using an algorithm Line sweep algorithm to solve this problem
    
    public boolean book(int startTime, int endTime) {
        map.put(startTime,map.getOrDefault(startTime,0)+1);
        map.put(endTime,map.getOrDefault(endTime,0)-1);
        int count=0;
        for(Integer i: map.keySet())
        {
            count+=map.get(i);
            if(count>allow)
            {
                map.put(startTime,map.get(startTime)-1);
                map.put(endTime,map.get(endTime)+1);
                return false;
            }

        }
        return true;

    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */