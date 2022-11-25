package com.liquido.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubAccountsNanopayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubAccountsNanopayExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("parent_id like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("parent_id not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andFriendlyNameIsNull() {
            addCriterion("friendly_name is null");
            return (Criteria) this;
        }

        public Criteria andFriendlyNameIsNotNull() {
            addCriterion("friendly_name is not null");
            return (Criteria) this;
        }

        public Criteria andFriendlyNameEqualTo(String value) {
            addCriterion("friendly_name =", value, "friendlyName");
            return (Criteria) this;
        }

        public Criteria andFriendlyNameNotEqualTo(String value) {
            addCriterion("friendly_name <>", value, "friendlyName");
            return (Criteria) this;
        }

        public Criteria andFriendlyNameGreaterThan(String value) {
            addCriterion("friendly_name >", value, "friendlyName");
            return (Criteria) this;
        }

        public Criteria andFriendlyNameGreaterThanOrEqualTo(String value) {
            addCriterion("friendly_name >=", value, "friendlyName");
            return (Criteria) this;
        }

        public Criteria andFriendlyNameLessThan(String value) {
            addCriterion("friendly_name <", value, "friendlyName");
            return (Criteria) this;
        }

        public Criteria andFriendlyNameLessThanOrEqualTo(String value) {
            addCriterion("friendly_name <=", value, "friendlyName");
            return (Criteria) this;
        }

        public Criteria andFriendlyNameLike(String value) {
            addCriterion("friendly_name like", value, "friendlyName");
            return (Criteria) this;
        }

        public Criteria andFriendlyNameNotLike(String value) {
            addCriterion("friendly_name not like", value, "friendlyName");
            return (Criteria) this;
        }

        public Criteria andFriendlyNameIn(List<String> values) {
            addCriterion("friendly_name in", values, "friendlyName");
            return (Criteria) this;
        }

        public Criteria andFriendlyNameNotIn(List<String> values) {
            addCriterion("friendly_name not in", values, "friendlyName");
            return (Criteria) this;
        }

        public Criteria andFriendlyNameBetween(String value1, String value2) {
            addCriterion("friendly_name between", value1, value2, "friendlyName");
            return (Criteria) this;
        }

        public Criteria andFriendlyNameNotBetween(String value1, String value2) {
            addCriterion("friendly_name not between", value1, value2, "friendlyName");
            return (Criteria) this;
        }

        public Criteria andLegalNameIsNull() {
            addCriterion("legal_name is null");
            return (Criteria) this;
        }

        public Criteria andLegalNameIsNotNull() {
            addCriterion("legal_name is not null");
            return (Criteria) this;
        }

        public Criteria andLegalNameEqualTo(String value) {
            addCriterion("legal_name =", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotEqualTo(String value) {
            addCriterion("legal_name <>", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameGreaterThan(String value) {
            addCriterion("legal_name >", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameGreaterThanOrEqualTo(String value) {
            addCriterion("legal_name >=", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLessThan(String value) {
            addCriterion("legal_name <", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLessThanOrEqualTo(String value) {
            addCriterion("legal_name <=", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLike(String value) {
            addCriterion("legal_name like", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotLike(String value) {
            addCriterion("legal_name not like", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameIn(List<String> values) {
            addCriterion("legal_name in", values, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotIn(List<String> values) {
            addCriterion("legal_name not in", values, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameBetween(String value1, String value2) {
            addCriterion("legal_name between", value1, value2, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotBetween(String value1, String value2) {
            addCriterion("legal_name not between", value1, value2, "legalName");
            return (Criteria) this;
        }

        public Criteria andExternalBankAccountIsNull() {
            addCriterion("external_bank_account is null");
            return (Criteria) this;
        }

        public Criteria andExternalBankAccountIsNotNull() {
            addCriterion("external_bank_account is not null");
            return (Criteria) this;
        }

        public Criteria andExternalBankAccountEqualTo(String value) {
            addCriterion("external_bank_account =", value, "externalBankAccount");
            return (Criteria) this;
        }

        public Criteria andExternalBankAccountNotEqualTo(String value) {
            addCriterion("external_bank_account <>", value, "externalBankAccount");
            return (Criteria) this;
        }

        public Criteria andExternalBankAccountGreaterThan(String value) {
            addCriterion("external_bank_account >", value, "externalBankAccount");
            return (Criteria) this;
        }

        public Criteria andExternalBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("external_bank_account >=", value, "externalBankAccount");
            return (Criteria) this;
        }

        public Criteria andExternalBankAccountLessThan(String value) {
            addCriterion("external_bank_account <", value, "externalBankAccount");
            return (Criteria) this;
        }

        public Criteria andExternalBankAccountLessThanOrEqualTo(String value) {
            addCriterion("external_bank_account <=", value, "externalBankAccount");
            return (Criteria) this;
        }

        public Criteria andExternalBankAccountLike(String value) {
            addCriterion("external_bank_account like", value, "externalBankAccount");
            return (Criteria) this;
        }

        public Criteria andExternalBankAccountNotLike(String value) {
            addCriterion("external_bank_account not like", value, "externalBankAccount");
            return (Criteria) this;
        }

        public Criteria andExternalBankAccountIn(List<String> values) {
            addCriterion("external_bank_account in", values, "externalBankAccount");
            return (Criteria) this;
        }

        public Criteria andExternalBankAccountNotIn(List<String> values) {
            addCriterion("external_bank_account not in", values, "externalBankAccount");
            return (Criteria) this;
        }

        public Criteria andExternalBankAccountBetween(String value1, String value2) {
            addCriterion("external_bank_account between", value1, value2, "externalBankAccount");
            return (Criteria) this;
        }

        public Criteria andExternalBankAccountNotBetween(String value1, String value2) {
            addCriterion("external_bank_account not between", value1, value2, "externalBankAccount");
            return (Criteria) this;
        }

        public Criteria andSubAccountUuidIsNull() {
            addCriterion("sub_account_uuid is null");
            return (Criteria) this;
        }

        public Criteria andSubAccountUuidIsNotNull() {
            addCriterion("sub_account_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andSubAccountUuidEqualTo(String value) {
            addCriterion("sub_account_uuid =", value, "subAccountUuid");
            return (Criteria) this;
        }

        public Criteria andSubAccountUuidNotEqualTo(String value) {
            addCriterion("sub_account_uuid <>", value, "subAccountUuid");
            return (Criteria) this;
        }

        public Criteria andSubAccountUuidGreaterThan(String value) {
            addCriterion("sub_account_uuid >", value, "subAccountUuid");
            return (Criteria) this;
        }

        public Criteria andSubAccountUuidGreaterThanOrEqualTo(String value) {
            addCriterion("sub_account_uuid >=", value, "subAccountUuid");
            return (Criteria) this;
        }

        public Criteria andSubAccountUuidLessThan(String value) {
            addCriterion("sub_account_uuid <", value, "subAccountUuid");
            return (Criteria) this;
        }

        public Criteria andSubAccountUuidLessThanOrEqualTo(String value) {
            addCriterion("sub_account_uuid <=", value, "subAccountUuid");
            return (Criteria) this;
        }

        public Criteria andSubAccountUuidLike(String value) {
            addCriterion("sub_account_uuid like", value, "subAccountUuid");
            return (Criteria) this;
        }

        public Criteria andSubAccountUuidNotLike(String value) {
            addCriterion("sub_account_uuid not like", value, "subAccountUuid");
            return (Criteria) this;
        }

        public Criteria andSubAccountUuidIn(List<String> values) {
            addCriterion("sub_account_uuid in", values, "subAccountUuid");
            return (Criteria) this;
        }

        public Criteria andSubAccountUuidNotIn(List<String> values) {
            addCriterion("sub_account_uuid not in", values, "subAccountUuid");
            return (Criteria) this;
        }

        public Criteria andSubAccountUuidBetween(String value1, String value2) {
            addCriterion("sub_account_uuid between", value1, value2, "subAccountUuid");
            return (Criteria) this;
        }

        public Criteria andSubAccountUuidNotBetween(String value1, String value2) {
            addCriterion("sub_account_uuid not between", value1, value2, "subAccountUuid");
            return (Criteria) this;
        }

        public Criteria andExtraDataIsNull() {
            addCriterion("extra_data is null");
            return (Criteria) this;
        }

        public Criteria andExtraDataIsNotNull() {
            addCriterion("extra_data is not null");
            return (Criteria) this;
        }

        public Criteria andExtraDataEqualTo(String value) {
            addCriterion("extra_data =", value, "extraData");
            return (Criteria) this;
        }

        public Criteria andExtraDataNotEqualTo(String value) {
            addCriterion("extra_data <>", value, "extraData");
            return (Criteria) this;
        }

        public Criteria andExtraDataGreaterThan(String value) {
            addCriterion("extra_data >", value, "extraData");
            return (Criteria) this;
        }

        public Criteria andExtraDataGreaterThanOrEqualTo(String value) {
            addCriterion("extra_data >=", value, "extraData");
            return (Criteria) this;
        }

        public Criteria andExtraDataLessThan(String value) {
            addCriterion("extra_data <", value, "extraData");
            return (Criteria) this;
        }

        public Criteria andExtraDataLessThanOrEqualTo(String value) {
            addCriterion("extra_data <=", value, "extraData");
            return (Criteria) this;
        }

        public Criteria andExtraDataLike(String value) {
            addCriterion("extra_data like", value, "extraData");
            return (Criteria) this;
        }

        public Criteria andExtraDataNotLike(String value) {
            addCriterion("extra_data not like", value, "extraData");
            return (Criteria) this;
        }

        public Criteria andExtraDataIn(List<String> values) {
            addCriterion("extra_data in", values, "extraData");
            return (Criteria) this;
        }

        public Criteria andExtraDataNotIn(List<String> values) {
            addCriterion("extra_data not in", values, "extraData");
            return (Criteria) this;
        }

        public Criteria andExtraDataBetween(String value1, String value2) {
            addCriterion("extra_data between", value1, value2, "extraData");
            return (Criteria) this;
        }

        public Criteria andExtraDataNotBetween(String value1, String value2) {
            addCriterion("extra_data not between", value1, value2, "extraData");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(String value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(String value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(String value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(String value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(String value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLike(String value) {
            addCriterion("account_id like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotLike(String value) {
            addCriterion("account_id not like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<String> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<String> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(String value1, String value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(String value1, String value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andIdempotencyKeyIsNull() {
            addCriterion("idempotency_key is null");
            return (Criteria) this;
        }

        public Criteria andIdempotencyKeyIsNotNull() {
            addCriterion("idempotency_key is not null");
            return (Criteria) this;
        }

        public Criteria andIdempotencyKeyEqualTo(String value) {
            addCriterion("idempotency_key =", value, "idempotencyKey");
            return (Criteria) this;
        }

        public Criteria andIdempotencyKeyNotEqualTo(String value) {
            addCriterion("idempotency_key <>", value, "idempotencyKey");
            return (Criteria) this;
        }

        public Criteria andIdempotencyKeyGreaterThan(String value) {
            addCriterion("idempotency_key >", value, "idempotencyKey");
            return (Criteria) this;
        }

        public Criteria andIdempotencyKeyGreaterThanOrEqualTo(String value) {
            addCriterion("idempotency_key >=", value, "idempotencyKey");
            return (Criteria) this;
        }

        public Criteria andIdempotencyKeyLessThan(String value) {
            addCriterion("idempotency_key <", value, "idempotencyKey");
            return (Criteria) this;
        }

        public Criteria andIdempotencyKeyLessThanOrEqualTo(String value) {
            addCriterion("idempotency_key <=", value, "idempotencyKey");
            return (Criteria) this;
        }

        public Criteria andIdempotencyKeyLike(String value) {
            addCriterion("idempotency_key like", value, "idempotencyKey");
            return (Criteria) this;
        }

        public Criteria andIdempotencyKeyNotLike(String value) {
            addCriterion("idempotency_key not like", value, "idempotencyKey");
            return (Criteria) this;
        }

        public Criteria andIdempotencyKeyIn(List<String> values) {
            addCriterion("idempotency_key in", values, "idempotencyKey");
            return (Criteria) this;
        }

        public Criteria andIdempotencyKeyNotIn(List<String> values) {
            addCriterion("idempotency_key not in", values, "idempotencyKey");
            return (Criteria) this;
        }

        public Criteria andIdempotencyKeyBetween(String value1, String value2) {
            addCriterion("idempotency_key between", value1, value2, "idempotencyKey");
            return (Criteria) this;
        }

        public Criteria andIdempotencyKeyNotBetween(String value1, String value2) {
            addCriterion("idempotency_key not between", value1, value2, "idempotencyKey");
            return (Criteria) this;
        }

        public Criteria andMdnIsNull() {
            addCriterion("mdn is null");
            return (Criteria) this;
        }

        public Criteria andMdnIsNotNull() {
            addCriterion("mdn is not null");
            return (Criteria) this;
        }

        public Criteria andMdnEqualTo(String value) {
            addCriterion("mdn =", value, "mdn");
            return (Criteria) this;
        }

        public Criteria andMdnNotEqualTo(String value) {
            addCriterion("mdn <>", value, "mdn");
            return (Criteria) this;
        }

        public Criteria andMdnGreaterThan(String value) {
            addCriterion("mdn >", value, "mdn");
            return (Criteria) this;
        }

        public Criteria andMdnGreaterThanOrEqualTo(String value) {
            addCriterion("mdn >=", value, "mdn");
            return (Criteria) this;
        }

        public Criteria andMdnLessThan(String value) {
            addCriterion("mdn <", value, "mdn");
            return (Criteria) this;
        }

        public Criteria andMdnLessThanOrEqualTo(String value) {
            addCriterion("mdn <=", value, "mdn");
            return (Criteria) this;
        }

        public Criteria andMdnLike(String value) {
            addCriterion("mdn like", value, "mdn");
            return (Criteria) this;
        }

        public Criteria andMdnNotLike(String value) {
            addCriterion("mdn not like", value, "mdn");
            return (Criteria) this;
        }

        public Criteria andMdnIn(List<String> values) {
            addCriterion("mdn in", values, "mdn");
            return (Criteria) this;
        }

        public Criteria andMdnNotIn(List<String> values) {
            addCriterion("mdn not in", values, "mdn");
            return (Criteria) this;
        }

        public Criteria andMdnBetween(String value1, String value2) {
            addCriterion("mdn between", value1, value2, "mdn");
            return (Criteria) this;
        }

        public Criteria andMdnNotBetween(String value1, String value2) {
            addCriterion("mdn not between", value1, value2, "mdn");
            return (Criteria) this;
        }

        public Criteria andIsPrefabIsNull() {
            addCriterion("is_prefab is null");
            return (Criteria) this;
        }

        public Criteria andIsPrefabIsNotNull() {
            addCriterion("is_prefab is not null");
            return (Criteria) this;
        }

        public Criteria andIsPrefabEqualTo(Boolean value) {
            addCriterion("is_prefab =", value, "isPrefab");
            return (Criteria) this;
        }

        public Criteria andIsPrefabNotEqualTo(Boolean value) {
            addCriterion("is_prefab <>", value, "isPrefab");
            return (Criteria) this;
        }

        public Criteria andIsPrefabGreaterThan(Boolean value) {
            addCriterion("is_prefab >", value, "isPrefab");
            return (Criteria) this;
        }

        public Criteria andIsPrefabGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_prefab >=", value, "isPrefab");
            return (Criteria) this;
        }

        public Criteria andIsPrefabLessThan(Boolean value) {
            addCriterion("is_prefab <", value, "isPrefab");
            return (Criteria) this;
        }

        public Criteria andIsPrefabLessThanOrEqualTo(Boolean value) {
            addCriterion("is_prefab <=", value, "isPrefab");
            return (Criteria) this;
        }

        public Criteria andIsPrefabIn(List<Boolean> values) {
            addCriterion("is_prefab in", values, "isPrefab");
            return (Criteria) this;
        }

        public Criteria andIsPrefabNotIn(List<Boolean> values) {
            addCriterion("is_prefab not in", values, "isPrefab");
            return (Criteria) this;
        }

        public Criteria andIsPrefabBetween(Boolean value1, Boolean value2) {
            addCriterion("is_prefab between", value1, value2, "isPrefab");
            return (Criteria) this;
        }

        public Criteria andIsPrefabNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_prefab not between", value1, value2, "isPrefab");
            return (Criteria) this;
        }

        public Criteria andParentClabeIdIsNull() {
            addCriterion("parent_clabe_id is null");
            return (Criteria) this;
        }

        public Criteria andParentClabeIdIsNotNull() {
            addCriterion("parent_clabe_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentClabeIdEqualTo(String value) {
            addCriterion("parent_clabe_id =", value, "parentClabeId");
            return (Criteria) this;
        }

        public Criteria andParentClabeIdNotEqualTo(String value) {
            addCriterion("parent_clabe_id <>", value, "parentClabeId");
            return (Criteria) this;
        }

        public Criteria andParentClabeIdGreaterThan(String value) {
            addCriterion("parent_clabe_id >", value, "parentClabeId");
            return (Criteria) this;
        }

        public Criteria andParentClabeIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_clabe_id >=", value, "parentClabeId");
            return (Criteria) this;
        }

        public Criteria andParentClabeIdLessThan(String value) {
            addCriterion("parent_clabe_id <", value, "parentClabeId");
            return (Criteria) this;
        }

        public Criteria andParentClabeIdLessThanOrEqualTo(String value) {
            addCriterion("parent_clabe_id <=", value, "parentClabeId");
            return (Criteria) this;
        }

        public Criteria andParentClabeIdLike(String value) {
            addCriterion("parent_clabe_id like", value, "parentClabeId");
            return (Criteria) this;
        }

        public Criteria andParentClabeIdNotLike(String value) {
            addCriterion("parent_clabe_id not like", value, "parentClabeId");
            return (Criteria) this;
        }

        public Criteria andParentClabeIdIn(List<String> values) {
            addCriterion("parent_clabe_id in", values, "parentClabeId");
            return (Criteria) this;
        }

        public Criteria andParentClabeIdNotIn(List<String> values) {
            addCriterion("parent_clabe_id not in", values, "parentClabeId");
            return (Criteria) this;
        }

        public Criteria andParentClabeIdBetween(String value1, String value2) {
            addCriterion("parent_clabe_id between", value1, value2, "parentClabeId");
            return (Criteria) this;
        }

        public Criteria andParentClabeIdNotBetween(String value1, String value2) {
            addCriterion("parent_clabe_id not between", value1, value2, "parentClabeId");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNull() {
            addCriterion("phone_number is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNotNull() {
            addCriterion("phone_number is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberEqualTo(String value) {
            addCriterion("phone_number =", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotEqualTo(String value) {
            addCriterion("phone_number <>", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThan(String value) {
            addCriterion("phone_number >", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("phone_number >=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThan(String value) {
            addCriterion("phone_number <", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThanOrEqualTo(String value) {
            addCriterion("phone_number <=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLike(String value) {
            addCriterion("phone_number like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotLike(String value) {
            addCriterion("phone_number not like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIn(List<String> values) {
            addCriterion("phone_number in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotIn(List<String> values) {
            addCriterion("phone_number not in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberBetween(String value1, String value2) {
            addCriterion("phone_number between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotBetween(String value1, String value2) {
            addCriterion("phone_number not between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andIsOpenIsNull() {
            addCriterion("is_open is null");
            return (Criteria) this;
        }

        public Criteria andIsOpenIsNotNull() {
            addCriterion("is_open is not null");
            return (Criteria) this;
        }

        public Criteria andIsOpenEqualTo(String value) {
            addCriterion("is_open =", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotEqualTo(String value) {
            addCriterion("is_open <>", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenGreaterThan(String value) {
            addCriterion("is_open >", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenGreaterThanOrEqualTo(String value) {
            addCriterion("is_open >=", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenLessThan(String value) {
            addCriterion("is_open <", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenLessThanOrEqualTo(String value) {
            addCriterion("is_open <=", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenLike(String value) {
            addCriterion("is_open like", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotLike(String value) {
            addCriterion("is_open not like", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenIn(List<String> values) {
            addCriterion("is_open in", values, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotIn(List<String> values) {
            addCriterion("is_open not in", values, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenBetween(String value1, String value2) {
            addCriterion("is_open between", value1, value2, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotBetween(String value1, String value2) {
            addCriterion("is_open not between", value1, value2, "isOpen");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}