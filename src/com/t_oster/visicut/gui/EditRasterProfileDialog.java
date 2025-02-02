/**
 * This file is part of VisiCut.
 * Copyright (C) 2011 - 2013 Thomas Oster <thomas.oster@rwth-aachen.de>
 * RWTH Aachen University - 52062 Aachen, Germany
 *
 *     VisiCut is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     VisiCut is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with VisiCut.  If not, see <http://www.gnu.org/licenses/>.
 **/
/*
 * EditRasterProfileDialog.java
 *
 * Created on 06.09.2011, 10:34:59
 */
package com.t_oster.visicut.gui;

import com.t_oster.liblasercut.BlackWhiteRaster;
import com.t_oster.liblasercut.BlackWhiteRaster.DitherAlgorithm;
import com.t_oster.liblasercut.dithering.DitheringAlgorithm;
import com.t_oster.uicomponents.BetterJTable;
import com.t_oster.visicut.VisicutModel;
import com.t_oster.visicut.gui.beans.CustomizableTableModel;
import com.t_oster.visicut.model.RasterProfile;

/**
 *
 * @author Thomas Oster <thomas.oster@rwth-aachen.de>
 */
public class EditRasterProfileDialog extends javax.swing.JDialog
{

  protected RasterProfile rasterProfile = null;
  public static final String PROP_RASTERPROFILE = "rasterProfile";

  /**
   * Get the value of RasterProfile
   *
   * @return the value of RasterProfile
   */
  public RasterProfile getRasterProfile()
  {
    return rasterProfile;
  }

  /**
   * Set the value of RasterProfile
   *
   * @param rasterProfile new value of RasterProfile
   */
  public void setRasterProfile(RasterProfile rasterProfile)
  {
    RasterProfile oldRasterProfile = this.rasterProfile;
    this.rasterProfile = rasterProfile;
    firePropertyChange(PROP_RASTERPROFILE, oldRasterProfile, rasterProfile);
    if (rasterProfile == null)
    {
      this.setCurrentRasterProfile(new RasterProfile());
    }
    else
    {
      this.setCurrentRasterProfile((RasterProfile) rasterProfile.clone());
    }
  }
  protected RasterProfile currentRasterProfile = null;
  public static final String PROP_CURRENTRASTERPROFILE = "currentRasterProfile";

  /**
   * Get the value of currentRasterProfile
   *
   * @return the value of currentRasterProfile
   */
  public RasterProfile getCurrentRasterProfile()
  {
    return currentRasterProfile;
  }

  /**
   * Set the value of currentRasterProfile
   *
   * @param currentRasterProfile new value of currentRasterProfile
   */
  public void setCurrentRasterProfile(RasterProfile currentRasterProfile)
  {
    RasterProfile oldCurrentRasterProfile = this.currentRasterProfile;
    this.currentRasterProfile = currentRasterProfile;
    firePropertyChange(PROP_CURRENTRASTERPROFILE, oldCurrentRasterProfile, currentRasterProfile);
    if (currentRasterProfile != null)
    {
      DitheringAlgorithm da = currentRasterProfile.getDitherAlgorithm();
      for (int i=0; i < this.jComboBox1.getItemCount(); i++)
      {
        if (da.getClass().isAssignableFrom(this.jComboBox1.getItemAt(i).getClass()))
        {
          this.jComboBox1.setSelectedIndex(i);
          break;
        }
      }
      this.currentRasterProfile.setDitherAlgorithm(da);
      this.jTable1.setModel(new CustomizableTableModel(currentRasterProfile.getDitherAlgorithm()));
    }
  }

  /** Creates new form EditRasterProfileDialog */
  public EditRasterProfileDialog(java.awt.Frame parent, boolean modal)
  {
    super(parent, modal);
    initComponents();
    jComboBox1.removeAllItems();
    for (DitherAlgorithm a : BlackWhiteRaster.DitherAlgorithm.values())
    {
      jComboBox1.addItem(BlackWhiteRaster.getDitheringAlgorithm(a));
    }
    this.jTable1.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
    cbResolution.removeAllItems();
    if (VisicutModel.getInstance().getSelectedLaserDevice() != null)
    {
      for (Double d: VisicutModel.getInstance().getSelectedLaserDevice().getLaserCutter().getResolutions())
      {
        this.cbResolution.addItem(d);
      }
    }
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfDescription = new javax.swing.JTextField();
        lbDescription = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        selectThumbnailButton1 = new com.t_oster.uicomponents.SelectThumbnailButton();
        cbInvertColors = new javax.swing.JCheckBox();
        jSlider1 = new javax.swing.JSlider();
        jSlider2 = new javax.swing.JSlider();
        lbGreyscaleShift = new javax.swing.JLabel();
        lbContrastBoost = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new BetterJTable();
        jLabel1 = new javax.swing.JLabel();
        cbResolution = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/t_oster/visicut/gui/resources/EditRasterProfileDialog"); // NOI18N
        setTitle(bundle.getString("TITLE")); // NOI18N
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.t_oster.visicut.gui.VisicutApp.class).getContext().getResourceMap(EditRasterProfileDialog.class);
        jButton4.setText(resourceMap.getString("Cancel")); // NOI18N
        jButton4.setName("jButton4"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText(resourceMap.getString("Save")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        tfDescription.setName("tfDescription"); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentRasterProfile.description}"), tfDescription, org.jdesktop.beansbinding.BeanProperty.create("text"), "desc");
        bindingGroup.addBinding(binding);

        lbDescription.setText(resourceMap.getString("Description")); // NOI18N
        lbDescription.setName("lbDescription"); // NOI18N

        lbName.setText(resourceMap.getString("lbName.text")); // NOI18N
        lbName.setName("lbName"); // NOI18N

        tfName.setName("tfName"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentRasterProfile.name}"), tfName, org.jdesktop.beansbinding.BeanProperty.create("text"), "Name");
        bindingGroup.addBinding(binding);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setName("jComboBox1"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentRasterProfile.ditherAlgorithm}"), jComboBox1, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        selectThumbnailButton1.setName("selectThumbnailButton1"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentRasterProfile.thumbnailPath}"), selectThumbnailButton1, org.jdesktop.beansbinding.BeanProperty.create("thumbnailPath"), "thumbnailbt");
        bindingGroup.addBinding(binding);

        cbInvertColors.setText(resourceMap.getString("profile.invertColors")); // NOI18N
        cbInvertColors.setName("cbInvertColors"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentRasterProfile.invertColors}"), cbInvertColors, org.jdesktop.beansbinding.BeanProperty.create("selected"), "invcolors");
        bindingGroup.addBinding(binding);

        jSlider1.setMaximum(255);
        jSlider1.setMinimum(-255);
        jSlider1.setToolTipText(resourceMap.getString("jSlider1.toolTipText")); // NOI18N
        jSlider1.setName("jSlider1"); // NOI18N

        jSlider2.setMaximum(255);
        jSlider2.setMinimum(0);
        jSlider2.setToolTipText(resourceMap.getString("jSlider2.toolTipText")); // NOI18N
        jSlider2.setName("jSlider2"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentRasterProfile.colorShift}"), jSlider1, org.jdesktop.beansbinding.BeanProperty.create("value"), "colorshift");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentRasterProfile.contrastBoost}"), jSlider2, org.jdesktop.beansbinding.BeanProperty.create("value"), "contrastboost");
        bindingGroup.addBinding(binding);

        lbGreyscaleShift.setText(resourceMap.getString("profile.greyscaleShift")); // NOI18N
        lbGreyscaleShift.setName("lbGreyscaleShift"); // NOI18N
        lbContrastBoost.setText(resourceMap.getString("profile.contrastBoost")); // NOI18N
        lbContrastBoost.setName("lbContrastBoost"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setName("jTable1"); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText(resourceMap.getString("Resolution")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        cbResolution.setEditable(true);
        cbResolution.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbResolution.setName("cbResolution"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentRasterProfile.DPI}"), cbResolution, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"), "cbBinding");
        bindingGroup.addBinding(binding);

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDescription)
                    .addComponent(selectThumbnailButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbGreyscaleShift)
                    .addComponent(lbContrastBoost)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                    .addComponent(jSlider2, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                    .addComponent(tfDescription)
                    .addComponent(tfName)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                    .addComponent(cbResolution, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbInvertColors)
                    .addComponent(lbName))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(selectThumbnailButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDescription)
                    .addComponent(tfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbResolution, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbGreyscaleShift)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbContrastBoost)
                    .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(cbInvertColors))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton4ActionPerformed
  {//GEN-HEADEREND:event_jButton4ActionPerformed

    this.setRasterProfile(null);     this.setVisible(false);   }//GEN-LAST:event_jButton4ActionPerformed

  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
  {//GEN-HEADEREND:event_jButton3ActionPerformed

    this.setRasterProfile(this.getCurrentRasterProfile());     this.setVisible(false);   }//GEN-LAST:event_jButton3ActionPerformed

private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    Object o = this.jComboBox1.getSelectedItem();
    if (o instanceof DitheringAlgorithm)
    {
      DitheringAlgorithm a = ((DitheringAlgorithm) o).clone();
      this.jTable1.setModel(new CustomizableTableModel(a));
      this.jScrollPane1.setVisible(a.getPropertyKeys().length > 0);
      this.pack();
      if (this.currentRasterProfile != null)
      {
        this.currentRasterProfile.setDitherAlgorithm(a);
      }
    }
}//GEN-LAST:event_jComboBox1ActionPerformed
  /**
   * @param args the command line arguments
   */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbInvertColors;
    private javax.swing.JComboBox cbResolution;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbDescription;
    private javax.swing.JLabel lbGreyscaleShift;
    private javax.swing.JLabel lbContrastBoost;
    private javax.swing.JLabel lbName;
    private com.t_oster.uicomponents.SelectThumbnailButton selectThumbnailButton1;
    private javax.swing.JTextField tfDescription;
    private javax.swing.JTextField tfName;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

  void setNameEditable(boolean b)
  {
    tfName.setEnabled(b);
  }

  void setCancelable(boolean b)
  {
    this.jButton4.setVisible(false);
  }

  public void setOnlyEditParameters(boolean b)
  {
    this.lbDescription.setVisible(!b);
    this.tfDescription.setVisible(!b);
    this.lbName.setVisible(!b);
    this.tfName.setVisible(!b);
    this.selectThumbnailButton1.setVisible(!b);
    this.pack();
  }
}
