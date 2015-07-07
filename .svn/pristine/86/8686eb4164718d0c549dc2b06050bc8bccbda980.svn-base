/*
 * Bicycle.java
 * TCSS 305 - Spring 2013
 */
import java.util.Map;
/**
 * A bicycle that chooses it's preferred method of movement and it's allowed terrain types.
 * @author Erica Putsche
 * @version 04/23/2013
 */
public class Bicycle extends AbstractVehicle {

  /**
   * Amount of time that this bicycle will stay dead after collision.
   */
  private static final int DEATH_TIME = 20;
  
  /**
   * Constructor that sets the x and y coordinates as well as the direction of the bicycle.
   * @param the_x The x coordinate.
   * @param the_y The y coordinate.
   * @param the_direction The direction the car is facing.
   */
  public Bicycle(final int the_x, final int the_y, final Direction the_direction) {
    super(the_x, the_y, the_direction, DEATH_TIME);
  }
  
  /**
   * Checks the terrain type and the status of the street lights to determine if the 
   * bicycle can pass through that block on the map.
   * @param the_terrain The terrain type the bicycle is near.
   * @param the_light The status of the street lights on the map.
   * @return Whether or not the bicycle can pass.
   */
  @Override
  public boolean canPass(final Terrain the_terrain, final Light the_light) {
    boolean canpass = false;
    if (the_terrain == Terrain.STREET || (the_terrain == Terrain.LIGHT 
        && the_light == Light.GREEN) || the_terrain == Terrain.TRAIL) {
      canpass = true;
    } 
    return canpass;
  }

  /**
   * Asks the bicycle for its preferred direction of movement.
   * @param the_neighbors The adjacent cells of the current bicycle.
   * @param the_light The status of the street lights on the map.
   * @return The direction in which the bicycle should attempt to move.
   */
  @Override
  public Direction chooseDirection(final Map<Direction, Terrain> the_neighbors,
                                   final Light the_light) {
    Direction dir;
    // if it's a light, keep going straight, and end up not moving because of a false return 
      // from canPass
    if (the_neighbors.get(this.getDirection()) == Terrain.LIGHT && the_light != Light.GREEN) {
      dir = this.getDirection();
    }
    
    if (the_neighbors.get(Direction.CENTER) == Terrain.TRAIL) { // if on trail
      dir = this.getDirection();                                    // go current direction
    } else {
      // non trail with trail nearby -> go to trail
      if (the_neighbors.get(this.getDirection()) == Terrain.TRAIL
          || the_neighbors.get(this.getDirection().left()) == Terrain.TRAIL
          || the_neighbors.get(this.getDirection().right()) == Terrain.TRAIL) {
        dir = chooseClosestTrail(the_neighbors);
      } else {
        // non trail with no trail nearby -> go straight, then left, then right, last reverse
        dir = chooseCircularDirection(the_neighbors, the_light);
      }
    }
    return dir;
  }

  /**
   * Picks a direction that points to a trail.
   * @param the_neighbors The surrounding terrain from the current bike.
   * @return The new direction to go that points to a trail.
   */
  private Direction chooseClosestTrail(final Map<Direction, Terrain> the_neighbors) {
    // this works because chooseDirection only calls this if there is an adjacent trail.
    Direction dir = this.getDirection(); 
    if (the_neighbors.get(this.getDirection().left()) == Terrain.TRAIL) {
      dir = this.getDirection().left();
    } else if (the_neighbors.get(this.getDirection().right()) == Terrain.TRAIL) {
      dir = this.getDirection().right();
    }
    return dir;
  }
}
