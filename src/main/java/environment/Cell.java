package environment;

import lifeform.LifeForm;
import weapon.Weapon;

/**
 * A class that creates a Cell type.
 * @author andrewjanuszko
 */
public class Cell extends Object {
  
  LifeForm entity;
  
  /**
   * Empty constructor for Cell().
   */
  public Cell() {
    // Empty.
  }

  /**
   * Allows the user to return the stored
   * LifeForm.
   * @return the LifeForm
   */
  public LifeForm getLifeForm() {
    return entity;
  }

  /**
   * Allows the user to add a LifeForm.
   * @param entity — the LifeForm to be stored.
   * @return true is the LifeForm was added, false if a LifeForm is saved.
   */
  public boolean addLifeForm(LifeForm entity) {
    if (this.entity == null) {
      this.entity = entity;
      return true;
    }
    return false;
  }
  
  /**
   * Allows the user to remove a LifeForm.
   */
  void removeLifeForm() {
    entity = null;
  }
  
  /**
   * Returns how many weapons are left in the cell
   * @return the number of weapons left.
   */
  public int getWeaponsCount() {
    return 0; // returns 0 / 1 / 2
  }
  
  /**
   * Adds a weapon to a cell.
   * @param weapon is the weapon to be put inside of the cell.
   * @return true if placed successfully, false otherwise.
   */
  public boolean addWeapon(Weapon weapon) {
    return false; // returns true / false
  }
  
  /**
   * Removes weapon if the weapon is in a cell.
   * @param weapon the weapon to be removed.
   * @return the removed weapon. Null otherwise.
   */
  public Weapon removeWeapon(Weapon weapon) {
    return null;
  }
  
  /**
   * Get the weapon in slot #1.
   * @return the weapon in slot #1.
   */
  public Weapon getWeapon1() {
    return null;
  }
  
  /**
   * Get the weapon in slot #2.
   * @return the weapon in slot #2.
   */
  public Weapon getWeapon2() {
    return null;
  }
  
}