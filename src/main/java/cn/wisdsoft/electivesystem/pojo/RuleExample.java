package cn.wisdsoft.electivesystem.pojo;

import java.util.ArrayList;
import java.util.List;

public class RuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RuleExample() {
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

        public Criteria andSelectIdIsNull() {
            addCriterion("select_id is null");
            return (Criteria) this;
        }

        public Criteria andSelectIdIsNotNull() {
            addCriterion("select_id is not null");
            return (Criteria) this;
        }

        public Criteria andSelectIdEqualTo(Integer value) {
            addCriterion("select_id =", value, "selectId");
            return (Criteria) this;
        }

        public Criteria andSelectIdNotEqualTo(Integer value) {
            addCriterion("select_id <>", value, "selectId");
            return (Criteria) this;
        }

        public Criteria andSelectIdGreaterThan(Integer value) {
            addCriterion("select_id >", value, "selectId");
            return (Criteria) this;
        }

        public Criteria andSelectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("select_id >=", value, "selectId");
            return (Criteria) this;
        }

        public Criteria andSelectIdLessThan(Integer value) {
            addCriterion("select_id <", value, "selectId");
            return (Criteria) this;
        }

        public Criteria andSelectIdLessThanOrEqualTo(Integer value) {
            addCriterion("select_id <=", value, "selectId");
            return (Criteria) this;
        }

        public Criteria andSelectIdIn(List<Integer> values) {
            addCriterion("select_id in", values, "selectId");
            return (Criteria) this;
        }

        public Criteria andSelectIdNotIn(List<Integer> values) {
            addCriterion("select_id not in", values, "selectId");
            return (Criteria) this;
        }

        public Criteria andSelectIdBetween(Integer value1, Integer value2) {
            addCriterion("select_id between", value1, value2, "selectId");
            return (Criteria) this;
        }

        public Criteria andSelectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("select_id not between", value1, value2, "selectId");
            return (Criteria) this;
        }

        public Criteria andUsualIsNull() {
            addCriterion("usual is null");
            return (Criteria) this;
        }

        public Criteria andUsualIsNotNull() {
            addCriterion("usual is not null");
            return (Criteria) this;
        }

        public Criteria andUsualEqualTo(Integer value) {
            addCriterion("usual =", value, "usual");
            return (Criteria) this;
        }

        public Criteria andUsualNotEqualTo(Integer value) {
            addCriterion("usual <>", value, "usual");
            return (Criteria) this;
        }

        public Criteria andUsualGreaterThan(Integer value) {
            addCriterion("usual >", value, "usual");
            return (Criteria) this;
        }

        public Criteria andUsualGreaterThanOrEqualTo(Integer value) {
            addCriterion("usual >=", value, "usual");
            return (Criteria) this;
        }

        public Criteria andUsualLessThan(Integer value) {
            addCriterion("usual <", value, "usual");
            return (Criteria) this;
        }

        public Criteria andUsualLessThanOrEqualTo(Integer value) {
            addCriterion("usual <=", value, "usual");
            return (Criteria) this;
        }

        public Criteria andUsualIn(List<Integer> values) {
            addCriterion("usual in", values, "usual");
            return (Criteria) this;
        }

        public Criteria andUsualNotIn(List<Integer> values) {
            addCriterion("usual not in", values, "usual");
            return (Criteria) this;
        }

        public Criteria andUsualBetween(Integer value1, Integer value2) {
            addCriterion("usual between", value1, value2, "usual");
            return (Criteria) this;
        }

        public Criteria andUsualNotBetween(Integer value1, Integer value2) {
            addCriterion("usual not between", value1, value2, "usual");
            return (Criteria) this;
        }

        public Criteria andMidtermIsNull() {
            addCriterion("midterm is null");
            return (Criteria) this;
        }

        public Criteria andMidtermIsNotNull() {
            addCriterion("midterm is not null");
            return (Criteria) this;
        }

        public Criteria andMidtermEqualTo(Integer value) {
            addCriterion("midterm =", value, "midterm");
            return (Criteria) this;
        }

        public Criteria andMidtermNotEqualTo(Integer value) {
            addCriterion("midterm <>", value, "midterm");
            return (Criteria) this;
        }

        public Criteria andMidtermGreaterThan(Integer value) {
            addCriterion("midterm >", value, "midterm");
            return (Criteria) this;
        }

        public Criteria andMidtermGreaterThanOrEqualTo(Integer value) {
            addCriterion("midterm >=", value, "midterm");
            return (Criteria) this;
        }

        public Criteria andMidtermLessThan(Integer value) {
            addCriterion("midterm <", value, "midterm");
            return (Criteria) this;
        }

        public Criteria andMidtermLessThanOrEqualTo(Integer value) {
            addCriterion("midterm <=", value, "midterm");
            return (Criteria) this;
        }

        public Criteria andMidtermIn(List<Integer> values) {
            addCriterion("midterm in", values, "midterm");
            return (Criteria) this;
        }

        public Criteria andMidtermNotIn(List<Integer> values) {
            addCriterion("midterm not in", values, "midterm");
            return (Criteria) this;
        }

        public Criteria andMidtermBetween(Integer value1, Integer value2) {
            addCriterion("midterm between", value1, value2, "midterm");
            return (Criteria) this;
        }

        public Criteria andMidtermNotBetween(Integer value1, Integer value2) {
            addCriterion("midterm not between", value1, value2, "midterm");
            return (Criteria) this;
        }

        public Criteria andSkillIsNull() {
            addCriterion("skill is null");
            return (Criteria) this;
        }

        public Criteria andSkillIsNotNull() {
            addCriterion("skill is not null");
            return (Criteria) this;
        }

        public Criteria andSkillEqualTo(Integer value) {
            addCriterion("skill =", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillNotEqualTo(Integer value) {
            addCriterion("skill <>", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillGreaterThan(Integer value) {
            addCriterion("skill >", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillGreaterThanOrEqualTo(Integer value) {
            addCriterion("skill >=", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillLessThan(Integer value) {
            addCriterion("skill <", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillLessThanOrEqualTo(Integer value) {
            addCriterion("skill <=", value, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillIn(List<Integer> values) {
            addCriterion("skill in", values, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillNotIn(List<Integer> values) {
            addCriterion("skill not in", values, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillBetween(Integer value1, Integer value2) {
            addCriterion("skill between", value1, value2, "skill");
            return (Criteria) this;
        }

        public Criteria andSkillNotBetween(Integer value1, Integer value2) {
            addCriterion("skill not between", value1, value2, "skill");
            return (Criteria) this;
        }

        public Criteria andFinalexamIsNull() {
            addCriterion("finalexam is null");
            return (Criteria) this;
        }

        public Criteria andFinalexamIsNotNull() {
            addCriterion("finalexam is not null");
            return (Criteria) this;
        }

        public Criteria andFinalexamEqualTo(Integer value) {
            addCriterion("finalexam =", value, "finalexam");
            return (Criteria) this;
        }

        public Criteria andFinalexamNotEqualTo(Integer value) {
            addCriterion("finalexam <>", value, "finalexam");
            return (Criteria) this;
        }

        public Criteria andFinalexamGreaterThan(Integer value) {
            addCriterion("finalexam >", value, "finalexam");
            return (Criteria) this;
        }

        public Criteria andFinalexamGreaterThanOrEqualTo(Integer value) {
            addCriterion("finalexam >=", value, "finalexam");
            return (Criteria) this;
        }

        public Criteria andFinalexamLessThan(Integer value) {
            addCriterion("finalexam <", value, "finalexam");
            return (Criteria) this;
        }

        public Criteria andFinalexamLessThanOrEqualTo(Integer value) {
            addCriterion("finalexam <=", value, "finalexam");
            return (Criteria) this;
        }

        public Criteria andFinalexamIn(List<Integer> values) {
            addCriterion("finalexam in", values, "finalexam");
            return (Criteria) this;
        }

        public Criteria andFinalexamNotIn(List<Integer> values) {
            addCriterion("finalexam not in", values, "finalexam");
            return (Criteria) this;
        }

        public Criteria andFinalexamBetween(Integer value1, Integer value2) {
            addCriterion("finalexam between", value1, value2, "finalexam");
            return (Criteria) this;
        }

        public Criteria andFinalexamNotBetween(Integer value1, Integer value2) {
            addCriterion("finalexam not between", value1, value2, "finalexam");
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