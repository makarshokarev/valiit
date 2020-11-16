package ee.bcs.valiit.lessons;
import static org.junit.jupiter.api.Assertions.assertEquals;
import ee.bcs.valiit.tasks.lessons.Lesson1MathUtil;
import org.junit.jupiter.api.Test;

public class Lesson1MathUtilTest {

    @Test
    public void min(){
            assertEquals(2, Lesson1MathUtil.min(2,3));
        }

    @Test
    public void isEven(){
        assertEquals(false, Lesson1MathUtil.isEven(6));
    }

    @Test
    public void max3(){
        assertEquals(2, Lesson1MathUtil.max(1,2,-3));
    }

    @Test
    public void abs(){
        assertEquals(5, Lesson1MathUtil.abs(-2));
    }

}
