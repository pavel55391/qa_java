import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ClassLionTest {
    @Mock
    Feline felineMock;
    Lion lion;

    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец", felineMock);
    }

    @Test
    public void getFoodMethodTest() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        lion.getFood();
        verify(felineMock, times(1)).getFood("Хищник");
    }

    /*@Test  // тест параметризован
    public void getKittensMaleMethodTest() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test   // тест параметризован
    public void getKittensFemaleMethodTest() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        assertTrue(lion.doesHaveMane());
    }*/

    @Test
    public void getKittensExceptionMethodTest() {
       assertThrows("Используйте допустимые значения пола животного - Самец или Самка",
                Exception.class,
                () -> new Lion("Трансгендерный", felineMock));
    }

    @Test
    public void getKittensTest() {
        lion.getKittens();
        verify(felineMock, times(1)).getKittens();
    }
}
