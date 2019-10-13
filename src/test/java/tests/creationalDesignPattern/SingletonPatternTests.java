package tests.creationalDesignPattern;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;

public class SingletonPatternTests {
    private static class SingletonClass {
        private static SingletonClass instance;

        synchronized static SingletonClass getInstance() {
            if (instance == null)
                instance = new SingletonClass();
            return instance;
        }

        String getAddress() {
           return "Address of star canada";
        }
    }

    @Test
    public void showSameInstanceOfSingletonClass() {
        SingletonClass s1 = SingletonClass.getInstance();
        System.out.println(s1.getAddress());
        assertEquals(s1.getAddress(), SingletonClass.getInstance().getAddress());
        assertSame(s1, SingletonClass.getInstance());
    }
}
