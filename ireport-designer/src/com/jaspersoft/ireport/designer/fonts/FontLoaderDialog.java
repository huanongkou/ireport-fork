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
package com.jaspersoft.ireport.designer.fonts;

import com.jaspersoft.ireport.locale.I18n;
import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;

/**
 *
 * @author  gtoffoli
 */
public class FontLoaderDialog extends javax.swing.JDialog implements TTFFontsLoaderMonitor {
    
    /** Creates new form FontLoaderDialog */
    public FontLoaderDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //applyI18n();
        this.pack();
        
        setLocationRelativeTo(null);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabelStatus.setText(I18n.getString("FontLoaderDialog.Label.LoadingStatus")); // NOI18N
        jLabelStatus.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelStatus.setPreferredSize(new java.awt.Dimension(391, 51));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(jLabelStatus, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void setStatus(String s)
    {
        jLabelStatus.setText(s);
    }
    
    public void fontsLoadingStatusUpdated(String statusMsg) {
        
        final String s = statusMsg;
        try {
            SwingUtilities.invokeAndWait( new Runnable()
            {
                public void run()
                {
                    setStatus(s);
                }
            }
            );
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
        
    }

    public void fontsLoadingStarted() {
        
        try {
            SwingUtilities.invokeAndWait( new Runnable()
            {
                public void run()
                {
                    setVisible(true);
                }
            }
            );
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }

    public void fontsLoadingFinished() {
        try {
            SwingUtilities.invokeAndWait( new Runnable()
            {
                public void run()
                {
                    setVisible(false);
                }
            }
            );
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelStatus;
    // End of variables declaration//GEN-END:variables
    
//    public void applyI18n(){
//                // Start autogenerated code ----------------------
//                jLabelStatus.setText(I18n.getString("fontLoaderDialog.labelStatus","Loading status"));
//                // End autogenerated code ----------------------
//    }
}