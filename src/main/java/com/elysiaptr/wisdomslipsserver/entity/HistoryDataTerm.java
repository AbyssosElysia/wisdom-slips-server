package com.elysiaptr.wisdomslipsserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 历史数据条目
 * @TableName history_data_term
 */
@TableName(value ="history_data_term")
@Data
public class HistoryDataTerm implements Serializable {
    /**
     * 历史数据id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 对应历史id
     */
    private Long historyId;

    /**
     * 是否删除：0=未删除，1=已删除
     */
    private Integer ifDelete;

    /**
     * 删除时间：如果删除时间超过3个月，自动清理
     */
    private Date deleteTime;

    /**
     * 删除者id
     */
    private Long deleteBy;

    /**
     * 所属子系统名
     */
    private String subsystem;

    /**
     * 所属模块名
     */
    private String module;

    /**
     * 功能点项名
     */
    private String pointTerm;

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
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新者
     */
    private Long updateBy;

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
        HistoryDataTerm other = (HistoryDataTerm) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHistoryId() == null ? other.getHistoryId() == null : this.getHistoryId().equals(other.getHistoryId()))
            && (this.getIfDelete() == null ? other.getIfDelete() == null : this.getIfDelete().equals(other.getIfDelete()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()))
            && (this.getDeleteBy() == null ? other.getDeleteBy() == null : this.getDeleteBy().equals(other.getDeleteBy()))
            && (this.getSubsystem() == null ? other.getSubsystem() == null : this.getSubsystem().equals(other.getSubsystem()))
            && (this.getModule() == null ? other.getModule() == null : this.getModule().equals(other.getModule()))
            && (this.getPointTerm() == null ? other.getPointTerm() == null : this.getPointTerm().equals(other.getPointTerm()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
            && (this.getUfp() == null ? other.getUfp() == null : this.getUfp().equals(other.getUfp()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHistoryId() == null) ? 0 : getHistoryId().hashCode());
        result = prime * result + ((getIfDelete() == null) ? 0 : getIfDelete().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        result = prime * result + ((getDeleteBy() == null) ? 0 : getDeleteBy().hashCode());
        result = prime * result + ((getSubsystem() == null) ? 0 : getSubsystem().hashCode());
        result = prime * result + ((getModule() == null) ? 0 : getModule().hashCode());
        result = prime * result + ((getPointTerm() == null) ? 0 : getPointTerm().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
        result = prime * result + ((getUfp() == null) ? 0 : getUfp().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
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
        sb.append(", historyId=").append(historyId);
        sb.append(", ifDelete=").append(ifDelete);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", deleteBy=").append(deleteBy);
        sb.append(", subsystem=").append(subsystem);
        sb.append(", module=").append(module);
        sb.append(", pointTerm=").append(pointTerm);
        sb.append(", description=").append(description);
        sb.append(", category=").append(category);
        sb.append(", ufp=").append(ufp);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}