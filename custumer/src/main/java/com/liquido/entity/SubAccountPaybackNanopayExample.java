package com.liquido.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SubAccountPaybackNanopayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubAccountPaybackNanopayExample() {
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

        public Criteria andParentAccountUuidIsNull() {
            addCriterion("parent_account_uuid is null");
            return (Criteria) this;
        }

        public Criteria andParentAccountUuidIsNotNull() {
            addCriterion("parent_account_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andParentAccountUuidEqualTo(String value) {
            addCriterion("parent_account_uuid =", value, "parentAccountUuid");
            return (Criteria) this;
        }

        public Criteria andParentAccountUuidNotEqualTo(String value) {
            addCriterion("parent_account_uuid <>", value, "parentAccountUuid");
            return (Criteria) this;
        }

        public Criteria andParentAccountUuidGreaterThan(String value) {
            addCriterion("parent_account_uuid >", value, "parentAccountUuid");
            return (Criteria) this;
        }

        public Criteria andParentAccountUuidGreaterThanOrEqualTo(String value) {
            addCriterion("parent_account_uuid >=", value, "parentAccountUuid");
            return (Criteria) this;
        }

        public Criteria andParentAccountUuidLessThan(String value) {
            addCriterion("parent_account_uuid <", value, "parentAccountUuid");
            return (Criteria) this;
        }

        public Criteria andParentAccountUuidLessThanOrEqualTo(String value) {
            addCriterion("parent_account_uuid <=", value, "parentAccountUuid");
            return (Criteria) this;
        }

        public Criteria andParentAccountUuidLike(String value) {
            addCriterion("parent_account_uuid like", value, "parentAccountUuid");
            return (Criteria) this;
        }

        public Criteria andParentAccountUuidNotLike(String value) {
            addCriterion("parent_account_uuid not like", value, "parentAccountUuid");
            return (Criteria) this;
        }

        public Criteria andParentAccountUuidIn(List<String> values) {
            addCriterion("parent_account_uuid in", values, "parentAccountUuid");
            return (Criteria) this;
        }

        public Criteria andParentAccountUuidNotIn(List<String> values) {
            addCriterion("parent_account_uuid not in", values, "parentAccountUuid");
            return (Criteria) this;
        }

        public Criteria andParentAccountUuidBetween(String value1, String value2) {
            addCriterion("parent_account_uuid between", value1, value2, "parentAccountUuid");
            return (Criteria) this;
        }

        public Criteria andParentAccountUuidNotBetween(String value1, String value2) {
            addCriterion("parent_account_uuid not between", value1, value2, "parentAccountUuid");
            return (Criteria) this;
        }

        public Criteria andParentAccountIdIsNull() {
            addCriterion("parent_account_id is null");
            return (Criteria) this;
        }

        public Criteria andParentAccountIdIsNotNull() {
            addCriterion("parent_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentAccountIdEqualTo(String value) {
            addCriterion("parent_account_id =", value, "parentAccountId");
            return (Criteria) this;
        }

        public Criteria andParentAccountIdNotEqualTo(String value) {
            addCriterion("parent_account_id <>", value, "parentAccountId");
            return (Criteria) this;
        }

        public Criteria andParentAccountIdGreaterThan(String value) {
            addCriterion("parent_account_id >", value, "parentAccountId");
            return (Criteria) this;
        }

        public Criteria andParentAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_account_id >=", value, "parentAccountId");
            return (Criteria) this;
        }

        public Criteria andParentAccountIdLessThan(String value) {
            addCriterion("parent_account_id <", value, "parentAccountId");
            return (Criteria) this;
        }

        public Criteria andParentAccountIdLessThanOrEqualTo(String value) {
            addCriterion("parent_account_id <=", value, "parentAccountId");
            return (Criteria) this;
        }

        public Criteria andParentAccountIdLike(String value) {
            addCriterion("parent_account_id like", value, "parentAccountId");
            return (Criteria) this;
        }

        public Criteria andParentAccountIdNotLike(String value) {
            addCriterion("parent_account_id not like", value, "parentAccountId");
            return (Criteria) this;
        }

        public Criteria andParentAccountIdIn(List<String> values) {
            addCriterion("parent_account_id in", values, "parentAccountId");
            return (Criteria) this;
        }

        public Criteria andParentAccountIdNotIn(List<String> values) {
            addCriterion("parent_account_id not in", values, "parentAccountId");
            return (Criteria) this;
        }

        public Criteria andParentAccountIdBetween(String value1, String value2) {
            addCriterion("parent_account_id between", value1, value2, "parentAccountId");
            return (Criteria) this;
        }

        public Criteria andParentAccountIdNotBetween(String value1, String value2) {
            addCriterion("parent_account_id not between", value1, value2, "parentAccountId");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdIsNull() {
            addCriterion("sub_account_id is null");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdIsNotNull() {
            addCriterion("sub_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdEqualTo(String value) {
            addCriterion("sub_account_id =", value, "subAccountId");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdNotEqualTo(String value) {
            addCriterion("sub_account_id <>", value, "subAccountId");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdGreaterThan(String value) {
            addCriterion("sub_account_id >", value, "subAccountId");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("sub_account_id >=", value, "subAccountId");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdLessThan(String value) {
            addCriterion("sub_account_id <", value, "subAccountId");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdLessThanOrEqualTo(String value) {
            addCriterion("sub_account_id <=", value, "subAccountId");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdLike(String value) {
            addCriterion("sub_account_id like", value, "subAccountId");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdNotLike(String value) {
            addCriterion("sub_account_id not like", value, "subAccountId");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdIn(List<String> values) {
            addCriterion("sub_account_id in", values, "subAccountId");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdNotIn(List<String> values) {
            addCriterion("sub_account_id not in", values, "subAccountId");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdBetween(String value1, String value2) {
            addCriterion("sub_account_id between", value1, value2, "subAccountId");
            return (Criteria) this;
        }

        public Criteria andSubAccountIdNotBetween(String value1, String value2) {
            addCriterion("sub_account_id not between", value1, value2, "subAccountId");
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

        public Criteria andRequestIdIsNull() {
            addCriterion("request_id is null");
            return (Criteria) this;
        }

        public Criteria andRequestIdIsNotNull() {
            addCriterion("request_id is not null");
            return (Criteria) this;
        }

        public Criteria andRequestIdEqualTo(String value) {
            addCriterion("request_id =", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotEqualTo(String value) {
            addCriterion("request_id <>", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdGreaterThan(String value) {
            addCriterion("request_id >", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdGreaterThanOrEqualTo(String value) {
            addCriterion("request_id >=", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdLessThan(String value) {
            addCriterion("request_id <", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdLessThanOrEqualTo(String value) {
            addCriterion("request_id <=", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdLike(String value) {
            addCriterion("request_id like", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotLike(String value) {
            addCriterion("request_id not like", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdIn(List<String> values) {
            addCriterion("request_id in", values, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotIn(List<String> values) {
            addCriterion("request_id not in", values, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdBetween(String value1, String value2) {
            addCriterion("request_id between", value1, value2, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotBetween(String value1, String value2) {
            addCriterion("request_id not between", value1, value2, "requestId");
            return (Criteria) this;
        }

        public Criteria andExternalIdIsNull() {
            addCriterion("external_id is null");
            return (Criteria) this;
        }

        public Criteria andExternalIdIsNotNull() {
            addCriterion("external_id is not null");
            return (Criteria) this;
        }

        public Criteria andExternalIdEqualTo(String value) {
            addCriterion("external_id =", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdNotEqualTo(String value) {
            addCriterion("external_id <>", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdGreaterThan(String value) {
            addCriterion("external_id >", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdGreaterThanOrEqualTo(String value) {
            addCriterion("external_id >=", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdLessThan(String value) {
            addCriterion("external_id <", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdLessThanOrEqualTo(String value) {
            addCriterion("external_id <=", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdLike(String value) {
            addCriterion("external_id like", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdNotLike(String value) {
            addCriterion("external_id not like", value, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdIn(List<String> values) {
            addCriterion("external_id in", values, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdNotIn(List<String> values) {
            addCriterion("external_id not in", values, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdBetween(String value1, String value2) {
            addCriterion("external_id between", value1, value2, "externalId");
            return (Criteria) this;
        }

        public Criteria andExternalIdNotBetween(String value1, String value2) {
            addCriterion("external_id not between", value1, value2, "externalId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIsNull() {
            addCriterion("transaction_id is null");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIsNotNull() {
            addCriterion("transaction_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionIdEqualTo(String value) {
            addCriterion("transaction_id =", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotEqualTo(String value) {
            addCriterion("transaction_id <>", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdGreaterThan(String value) {
            addCriterion("transaction_id >", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_id >=", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLessThan(String value) {
            addCriterion("transaction_id <", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLessThanOrEqualTo(String value) {
            addCriterion("transaction_id <=", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLike(String value) {
            addCriterion("transaction_id like", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotLike(String value) {
            addCriterion("transaction_id not like", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIn(List<String> values) {
            addCriterion("transaction_id in", values, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotIn(List<String> values) {
            addCriterion("transaction_id not in", values, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdBetween(String value1, String value2) {
            addCriterion("transaction_id between", value1, value2, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotBetween(String value1, String value2) {
            addCriterion("transaction_id not between", value1, value2, "transactionId");
            return (Criteria) this;
        }

        public Criteria andReferenceNumberIsNull() {
            addCriterion("reference_number is null");
            return (Criteria) this;
        }

        public Criteria andReferenceNumberIsNotNull() {
            addCriterion("reference_number is not null");
            return (Criteria) this;
        }

        public Criteria andReferenceNumberEqualTo(String value) {
            addCriterion("reference_number =", value, "referenceNumber");
            return (Criteria) this;
        }

        public Criteria andReferenceNumberNotEqualTo(String value) {
            addCriterion("reference_number <>", value, "referenceNumber");
            return (Criteria) this;
        }

        public Criteria andReferenceNumberGreaterThan(String value) {
            addCriterion("reference_number >", value, "referenceNumber");
            return (Criteria) this;
        }

        public Criteria andReferenceNumberGreaterThanOrEqualTo(String value) {
            addCriterion("reference_number >=", value, "referenceNumber");
            return (Criteria) this;
        }

        public Criteria andReferenceNumberLessThan(String value) {
            addCriterion("reference_number <", value, "referenceNumber");
            return (Criteria) this;
        }

        public Criteria andReferenceNumberLessThanOrEqualTo(String value) {
            addCriterion("reference_number <=", value, "referenceNumber");
            return (Criteria) this;
        }

        public Criteria andReferenceNumberLike(String value) {
            addCriterion("reference_number like", value, "referenceNumber");
            return (Criteria) this;
        }

        public Criteria andReferenceNumberNotLike(String value) {
            addCriterion("reference_number not like", value, "referenceNumber");
            return (Criteria) this;
        }

        public Criteria andReferenceNumberIn(List<String> values) {
            addCriterion("reference_number in", values, "referenceNumber");
            return (Criteria) this;
        }

        public Criteria andReferenceNumberNotIn(List<String> values) {
            addCriterion("reference_number not in", values, "referenceNumber");
            return (Criteria) this;
        }

        public Criteria andReferenceNumberBetween(String value1, String value2) {
            addCriterion("reference_number between", value1, value2, "referenceNumber");
            return (Criteria) this;
        }

        public Criteria andReferenceNumberNotBetween(String value1, String value2) {
            addCriterion("reference_number not between", value1, value2, "referenceNumber");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("`status` like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("`status` not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(String value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(String value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(String value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(String value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(String value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(String value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLike(String value) {
            addCriterion("amount like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotLike(String value) {
            addCriterion("amount not like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<String> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<String> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(String value1, String value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(String value1, String value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("currency is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("currency is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("currency =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("currency <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("currency >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("currency >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("currency <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("currency <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("currency like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("currency not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("currency in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("currency not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("currency between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("currency not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andSubmitUnixTimeIsNull() {
            addCriterion("submit_unix_time is null");
            return (Criteria) this;
        }

        public Criteria andSubmitUnixTimeIsNotNull() {
            addCriterion("submit_unix_time is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitUnixTimeEqualTo(Long value) {
            addCriterion("submit_unix_time =", value, "submitUnixTime");
            return (Criteria) this;
        }

        public Criteria andSubmitUnixTimeNotEqualTo(Long value) {
            addCriterion("submit_unix_time <>", value, "submitUnixTime");
            return (Criteria) this;
        }

        public Criteria andSubmitUnixTimeGreaterThan(Long value) {
            addCriterion("submit_unix_time >", value, "submitUnixTime");
            return (Criteria) this;
        }

        public Criteria andSubmitUnixTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("submit_unix_time >=", value, "submitUnixTime");
            return (Criteria) this;
        }

        public Criteria andSubmitUnixTimeLessThan(Long value) {
            addCriterion("submit_unix_time <", value, "submitUnixTime");
            return (Criteria) this;
        }

        public Criteria andSubmitUnixTimeLessThanOrEqualTo(Long value) {
            addCriterion("submit_unix_time <=", value, "submitUnixTime");
            return (Criteria) this;
        }

        public Criteria andSubmitUnixTimeIn(List<Long> values) {
            addCriterion("submit_unix_time in", values, "submitUnixTime");
            return (Criteria) this;
        }

        public Criteria andSubmitUnixTimeNotIn(List<Long> values) {
            addCriterion("submit_unix_time not in", values, "submitUnixTime");
            return (Criteria) this;
        }

        public Criteria andSubmitUnixTimeBetween(Long value1, Long value2) {
            addCriterion("submit_unix_time between", value1, value2, "submitUnixTime");
            return (Criteria) this;
        }

        public Criteria andSubmitUnixTimeNotBetween(Long value1, Long value2) {
            addCriterion("submit_unix_time not between", value1, value2, "submitUnixTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNull() {
            addCriterion("submit_time is null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNotNull() {
            addCriterion("submit_time is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeEqualTo(String value) {
            addCriterion("submit_time =", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotEqualTo(String value) {
            addCriterion("submit_time <>", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThan(String value) {
            addCriterion("submit_time >", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThanOrEqualTo(String value) {
            addCriterion("submit_time >=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThan(String value) {
            addCriterion("submit_time <", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThanOrEqualTo(String value) {
            addCriterion("submit_time <=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLike(String value) {
            addCriterion("submit_time like", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotLike(String value) {
            addCriterion("submit_time not like", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIn(List<String> values) {
            addCriterion("submit_time in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotIn(List<String> values) {
            addCriterion("submit_time not in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeBetween(String value1, String value2) {
            addCriterion("submit_time between", value1, value2, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotBetween(String value1, String value2) {
            addCriterion("submit_time not between", value1, value2, "submitTime");
            return (Criteria) this;
        }

        public Criteria andFinalStatusTimeIsNull() {
            addCriterion("final_status_time is null");
            return (Criteria) this;
        }

        public Criteria andFinalStatusTimeIsNotNull() {
            addCriterion("final_status_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinalStatusTimeEqualTo(String value) {
            addCriterion("final_status_time =", value, "finalStatusTime");
            return (Criteria) this;
        }

        public Criteria andFinalStatusTimeNotEqualTo(String value) {
            addCriterion("final_status_time <>", value, "finalStatusTime");
            return (Criteria) this;
        }

        public Criteria andFinalStatusTimeGreaterThan(String value) {
            addCriterion("final_status_time >", value, "finalStatusTime");
            return (Criteria) this;
        }

        public Criteria andFinalStatusTimeGreaterThanOrEqualTo(String value) {
            addCriterion("final_status_time >=", value, "finalStatusTime");
            return (Criteria) this;
        }

        public Criteria andFinalStatusTimeLessThan(String value) {
            addCriterion("final_status_time <", value, "finalStatusTime");
            return (Criteria) this;
        }

        public Criteria andFinalStatusTimeLessThanOrEqualTo(String value) {
            addCriterion("final_status_time <=", value, "finalStatusTime");
            return (Criteria) this;
        }

        public Criteria andFinalStatusTimeLike(String value) {
            addCriterion("final_status_time like", value, "finalStatusTime");
            return (Criteria) this;
        }

        public Criteria andFinalStatusTimeNotLike(String value) {
            addCriterion("final_status_time not like", value, "finalStatusTime");
            return (Criteria) this;
        }

        public Criteria andFinalStatusTimeIn(List<String> values) {
            addCriterion("final_status_time in", values, "finalStatusTime");
            return (Criteria) this;
        }

        public Criteria andFinalStatusTimeNotIn(List<String> values) {
            addCriterion("final_status_time not in", values, "finalStatusTime");
            return (Criteria) this;
        }

        public Criteria andFinalStatusTimeBetween(String value1, String value2) {
            addCriterion("final_status_time between", value1, value2, "finalStatusTime");
            return (Criteria) this;
        }

        public Criteria andFinalStatusTimeNotBetween(String value1, String value2) {
            addCriterion("final_status_time not between", value1, value2, "finalStatusTime");
            return (Criteria) this;
        }

        public Criteria andFinalStatusUnixTimeIsNull() {
            addCriterion("final_status_unix_time is null");
            return (Criteria) this;
        }

        public Criteria andFinalStatusUnixTimeIsNotNull() {
            addCriterion("final_status_unix_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinalStatusUnixTimeEqualTo(Long value) {
            addCriterion("final_status_unix_time =", value, "finalStatusUnixTime");
            return (Criteria) this;
        }

        public Criteria andFinalStatusUnixTimeNotEqualTo(Long value) {
            addCriterion("final_status_unix_time <>", value, "finalStatusUnixTime");
            return (Criteria) this;
        }

        public Criteria andFinalStatusUnixTimeGreaterThan(Long value) {
            addCriterion("final_status_unix_time >", value, "finalStatusUnixTime");
            return (Criteria) this;
        }

        public Criteria andFinalStatusUnixTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("final_status_unix_time >=", value, "finalStatusUnixTime");
            return (Criteria) this;
        }

        public Criteria andFinalStatusUnixTimeLessThan(Long value) {
            addCriterion("final_status_unix_time <", value, "finalStatusUnixTime");
            return (Criteria) this;
        }

        public Criteria andFinalStatusUnixTimeLessThanOrEqualTo(Long value) {
            addCriterion("final_status_unix_time <=", value, "finalStatusUnixTime");
            return (Criteria) this;
        }

        public Criteria andFinalStatusUnixTimeIn(List<Long> values) {
            addCriterion("final_status_unix_time in", values, "finalStatusUnixTime");
            return (Criteria) this;
        }

        public Criteria andFinalStatusUnixTimeNotIn(List<Long> values) {
            addCriterion("final_status_unix_time not in", values, "finalStatusUnixTime");
            return (Criteria) this;
        }

        public Criteria andFinalStatusUnixTimeBetween(Long value1, Long value2) {
            addCriterion("final_status_unix_time between", value1, value2, "finalStatusUnixTime");
            return (Criteria) this;
        }

        public Criteria andFinalStatusUnixTimeNotBetween(Long value1, Long value2) {
            addCriterion("final_status_unix_time not between", value1, value2, "finalStatusUnixTime");
            return (Criteria) this;
        }

        public Criteria andVendorErrorCodeIsNull() {
            addCriterion("vendor_error_code is null");
            return (Criteria) this;
        }

        public Criteria andVendorErrorCodeIsNotNull() {
            addCriterion("vendor_error_code is not null");
            return (Criteria) this;
        }

        public Criteria andVendorErrorCodeEqualTo(String value) {
            addCriterion("vendor_error_code =", value, "vendorErrorCode");
            return (Criteria) this;
        }

        public Criteria andVendorErrorCodeNotEqualTo(String value) {
            addCriterion("vendor_error_code <>", value, "vendorErrorCode");
            return (Criteria) this;
        }

        public Criteria andVendorErrorCodeGreaterThan(String value) {
            addCriterion("vendor_error_code >", value, "vendorErrorCode");
            return (Criteria) this;
        }

        public Criteria andVendorErrorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("vendor_error_code >=", value, "vendorErrorCode");
            return (Criteria) this;
        }

        public Criteria andVendorErrorCodeLessThan(String value) {
            addCriterion("vendor_error_code <", value, "vendorErrorCode");
            return (Criteria) this;
        }

        public Criteria andVendorErrorCodeLessThanOrEqualTo(String value) {
            addCriterion("vendor_error_code <=", value, "vendorErrorCode");
            return (Criteria) this;
        }

        public Criteria andVendorErrorCodeLike(String value) {
            addCriterion("vendor_error_code like", value, "vendorErrorCode");
            return (Criteria) this;
        }

        public Criteria andVendorErrorCodeNotLike(String value) {
            addCriterion("vendor_error_code not like", value, "vendorErrorCode");
            return (Criteria) this;
        }

        public Criteria andVendorErrorCodeIn(List<String> values) {
            addCriterion("vendor_error_code in", values, "vendorErrorCode");
            return (Criteria) this;
        }

        public Criteria andVendorErrorCodeNotIn(List<String> values) {
            addCriterion("vendor_error_code not in", values, "vendorErrorCode");
            return (Criteria) this;
        }

        public Criteria andVendorErrorCodeBetween(String value1, String value2) {
            addCriterion("vendor_error_code between", value1, value2, "vendorErrorCode");
            return (Criteria) this;
        }

        public Criteria andVendorErrorCodeNotBetween(String value1, String value2) {
            addCriterion("vendor_error_code not between", value1, value2, "vendorErrorCode");
            return (Criteria) this;
        }

        public Criteria andVendorErrorMessageIsNull() {
            addCriterion("vendor_error_message is null");
            return (Criteria) this;
        }

        public Criteria andVendorErrorMessageIsNotNull() {
            addCriterion("vendor_error_message is not null");
            return (Criteria) this;
        }

        public Criteria andVendorErrorMessageEqualTo(String value) {
            addCriterion("vendor_error_message =", value, "vendorErrorMessage");
            return (Criteria) this;
        }

        public Criteria andVendorErrorMessageNotEqualTo(String value) {
            addCriterion("vendor_error_message <>", value, "vendorErrorMessage");
            return (Criteria) this;
        }

        public Criteria andVendorErrorMessageGreaterThan(String value) {
            addCriterion("vendor_error_message >", value, "vendorErrorMessage");
            return (Criteria) this;
        }

        public Criteria andVendorErrorMessageGreaterThanOrEqualTo(String value) {
            addCriterion("vendor_error_message >=", value, "vendorErrorMessage");
            return (Criteria) this;
        }

        public Criteria andVendorErrorMessageLessThan(String value) {
            addCriterion("vendor_error_message <", value, "vendorErrorMessage");
            return (Criteria) this;
        }

        public Criteria andVendorErrorMessageLessThanOrEqualTo(String value) {
            addCriterion("vendor_error_message <=", value, "vendorErrorMessage");
            return (Criteria) this;
        }

        public Criteria andVendorErrorMessageLike(String value) {
            addCriterion("vendor_error_message like", value, "vendorErrorMessage");
            return (Criteria) this;
        }

        public Criteria andVendorErrorMessageNotLike(String value) {
            addCriterion("vendor_error_message not like", value, "vendorErrorMessage");
            return (Criteria) this;
        }

        public Criteria andVendorErrorMessageIn(List<String> values) {
            addCriterion("vendor_error_message in", values, "vendorErrorMessage");
            return (Criteria) this;
        }

        public Criteria andVendorErrorMessageNotIn(List<String> values) {
            addCriterion("vendor_error_message not in", values, "vendorErrorMessage");
            return (Criteria) this;
        }

        public Criteria andVendorErrorMessageBetween(String value1, String value2) {
            addCriterion("vendor_error_message between", value1, value2, "vendorErrorMessage");
            return (Criteria) this;
        }

        public Criteria andVendorErrorMessageNotBetween(String value1, String value2) {
            addCriterion("vendor_error_message not between", value1, value2, "vendorErrorMessage");
            return (Criteria) this;
        }

        public Criteria andResponseIsNull() {
            addCriterion("response is null");
            return (Criteria) this;
        }

        public Criteria andResponseIsNotNull() {
            addCriterion("response is not null");
            return (Criteria) this;
        }

        public Criteria andResponseEqualTo(String value) {
            addCriterion("response =", value, "response");
            return (Criteria) this;
        }

        public Criteria andResponseNotEqualTo(String value) {
            addCriterion("response <>", value, "response");
            return (Criteria) this;
        }

        public Criteria andResponseGreaterThan(String value) {
            addCriterion("response >", value, "response");
            return (Criteria) this;
        }

        public Criteria andResponseGreaterThanOrEqualTo(String value) {
            addCriterion("response >=", value, "response");
            return (Criteria) this;
        }

        public Criteria andResponseLessThan(String value) {
            addCriterion("response <", value, "response");
            return (Criteria) this;
        }

        public Criteria andResponseLessThanOrEqualTo(String value) {
            addCriterion("response <=", value, "response");
            return (Criteria) this;
        }

        public Criteria andResponseLike(String value) {
            addCriterion("response like", value, "response");
            return (Criteria) this;
        }

        public Criteria andResponseNotLike(String value) {
            addCriterion("response not like", value, "response");
            return (Criteria) this;
        }

        public Criteria andResponseIn(List<String> values) {
            addCriterion("response in", values, "response");
            return (Criteria) this;
        }

        public Criteria andResponseNotIn(List<String> values) {
            addCriterion("response not in", values, "response");
            return (Criteria) this;
        }

        public Criteria andResponseBetween(String value1, String value2) {
            addCriterion("response between", value1, value2, "response");
            return (Criteria) this;
        }

        public Criteria andResponseNotBetween(String value1, String value2) {
            addCriterion("response not between", value1, value2, "response");
            return (Criteria) this;
        }

        public Criteria andNotifyClientStatusIsNull() {
            addCriterion("notify_client_status is null");
            return (Criteria) this;
        }

        public Criteria andNotifyClientStatusIsNotNull() {
            addCriterion("notify_client_status is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyClientStatusEqualTo(String value) {
            addCriterion("notify_client_status =", value, "notifyClientStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyClientStatusNotEqualTo(String value) {
            addCriterion("notify_client_status <>", value, "notifyClientStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyClientStatusGreaterThan(String value) {
            addCriterion("notify_client_status >", value, "notifyClientStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyClientStatusGreaterThanOrEqualTo(String value) {
            addCriterion("notify_client_status >=", value, "notifyClientStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyClientStatusLessThan(String value) {
            addCriterion("notify_client_status <", value, "notifyClientStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyClientStatusLessThanOrEqualTo(String value) {
            addCriterion("notify_client_status <=", value, "notifyClientStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyClientStatusLike(String value) {
            addCriterion("notify_client_status like", value, "notifyClientStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyClientStatusNotLike(String value) {
            addCriterion("notify_client_status not like", value, "notifyClientStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyClientStatusIn(List<String> values) {
            addCriterion("notify_client_status in", values, "notifyClientStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyClientStatusNotIn(List<String> values) {
            addCriterion("notify_client_status not in", values, "notifyClientStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyClientStatusBetween(String value1, String value2) {
            addCriterion("notify_client_status between", value1, value2, "notifyClientStatus");
            return (Criteria) this;
        }

        public Criteria andNotifyClientStatusNotBetween(String value1, String value2) {
            addCriterion("notify_client_status not between", value1, value2, "notifyClientStatus");
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

        public Criteria andFlagsIsNull() {
            addCriterion("flags is null");
            return (Criteria) this;
        }

        public Criteria andFlagsIsNotNull() {
            addCriterion("flags is not null");
            return (Criteria) this;
        }

        public Criteria andFlagsEqualTo(Integer value) {
            addCriterion("flags =", value, "flags");
            return (Criteria) this;
        }

        public Criteria andFlagsNotEqualTo(Integer value) {
            addCriterion("flags <>", value, "flags");
            return (Criteria) this;
        }

        public Criteria andFlagsGreaterThan(Integer value) {
            addCriterion("flags >", value, "flags");
            return (Criteria) this;
        }

        public Criteria andFlagsGreaterThanOrEqualTo(Integer value) {
            addCriterion("flags >=", value, "flags");
            return (Criteria) this;
        }

        public Criteria andFlagsLessThan(Integer value) {
            addCriterion("flags <", value, "flags");
            return (Criteria) this;
        }

        public Criteria andFlagsLessThanOrEqualTo(Integer value) {
            addCriterion("flags <=", value, "flags");
            return (Criteria) this;
        }

        public Criteria andFlagsIn(List<Integer> values) {
            addCriterion("flags in", values, "flags");
            return (Criteria) this;
        }

        public Criteria andFlagsNotIn(List<Integer> values) {
            addCriterion("flags not in", values, "flags");
            return (Criteria) this;
        }

        public Criteria andFlagsBetween(Integer value1, Integer value2) {
            addCriterion("flags between", value1, value2, "flags");
            return (Criteria) this;
        }

        public Criteria andFlagsNotBetween(Integer value1, Integer value2) {
            addCriterion("flags not between", value1, value2, "flags");
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