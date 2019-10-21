package environment;

import lifeform.LifeForm;

/**
 * A class that creates an Environment type.
 * @author andrewjanuszko
 */
public class Environment {
  
  private Cell[][] cell;
  
  /**
   * Environment constructor — template for Environment type.
   * @param row holds the y position in the 2D array.
   * @param col holds the x position in the 2D array.
   */
  public Environment(int row, int col) {
    cell = new Cell[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        cell[i][j] = new Cell();
      } 
    }
  }
  
  /**
   * Allows users to add LifeForms to the environment.
   * @param lf — holds the LifeForm to be added.
   * @param row — the y position to store it at in the 2D array.
   * @param col — the x position to store it at in the 2D array.
   * @return true if added successfully, false if not added.
   */
  boolean addLifeForm(LifeForm lf, int row, int col) {
    if (getLifeForm(row,col) == null) {
      cell[row][col].addLifeForm(lf);
    }
    return (cell[row][col].getLifeForm() == lf) ? true : false;
  }
  
  /**
   * Allows users to remove LifeForms from the environment.
   * @param row — the y position to remove from the 2D array.
   * @param col — the x position to remove from the 2D array.
   */
  void removeLifeForm(int row, int col) {
    cell[row][col] = new Cell();
  }
  
  /**
   * Allows users to retrive the LifeForm they stored.
   * @param row — the y position to get from the 2D array.
   * @param col — the x position to get from the 2D array.
   * @return the LifeForm from the array.
   */
  LifeForm getLifeForm(int row, int col) {
    return cell[row][col].getLifeForm();
  }

}
