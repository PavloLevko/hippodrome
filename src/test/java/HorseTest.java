import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class HorseTest {
    String nameActual = "Name";
    String nameBlank = " ";
    double speedActual = 300.0;
    double speedNegative = -1;
    double distanceActual = 100;
    double distanceNegative = -1;
    String massageNull = "Name cannot be null.";
    String massageBlank = "Name cannot be blank.";
    String massageNegativeSpeed = "Speed cannot be negative.";
   String massageNegativeDistance = "Distance cannot be negative.";
    Horse horse = new Horse(nameActual, speedActual, distanceActual);
    @Test
    public void testNameNull(){
        assertThrows(IllegalArgumentException.class, () -> new Horse(null,speedActual,distanceActual));
    }
    @Test
    public void testMassageNullName(){
        try {
            new Horse(null,speedActual,distanceActual);
        }catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),massageNull);
        }
    }
    @Test
    public void testMassageNullBlank(){
        try {
            new Horse(nameBlank ,speedActual,distanceActual);
        }catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),massageBlank);
        }
    }
    @Test
    public void speedThrowsValueTest() {
        assertThrows(IllegalArgumentException.class,
                () -> new Horse(nameActual,speedNegative,distanceActual));
    }
    @Test
    public void speedMassageValue(){
        try {
            new Horse(nameActual,speedNegative,distanceActual);
        }catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),massageNegativeSpeed);
        }
    }
    @Test
    public void distanceThrowsValueTest() {
        assertThrows(IllegalArgumentException.class,
                () -> new Horse(nameActual,speedActual,distanceNegative));
    }
    @Test
    public void distanceMassageValue(){
        try {
            new Horse(nameActual,speedActual,distanceNegative);
        }catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),massageNegativeDistance);
        }
    }
    @Test
    public void testGetName() {
        assertEquals(nameActual, horse.getName());
    }
    @Test
    public void testGetSpeed() {
        assertEquals(speedActual, horse.getSpeed());
    }
    @Test
    public void testGetDistance() {
        assertEquals(distanceActual, horse.getDistance());
    }
    @Test
    public void testMove() {
    try {
        MockedStatic<Horse> mocked = mockStatic(Horse.class);
        mocked.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(0.5);
        horse.move();
        mocked.verify(() -> Horse.getRandomDouble(0.2, 0.9));
    }catch (NullPointerException e){
        assertEquals(e.getMessage(),massageNegativeDistance);
    }
    }
    @Test
    public void testGetRandom() {
        double expected = distanceActual + speedActual * 0.5;
        Horse horse1 = new Horse(nameActual, speedActual, distanceActual);
        try (MockedStatic<Horse> horseMockedStatic =
                     mockStatic(Horse.class)) {
            horseMockedStatic.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(0.5);
            horse1.move();
            assertEquals(expected, horse1.getDistance());
        }
    }
    }
