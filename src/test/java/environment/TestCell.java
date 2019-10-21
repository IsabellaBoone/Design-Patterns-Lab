package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import lifeform.MockLifeForm;

import org.junit.Test;

/**
 * The JUnit 4 test file for Cell.class
 * @author andrewjanuszko
 */
public class TestCell {

  /**
   * Tests to see if a Cell can be properly
   * initialized.
   */
  @Test
  public void testInitialization() {
    Cell cell = new Cell();
    assertNull(cell.getLifeForm());
  }
  
  /**
   * Tests to see if a LifeForm can be
   * properly added to a Cell.
   */
  @Test
  public void testAddLifeForm() {
    MockLifeForm bob = new MockLifeForm("Bob", 40);
    MockLifeForm fred = new MockLifeForm("Fred", 40);
    Cell cell = new Cell();
    // The cell is empty so this should work.
    boolean success = cell.addLifeForm(bob);
    assertTrue(success);
    assertEquals(bob, cell.getLifeForm());
    // The cell is not empty so this should fail.
    success = cell.addLifeForm(fred);
    assertFalse(success);
    assertEquals(bob, cell.getLifeForm());
  }
  
  /**
   * Tests to see if the overwrite protection
   * works properly on a Cell.
   */
  @Test
  public void testOverwriteLifeForm() {
    MockLifeForm bob = new MockLifeForm("Bob", 40);
    Cell cell = new Cell();
    cell.addLifeForm(bob);
    assertEquals(bob, cell.getLifeForm());
    MockLifeForm fred = new MockLifeForm("Fred", 40);
    assertFalse(cell.addLifeForm(fred));
  }
  
  /**
   * Tests to see if LifeForms can be
   * properly removed from a Cell.
   */
  @Test
  public void testRemoveLifeForm() {
    MockLifeForm bob = new MockLifeForm("Bob", 40);
    Cell cell = new Cell();
    cell.addLifeForm(bob);
    assertEquals(bob, cell.getLifeForm());
    cell.removeLifeForm();
    assertNull(cell.getLifeForm());
  }

}
