package pscp;

import java.util.Queue;
import java.util.Stack;

public class QueueUsingStack{
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        CustomQueue queue = new CustomQueue(s1, s2);
        queue.rear(5);
        queue.rear(8);
       // System.out.println(queue.front());
        queue.rear(18);
        queue.rear(28);
        queue.rear(38);
        System.out.println(queue.front());
        System.out.println(queue.front());
        queue.rear(58);
        queue.rear(78);
        System.out.println(queue.front());
        System.out.println(queue.front());
        System.out.println(queue.front());
        System.out.println(queue.front());
        System.out.println(queue.front());
        System.out.println(queue.front());
        Queue queue2;
    }

}


/*
1. take two stack s1 s2
2. first element push to s1... second element..push to s1 and so on...by that way stack bottom has oldest element
3. Pop operation: until s1 empty pop all element one by one and push to s2.. now s2 top has oldest element return it.
4. Now fill s1 with all value of s2.
*/
class CustomQueue{
    private Stack s1 ,s2;
    public CustomQueue(Stack s1, Stack s2){
        this.s1=s1;
        this.s2=s2;
    }

    void rear(int i){
        s1.push(i);
    }

    int front(){
        if(s1.isEmpty() && s2.isEmpty()){
            System.out.println("Can not retrieved from front as both stacks are empty...");
            return 0;
        }
        
       if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
        }
        int x = (Integer)(s2.peek());
        s2.pop();
        
        return x;

    }

}