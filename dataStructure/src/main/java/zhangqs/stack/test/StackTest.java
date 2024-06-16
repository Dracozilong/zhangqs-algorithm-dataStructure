package zhangqs.stack.test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zhangqs.array.test.ArrayTest;
import zhangqs.stack.Stack;

import java.util.ArrayList;

public class StackTest {

    private final Logger logger = LoggerFactory.getLogger(StackTest.class);

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        Object o = stack.pop();
        int size = stack.size();
        System.out.println(size);
        System.out.println(o);

   }
}