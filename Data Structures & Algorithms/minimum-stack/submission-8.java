class MinStack {
    Stack<Integer> a;
    Stack<Integer> minStack;
    public MinStack() {
        a = new Stack<>(); 
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        a.add(val);

        if(minStack.isEmpty()){
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }
    
    public void pop() {
        a.pop();
        minStack.pop();
    }
    
    public int top() {
        return a.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
