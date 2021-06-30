package com.zhangxx.java8.svn;

import javax.swing.table.DefaultTableModel;

public class MyDefaultTableModel extends DefaultTableModel {

    public MyDefaultTableModel(String[] columns, int i) {
        super(columns, i);
    }


    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}

