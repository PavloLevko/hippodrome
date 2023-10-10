import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    @Timeout(22)
    public void testMain(){
    }

    @Test
    @Disabled
    public void disabledTestMain2(){
    }

}