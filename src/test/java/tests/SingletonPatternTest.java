package tests;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class SingletonPatternTest {
    private static class SingletonClass {
        private static SingletonClass instance;

        public synchronized static SingletonClass getInstance() {
            if (instance == null)
                instance = new SingletonClass();
            return instance;
        }
    }

    @Test
    public void showSameInstanceOfSingletonClass() {
        assertSame(SingletonClass.getInstance(), SingletonClass.getInstance());
    }
}
