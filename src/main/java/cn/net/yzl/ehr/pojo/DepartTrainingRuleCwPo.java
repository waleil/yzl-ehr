package cn.net.yzl.ehr.pojo;

import java.io.Serializable;

/**
 * depart_training_rule_cw
 * @author 
 */
public class DepartTrainingRuleCwPo implements Serializable {
    /**
     * 唯一标识
     */
    private Integer id;

    /**
     * 培训规则no
     */
    private Integer trainingRuleId;

    /**
     * 课件表no 外键
     */
    private Integer coursewareId;

    /**
     * 是否删除 0删除 1正常
     */
    private Byte isDel;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrainingRuleId() {
        return trainingRuleId;
    }

    public void setTrainingRuleId(Integer trainingRuleId) {
        this.trainingRuleId = trainingRuleId;
    }

    public Integer getCoursewareId() {
        return coursewareId;
    }

    public void setCoursewareId(Integer coursewareId) {
        this.coursewareId = coursewareId;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        DepartTrainingRuleCwPo other = (DepartTrainingRuleCwPo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTrainingRuleId() == null ? other.getTrainingRuleId() == null : this.getTrainingRuleId().equals(other.getTrainingRuleId()))
            && (this.getCoursewareId() == null ? other.getCoursewareId() == null : this.getCoursewareId().equals(other.getCoursewareId()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTrainingRuleId() == null) ? 0 : getTrainingRuleId().hashCode());
        result = prime * result + ((getCoursewareId() == null) ? 0 : getCoursewareId().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", trainingRuleId=").append(trainingRuleId);
        sb.append(", coursewareId=").append(coursewareId);
        sb.append(", isDel=").append(isDel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}