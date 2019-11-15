package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import environment.*;
import lifeform.*;

/*
 * Possibly do:
 * make hovering work.
 */

public class GUI extends JFrame {

  Environment env;
  static GridBagConstraints x = new GridBagConstraints();
  JLabel[][] labelArray;
  JLabel stats;
  JPanel board = new JPanel(new GridBagLayout());
  
  public GUI(Environment env) {
    this.env = env;
    setLayout(new GridBagLayout());
    drawEnvironment();
    setMouseListener();
    drawStats(env.getCell(0, 0));
    drawLegend();
    
    pack();
    setResizable(false);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void drawEnvironment() {
    JLabel imageLabel;
    labelArray = new JLabel[env.getNumRows()][env.getNumCols()];
    for (int r = 0; r < env.getNumRows(); r++) {
      for (int c = 0; c < env.getNumCols(); c++) {
        imageLabel = new JLabel(createSquare(env.getCell(r, c)));
        labelArray[r][c] = imageLabel;
        x.gridx = c;
        x.gridy = r;
        board.add(labelArray[r][c], x);
      }
    }
    x.gridx = 0;
    x.gridy = 0;
    add(board, x);
  }
  /*
   * Redraws the board.
   */
  public void redrawBoard() {
    for (int r = 0; r < env.getNumRows(); r++) {
      for (int c = 0; c < env.getNumCols(); c++) {
        labelArray[r][c].setIcon(createSquare(env.getCell(r, c)));
      }
    }
  }
  
  public void redrawStats() {
    stats.setText(env.getSelectedCell().getStats());
  }
  private void drawStats(Cell c) {
    stats = new JLabel(c.getStats());
    stats.setLocation(0, 0);
    stats.setOpaque(true);
    stats.setBackground(new Color(255,255,255));
    x.anchor = x.FIRST_LINE_START;
    x.gridx = 1;
    x.gridy = 0;
    add(stats, x);
  }

  /*
   * draws legend.
   */
  public void drawLegend() {
    JLabel legend = new JLabel(legendImage());
    legend.setLocation(0, 0);
    legend.setOpaque(true);
    legend.setBackground(new Color(200, 200, 200));
    x.anchor = x.FIRST_LINE_START;
    x.weighty = 1.0;
    x.gridx = 0;
    x.gridy = 1;
    add(legend, x);
  }

  private ImageIcon createSquare(Cell c) {
    BufferedImage i = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
    Graphics g = i.getGraphics();
    
    //selected cell
    if(c == env.getSelectedCell()) {
      g.setColor(new Color(150, 200, 150));
      g.fillRect(0, 0, 50, 50);
      g.setColor(Color.WHITE);
      g.drawRect(49, 0, 1, 50);
      g.drawRect(0, 49, 50, 1);
    }
    else {
      g.setColor(new Color(100, 100, 100));
      g.fillRect(0, 0, 50, 50);
      g.setColor(Color.WHITE);
      g.drawRect(49, 0, 1, 50);
      g.drawRect(0, 49, 50, 1);
    }
    
    if(c.hasLifeForm()) {
      if(c.getLifeForm() instanceof Alien) {
        g.setColor(new Color(255, 0, 0));
        g.fillRect(10, 10, 30, 30);
      }
      else if(c.getLifeForm() instanceof Human) {
        g.setColor(new Color(0, 255, 255));
        g.fillOval(10, 10, 30, 30);
      }
    }
    return new ImageIcon(i);
  }

  private ImageIcon legendImage() {
    BufferedImage i = new BufferedImage(500, 150, BufferedImage.TYPE_3BYTE_BGR);
    Graphics g = i.getGraphics();
    return new ImageIcon(getClass().getResource("CommandButtons/legend.png"));
  }
  
  private void onMouseClicked(MouseEvent e) {
    for (int r = 0; r < env.getNumRows(); r++) {
      for (int c = 0; c < env.getNumCols(); c++) {
        if(e.getSource() == labelArray[r][c]) {
          env.selectCell(r, c);
          redrawBoard();
          redrawStats();
        }
      }
    }
  }
  public void setMouseListener() {
    for (int r = 0; r < env.getNumRows(); r++) {
      for (int c = 0; c < env.getNumCols(); c++) {
        labelArray[r][c].addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            onMouseClicked(e);
          }
        });
      }
    }
  }
}
