import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HairDresserHandlerTest {

    @Before
    public void setUp(){
    }

    @Test
    public void getDresser() {
        HairDresserHandler hairDresser = new HairDresserHandler();
        hairDresser.addHairDresser("Bruce Wayne", "I'm Batman!");
        assertEquals("Not adding hairdresser properly", 4, hairDresser.hairDresserList.size());

        HairDresser dresser = hairDresser.getDresser(3);
        assertEquals("Not getting hairdresser properly", "Bruce Wayne", dresser.getName());
    }
}