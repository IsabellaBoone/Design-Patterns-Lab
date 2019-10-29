package environment;

import lifeform.LifeForm;
import weapon.Weapon;

/**
 * A class that creates an Environment type.
 * 
 * @author andrewjanuszko
 */
public class Environment extends Object {

  private Cell[][] cell;
  private static Environment env;

  /**
   * Environment constructor — template for Environment type.
   * 
   * @param row holds the y position in the 2D array.
   * @param col holds the x position in the 2D array.
   */
  private Environment(int row, int col) {
    cell = new Cell[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        cell[i][j] = new Cell();
      }
    }
  }

  /**
   * Allows users to add LifeForms to the environment.
   * 
   * @param lf  — holds the LifeForm to be added.
   * @param row — the y position to store it at in the 2D array.
   * @param col — the x position to store it at in the 2D array.
   * @return true if added successfully, false if not added.
   */
  boolean addLifeForm(LifeForm lf, int row, int col) {
    if (getLifeForm(row, col) == lf) {
      return false;
    }
    if (getLifeForm(row, col) == null) {
      cell[row][col].addLifeForm(lf);
    }
    return (cell[row][col].getLifeForm() == lf) ? true : false;
  }

  /**
   * Add a weapon to the the lifeform at the position of row, col.
   * 
   * @param weapon - weapon to add 
   * @param row - the y position to store it at in the 2D array.
   * @param col - the x position to store it at in the 2D array. 
   * @return - whether or not the addition was successful.  
   */
  boolean addWeapon(Weapon weapon, int row, int col) {
    if (env.getNumRows() > row && env.getNumCols() > col && col >= 0 && row >= 0) {
      return cell[row][col].addWeapon(weapon);
    }
    return false;
  }

  /**
   * Removes all LifeForms and Weapons. Used for resets.
   */
  public void clearBoard() {
    for (int i = 0; i < getNumRows(); ++i) {
      for (int j = 0; j < getNumCols(); ++j) {
        cell[i][j] = new Cell();
      }
    }
  }

  /**
   * Get the distance between a lifeform at [row1][col1] and the other
   * lifeform at [row2][col2].  
   * 
   * @param row1 - the y position of the first lifeform. 
   * @param col1 - the x position of the first lifeform. 
   * @param row2 - the y position of the second lifeform. 
   * @param col2 - the x position of the second lifeform. 
   * @return - the distance between the lifeforms.  
   */
  double getDistance(int row1, int col1, int row2, int col2) {
    return 5 * Math.sqrt(Math.pow(col2 - col1, 2) + Math.pow(row2 - row1, 2));
  }

  /**
   * 
   * @param lf1
   * @param lf2
   * @return
   */
  double getDistance(LifeForm lf1, LifeForm lf2) {
    return 5 * Math.sqrt(Math.pow(lf2.getCol() - lf1.getCol(), 2) + Math.pow(lf2.getRow() - lf1.getRow(), 2));
  }

  /**
   * Creates a singleton instance of the environment.
   * 
   * @param rows the num of rows in the environment.
   * @param cols the num of cols in the environment.
   * @return the Singleton instance of the Environment.
   */
  public static Environment getEnvironment(int rows, int cols) {
    if (env == null) {
      env = new Environment(rows, cols);
    }
    return env;
  }

  /**
   * Allows users to retrive the LifeForm they stored.
   * 
   * @param row — the y position to get from the 2D array.
   * @param col — the x position to get from the 2D array.
   * @return the LifeForm from the array.
   */
  LifeForm getLifeForm(int row, int col) {
    return cell[row][col].getLifeForm();
  }

  /**
   * 
   * @return
   */
  int getNumCols() {
    return cell[0].length;
  }

  /**
   * 
   * @return
   */
  int getNumRows() {
    return cell.length;
  }

  /**
   * 
   * @param row
   * @param col
   * @return
   */
  Weapon[] getWeapons(int row, int col) {
    Weapon[] weapons = new Weapon[2];
    weapons[0] = cell[row][col].getWeapon1();
    weapons[1] = cell[row][col].getWeapon2();
    return weapons;
  }

  /**
   * Allows users to remove LifeForms from the environment.
   * 
   * @param row — the y position to remove from the 2D array.
   * @param col — the x position to remove from the 2D array.
   */
  void removeLifeForm(int row, int col) {
    cell[row][col].removeLifeForm();
  }

  /**
   * 
   * @param weapon
   * @param row
   * @param col
   * @return
   */
  Weapon removeWeapon(Weapon weapon, int row, int col) {
    return null;
  }
}
