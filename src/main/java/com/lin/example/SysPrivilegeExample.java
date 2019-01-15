package com.lin.example;

import java.util.ArrayList;
import java.util.List;

public class SysPrivilegeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysPrivilegeExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andPrivilegeNameIsNull() {
            addCriterion("privilege_name is null");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameIsNotNull() {
            addCriterion("privilege_name is not null");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameEqualTo(String value) {
            addCriterion("privilege_name =", value, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameNotEqualTo(String value) {
            addCriterion("privilege_name <>", value, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameGreaterThan(String value) {
            addCriterion("privilege_name >", value, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameGreaterThanOrEqualTo(String value) {
            addCriterion("privilege_name >=", value, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameLessThan(String value) {
            addCriterion("privilege_name <", value, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameLessThanOrEqualTo(String value) {
            addCriterion("privilege_name <=", value, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameLike(String value) {
            addCriterion("privilege_name like", value, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameNotLike(String value) {
            addCriterion("privilege_name not like", value, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameIn(List<String> values) {
            addCriterion("privilege_name in", values, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameNotIn(List<String> values) {
            addCriterion("privilege_name not in", values, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameBetween(String value1, String value2) {
            addCriterion("privilege_name between", value1, value2, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameNotBetween(String value1, String value2) {
            addCriterion("privilege_name not between", value1, value2, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUrlIsNull() {
            addCriterion("privilege_url is null");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUrlIsNotNull() {
            addCriterion("privilege_url is not null");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUrlEqualTo(String value) {
            addCriterion("privilege_url =", value, "privilegeUrl");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUrlNotEqualTo(String value) {
            addCriterion("privilege_url <>", value, "privilegeUrl");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUrlGreaterThan(String value) {
            addCriterion("privilege_url >", value, "privilegeUrl");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("privilege_url >=", value, "privilegeUrl");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUrlLessThan(String value) {
            addCriterion("privilege_url <", value, "privilegeUrl");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUrlLessThanOrEqualTo(String value) {
            addCriterion("privilege_url <=", value, "privilegeUrl");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUrlLike(String value) {
            addCriterion("privilege_url like", value, "privilegeUrl");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUrlNotLike(String value) {
            addCriterion("privilege_url not like", value, "privilegeUrl");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUrlIn(List<String> values) {
            addCriterion("privilege_url in", values, "privilegeUrl");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUrlNotIn(List<String> values) {
            addCriterion("privilege_url not in", values, "privilegeUrl");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUrlBetween(String value1, String value2) {
            addCriterion("privilege_url between", value1, value2, "privilegeUrl");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUrlNotBetween(String value1, String value2) {
            addCriterion("privilege_url not between", value1, value2, "privilegeUrl");
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