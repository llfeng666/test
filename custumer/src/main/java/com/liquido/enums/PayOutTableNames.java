package com.liquido.enums;

public enum PayOutTableNames {
    DUKPAY("dukpay","payout_dukpay"),
    CHENG_FAN("cheng_fan","payout_cheng_fan"),
    WAN_BO("wan_bo","payout_wan_bo");

    PayOutTableNames(final String coName, final String tableName) {
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
        for (PayOutTableNames value : PayOutTableNames.values()) {
            if (coName.equals(value.coName)) {
                return value.tableName;
            }
        }
        return null;
    }





}
