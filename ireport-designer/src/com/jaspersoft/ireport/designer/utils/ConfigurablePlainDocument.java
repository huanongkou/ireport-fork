

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
package com.jaspersoft.ireport.designer.utils;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;




/**
 *
 * @author gtoffoli
 */


public class ConfigurablePlainDocument extends PlainDocument {
        
    //Store maximum characters permitted
        private int maxChars;

    @Override
    public void insertString(int offs, String string, javax.swing.text.AttributeSet as) throws BadLocationException {
        if(string != null && (getLength() + string.length() < getMaxChars())){
                super.insertString(offs, string, as);
        }
    }

    public ConfigurablePlainDocument(int maxChars)
    {
        super();
        this.maxChars = maxChars;
    }
    
    /**
     * @return the maxChars
     */
    public int getMaxChars() {
        return maxChars;
    }

    /**
     * @param maxChars the maxChars to set
     */
    public void setMaxChars(int maxChars) {
        this.maxChars = maxChars;
    }
}
