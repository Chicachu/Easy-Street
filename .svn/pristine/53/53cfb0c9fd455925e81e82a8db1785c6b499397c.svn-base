import java.util.Map;

/*
 * AbstractVehicle.java
 * TCSS 305 - Spring 2013
 */

/**
 * An abstract vehicle for other moving objects to model.
 * @author Erica Putsche
 * @version 04/17/2013
 */
public abstract class AbstractVehicle implements Vehicle {

  /**
   * Initial x coordinate.
   */
  private final int my_initial_x; 
  
  /**
   * Initial y coordinate.
   */
  private final int my_initial_y; 
  
  /**
   * Initial direction. 
   */
  private final Direction my_initial_direction;
    
  /**
   * The x coordinate.
   */
  private int my_x;
  
  /**
   * The y coordinate.
   */
  private int my_y;
  
  /**
   * The direction the vehicle is facing.
   */
  private Direction my_direction;
  
  /**
   * Dead or alive status of vehicle.
   */
  private boolean my_is_alive = true;
  
  /**
   * The number of moves the vehicle will stay dead after a collision.
   */
  private final int my_death_time;
  
  /**
   * Keeps track of how many pokes the vehicle has been dead.
   */
  private int my_num_deaths;
  
  /**
   * Constructor that sets the x and y coordinates as well as the direction of the vehicle.
   * @param the_x The x coordinate.
   * @param the_y The y coordinate.
   * @param the_direction The direction the vehicle is facing.
   * @param the_death_time The amount of time the vehicle will stay dead after a collision.
   */
  protected AbstractVehicle(final int the_x, final int the_y, final Direction the_direction, 
                            final int the_death_time) {
    my_x = the_x; 
    my_y = the_y;
    my_direction = the_direction;
    my_death_time = the_death_time;

    // save initial state for reset ability.
    my_initial_x = my_x;
    my_initial_y = my_y;
    my_initial_direction = my_direction;
  }

  /**
   * Updates vehicles status after a collision occurs. 
   * @param the_other The vehicle that 
   */
  @Override
  public void collide(final Vehicle the_other) {
    if (this.getDeathTime() > the_other.getDeathTime()) {
      my_is_alive = false;
    }
  }

  /**
   * Gets the death time associated with the vehicle.
   * @return The amount of time a vehicle stays dead.
   */
  @Override
  public int getDeathTime() {
    return my_death_time;
  }

  
  /**
   * Gets the direction the vehicle is currently facing.
   * @return The direction the vehicle is currently facing.
   */
  @Override
  public Direction getDirection() {
    return my_direction;
  }

  /**
   * Gets the current X coordinate of the vehicle.
   * @return The current X coordinate of the vehicle.
   */
  @Override
  public int getX() {
    return my_x;
  }

  /**
   * Gets the current Y coordinate of the vehicle.
   * @return The current Y coordinate of the vehicle.
   */
  @Override
  public int getY() {
    return my_y;
  }

  /**
   * Asks if the vehicle is alive or dead.
   * @return The state of the vehicle (alive or dead).
   */
  @Override
  public boolean isAlive() {
    return my_is_alive;
  }

  @Override
  public void poke() {
    if (my_num_deaths < my_death_time) {
      my_num_deaths++; 
    } else {
      my_num_deaths = 0; 
      my_is_alive = true;
    }
  }
  
  /**
   * Retrieves the string representation of the image of the vehicle to be used by the GUI.
   * @return The string representation of the vehicle's image.
   */
  @Override
  public String getImageFileName() {
    String image_name; 
    if (this.isAlive()) {
      image_name = this.getClass().getName().toLowerCase() + ".gif";
    } else {
      image_name = this.getClass().getName().toLowerCase() + "_dead.gif";
    }
    return image_name;
  }

  /**
   * Resets the vehicles state to it's initial state.
   */
  @Override
  public void reset() {
    setX(my_initial_x); 
    setY(my_initial_y);
    setDirection(my_initial_direction);
  }

  /**
   * Sets the direction of the vehicle.
   * @param the_direction The direction the vehicle will be set to.
   */
  @Override
  public void setDirection(final Direction the_direction) {
    my_direction = the_direction;
  }

  @Override
  public void setX(final int the_x) {
    my_x = the_x;
  }

  @Override
  public void setY(final int the_y) {
    my_y = the_y;
  }
  
  /**
   * Chooses a direction based on a pattern: First attempt to go straight, then left, 
   * then right, and if all of those fail, reverse. Both the car and bike use this pattern.
   * @param the_neighbors The neighboring cells to the vehicle.
   * @param the_light The current color of the street lights.
   * @return The new direction to go in.
   */
  protected Direction chooseCircularDirection(final Map<Direction, Terrain> the_neighbors, 
                                              final Light the_light) {
    Direction dir;
//    if (the_neighbors.get(this.getDirection()) == Terrain.STREET) {
//      dir = this.getDirection();
//    } else if (the_neighbors.get(this.getDirection().left()) == Terrain.STREET) {
//      dir = this.getDirection().left();
//    } else if (the_neighbors.get(this.getDirection().right()) == Terrain.STREET) {
//      dir = this.getDirection().right();
//    } else {
//      dir = this.getDirection().reverse();
//    }
    if (canPass(the_neighbors.get(this.getDirection()), the_light)) {
      dir = this.getDirection();
    } else if (canPass(the_neighbors.get(this.getDirection().left()), the_light)) {
      dir = this.getDirection().left();
    } else if (canPass(the_neighbors.get(this.getDirection().right()), the_light)) {
      dir = this.getDirection().right();
    } else {
      dir = this.getDirection().reverse();
    }
    
    return dir;
  }
  
}
