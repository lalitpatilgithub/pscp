package pscp;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue{
    public static void main(String[] args) {
        Queue q1 = new LinkedList<>();
        Queue q2 = new LinkedList<>();

        CustomStack stack = new CustomStack(q1,q2);
        stack.push(1);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }

}


/*
1. take two stack s1 s2
2. first element push to s1... second element..push to s1 and so on...by that way stack bottom has oldest element
3. Pop operation: until s1 empty pop all element one by one and push to s2.. now s2 top has oldest element return it.
4. Now fill s1 with all value of s2.
*/
class CustomStack{
    private Queue q1 ,q2;
    public CustomStack(Queue q1, Queue q2){
        this.q1 =q1;
         this.q2=q2;
    }

    

    void push(int i){
        q1.add(i);

    }


    void pop(){

        if(q1.isEmpty() && q2.isEmpty()){
            System.out.println("Can Not pop the element");
            return ;
        }

        if(q2.isEmpty()){
            while(!q1.isEmpty()){
                q2.add(q1.remove());
            }
        }
        System.out.println(q2.remove());
    }

}