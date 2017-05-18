package kata;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class KataTest {

  @Test
  public void Test1() {
    int[] data1= {1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,1,0,1,0,1,0};
    int[] data2= {1,0,1,0,1,0,1,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1};
    assertArrayEquals(data2, Kata.DataReverse(data1));  
  }
  
  @Test
  public void Test2() {
    int[] data1= {0,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1};
    int[] data2= {0,0,1,0,1,0,0,1,0,0,1,1,0,1,1,0};
    assertArrayEquals(data2, Kata.DataReverse(data1));  

  }
}
