import app.*;

import static org.junit.Assert.*;
import org.junit.*;

public class CustomerTest {

  Customer customer;

  @Before
  public void before(){
    customer = new Customer("Jimmy McSnoutsnout");
  }

  @Test
  public void hasName(){
    assertEquals("Jimmy McSnoutsnout", customer.getName());
  }

}
