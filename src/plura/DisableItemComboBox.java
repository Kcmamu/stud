/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plura;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.InputMap;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.KeyStroke;

/**
 *
 * @author kandit
 */
public class DisableItemComboBox< E> extends JComboBox< E> {
  private final Set< Integer> disableIndexSet = new HashSet<>();
  private boolean isDisableIndex;
  private final Action up = new AbstractAction() {
    @Override public void actionPerformed(ActionEvent e) {
      int si = getSelectedIndex();
      for (int i = si - 1; i >= 0; i--) {
        if (!disableIndexSet.contains(i)) {
          setSelectedIndex(i);
          break;
        }
      }
    }
  };
  private final Action down = new AbstractAction() {
    @Override public void actionPerformed(ActionEvent e) {
      int si = getSelectedIndex();
      for (int i = si + 1; i < getModel().getSize(); i++) {
        if (!disableIndexSet.contains(i)) {
          setSelectedIndex(i);
          break;
        }
      }
    }
  };
  public DisableItemComboBox() {
    super();
  }
  public DisableItemComboBox(ComboBoxModel< E> aModel) {
    super(aModel);
  }
  public DisableItemComboBox(E[] items) {
    super(items);
  }
  @Override public void updateUI() {
    super.updateUI();
    setRenderer(new DefaultListCellRenderer() {
      @Override 
      public Component getListCellRendererComponent(
          JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component c;
        if (disableIndexSet.contains(index)) {
          c = super.getListCellRendererComponent(list, value, index, false, false);
          c.setEnabled(false);
        } else {
          c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
          c.setEnabled(true);
        }
        return c;
      }
    });
    ActionMap am = getActionMap();
    am.put("selectPrevious3", up);
    am.put("selectNext3", down);
    InputMap im = getInputMap();
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0),      "selectPrevious3");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_KP_UP, 0),   "selectPrevious3");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0),    "selectNext3");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_KP_DOWN, 0), "selectNext3");
  }
  public void setDisableIndex(Set< Integer> set) {
    disableIndexSet.clear();
    for (Integer i : set){
         disableIndexSet.add(i);
    }
 
  }
  @Override public void setPopupVisible(boolean v) {
    if (!v && isDisableIndex) {
      isDisableIndex = false;
    } else {
      super.setPopupVisible(v);
    }
  }
  @Override public void setSelectedIndex(int index) {
    if (disableIndexSet.contains(index)) {
      isDisableIndex = true;
    } else {
      //isDisableIndex = false;
      super.setSelectedIndex(index);
    }
  }
}