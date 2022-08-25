package com.example.enums;

public enum TableNames {
    DUKPAY("dukpay","pay_in_dukpay"),
    CHENG_FAN("cheng_fan","pay_in_cheng_fan"),
    WAN_BO("wan_bo","pay_in_wan_bo");

    TableNames(final String coName, final String tableName) {
        this.coName = coName;
        this.tableName = tableName;
    }

    public String getCoName() {
        return coName;
    }

    public void setCoName(String coName) {
        this.coName = coName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    private String coName;

    private String tableName;

    public static String findTableName(String coName){
        for (TableNames value : TableNames.values()) {
            if (coName.equals(value.coName)) {
                return value.tableName;
            }
        }
        return null;
    }





}
