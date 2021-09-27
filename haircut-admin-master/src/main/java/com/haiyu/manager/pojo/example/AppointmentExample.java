package com.haiyu.manager.pojo.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppointmentExample() {
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

        public Criteria andAidIsNull() {
            addCriterion("aid is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("aid is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(Integer value) {
            addCriterion("aid =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(Integer value) {
            addCriterion("aid <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(Integer value) {
            addCriterion("aid >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(Integer value) {
            addCriterion("aid >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(Integer value) {
            addCriterion("aid <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(Integer value) {
            addCriterion("aid <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<Integer> values) {
            addCriterion("aid in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<Integer> values) {
            addCriterion("aid not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(Integer value1, Integer value2) {
            addCriterion("aid between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(Integer value1, Integer value2) {
            addCriterion("aid not between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Integer value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Integer value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Integer value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Integer value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Integer> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Integer> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNull() {
            addCriterion("customer_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNotNull() {
            addCriterion("customer_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameEqualTo(String value) {
            addCriterion("customer_name =", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            addCriterion("customer_name <>", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            addCriterion("customer_name >", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_name >=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThan(String value) {
            addCriterion("customer_name <", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            addCriterion("customer_name <=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLike(String value) {
            addCriterion("customer_name like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotLike(String value) {
            addCriterion("customer_name not like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIn(List<String> values) {
            addCriterion("customer_name in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            addCriterion("customer_name not in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            addCriterion("customer_name between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            addCriterion("customer_name not between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneIsNull() {
            addCriterion("customer_phone is null");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneIsNotNull() {
            addCriterion("customer_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneEqualTo(String value) {
            addCriterion("customer_phone =", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotEqualTo(String value) {
            addCriterion("customer_phone <>", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneGreaterThan(String value) {
            addCriterion("customer_phone >", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("customer_phone >=", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneLessThan(String value) {
            addCriterion("customer_phone <", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneLessThanOrEqualTo(String value) {
            addCriterion("customer_phone <=", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneLike(String value) {
            addCriterion("customer_phone like", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotLike(String value) {
            addCriterion("customer_phone not like", value, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneIn(List<String> values) {
            addCriterion("customer_phone in", values, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotIn(List<String> values) {
            addCriterion("customer_phone not in", values, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneBetween(String value1, String value2) {
            addCriterion("customer_phone between", value1, value2, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerPhoneNotBetween(String value1, String value2) {
            addCriterion("customer_phone not between", value1, value2, "customerPhone");
            return (Criteria) this;
        }

        public Criteria andCustomerAvatarIsNull() {
            addCriterion("customer_avatar is null");
            return (Criteria) this;
        }

        public Criteria andCustomerAvatarIsNotNull() {
            addCriterion("customer_avatar is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerAvatarEqualTo(String value) {
            addCriterion("customer_avatar =", value, "customerAvatar");
            return (Criteria) this;
        }

        public Criteria andCustomerAvatarNotEqualTo(String value) {
            addCriterion("customer_avatar <>", value, "customerAvatar");
            return (Criteria) this;
        }

        public Criteria andCustomerAvatarGreaterThan(String value) {
            addCriterion("customer_avatar >", value, "customerAvatar");
            return (Criteria) this;
        }

        public Criteria andCustomerAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("customer_avatar >=", value, "customerAvatar");
            return (Criteria) this;
        }

        public Criteria andCustomerAvatarLessThan(String value) {
            addCriterion("customer_avatar <", value, "customerAvatar");
            return (Criteria) this;
        }

        public Criteria andCustomerAvatarLessThanOrEqualTo(String value) {
            addCriterion("customer_avatar <=", value, "customerAvatar");
            return (Criteria) this;
        }

        public Criteria andCustomerAvatarLike(String value) {
            addCriterion("customer_avatar like", value, "customerAvatar");
            return (Criteria) this;
        }

        public Criteria andCustomerAvatarNotLike(String value) {
            addCriterion("customer_avatar not like", value, "customerAvatar");
            return (Criteria) this;
        }

        public Criteria andCustomerAvatarIn(List<String> values) {
            addCriterion("customer_avatar in", values, "customerAvatar");
            return (Criteria) this;
        }

        public Criteria andCustomerAvatarNotIn(List<String> values) {
            addCriterion("customer_avatar not in", values, "customerAvatar");
            return (Criteria) this;
        }

        public Criteria andCustomerAvatarBetween(String value1, String value2) {
            addCriterion("customer_avatar between", value1, value2, "customerAvatar");
            return (Criteria) this;
        }

        public Criteria andCustomerAvatarNotBetween(String value1, String value2) {
            addCriterion("customer_avatar not between", value1, value2, "customerAvatar");
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

        public Criteria andStoreNameIsNull() {
            addCriterion("store_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("store_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("store_name =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("store_name <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("store_name >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_name >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("store_name <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("store_name <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("store_name like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("store_name not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("store_name in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("store_name not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("store_name between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("store_name not between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andServerIdIsNull() {
            addCriterion("server_id is null");
            return (Criteria) this;
        }

        public Criteria andServerIdIsNotNull() {
            addCriterion("server_id is not null");
            return (Criteria) this;
        }

        public Criteria andServerIdEqualTo(Integer value) {
            addCriterion("server_id =", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotEqualTo(Integer value) {
            addCriterion("server_id <>", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThan(Integer value) {
            addCriterion("server_id >", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("server_id >=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThan(Integer value) {
            addCriterion("server_id <", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThanOrEqualTo(Integer value) {
            addCriterion("server_id <=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdIn(List<Integer> values) {
            addCriterion("server_id in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotIn(List<Integer> values) {
            addCriterion("server_id not in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdBetween(Integer value1, Integer value2) {
            addCriterion("server_id between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("server_id not between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerNameIsNull() {
            addCriterion("server_name is null");
            return (Criteria) this;
        }

        public Criteria andServerNameIsNotNull() {
            addCriterion("server_name is not null");
            return (Criteria) this;
        }

        public Criteria andServerNameEqualTo(String value) {
            addCriterion("server_name =", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameNotEqualTo(String value) {
            addCriterion("server_name <>", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameGreaterThan(String value) {
            addCriterion("server_name >", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameGreaterThanOrEqualTo(String value) {
            addCriterion("server_name >=", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameLessThan(String value) {
            addCriterion("server_name <", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameLessThanOrEqualTo(String value) {
            addCriterion("server_name <=", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameLike(String value) {
            addCriterion("server_name like", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameNotLike(String value) {
            addCriterion("server_name not like", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameIn(List<String> values) {
            addCriterion("server_name in", values, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameNotIn(List<String> values) {
            addCriterion("server_name not in", values, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameBetween(String value1, String value2) {
            addCriterion("server_name between", value1, value2, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameNotBetween(String value1, String value2) {
            addCriterion("server_name not between", value1, value2, "serverName");
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

        public Criteria andBarberAvatarIsNull() {
            addCriterion("barber_avatar is null");
            return (Criteria) this;
        }

        public Criteria andBarberAvatarIsNotNull() {
            addCriterion("barber_avatar is not null");
            return (Criteria) this;
        }

        public Criteria andBarberAvatarEqualTo(String value) {
            addCriterion("barber_avatar =", value, "barberAvatar");
            return (Criteria) this;
        }

        public Criteria andBarberAvatarNotEqualTo(String value) {
            addCriterion("barber_avatar <>", value, "barberAvatar");
            return (Criteria) this;
        }

        public Criteria andBarberAvatarGreaterThan(String value) {
            addCriterion("barber_avatar >", value, "barberAvatar");
            return (Criteria) this;
        }

        public Criteria andBarberAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("barber_avatar >=", value, "barberAvatar");
            return (Criteria) this;
        }

        public Criteria andBarberAvatarLessThan(String value) {
            addCriterion("barber_avatar <", value, "barberAvatar");
            return (Criteria) this;
        }

        public Criteria andBarberAvatarLessThanOrEqualTo(String value) {
            addCriterion("barber_avatar <=", value, "barberAvatar");
            return (Criteria) this;
        }

        public Criteria andBarberAvatarLike(String value) {
            addCriterion("barber_avatar like", value, "barberAvatar");
            return (Criteria) this;
        }

        public Criteria andBarberAvatarNotLike(String value) {
            addCriterion("barber_avatar not like", value, "barberAvatar");
            return (Criteria) this;
        }

        public Criteria andBarberAvatarIn(List<String> values) {
            addCriterion("barber_avatar in", values, "barberAvatar");
            return (Criteria) this;
        }

        public Criteria andBarberAvatarNotIn(List<String> values) {
            addCriterion("barber_avatar not in", values, "barberAvatar");
            return (Criteria) this;
        }

        public Criteria andBarberAvatarBetween(String value1, String value2) {
            addCriterion("barber_avatar between", value1, value2, "barberAvatar");
            return (Criteria) this;
        }

        public Criteria andBarberAvatarNotBetween(String value1, String value2) {
            addCriterion("barber_avatar not between", value1, value2, "barberAvatar");
            return (Criteria) this;
        }

        public Criteria andBarberPhoneIsNull() {
            addCriterion("barber_phone is null");
            return (Criteria) this;
        }

        public Criteria andBarberPhoneIsNotNull() {
            addCriterion("barber_phone is not null");
            return (Criteria) this;
        }

        public Criteria andBarberPhoneEqualTo(String value) {
            addCriterion("barber_phone =", value, "barberPhone");
            return (Criteria) this;
        }

        public Criteria andBarberPhoneNotEqualTo(String value) {
            addCriterion("barber_phone <>", value, "barberPhone");
            return (Criteria) this;
        }

        public Criteria andBarberPhoneGreaterThan(String value) {
            addCriterion("barber_phone >", value, "barberPhone");
            return (Criteria) this;
        }

        public Criteria andBarberPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("barber_phone >=", value, "barberPhone");
            return (Criteria) this;
        }

        public Criteria andBarberPhoneLessThan(String value) {
            addCriterion("barber_phone <", value, "barberPhone");
            return (Criteria) this;
        }

        public Criteria andBarberPhoneLessThanOrEqualTo(String value) {
            addCriterion("barber_phone <=", value, "barberPhone");
            return (Criteria) this;
        }

        public Criteria andBarberPhoneLike(String value) {
            addCriterion("barber_phone like", value, "barberPhone");
            return (Criteria) this;
        }

        public Criteria andBarberPhoneNotLike(String value) {
            addCriterion("barber_phone not like", value, "barberPhone");
            return (Criteria) this;
        }

        public Criteria andBarberPhoneIn(List<String> values) {
            addCriterion("barber_phone in", values, "barberPhone");
            return (Criteria) this;
        }

        public Criteria andBarberPhoneNotIn(List<String> values) {
            addCriterion("barber_phone not in", values, "barberPhone");
            return (Criteria) this;
        }

        public Criteria andBarberPhoneBetween(String value1, String value2) {
            addCriterion("barber_phone between", value1, value2, "barberPhone");
            return (Criteria) this;
        }

        public Criteria andBarberPhoneNotBetween(String value1, String value2) {
            addCriterion("barber_phone not between", value1, value2, "barberPhone");
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

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Integer value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Integer value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Integer> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andSegmentIsNull() {
            addCriterion("segment is null");
            return (Criteria) this;
        }

        public Criteria andSegmentIsNotNull() {
            addCriterion("segment is not null");
            return (Criteria) this;
        }

        public Criteria andSegmentEqualTo(Integer value) {
            addCriterion("segment =", value, "segment");
            return (Criteria) this;
        }

        public Criteria andSegmentNotEqualTo(Integer value) {
            addCriterion("segment <>", value, "segment");
            return (Criteria) this;
        }

        public Criteria andSegmentGreaterThan(Integer value) {
            addCriterion("segment >", value, "segment");
            return (Criteria) this;
        }

        public Criteria andSegmentGreaterThanOrEqualTo(Integer value) {
            addCriterion("segment >=", value, "segment");
            return (Criteria) this;
        }

        public Criteria andSegmentLessThan(Integer value) {
            addCriterion("segment <", value, "segment");
            return (Criteria) this;
        }

        public Criteria andSegmentLessThanOrEqualTo(Integer value) {
            addCriterion("segment <=", value, "segment");
            return (Criteria) this;
        }

        public Criteria andSegmentIn(List<Integer> values) {
            addCriterion("segment in", values, "segment");
            return (Criteria) this;
        }

        public Criteria andSegmentNotIn(List<Integer> values) {
            addCriterion("segment not in", values, "segment");
            return (Criteria) this;
        }

        public Criteria andSegmentBetween(Integer value1, Integer value2) {
            addCriterion("segment between", value1, value2, "segment");
            return (Criteria) this;
        }

        public Criteria andSegmentNotBetween(Integer value1, Integer value2) {
            addCriterion("segment not between", value1, value2, "segment");
            return (Criteria) this;
        }

        public Criteria andDayIsNull() {
            addCriterion("day is null");
            return (Criteria) this;
        }

        public Criteria andDayIsNotNull() {
            addCriterion("day is not null");
            return (Criteria) this;
        }

        public Criteria andDayEqualTo(Date value) {
            addCriterion("day =", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotEqualTo(Date value) {
            addCriterion("day <>", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThan(Date value) {
            addCriterion("day >", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThanOrEqualTo(Date value) {
            addCriterion("day >=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThan(Date value) {
            addCriterion("day <", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThanOrEqualTo(Date value) {
            addCriterion("day <=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayIn(List<Date> values) {
            addCriterion("day in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotIn(List<Date> values) {
            addCriterion("day not in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayBetween(Date value1, Date value2) {
            addCriterion("day between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotBetween(Date value1, Date value2) {
            addCriterion("day not between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
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

        public Criteria andNoonnameIsNull() {
            addCriterion("noonName is null");
            return (Criteria) this;
        }

        public Criteria andNoonnameIsNotNull() {
            addCriterion("noonName is not null");
            return (Criteria) this;
        }

        public Criteria andNoonnameEqualTo(String value) {
            addCriterion("noonName =", value, "noonname");
            return (Criteria) this;
        }

        public Criteria andNoonnameNotEqualTo(String value) {
            addCriterion("noonName <>", value, "noonname");
            return (Criteria) this;
        }

        public Criteria andNoonnameGreaterThan(String value) {
            addCriterion("noonName >", value, "noonname");
            return (Criteria) this;
        }

        public Criteria andNoonnameGreaterThanOrEqualTo(String value) {
            addCriterion("noonName >=", value, "noonname");
            return (Criteria) this;
        }

        public Criteria andNoonnameLessThan(String value) {
            addCriterion("noonName <", value, "noonname");
            return (Criteria) this;
        }

        public Criteria andNoonnameLessThanOrEqualTo(String value) {
            addCriterion("noonName <=", value, "noonname");
            return (Criteria) this;
        }

        public Criteria andNoonnameLike(String value) {
            addCriterion("noonName like", value, "noonname");
            return (Criteria) this;
        }

        public Criteria andNoonnameNotLike(String value) {
            addCriterion("noonName not like", value, "noonname");
            return (Criteria) this;
        }

        public Criteria andNoonnameIn(List<String> values) {
            addCriterion("noonName in", values, "noonname");
            return (Criteria) this;
        }

        public Criteria andNoonnameNotIn(List<String> values) {
            addCriterion("noonName not in", values, "noonname");
            return (Criteria) this;
        }

        public Criteria andNoonnameBetween(String value1, String value2) {
            addCriterion("noonName between", value1, value2, "noonname");
            return (Criteria) this;
        }

        public Criteria andNoonnameNotBetween(String value1, String value2) {
            addCriterion("noonName not between", value1, value2, "noonname");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
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