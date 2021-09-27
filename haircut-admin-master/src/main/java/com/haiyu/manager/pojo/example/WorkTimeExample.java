package com.haiyu.manager.pojo.example;

import java.util.ArrayList;
import java.util.List;

public class WorkTimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkTimeExample() {
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

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Integer value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Integer value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Integer value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Integer value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Integer value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Integer> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Integer> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Integer value1, Integer value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Integer value1, Integer value2) {
            addCriterion("sid not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
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

        public Criteria andBarberNameIsNull() {
            addCriterion("barber_name is null");
            return (Criteria) this;
        }

        public Criteria andBarberNameIsNotNull() {
            addCriterion("barber_name is not null");
            return (Criteria) this;
        }

        public Criteria andBarberNameEqualTo(String value) {
            addCriterion("barber_name =", value, "barberName");
            return (Criteria) this;
        }

        public Criteria andBarberNameNotEqualTo(String value) {
            addCriterion("barber_name <>", value, "barberName");
            return (Criteria) this;
        }

        public Criteria andBarberNameGreaterThan(String value) {
            addCriterion("barber_name >", value, "barberName");
            return (Criteria) this;
        }

        public Criteria andBarberNameGreaterThanOrEqualTo(String value) {
            addCriterion("barber_name >=", value, "barberName");
            return (Criteria) this;
        }

        public Criteria andBarberNameLessThan(String value) {
            addCriterion("barber_name <", value, "barberName");
            return (Criteria) this;
        }

        public Criteria andBarberNameLessThanOrEqualTo(String value) {
            addCriterion("barber_name <=", value, "barberName");
            return (Criteria) this;
        }

        public Criteria andBarberNameLike(String value) {
            addCriterion("barber_name like", value, "barberName");
            return (Criteria) this;
        }

        public Criteria andBarberNameNotLike(String value) {
            addCriterion("barber_name not like", value, "barberName");
            return (Criteria) this;
        }

        public Criteria andBarberNameIn(List<String> values) {
            addCriterion("barber_name in", values, "barberName");
            return (Criteria) this;
        }

        public Criteria andBarberNameNotIn(List<String> values) {
            addCriterion("barber_name not in", values, "barberName");
            return (Criteria) this;
        }

        public Criteria andBarberNameBetween(String value1, String value2) {
            addCriterion("barber_name between", value1, value2, "barberName");
            return (Criteria) this;
        }

        public Criteria andBarberNameNotBetween(String value1, String value2) {
            addCriterion("barber_name not between", value1, value2, "barberName");
            return (Criteria) this;
        }

        public Criteria andStartIsNull() {
            addCriterion("start is null");
            return (Criteria) this;
        }

        public Criteria andStartIsNotNull() {
            addCriterion("start is not null");
            return (Criteria) this;
        }

        public Criteria andStartEqualTo(String value) {
            addCriterion("start =", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotEqualTo(String value) {
            addCriterion("start <>", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartGreaterThan(String value) {
            addCriterion("start >", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartGreaterThanOrEqualTo(String value) {
            addCriterion("start >=", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartLessThan(String value) {
            addCriterion("start <", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartLessThanOrEqualTo(String value) {
            addCriterion("start <=", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartLike(String value) {
            addCriterion("start like", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotLike(String value) {
            addCriterion("start not like", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartIn(List<String> values) {
            addCriterion("start in", values, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotIn(List<String> values) {
            addCriterion("start not in", values, "start");
            return (Criteria) this;
        }

        public Criteria andStartBetween(String value1, String value2) {
            addCriterion("start between", value1, value2, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotBetween(String value1, String value2) {
            addCriterion("start not between", value1, value2, "start");
            return (Criteria) this;
        }

        public Criteria andEndIsNull() {
            addCriterion("end is null");
            return (Criteria) this;
        }

        public Criteria andEndIsNotNull() {
            addCriterion("end is not null");
            return (Criteria) this;
        }

        public Criteria andEndEqualTo(String value) {
            addCriterion("end =", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotEqualTo(String value) {
            addCriterion("end <>", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndGreaterThan(String value) {
            addCriterion("end >", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndGreaterThanOrEqualTo(String value) {
            addCriterion("end >=", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndLessThan(String value) {
            addCriterion("end <", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndLessThanOrEqualTo(String value) {
            addCriterion("end <=", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndLike(String value) {
            addCriterion("end like", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotLike(String value) {
            addCriterion("end not like", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndIn(List<String> values) {
            addCriterion("end in", values, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotIn(List<String> values) {
            addCriterion("end not in", values, "end");
            return (Criteria) this;
        }

        public Criteria andEndBetween(String value1, String value2) {
            addCriterion("end between", value1, value2, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotBetween(String value1, String value2) {
            addCriterion("end not between", value1, value2, "end");
            return (Criteria) this;
        }

        public Criteria andNoonIsNull() {
            addCriterion("noon is null");
            return (Criteria) this;
        }

        public Criteria andNoonIsNotNull() {
            addCriterion("noon is not null");
            return (Criteria) this;
        }

        public Criteria andNoonEqualTo(Integer value) {
            addCriterion("noon =", value, "noon");
            return (Criteria) this;
        }

        public Criteria andNoonNotEqualTo(Integer value) {
            addCriterion("noon <>", value, "noon");
            return (Criteria) this;
        }

        public Criteria andNoonGreaterThan(Integer value) {
            addCriterion("noon >", value, "noon");
            return (Criteria) this;
        }

        public Criteria andNoonGreaterThanOrEqualTo(Integer value) {
            addCriterion("noon >=", value, "noon");
            return (Criteria) this;
        }

        public Criteria andNoonLessThan(Integer value) {
            addCriterion("noon <", value, "noon");
            return (Criteria) this;
        }

        public Criteria andNoonLessThanOrEqualTo(Integer value) {
            addCriterion("noon <=", value, "noon");
            return (Criteria) this;
        }

        public Criteria andNoonIn(List<Integer> values) {
            addCriterion("noon in", values, "noon");
            return (Criteria) this;
        }

        public Criteria andNoonNotIn(List<Integer> values) {
            addCriterion("noon not in", values, "noon");
            return (Criteria) this;
        }

        public Criteria andNoonBetween(Integer value1, Integer value2) {
            addCriterion("noon between", value1, value2, "noon");
            return (Criteria) this;
        }

        public Criteria andNoonNotBetween(Integer value1, Integer value2) {
            addCriterion("noon not between", value1, value2, "noon");
            return (Criteria) this;
        }

        public Criteria andNoonNameIsNull() {
            addCriterion("noon_name is null");
            return (Criteria) this;
        }

        public Criteria andNoonNameIsNotNull() {
            addCriterion("noon_name is not null");
            return (Criteria) this;
        }

        public Criteria andNoonNameEqualTo(String value) {
            addCriterion("noon_name =", value, "noonName");
            return (Criteria) this;
        }

        public Criteria andNoonNameNotEqualTo(String value) {
            addCriterion("noon_name <>", value, "noonName");
            return (Criteria) this;
        }

        public Criteria andNoonNameGreaterThan(String value) {
            addCriterion("noon_name >", value, "noonName");
            return (Criteria) this;
        }

        public Criteria andNoonNameGreaterThanOrEqualTo(String value) {
            addCriterion("noon_name >=", value, "noonName");
            return (Criteria) this;
        }

        public Criteria andNoonNameLessThan(String value) {
            addCriterion("noon_name <", value, "noonName");
            return (Criteria) this;
        }

        public Criteria andNoonNameLessThanOrEqualTo(String value) {
            addCriterion("noon_name <=", value, "noonName");
            return (Criteria) this;
        }

        public Criteria andNoonNameLike(String value) {
            addCriterion("noon_name like", value, "noonName");
            return (Criteria) this;
        }

        public Criteria andNoonNameNotLike(String value) {
            addCriterion("noon_name not like", value, "noonName");
            return (Criteria) this;
        }

        public Criteria andNoonNameIn(List<String> values) {
            addCriterion("noon_name in", values, "noonName");
            return (Criteria) this;
        }

        public Criteria andNoonNameNotIn(List<String> values) {
            addCriterion("noon_name not in", values, "noonName");
            return (Criteria) this;
        }

        public Criteria andNoonNameBetween(String value1, String value2) {
            addCriterion("noon_name between", value1, value2, "noonName");
            return (Criteria) this;
        }

        public Criteria andNoonNameNotBetween(String value1, String value2) {
            addCriterion("noon_name not between", value1, value2, "noonName");
            return (Criteria) this;
        }

        public Criteria andIntervalMaxIsNull() {
            addCriterion("interval_max is null");
            return (Criteria) this;
        }

        public Criteria andIntervalMaxIsNotNull() {
            addCriterion("interval_max is not null");
            return (Criteria) this;
        }

        public Criteria andIntervalMaxEqualTo(Integer value) {
            addCriterion("interval_max =", value, "intervalMax");
            return (Criteria) this;
        }

        public Criteria andIntervalMaxNotEqualTo(Integer value) {
            addCriterion("interval_max <>", value, "intervalMax");
            return (Criteria) this;
        }

        public Criteria andIntervalMaxGreaterThan(Integer value) {
            addCriterion("interval_max >", value, "intervalMax");
            return (Criteria) this;
        }

        public Criteria andIntervalMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("interval_max >=", value, "intervalMax");
            return (Criteria) this;
        }

        public Criteria andIntervalMaxLessThan(Integer value) {
            addCriterion("interval_max <", value, "intervalMax");
            return (Criteria) this;
        }

        public Criteria andIntervalMaxLessThanOrEqualTo(Integer value) {
            addCriterion("interval_max <=", value, "intervalMax");
            return (Criteria) this;
        }

        public Criteria andIntervalMaxIn(List<Integer> values) {
            addCriterion("interval_max in", values, "intervalMax");
            return (Criteria) this;
        }

        public Criteria andIntervalMaxNotIn(List<Integer> values) {
            addCriterion("interval_max not in", values, "intervalMax");
            return (Criteria) this;
        }

        public Criteria andIntervalMaxBetween(Integer value1, Integer value2) {
            addCriterion("interval_max between", value1, value2, "intervalMax");
            return (Criteria) this;
        }

        public Criteria andIntervalMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("interval_max not between", value1, value2, "intervalMax");
            return (Criteria) this;
        }

        public Criteria andAlldayIsNull() {
            addCriterion("allDay is null");
            return (Criteria) this;
        }

        public Criteria andAlldayIsNotNull() {
            addCriterion("allDay is not null");
            return (Criteria) this;
        }

        public Criteria andAlldayEqualTo(Boolean value) {
            addCriterion("allDay =", value, "allday");
            return (Criteria) this;
        }

        public Criteria andAlldayNotEqualTo(Boolean value) {
            addCriterion("allDay <>", value, "allday");
            return (Criteria) this;
        }

        public Criteria andAlldayGreaterThan(Boolean value) {
            addCriterion("allDay >", value, "allday");
            return (Criteria) this;
        }

        public Criteria andAlldayGreaterThanOrEqualTo(Boolean value) {
            addCriterion("allDay >=", value, "allday");
            return (Criteria) this;
        }

        public Criteria andAlldayLessThan(Boolean value) {
            addCriterion("allDay <", value, "allday");
            return (Criteria) this;
        }

        public Criteria andAlldayLessThanOrEqualTo(Boolean value) {
            addCriterion("allDay <=", value, "allday");
            return (Criteria) this;
        }

        public Criteria andAlldayIn(List<Boolean> values) {
            addCriterion("allDay in", values, "allday");
            return (Criteria) this;
        }

        public Criteria andAlldayNotIn(List<Boolean> values) {
            addCriterion("allDay not in", values, "allday");
            return (Criteria) this;
        }

        public Criteria andAlldayBetween(Boolean value1, Boolean value2) {
            addCriterion("allDay between", value1, value2, "allday");
            return (Criteria) this;
        }

        public Criteria andAlldayNotBetween(Boolean value1, Boolean value2) {
            addCriterion("allDay not between", value1, value2, "allday");
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