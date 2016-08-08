import app.*;

import static org.junit.Assert.*;
import org.junit.*;

public class ItemTest {

  Item prizeSnouts;

  @Before
  public void before(){
    prizeSnouts = new Item("Prize Snouts", 699);
  }

  @Test
  public void hasName(){
    assertEquals("Prize Snouts", prizeSnouts.getName());
  }

  @Test
  public void hasPrice(){
    assertEquals(699, prizeSnouts.getPrice());
  }

}
