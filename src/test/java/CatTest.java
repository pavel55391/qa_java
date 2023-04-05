import com.example.Cat;
import com.example.Feline;
import com.example.Lion;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;
    @Mock
    Cat cat;

    @Test
    public void catTest() throws Exception {
        Feline predator = new Feline();
        Mockito.when(cat.getFood()).thenReturn(predator.eatMeat());
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }

    @Test
    public void getSoundCountTest() {
        cat.getSound();
        Mockito.verify(cat, Mockito.times(1)).getSound();
    }

    @Test
    public void getSoundTest() {
        Cat newCat = new Cat(feline);
        Assert.assertEquals("Мяу", newCat.getSound());
    }

    @Test
    public void getFoodTest() throws Exception {
        Cat cat = new Cat(new Feline());
        Assert.assertEquals("Список еды не совпадает", List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }
}
