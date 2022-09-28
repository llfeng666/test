package com.liquido.entity;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Builder;


@Builder
public class WorkItem {
    private String workItemId;

    public void setLastRunTime(Timestamp lastRunTime) {
        this.lastRunTime = lastRunTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    private String workType;
    private String workGroupId;
    private int numRetries;
    private String status;
    private String lastFailureReason;
    private Timestamp lastRunTime;
    private int version;
    private Timestamp createTime;
    private Timestamp updateTime;

    public String getWorkItemId() {
        return workItemId;
    }

    public void setWorkItemId(String workItemId) {
        this.workItemId = workItemId;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getWorkGroupId() {
        return workGroupId;
    }

    public void setWorkGroupId(String workGroupId) {
        this.workGroupId = workGroupId;
    }

    public int getNumRetries() {
        return numRetries;
    }

    public void setNumRetries(int numRetries) {
        this.numRetries = numRetries;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastFailureReason() {
        return lastFailureReason;
    }

    public void setLastFailureReason(String lastFailureReason) {
        this.lastFailureReason = lastFailureReason;
    }

    public Date getLastRunTime() {
        return lastRunTime;
    }



    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }


}
