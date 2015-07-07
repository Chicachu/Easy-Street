/*
 * TruckTest.java
 * TCSS 305 - Spring 2013
 */

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * Used to test the methods contained in Truck.java.
 * @author Erica Putsche
 * @version 04/25/2013
 */
public class TruckTest {

  /**
   * A truck used in tests.
   */
  private Truck my_truck;
  
  /**
   * Sets up trucks to be tested.
   * @throws Exception
   */
  @Before
  public void setUp() { // throws Exception {
    // truck facing south and should never choose north (reverse) unless 
    // it is it's only option.
    my_truck = new Truck(0, 0, Direction.SOUTH);
  }
  
  /**
   * Test method for {@link Truck#canPass(Terrain, Light)}.
   */
  @Test
  public void testCanPass() {
    my_truck = new Truck(4, 14, Direction.EAST);
    for (Terrain terrain : Terrain.values()) {
      for (Light light : Light.values()) {
        // trucks can only be on streets or lights, and they ignore all lights.
        if (terrain == Terrain.STREET || terrain == Terrain.LIGHT) {
          assertTrue("Trucks can pass through " + terrain + " with any light.", 
                     my_truck.canPass(terrain, light));
        } else {
          assertFalse("Trucks can not pass through " + terrain, 
                      my_truck.canPass(terrain, light));
        }
      }
    }
  }

  /**
   * Test method for {@link Truck#chooseDirection(java.util.Map, Light)}.
   */
  @Test
  public void testChooseDirection() {
    final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
    for (Terrain t1 : Terrain.values()) {
      for (Terrain t2 : Terrain.values()) {
        for (Terrain t3 : Terrain.values()) {
          for (Terrain t4 : Terrain.values()) {
            neighbors.put(Direction.NORTH, t1);
            neighbors.put(Direction.WEST, t2); 
            neighbors.put(Direction.EAST, t3); 
            neighbors.put(Direction.SOUTH,  t4); 
            neighbors.put(Direction.CENTER, Terrain.STREET);
            
            for (Light light : Light.values()) {
              if (hasAdjacentStreetOrLight(neighbors)) { 
                final Direction dir = my_truck.chooseDirection(neighbors, light);
                assertNotSame("Truck should not reverse if it doesn't have to.", 
                            dir == Direction.NORTH);
              } else {
                final Direction dir = my_truck.chooseDirection(neighbors, light);
                assertEquals("Invalid direction chosen, should be  north was " + dir
                           , dir, Direction.NORTH);       
              }
            }
          }
        }
      }
    }
  }
  
  /**
   * Returns true if there are any adjacent streets or lights.
   * @param the_neighbors All of the adjacent squares of this vehicle.
   * @return If there are any adjacent streets or lights.
   */
  private boolean hasAdjacentStreetOrLight(final Map<Direction, Terrain> the_neighbors) {
    boolean has_street_or_light = false; 
    if ((the_neighbors.get(Direction.SOUTH) == Terrain.STREET 
        || the_neighbors.get(Direction.SOUTH) == Terrain.LIGHT)
        || (the_neighbors.get(Direction.WEST) == Terrain.STREET 
        || the_neighbors.get(Direction.WEST) == Terrain.LIGHT)
        || (the_neighbors.get(Direction.EAST) == Terrain.STREET 
        || the_neighbors.get(Direction.EAST) == Terrain.LIGHT)) {
      has_street_or_light = true;
    }
    return has_street_or_light;
  }
}
