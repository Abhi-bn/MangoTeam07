/*
    Mango - Open Source M2M - http://mango.serotoninsoftware.com
    Copyright (C) 2006-2011 Serotonin Software Technologies Inc.
    @author Matthew Lohbihler
    
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.serotonin.mango.web.dwr.beans;

import com.serotonin.mango.web.taglib.Functions;
import com.serotonin.mango.DataTypes;
import com.serotonin.mango.rt.dataImage.PointValueTime;
import com.serotonin.mango.vo.DataPointVO;

/**
 * @author Matthew Lohbihler
 */
public class RenderedPointValueTime {
    private String value;
    private String time;
    private String annotation;

    public RenderedPointValueTime(DataPointVO pointVO, PointValueTime pointValue) {
        if (pointValue != null) {
            if (DataTypes.getDataType(pointValue.getValue()) == DataTypes.NUMERIC) {
                String str = String.format("%1.2f", pointValue.getValue().getDoubleValue());
                pointValue = new PointValueTime(Double.valueOf(str), pointValue.getTime());
            }
        }
        this.value = Functions.getHtmlText(pointVO, pointValue);
        this.time = Functions.getTime(pointValue);
    }

    public RenderedPointValueTime(String value, String time, String annotation) {
        this.value = value;
        this.time = time;
        this.annotation = annotation;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }
}
