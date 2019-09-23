package tests;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;

public class SingletonPatternTest {
    private static class SingletonClass {
        private static SingletonClass instance;

        public synchronized static SingletonClass getInstance() {
            if (instance == null)
                instance = new SingletonClass();
            return instance;
        }
        public  String getAddress(){
             System.out.println("Address of star canada");
             return String.valueOf(this);
        }
    }

    @Test
    public void showSameInstanceOfSingletonClass() {
        SingletonClass s1 = SingletonClass.getInstance();
        assertEquals(s1.getAddress(),SingletonClass.getInstance().getAddress());
        //assertSame(SingletonClass.getInstance(), SingletonClass.getInstance());
    }
}
