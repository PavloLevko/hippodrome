import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class HippodromeTest {
   List<Horse> horses = new ArrayList<>();
    String massageNull = "Horses cannot be null.";
    String massageEmpty = "Horses cannot be empty.";
    @Test
    public void testObjectNull(){
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
    }
    @Test
    public void testMassageNull(){
        try {
            new Hippodrome(null);
        }catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),massageNull);
        }
    }
    @Test
    public void testEmptyList(){
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(horses));
    }
    @Test
    public void testMassageEmpty(){
        try {
            new Hippodrome(horses);
        }catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),massageEmpty);
        }
    }
    @Test
    public void testReturnListHorses(){
       double speedActual = 300.0;
       double distanceActual = 100;
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Horse horse = new Horse("Horse" + i, speedActual, distanceActual);
            horses.add(horse);
    }
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(hippodrome.getHorses().size(),horses.size());
        for (int i = 0; i < 30; i++) {
            assertEquals(horses.get(i),hippodrome.getHorses().get(i));
        }
    }
    @Test
    public void testMoveListHorse(){
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Horse horse = mock(Horse.class);
            horses.add(horse);
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();
        for(Horse horse : horses){
            verify(horse).move();
        }
    }
    @Test
    public void testGetWinner(){
double speedActual = 300.0;
        double distanceActual = 100;
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Horse horse = new Horse("Horse" + i, speedActual, distanceActual);
            horses.add(horse);
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(hippodrome.getWinner(),horses.get(0));

    }


}