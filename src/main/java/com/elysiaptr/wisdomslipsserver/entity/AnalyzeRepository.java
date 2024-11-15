package com.elysiaptr.wisdomslipsserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 保存分析历史
 * @TableName analyze_repository
 */
@TableName(value ="analyze_repository")
@Data
public class AnalyzeRepository implements Serializable {
    /**
     * 查询历史id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 内部逻辑文件
     */
    private Integer ilf;

    /**
     * 外部接口文件
     */
    private Integer eif;

    /**
     * 外部输入
     */
    private Integer ei;

    /**
     * 外部输出
     */
    private Integer eo;

    /**
     * 外部查询
     */
    private Integer eq;

    /**
     * 综合系统特征
     */
    private Integer gsc;

    /**
     * 调整系数值
     */
    private Double vaf;

    /**
     * 答案
     */
    private Double answer;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人
     */
    private Long updateBy;

    /**
     * 是否删除：0=未删除，1=已删除
     */
    private Integer ifDelete;

    /**
     * 删除时间：如果删除时间超过3个月，自动清理
     */
    private Date deleteTime;

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
        AnalyzeRepository other = (AnalyzeRepository) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIlf() == null ? other.getIlf() == null : this.getIlf().equals(other.getIlf()))
            && (this.getEif() == null ? other.getEif() == null : this.getEif().equals(other.getEif()))
            && (this.getEi() == null ? other.getEi() == null : this.getEi().equals(other.getEi()))
            && (this.getEo() == null ? other.getEo() == null : this.getEo().equals(other.getEo()))
            && (this.getEq() == null ? other.getEq() == null : this.getEq().equals(other.getEq()))
            && (this.getGsc() == null ? other.getGsc() == null : this.getGsc().equals(other.getGsc()))
            && (this.getVaf() == null ? other.getVaf() == null : this.getVaf().equals(other.getVaf()))
            && (this.getAnswer() == null ? other.getAnswer() == null : this.getAnswer().equals(other.getAnswer()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getIfDelete() == null ? other.getIfDelete() == null : this.getIfDelete().equals(other.getIfDelete()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIlf() == null) ? 0 : getIlf().hashCode());
        result = prime * result + ((getEif() == null) ? 0 : getEif().hashCode());
        result = prime * result + ((getEi() == null) ? 0 : getEi().hashCode());
        result = prime * result + ((getEo() == null) ? 0 : getEo().hashCode());
        result = prime * result + ((getEq() == null) ? 0 : getEq().hashCode());
        result = prime * result + ((getGsc() == null) ? 0 : getGsc().hashCode());
        result = prime * result + ((getVaf() == null) ? 0 : getVaf().hashCode());
        result = prime * result + ((getAnswer() == null) ? 0 : getAnswer().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getIfDelete() == null) ? 0 : getIfDelete().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ilf=").append(ilf);
        sb.append(", eif=").append(eif);
        sb.append(", ei=").append(ei);
        sb.append(", eo=").append(eo);
        sb.append(", eq=").append(eq);
        sb.append(", gsc=").append(gsc);
        sb.append(", vaf=").append(vaf);
        sb.append(", answer=").append(answer);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", ifDelete=").append(ifDelete);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}