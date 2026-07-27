class MinStack {
    private Stack<Long> st;
    private long mini;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        long x = val;
        if(st.isEmpty()){
            mini = x;
            st.push(x);
            return;
        }
        if(x >= mini) st.push(x);
        else{
            st.push(2L*x-mini);
            mini = x;
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        long x = st.pop();
        if(x < mini) mini = 2*mini-x;
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        long x = st.peek();
        if(mini < x) return (int)x;
        return (int)mini;
    }
    
    public int getMin() {
        return (int)mini;
    }
}
