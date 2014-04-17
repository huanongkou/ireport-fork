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
package com.jaspersoft.ireport.designer.connection.gui;

import com.jaspersoft.ireport.locale.I18n;
import com.jaspersoft.ireport.designer.IReportConnection;
import com.jaspersoft.ireport.designer.IReportConnectionEditor;
import com.jaspersoft.ireport.designer.connection.JREmptyDatasourceConnection;


/**
 *
 * @author  gtoffoli
 */
public class JREmptyDataSourceConnectionEditor extends javax.swing.JPanel implements IReportConnectionEditor {
    
    private IReportConnection iReportConnection = null;
    private boolean init = false;
    
    /** Creates new form EJBQLConnectionEditor */
    public JREmptyDataSourceConnectionEditor() {
        initComponents();
        //applyI18n();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanelEmptyDataSource = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jSpinnerNumRecords = new javax.swing.JSpinner();

        setLayout(new java.awt.BorderLayout());

        jPanelEmptyDataSource.setLayout(new java.awt.GridBagLayout());

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText(I18n.getString("JREmptyDataSourceConnectionEditor.Label.NumEmptyRec")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(16, 20, 0, 4);
        jPanelEmptyDataSource.add(jLabel24, gridBagConstraints);

        jSpinnerNumRecords.setPreferredSize(new java.awt.Dimension(70, 18));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 0, 20);
        jPanelEmptyDataSource.add(jSpinnerNumRecords, gridBagConstraints);

        add(jPanelEmptyDataSource, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanelEmptyDataSource;
    private javax.swing.JSpinner jSpinnerNumRecords;
    // End of variables declaration//GEN-END:variables
    
    
    public void setIReportConnection(IReportConnection c) {
        
        this.iReportConnection = c;
        if (iReportConnection instanceof JREmptyDatasourceConnection)
        {
            JREmptyDatasourceConnection con = (JREmptyDatasourceConnection)iReportConnection;
            jSpinnerNumRecords.getModel().setValue(new Integer(con.getRecords()));
        }
    }

    public IReportConnection getIReportConnection() {
        
        IReportConnection irConn = new JREmptyDatasourceConnection();

        ((JREmptyDatasourceConnection)irConn).setRecords( ((javax.swing.SpinnerNumberModel)jSpinnerNumRecords.getModel()).getNumber().intValue() );
        iReportConnection = irConn;
        return iReportConnection;
    }
    
    /*
    public void applyI18n(){
                // Start autogenerated code ----------------------
                jLabel24.setText(I18n.getString("connectionDialog.label24","Number of empty records"));
    }
    */
    
    
}