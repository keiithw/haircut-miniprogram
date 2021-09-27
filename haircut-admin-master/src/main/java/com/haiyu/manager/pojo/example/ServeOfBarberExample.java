package com.haiyu.manager.pojo.example;

import java.util.ArrayList;
import java.util.List;

public class ServeOfBarberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServeOfBarberExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBarberIdIsNull() {
            addCriterion("barber_id is null");
            return (Criteria) this;
        }

        public Criteria andBarberIdIsNotNull() {
            addCriterion("barber_id is not null");
            return (Criteria) this;
        }

        public Criteria andBarberIdEqualTo(Integer value) {
            addCriterion("barber_id =", value, "barberId");
            return (Criteria) this;
        }

        public Criteria andBarberIdNotEqualTo(Integer value) {
            addCriterion("barber_id <>", value, "barberId");
            return (Criteria) this;
        }

        public Criteria andBarberIdGreaterThan(Integer value) {
            addCriterion("barber_id >", value, "barberId");
            return (Criteria) this;
        }

        public Criteria andBarberIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("barber_id >=", value, "barberId");
            return (Criteria) this;
        }

        public Criteria andBarberIdLessThan(Integer value) {
            addCriterion("barber_id <", value, "barberId");
            return (Criteria) this;
        }

        public Criteria andBarberIdLessThanOrEqualTo(Integer value) {
            addCriterion("barber_id <=", value, "barberId");
            return (Criteria) this;
        }

        public Criteria andBarberIdIn(List<Integer> values) {
            addCriterion("barber_id in", values, "barberId");
            return (Criteria) this;
        }

        public Criteria andBarberIdNotIn(List<Integer> values) {
            addCriterion("barber_id not in", values, "barberId");
            return (Criteria) this;
        }

        public Criteria andBarberIdBetween(Integer value1, Integer value2) {
            addCriterion("barber_id between", value1, value2, "barberId");
            return (Criteria) this;
        }

        public Criteria andBarberIdNotBetween(Integer value1, Integer value2) {
            addCriterion("barber_id not between", value1, value2, "barberId");
            return (Criteria) this;
        }

        public Criteria andServeIdsIsNull() {
            addCriterion("serve_ids is null");
            return (Criteria) this;
        }

        public Criteria andServeIdsIsNotNull() {
            addCriterion("serve_ids is not null");
            return (Criteria) this;
        }

        public Criteria andServeIdsEqualTo(String value) {
            addCriterion("serve_ids =", value, "serveIds");
            return (Criteria) this;
        }

        public Criteria andServeIdsNotEqualTo(String value) {
            addCriterion("serve_ids <>", value, "serveIds");
            return (Criteria) this;
        }

        public Criteria andServeIdsGreaterThan(String value) {
            addCriterion("serve_ids >", value, "serveIds");
            return (Criteria) this;
        }

        public Criteria andServeIdsGreaterThanOrEqualTo(String value) {
            addCriterion("serve_ids >=", value, "serveIds");
            return (Criteria) this;
        }

        public Criteria andServeIdsLessThan(String value) {
            addCriterion("serve_ids <", value, "serveIds");
            return (Criteria) this;
        }

        public Criteria andServeIdsLessThanOrEqualTo(String value) {
            addCriterion("serve_ids <=", value, "serveIds");
            return (Criteria) this;
        }

        public Criteria andServeIdsLike(String value) {
            addCriterion("serve_ids like", value, "serveIds");
            return (Criteria) this;
        }

        public Criteria andServeIdsNotLike(String value) {
            addCriterion("serve_ids not like", value, "serveIds");
            return (Criteria) this;
        }

        public Criteria andServeIdsIn(List<String> values) {
            addCriterion("serve_ids in", values, "serveIds");
            return (Criteria) this;
        }

        public Criteria andServeIdsNotIn(List<String> values) {
            addCriterion("serve_ids not in", values, "serveIds");
            return (Criteria) this;
        }

        public Criteria andServeIdsBetween(String value1, String value2) {
            addCriterion("serve_ids between", value1, value2, "serveIds");
            return (Criteria) this;
        }

        public Criteria andServeIdsNotBetween(String value1, String value2) {
            addCriterion("serve_ids not between", value1, value2, "serveIds");
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