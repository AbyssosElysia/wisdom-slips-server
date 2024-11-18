package com.elysiaptr.wisdomslipsserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 功能点
 * @TableName function_point
 */
@TableName(value ="function_point")
@Data
public class FunctionPoint implements Serializable {
    /**
     * 历史数据id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 对应项目id
     */
    private Long projectId;

    /**
     * 所属子系统id
     */
    private Long subsystemId;

    /**
     * 是否删除：0=未删除，1=已删除
     */
    private Integer ifDelete;

    /**
     * 删除时间：如果删除时间超过3个月，自动清理
     */
    private Date deleteTime;

    /**
     * 所属模块名
     */
    private String module;

    /**
     * 功能点名
     */
    private String name;

    /**
     * 功能点描述
     */
    private String description;

    /**
     * 分类
     */
    private String category;

    /**
     * 对应ufp
     */
    private Integer ufp;

    /**
     * 复杂度：1=低，2=中，3=高
     */
    private Integer complexity;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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
        FunctionPoint other = (FunctionPoint) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getSubsystemId() == null ? other.getSubsystemId() == null : this.getSubsystemId().equals(other.getSubsystemId()))
            && (this.getIfDelete() == null ? other.getIfDelete() == null : this.getIfDelete().equals(other.getIfDelete()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()))
            && (this.getModule() == null ? other.getModule() == null : this.getModule().equals(other.getModule()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
            && (this.getUfp() == null ? other.getUfp() == null : this.getUfp().equals(other.getUfp()))
            && (this.getComplexity() == null ? other.getComplexity() == null : this.getComplexity().equals(other.getComplexity()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getSubsystemId() == null) ? 0 : getSubsystemId().hashCode());
        result = prime * result + ((getIfDelete() == null) ? 0 : getIfDelete().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        result = prime * result + ((getModule() == null) ? 0 : getModule().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
        result = prime * result + ((getUfp() == null) ? 0 : getUfp().hashCode());
        result = prime * result + ((getComplexity() == null) ? 0 : getComplexity().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectId=").append(projectId);
        sb.append(", subsystemId=").append(subsystemId);
        sb.append(", ifDelete=").append(ifDelete);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", module=").append(module);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", category=").append(category);
        sb.append(", ufp=").append(ufp);
        sb.append(", complexity=").append(complexity);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}