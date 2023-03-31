import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClassFelineTest {
    @Mock
    Feline feline;

    @Test
    public void getFamilyTest(){
        Mockito.when(feline.getFamily()).thenReturn("Хуячьи");
        feline.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();
    }

    @Test
    public void getFamilyNameTest() {
        Feline felineObj = new Feline();
        Assert.assertEquals("Кошачьи", felineObj.getFamily());
    }

    @Test
    public void getKittensTest() {
        Feline felineObj = new Feline();
        Assert.assertEquals(felineObj.getKittens(), 1);
    }
}
