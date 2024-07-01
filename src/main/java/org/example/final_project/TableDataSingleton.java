package org.example.final_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TableDataSingleton {
    private static TableDataSingleton instance;
    private ObservableList<Table> tableData;
    private ObservableList<Table> transactionData;

    private TableDataSingleton() {
        tableData = FXCollections.observableArrayList();
        transactionData = FXCollections.observableArrayList();
    }

    public static synchronized TableDataSingleton getInstance() {
        if (instance == null) {
            instance = new TableDataSingleton();
        }
        return instance;
    }

    public ObservableList<Table> getTableData() {
        return tableData;
    }

    public ObservableList<Table> getTransactionData() {
        return transactionData;
    }
}