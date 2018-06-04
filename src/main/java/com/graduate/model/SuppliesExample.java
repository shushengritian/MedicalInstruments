package com.graduate.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SuppliesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SuppliesExample() {
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

        public Criteria andHcNoIsNull() {
            addCriterion("hc_no is null");
            return (Criteria) this;
        }

        public Criteria andHcNoIsNotNull() {
            addCriterion("hc_no is not null");
            return (Criteria) this;
        }

        public Criteria andHcNoEqualTo(String value) {
            addCriterion("hc_no =", value, "hcNo");
            return (Criteria) this;
        }

        public Criteria andHcNoNotEqualTo(String value) {
            addCriterion("hc_no <>", value, "hcNo");
            return (Criteria) this;
        }

        public Criteria andHcNoGreaterThan(String value) {
            addCriterion("hc_no >", value, "hcNo");
            return (Criteria) this;
        }

        public Criteria andHcNoGreaterThanOrEqualTo(String value) {
            addCriterion("hc_no >=", value, "hcNo");
            return (Criteria) this;
        }

        public Criteria andHcNoLessThan(String value) {
            addCriterion("hc_no <", value, "hcNo");
            return (Criteria) this;
        }

        public Criteria andHcNoLessThanOrEqualTo(String value) {
            addCriterion("hc_no <=", value, "hcNo");
            return (Criteria) this;
        }

        public Criteria andHcNoLike(String value) {
            addCriterion("hc_no like", value, "hcNo");
            return (Criteria) this;
        }

        public Criteria andHcNoNotLike(String value) {
            addCriterion("hc_no not like", value, "hcNo");
            return (Criteria) this;
        }

        public Criteria andHcNoIn(List<String> values) {
            addCriterion("hc_no in", values, "hcNo");
            return (Criteria) this;
        }

        public Criteria andHcNoNotIn(List<String> values) {
            addCriterion("hc_no not in", values, "hcNo");
            return (Criteria) this;
        }

        public Criteria andHcNoBetween(String value1, String value2) {
            addCriterion("hc_no between", value1, value2, "hcNo");
            return (Criteria) this;
        }

        public Criteria andHcNoNotBetween(String value1, String value2) {
            addCriterion("hc_no not between", value1, value2, "hcNo");
            return (Criteria) this;
        }

        public Criteria andHcNameIsNull() {
            addCriterion("hc_name is null");
            return (Criteria) this;
        }

        public Criteria andHcNameIsNotNull() {
            addCriterion("hc_name is not null");
            return (Criteria) this;
        }

        public Criteria andHcNameEqualTo(String value) {
            addCriterion("hc_name =", value, "hcName");
            return (Criteria) this;
        }

        public Criteria andHcNameNotEqualTo(String value) {
            addCriterion("hc_name <>", value, "hcName");
            return (Criteria) this;
        }

        public Criteria andHcNameGreaterThan(String value) {
            addCriterion("hc_name >", value, "hcName");
            return (Criteria) this;
        }

        public Criteria andHcNameGreaterThanOrEqualTo(String value) {
            addCriterion("hc_name >=", value, "hcName");
            return (Criteria) this;
        }

        public Criteria andHcNameLessThan(String value) {
            addCriterion("hc_name <", value, "hcName");
            return (Criteria) this;
        }

        public Criteria andHcNameLessThanOrEqualTo(String value) {
            addCriterion("hc_name <=", value, "hcName");
            return (Criteria) this;
        }

        public Criteria andHcNameLike(String value) {
            addCriterion("hc_name like", value, "hcName");
            return (Criteria) this;
        }

        public Criteria andHcNameNotLike(String value) {
            addCriterion("hc_name not like", value, "hcName");
            return (Criteria) this;
        }

        public Criteria andHcNameIn(List<String> values) {
            addCriterion("hc_name in", values, "hcName");
            return (Criteria) this;
        }

        public Criteria andHcNameNotIn(List<String> values) {
            addCriterion("hc_name not in", values, "hcName");
            return (Criteria) this;
        }

        public Criteria andHcNameBetween(String value1, String value2) {
            addCriterion("hc_name between", value1, value2, "hcName");
            return (Criteria) this;
        }

        public Criteria andHcNameNotBetween(String value1, String value2) {
            addCriterion("hc_name not between", value1, value2, "hcName");
            return (Criteria) this;
        }

        public Criteria andManafacturerIsNull() {
            addCriterion("manafacturer is null");
            return (Criteria) this;
        }

        public Criteria andManafacturerIsNotNull() {
            addCriterion("manafacturer is not null");
            return (Criteria) this;
        }

        public Criteria andManafacturerEqualTo(String value) {
            addCriterion("manafacturer =", value, "manafacturer");
            return (Criteria) this;
        }

        public Criteria andManafacturerNotEqualTo(String value) {
            addCriterion("manafacturer <>", value, "manafacturer");
            return (Criteria) this;
        }

        public Criteria andManafacturerGreaterThan(String value) {
            addCriterion("manafacturer >", value, "manafacturer");
            return (Criteria) this;
        }

        public Criteria andManafacturerGreaterThanOrEqualTo(String value) {
            addCriterion("manafacturer >=", value, "manafacturer");
            return (Criteria) this;
        }

        public Criteria andManafacturerLessThan(String value) {
            addCriterion("manafacturer <", value, "manafacturer");
            return (Criteria) this;
        }

        public Criteria andManafacturerLessThanOrEqualTo(String value) {
            addCriterion("manafacturer <=", value, "manafacturer");
            return (Criteria) this;
        }

        public Criteria andManafacturerLike(String value) {
            addCriterion("manafacturer like", value, "manafacturer");
            return (Criteria) this;
        }

        public Criteria andManafacturerNotLike(String value) {
            addCriterion("manafacturer not like", value, "manafacturer");
            return (Criteria) this;
        }

        public Criteria andManafacturerIn(List<String> values) {
            addCriterion("manafacturer in", values, "manafacturer");
            return (Criteria) this;
        }

        public Criteria andManafacturerNotIn(List<String> values) {
            addCriterion("manafacturer not in", values, "manafacturer");
            return (Criteria) this;
        }

        public Criteria andManafacturerBetween(String value1, String value2) {
            addCriterion("manafacturer between", value1, value2, "manafacturer");
            return (Criteria) this;
        }

        public Criteria andManafacturerNotBetween(String value1, String value2) {
            addCriterion("manafacturer not between", value1, value2, "manafacturer");
            return (Criteria) this;
        }

        public Criteria andHcTypeIsNull() {
            addCriterion("hc_type is null");
            return (Criteria) this;
        }

        public Criteria andHcTypeIsNotNull() {
            addCriterion("hc_type is not null");
            return (Criteria) this;
        }

        public Criteria andHcTypeEqualTo(Byte value) {
            addCriterion("hc_type =", value, "hcType");
            return (Criteria) this;
        }

        public Criteria andHcTypeNotEqualTo(Byte value) {
            addCriterion("hc_type <>", value, "hcType");
            return (Criteria) this;
        }

        public Criteria andHcTypeGreaterThan(Byte value) {
            addCriterion("hc_type >", value, "hcType");
            return (Criteria) this;
        }

        public Criteria andHcTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("hc_type >=", value, "hcType");
            return (Criteria) this;
        }

        public Criteria andHcTypeLessThan(Byte value) {
            addCriterion("hc_type <", value, "hcType");
            return (Criteria) this;
        }

        public Criteria andHcTypeLessThanOrEqualTo(Byte value) {
            addCriterion("hc_type <=", value, "hcType");
            return (Criteria) this;
        }

        public Criteria andHcTypeIn(List<Byte> values) {
            addCriterion("hc_type in", values, "hcType");
            return (Criteria) this;
        }

        public Criteria andHcTypeNotIn(List<Byte> values) {
            addCriterion("hc_type not in", values, "hcType");
            return (Criteria) this;
        }

        public Criteria andHcTypeBetween(Byte value1, Byte value2) {
            addCriterion("hc_type between", value1, value2, "hcType");
            return (Criteria) this;
        }

        public Criteria andHcTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("hc_type not between", value1, value2, "hcType");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(Byte value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(Byte value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(Byte value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(Byte value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(Byte value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(Byte value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<Byte> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<Byte> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(Byte value1, Byte value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(Byte value1, Byte value2) {
            addCriterion("unit not between", value1, value2, "unit");
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

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
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

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andModifiedTimeIsNull() {
            addCriterion("modified_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNotNull() {
            addCriterion("modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeEqualTo(Date value) {
            addCriterion("modified_time =", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotEqualTo(Date value) {
            addCriterion("modified_time <>", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThan(Date value) {
            addCriterion("modified_time >", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modified_time >=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThan(Date value) {
            addCriterion("modified_time <", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("modified_time <=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIn(List<Date> values) {
            addCriterion("modified_time in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotIn(List<Date> values) {
            addCriterion("modified_time not in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("modified_time between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("modified_time not between", value1, value2, "modifiedTime");
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