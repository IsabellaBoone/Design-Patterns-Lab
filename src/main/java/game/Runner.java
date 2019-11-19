package game;

import commands.Attack;
import commands.Command;
import commands.Drop;
import commands.East;
import commands.Move;
import commands.North;
import commands.Pickup;
import commands.Reload;
import commands.Remote;
import commands.South;
import commands.West;
import environment.Environment;
import exceptions.AttachmentException;
import exceptions.RecoveryRateException;
import exceptions.WeaponException;
import gui.CommandGui;
import gui.GUI;

import java.awt.Graphics;

import javax.swing.JFrame;

import lifeform.*;
import recovery.*;
import weapon.*;



public class Runner extends JFrame {
  static Environment e;
  static GUI gui;

  public static void main(String[] args) 
      throws RecoveryRateException, AttachmentException, WeaponException {
    start();
  }
  
  @Override
  public void paint(Graphics g) {
    add(gui);
  }
  
  static void start() throws RecoveryRateException, AttachmentException, WeaponException { 
    e = e.getEnvironment(10, 10);
    gui = new GUI(e);
    //**********************The Remote******************************************
    Remote r = new Remote(e);
    Command north = new North();
    Command east = new East();
    Command south = new South();
    Command west = new West();
    Command reload = new Reload();
    Command drop = new Drop();
    Command attack = new Attack();
    Command pickup = new Pickup();
    Command move = new Move();
    r.setCommand(0, north);
    r.setCommand(1, east);
    r.setCommand(2, south);
    r.setCommand(3, west);
    r.setCommand(4, reload);
    r.setCommand(5, drop);
    r.setCommand(6, attack);
    r.setCommand(7, pickup);
    r.setCommand(8, move);
    
    //****************************************************************
    
    
    LifeForm c = new Human("Chase", 200, 20);
    e.addLifeForm(c, 0, 0);
    LifeForm j = new Human("Joel-chan", 10000, 1000);
    e.addLifeForm(j, 2, 2);
    LifeForm m = new Human("Morgan", 150, 30);
    e.addLifeForm(m, 6, 8);
    LifeForm i = new Human("Isabella", 120, 45);
    e.addLifeForm(i, 3, 5);
    LifeForm a = new Human("Andrew", 2, 0);
    e.addLifeForm(a, 8, 3);
    RecoveryBehavior rl = new RecoveryLinear(2);
    Weapon p1 = new Scope(new PowerBooster(new Pistol())); 
    e.addWeapon(p1, 1, 1);
    Weapon p2 = new PowerBooster(new PowerBooster(new Pistol()));
    e.addWeapon(p2, 1, 1);
    Weapon p3 = new Scope(new Scope(new PlasmaCannon()));
    e.addWeapon(p3, 1, 2);
    Weapon pc = new PowerBooster(new PowerBooster(new PlasmaCannon()));
    e.addWeapon(pc, 1, 2);
    Weapon cg = new PowerBooster(new PowerBooster(new ChainGun()));
    e.addWeapon(cg, 1, 3);
    Weapon p4 = new ChainGun();
    e.addWeapon(p4, 1, 3);
    LifeForm jun = new Alien("America's Sweetheart: Jun", 10000, rl, 2);
    e.addLifeForm(jun, 6, 2);
    LifeForm kim = new Alien("Rat King: Kim", 3000, rl, 10);
    e.addLifeForm(kim, 3, 1);
    
    // dummies to test firing
    LifeForm d1 = new Human("Dummy 1", 1000, 0);
    LifeForm d2 = new Human("Dummy 2", 1000, 0);
    e.addLifeForm(d1, 9, 9);
    e.addLifeForm(d2, 9, 8);
    
    //
    
    jun.pickUpWeapon(pc);
    m.pickUpWeapon(cg);
    kim.turn(4);
   
    gui.redrawBoard();
    
    CommandGui commands = new CommandGui(e, gui, r); 
    
  }
}
