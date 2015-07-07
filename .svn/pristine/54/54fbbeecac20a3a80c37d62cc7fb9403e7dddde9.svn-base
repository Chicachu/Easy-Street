/*
 * Car.java
 * TCSS 305 - Spring 2013 
 */
import java.util.Map;
/**
 * A car that chooses it's preferred method of movement and allowed terrain types.
 * @author Erica Putsche
 * @version 4/21/2013
 */
public class Car extends AbstractVehicle {
  
  /**
   * Amount of time that this car will stay dead after collision.
   */
  private static final int DEATH_TIME = 10; 

  /**
   * Constructor that sets the x and y coordinates as well as the direction of the car.
   * @param the_x The x coordinate.
   * @param the_y The y coordinate.
   * @param the_direction The direction the car is facing.
   */
  public Car(final int the_x, final int the_y, final Direction the_direction) {
    super(the_x, the_y, the_direction, DEATH_TIME);
  }
  
  /**
   * Checks the terrain type and the status of the street lights to determine if the 
   * car can pass through that block on the map.
   * @param the_terrain The terrain type the car is near.
   * @param the_light The status of the street lights on the map.
   * @return Whether or not the car can pass.
   */
  @Override
  public boolean canPass(final Terrain the_terrain, final Light the_light) {
    boolean can_pass = false; 
    if (the_terrain == Terrain.STREET || (the_terrain == Terrain.LIGHT 
        && (the_light == Light.GREEN || the_light == Light.YELLOW))) {
      can_pass = true;
    } 
    return can_pass;
  }

  /**
   * Asks the car for its preferred direction of movement.
   * @param the_neighbors The adjacent cells of the current car.
   * @param the_light The status of the street lights on the map.
   * @return The direction in which the car should attempt to move.
   */
  @Override
  public Direction chooseDirection(final Map<Direction, Terrain> the_neighbors,
                                   final Light the_light) {
    Direction dir;
    if (the_neighbors.get(this.getDirection()) == Terrain.LIGHT) {
      dir = this.getDirection();
    } else { 
     // dir = chooseCircularDirection(the_neighbors);
      if (the_neighbors.get(this.getDirection()) == Terrain.STREET) {
        dir = this.getDirection();
      } else if (the_neighbors.get(this.getDirection().left()) == Terrain.STREET) {
        dir = this.getDirection().left();
      } else if (the_neighbors.get(this.getDirection().right()) == Terrain.STREET) {
        dir = this.getDirection().right();
      } else {
        dir = this.getDirection().reverse();
      }
    }
    return dir;
  }
}
