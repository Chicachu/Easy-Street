/*
 * Human.java
 * TCSS 305 - Spring 2013
 */
import java.util.Map;

/**
 * A human that chooses it's preferred method of movement and it's allowed terrain types.
 * @author Erica Putsche
 * @version 04/23/2013
 */
public class Human extends AbstractVehicle {

  /**
   * Amount of time that this human will stay dead after collision.
   */
  private static final int DEATH_TIME = 50;
  
  /**
   * The terrain the human starts on.
   */
  private final Terrain my_terrain; 
  
  /**
   * Constructor that sets the x and y coordinates as well as the direction of the human.
   * @param the_x The x coordinate.
   * @param the_y The y coordinate.
   * @param the_direction The direction the human is facing.
   * @param the_terrain The terrain the human starts on.
   */
  public Human(final int the_x, final int the_y, final Direction the_direction, 
               final Terrain the_terrain) {
    super(the_x, the_y, the_direction, DEATH_TIME);
    my_terrain = the_terrain;
  }
  
  /**
   * Checks the terrain type and the status of the street lights to determine if the 
   * human can pass through that block on the map.
   * @param the_terrain The terrain type the human is near.
   * @param the_light The status of the street lights on the map.
   * @return Whether or not the human can pass.
   */
  @Override
  public boolean canPass(final Terrain the_terrain, final Light the_light) {
    boolean canpass = false;
    if (the_terrain.equals(my_terrain) || (my_terrain == Terrain.STREET 
        && the_terrain == Terrain.LIGHT) || (my_terrain == Terrain.LIGHT 
        && the_terrain == Terrain.STREET)) {
      canpass = true;
    }
    return canpass;
  }

  /**
   * Asks the human for its preferred direction of movement.
   * @param the_neighbors The adjacent cells of the current human.
   * @param the_light The status of the street lights on the map.
   * @return The direction in which the human
   *  should attempt to move.
   */
  @Override
  public Direction chooseDirection(final Map<Direction, Terrain> the_neighbors, 
                                   final Light the_light) {
    Direction dir = Direction.random();
    while (!canPass(the_neighbors.get(dir), the_light)) {
      dir = Direction.random();
    }
    return dir;
  }

}
