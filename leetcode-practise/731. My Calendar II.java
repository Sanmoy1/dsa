class MyCalendarTwo {
    TreeMap<Integer, Integer> map;
    int allow;
    public MyCalendarTwo() {
        map=new TreeMap<>();
        allow=2;
    }
    
    public boolean book(int startTime, int endTime) {
        map.put(startTime,map.getOrDefault(startTime,0)+1);
        map.put(endTime,map.getOrDefault(endTime,0)-1);
        int count=0;
        for(Integer i:map.keySet())
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
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */