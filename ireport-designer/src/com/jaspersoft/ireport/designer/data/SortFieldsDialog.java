/*
 * iReport - Visual Designer for JasperReports.
 * Copyright (C) 2002 - 2009 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of iReport.
 *
 * iReport is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * iReport is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with iReport. If not, see <http://www.gnu.org/licenses/>.
 */
package com.jaspersoft.ireport.designer.data;

import com.jaspersoft.ireport.locale.I18n;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import java.util.*;
import net.sf.jasperreports.engine.design.JRDesignDataset;
import net.sf.jasperreports.engine.design.JRDesignSortField;
import net.sf.jasperreports.engine.type.SortOrderEnum;
/**
 *
 * @author  Administrator
 */
public class SortFieldsDialog extends javax.swing.JDialog {

    private JRDesignDataset dataset;

    public SortFieldsDialog(Dialog parent, boolean modal) 
    {
         super(parent,modal);
         initAll();
    }

    /** Creates new form ReportQueryFrame */
    public SortFieldsDialog(Frame parent, boolean modal) 
    {
         super(parent,modal);
         initAll();
    }

    
    public void initAll()
    {
        initComponents();

        jList1.setModel(new DefaultListModel());
        setLocationRelativeTo(null);
        
        jList1.setCellRenderer(new SortFieldCellRenderer());
        
        javax.swing.KeyStroke escape =  javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0, false);
        javax.swing.Action escapeAction = new javax.swing.AbstractAction() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                jButtonCloseActionPerformed(e);
            }
        };
       
        getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).put(escape, I18n.getString("Global.Pane.Escape"));
        getRootPane().getActionMap().put(I18n.getString("Global.Pane.Escape"), escapeAction);

        //applyI18n();
        //to make the default button ...
        this.getRootPane().setDefaultButton(this.jButtonClose);
    }
    
    /**
     * This function replace the list.
     * The replacement is done removing each single SortField and adding all the fields again
     * reading them by the list model.
     */
    private void updateDatasetSortFieldList()
    {
        
        while (getDataset().getSortFieldsList().size() > 0)
            {
                JRDesignSortField field = (JRDesignSortField)getDataset().getSortFieldsList().get(0);
                getDataset().removeSortField(field);
            }
            
            DefaultListModel dlm = (DefaultListModel)jList1.getModel();
            for (int i=0; i<dlm.getSize(); ++i)
            {
                try {
                    getDataset().addSortField( (JRDesignSortField)dlm.get(i) );
                } catch (Exception ex) {}
            }
        
    }
    
    /*
    public void applyI18n()
    {
                // Start autogenerated code ----------------------
                // End autogenerated code ----------------------
        this.setTitle( I18n.getString("sortFieldsDialog.title","Sorting options") );
        jButtonClose.setText(I18n.getString("close","Close"));
        
        jLabelSortBy.setText( I18n.getString("sortFieldsDialog.labelSortBy","Sort by...") );
        jButtonAdd.setText( I18n.getString("sortFieldsDialog.buttonAdd","Add field") );
        jButtonAscDesc.setText( I18n.getString("sortFieldsDialog.buttonAscDesc","Asc / Desc") );
        jButtonModify.setText( I18n.getString("sortFieldsDialog.buttonModify","Modify field") );
        jButtonMoveDown.setText( I18n.getString("sortFieldsDialog.buttonMoveDown","Move down") );
        jButtonMoveUp.setText( I18n.getString("sortFieldsDialog.buttonMoveUp","Move up") );
        jButtonRemove.setText( I18n.getString("sortFieldsDialog.buttonRemove","Remove field") );
    }
     */

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelSortBy = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonModify = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        jButtonMoveUp = new javax.swing.JButton();
        jButtonMoveDown = new javax.swing.JButton();
        jButtonAscDesc = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(I18n.getString("SortFieldsDialog.Title.Sorting")); // NOI18N
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabelSortBy.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelSortBy.setText(I18n.getString("SortFieldsDialog.Label.SortBy")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(jLabelSortBy, gridBagConstraints);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(359, 260));

        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 4, 4);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jPanel1.setMinimumSize(new java.awt.Dimension(120, 10));
        jPanel1.setPreferredSize(new java.awt.Dimension(120, 10));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jButtonAdd.setText(I18n.getString("Global.Button.AddField")); // NOI18N
        jButtonAdd.setMaximumSize(new java.awt.Dimension(200, 26));
        jButtonAdd.setMinimumSize(new java.awt.Dimension(90, 26));
        jButtonAdd.setPreferredSize(new java.awt.Dimension(120, 26));
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        jPanel1.add(jButtonAdd, gridBagConstraints);

        jButtonModify.setText(I18n.getString("SortFieldsDialog.Button.ModifyField")); // NOI18N
        jButtonModify.setMaximumSize(new java.awt.Dimension(200, 26));
        jButtonModify.setMinimumSize(new java.awt.Dimension(90, 26));
        jButtonModify.setPreferredSize(new java.awt.Dimension(120, 26));
        jButtonModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        jPanel1.add(jButtonModify, gridBagConstraints);

        jButtonRemove.setText(I18n.getString("SortFieldsDialog.Button.RemoveField")); // NOI18N
        jButtonRemove.setMaximumSize(new java.awt.Dimension(200, 26));
        jButtonRemove.setMinimumSize(new java.awt.Dimension(90, 26));
        jButtonRemove.setPreferredSize(new java.awt.Dimension(120, 26));
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        jPanel1.add(jButtonRemove, gridBagConstraints);

        jButtonMoveUp.setText(I18n.getString("Global.Button.MoveUp")); // NOI18N
        jButtonMoveUp.setMaximumSize(new java.awt.Dimension(200, 26));
        jButtonMoveUp.setMinimumSize(new java.awt.Dimension(90, 26));
        jButtonMoveUp.setPreferredSize(new java.awt.Dimension(120, 26));
        jButtonMoveUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMoveUpActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        jPanel1.add(jButtonMoveUp, gridBagConstraints);

        jButtonMoveDown.setText(I18n.getString("Global.Button.MoveDown")); // NOI18N
        jButtonMoveDown.setMaximumSize(new java.awt.Dimension(200, 26));
        jButtonMoveDown.setMinimumSize(new java.awt.Dimension(90, 26));
        jButtonMoveDown.setPreferredSize(new java.awt.Dimension(120, 26));
        jButtonMoveDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMoveDownActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        jPanel1.add(jButtonMoveDown, gridBagConstraints);

        jButtonAscDesc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jaspersoft/ireport/designer/data/arrow_refresh.png"))); // NOI18N
        jButtonAscDesc.setText(I18n.getString("SortFieldsDialog.Button.AscDesc")); // NOI18N
        jButtonAscDesc.setMaximumSize(new java.awt.Dimension(200, 26));
        jButtonAscDesc.setMinimumSize(new java.awt.Dimension(90, 26));
        jButtonAscDesc.setPreferredSize(new java.awt.Dimension(120, 26));
        jButtonAscDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAscDescActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        jPanel1.add(jButtonAscDesc, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jPanel2, gridBagConstraints);

        jButtonClose.setText(I18n.getString("Global.Button.Close")); // NOI18N
        jButtonClose.setMaximumSize(new java.awt.Dimension(200, 26));
        jButtonClose.setMinimumSize(new java.awt.Dimension(90, 26));
        jButtonClose.setPreferredSize(new java.awt.Dimension(120, 26));
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jButtonClose, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 4);
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked

        if (evt.getClickCount() == 2 &&
            evt.getButton() == MouseEvent.BUTTON1)
        {
            jButtonModifyActionPerformed(null);
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void jButtonAscDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAscDescActionPerformed

        // get selected sortfield...
        int[] items = jList1.getSelectedIndices();
        for (int i=0; i<items.length; ++i)
        {
            JRDesignSortField field = (JRDesignSortField)jList1.getModel().getElementAt(items[i]);
            if (field.getOrderValue() == SortOrderEnum.ASCENDING)
            {
                field.setOrder( SortOrderEnum.DESCENDING);
            }
            else
            {
                field.setOrder( SortOrderEnum.ASCENDING);
            }
        }
        updateDatasetSortFieldList();
        jList1.updateUI();
        
    }//GEN-LAST:event_jButtonAscDescActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged

        if (jList1.getSelectedIndex() >= 0)
        {
            jButtonAscDesc.setEnabled(true);
            jButtonModify.setEnabled(true);
            jButtonRemove.setEnabled(true);
            jButtonMoveUp.setEnabled(jList1.getSelectedIndex() > 0);
            jButtonMoveDown.setEnabled(jList1.getSelectedIndex() < ((DefaultListModel)jList1.getModel()).size()-1);
        }
        else
        {
            jButtonAscDesc.setEnabled(false);
            jButtonModify.setEnabled(false);
            jButtonRemove.setEnabled(false);
            jButtonMoveUp.setEnabled(false);
            jButtonMoveDown.setEnabled(false);
        }
    }//GEN-LAST:event_jList1ValueChanged

    private void jButtonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifyActionPerformed

        // get selected sortfield...
        if (jList1.getSelectedIndex() >= 0)
        {
            JRDesignSortField field = (JRDesignSortField)jList1.getSelectedValue();
            SortFieldDialog sfd = new SortFieldDialog(this, true);
            sfd.setDataset( getDataset() );
            sfd.setSortField( field );
            
            sfd.setVisible(true);
            
            if (sfd.getDialogResult() == javax.swing.JOptionPane.OK_OPTION)
            {
                field.setName( sfd.getSortField().getName() );
                field.setOrder( sfd.getSortField().getOrderValue() );
                jList1.updateUI();
            }
            updateDatasetSortFieldList();
        }
    }//GEN-LAST:event_jButtonModifyActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonMoveUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMoveUpActionPerformed

        if (jList1.getSelectedValues() != null)
        {
            int[] indices = jList1.getSelectedIndices();
            for (int i=0; i<indices.length; ++i)
            {
                if (indices[i] == 0) continue;
                Object val = ((DefaultListModel)jList1.getModel()).remove( indices[i] );
                ((DefaultListModel)jList1.getModel()).insertElementAt(val, indices[i]-1);
                indices[i]--;
            }
            jList1.setSelectedIndices(indices);
            
            updateDatasetSortFieldList();
        }

    }//GEN-LAST:event_jButtonMoveUpActionPerformed

    private void jButtonMoveDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMoveDownActionPerformed
        if (jList1.getSelectedValues() != null)
        {
            int[] indices = jList1.getSelectedIndices();
            for (int i=indices.length-1; i>=0; --i)
            {
                if (indices[i] >= ((DefaultListModel)jList1.getModel()).size() -1 ) continue;

                Object val = ((DefaultListModel)jList1.getModel()).remove( indices[i] );
                ((DefaultListModel)jList1.getModel()).insertElementAt(val, indices[i]+1);
                indices[i]++;
            }
            jList1.setSelectedIndices(indices);
            
            updateDatasetSortFieldList();
          }
    }//GEN-LAST:event_jButtonMoveDownActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed

        if (jList1.getSelectedValues() != null)
        {
            Object[] values = jList1.getSelectedValues();
            for (int i=0; i<values.length; ++i)
            {
                JRDesignSortField field = (JRDesignSortField)values[i];
                ((DefaultListModel)jList1.getModel()).removeElement(field);
                getDataset().removeSortField( field );
            }
        }


    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed

        SortFieldDialog jrpd = new SortFieldDialog(this, true);
        jrpd.setDataset( getDataset() );
        jrpd.setVisible(true);

        if (jrpd.getDialogResult() == javax.swing.JOptionPane.OK_OPTION)
        {

            JRDesignSortField field = jrpd.getSortField();
            ((DefaultListModel)jList1.getModel()).addElement(field);
            try {
                getDataset().addSortField( field );
            } catch (Exception ex) { }
        }
        

    }//GEN-LAST:event_jButtonAddActionPerformed

   
    //getSubDataset().fireSubDatasetObjectChangedListenerSubDatasetObjectChanged( new SubDatasetObjectChangedEvent( getSubDataset() ,SubDatasetObjectChangedEvent.SORTFIELD, SubDatasetObjectChangedEvent.MODIFIED, null, null));
    
    public JRDesignDataset getDataset() {
        return dataset;
    }

    public void setDataset(JRDesignDataset dataset) {
        this.dataset = dataset;
        List cp = dataset.getSortFieldsList();
        for (int i=0; i<cp.size(); ++i) {
            ((DefaultListModel)jList1.getModel()).addElement( (JRDesignSortField)cp.get(i) );
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAscDesc;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonModify;
    private javax.swing.JButton jButtonMoveDown;
    private javax.swing.JButton jButtonMoveUp;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JLabel jLabelSortBy;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
