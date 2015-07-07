import java.util.Map;

/*
 * Truck.java
 * TCSS 305 - Spring 2013 
 */

/**
 * A truck that describes its preferred method of movement and which terrain/lights 
 * it may pass through.
 * @author Erica Putsche
 * @version 4/20/2013
 */
public class Truck extends AbstractVehicle {

  /**
   * Amount of time that this truck will stay dead after collision.
   */
  private static final int DEATH_TIME = 0;
  
  /**
   * Constructor that sets the x and y coordinates as well as the direction of the truck.
   * @param the_x The x coordinate.
   * @param the_y The y coordinate.
   * @param the_direction The direction the truck is facing.
   */
  public Truck(final int the_x, final int the_y, final Direction the_direction) {
    super(the_x, the_y, the_direction, DEATH_TIME);
  }
  
  /**
   * Checks the terrain type and the status of the street lights to determine if the 
   * truck can pass through that block on the map.
   * @param the_terrain The terrain type the truck is near.
   * @param the_light The status of the street lights on the map.
   * @return Whether or not the truck can pass.
   */
  @Override
  public boolean canPass(final Terrain the_terrain, final Light the_light) {
    boolean can_pass = false; 
    if (the_terrain == Terrain.STREET || the_terrain == Terrain.LIGHT) {
      can_pass = true;
    }
    return can_pass;
  }
  
  /**
   * Asks the truck for its preferred direction of movement.
   * @param the_neighbors The adjacent cells of the current Truck.
   * @param the_light The status of the street lights on the map.
   * @return The direction in which the truck should attempt to move.
   */
  @Override
  public Direction chooseDirection(final Map<Direction, Terrain> the_neighbors, 
                                   final Light the_light) {
    Direction dirc = Direction.random();
    // check if truck can go in any direction except reverse.
    if (canPass(the_neighbors.get(this.getDirection()), the_light)
        || canPass(the_neighbors.get(this.getDirection().left()), the_light)
        || canPass(the_neighbors.get(this.getDirection().right()), the_light)) {
      while (dirc == this.getDirection().reverse() 
          || (the_neighbors.get(dirc) != Terrain.STREET 
          && the_neighbors.get(dirc) != Terrain.LIGHT)) {
        // if the direction obtained is the reverse direction OR if the direction obtained is
          // neither street or light, then get another random direction.
        dirc = Direction.random();
      }
    } else {
      dirc =  this.getDirection().reverse();      
    }
    return dirc;
  }
}
