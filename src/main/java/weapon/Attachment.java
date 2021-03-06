package weapon;

import exceptions.WeaponException;

/**
 * A template for all attachments.
 * @author andrewjanuszko
 */
public abstract class Attachment extends Object implements Weapon {
  
  protected Weapon base;
  
  /**
   * Creates an attachment.
   */
  public Attachment() {
    
  }

  /**
   * Updates the time of the system.
   */
  public void updateTime(int time) {
    if (time >= 0) {
      base.updateTime(time);
    } else {
      System.out.println("I don't know how you managed to get a negative round, but you did.");
    }
  }
  
  /**
   * Most attachments will change the damage the weapon does when it fires.
   * @param distance — distance to the target, for now, if the target is in range, it will be hit.
   * @return the damage the weapon deals to the target, the target's armor may mitigate this damage.
   * @throws WeaponException if incorrect distance.
   */
  public abstract int fire(int distance) throws WeaponException;
  
  /**
   * Get the base damage of the current weapon.
   * @return the base damage of this weapon.
   */
  public int getBaseDamage() {
    return base.getBaseDamage();
  }
 
  /**
   * Gets the number of bullets in the clip of the current weapon.
   * @return the current number of bullets in the clip.
   */
  public int getCurrentAmmo() {
    return base.getCurrentAmmo();
  }
 
  /**
   * Gets the clip size of the current weapon.
   * @return the clip size of this weapon.
   */
  public int getMaxAmmo() {
    return base.getMaxAmmo();
  }
 
  /**
   * Get the maximum range of the current weapon.
   * @return the maximum range of the weapon.
   */
  public int getMaxRange() {
    return base.getMaxRange();
  }
  
  /**
   * Get the number of attachments on the current weapon.
   * @return the number of attachments on this Weapon.
   */
  public int getNumAttachments() {
    return base.getNumAttachments() + 1;
  }
 
  /**
   * Get the number of times the current weapon may fire during a round.
   * @return the number of times this weapon may fire during a round.
   */
  public int getRateOfFire() {
    return base.getRateOfFire();
  }
  
  /**
   * Gets the number of shots left in the current round.
   * @return the number of shots left in this round.
   */
  public int getShotsLeft() {
    return base.getShotsLeft();
  }

  /**
   * Reload the clip to full capacity.
   * For now, we assume a limitless supply of clips.
   * This may be refactored in the future to take ammo reserves into account.
   */
  public void reload() {
    base.reload();
  }

}
