package com.elysiaptr.wisdomslipsserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 项目分析
 * @TableName project
 */
@TableName(value ="project")
@Data
public class Project implements Serializable {
    /**
     * 查询历史id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 项目名
     */
    private String name;

    /**
     * 对应用户id
     */
    private Long userId;

    /**
     * 是否删除：0=未删除，1=已删除
     */
    private Integer ifDelete;

    /**
     * 删除时间：如果删除时间超过3个月，自动清理
     */
    private Date deleteTime;

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
     * 数据通信
     */
    private Integer gscDc;

    /**
     * 分布式数据处理
     */
    private Integer gscDdp;

    /**
     * 性能
     */
    private Integer gscP;

    /**
     * 重度配置
     */
    private Integer gscHuc;

    /**
     * 处理速率
     */
    private Integer gscTr;

    /**
     * 在线数据输入
     */
    private Integer gscOde;

    /**
     * 最终用户使用效率
     */
    private Integer gscEue;

    /**
     * 在线升级
     */
    private Integer gscOu;

    /**
     * 复杂处理
     */
    private Integer gscCp;

    /**
     * 可重用性
     */
    private Integer gscR;

    /**
     * 易安装性
     */
    private Integer gscIe;

    /**
     * 易操作性
     */
    private Integer gscOe;

    /**
     * 多场所
     */
    private Integer gscMs;

    /**
     * 支持变更
     */
    private Integer gscFc;

    /**
     * 综合系统特征
     */
    private Integer diSum;

    /**
     * 调整系数值
     */
    private Double vaf;

    /**
     * 规模变更调整因子
     */
    private Double cf;

    /**
     * 复杂度：1=低，2=中，3=高
     */
    private Integer complexity;

    /**
     * 状态：1=项目立项，2=项目招标，3=项目早期，4=项目中期，5=项目完成
     */
    private Integer stage;

    /**
     * 方法：1=dfp，2=s
     */
    private Integer method;

    /**
     * 未调整功能点数
     */
    private Double ufp;

    /**
     * 调整后功能点数（通用系统调整因子法）
     */
    private Double dfp;

    /**
     * 调整后功能点数（需求变更调整因子法）
     */
    private Double s;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
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
        Project other = (Project) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getIfDelete() == null ? other.getIfDelete() == null : this.getIfDelete().equals(other.getIfDelete()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()))
            && (this.getIlf() == null ? other.getIlf() == null : this.getIlf().equals(other.getIlf()))
            && (this.getEif() == null ? other.getEif() == null : this.getEif().equals(other.getEif()))
            && (this.getEi() == null ? other.getEi() == null : this.getEi().equals(other.getEi()))
            && (this.getEo() == null ? other.getEo() == null : this.getEo().equals(other.getEo()))
            && (this.getEq() == null ? other.getEq() == null : this.getEq().equals(other.getEq()))
            && (this.getGscDc() == null ? other.getGscDc() == null : this.getGscDc().equals(other.getGscDc()))
            && (this.getGscDdp() == null ? other.getGscDdp() == null : this.getGscDdp().equals(other.getGscDdp()))
            && (this.getGscP() == null ? other.getGscP() == null : this.getGscP().equals(other.getGscP()))
            && (this.getGscHuc() == null ? other.getGscHuc() == null : this.getGscHuc().equals(other.getGscHuc()))
            && (this.getGscTr() == null ? other.getGscTr() == null : this.getGscTr().equals(other.getGscTr()))
            && (this.getGscOde() == null ? other.getGscOde() == null : this.getGscOde().equals(other.getGscOde()))
            && (this.getGscEue() == null ? other.getGscEue() == null : this.getGscEue().equals(other.getGscEue()))
            && (this.getGscOu() == null ? other.getGscOu() == null : this.getGscOu().equals(other.getGscOu()))
            && (this.getGscCp() == null ? other.getGscCp() == null : this.getGscCp().equals(other.getGscCp()))
            && (this.getGscR() == null ? other.getGscR() == null : this.getGscR().equals(other.getGscR()))
            && (this.getGscIe() == null ? other.getGscIe() == null : this.getGscIe().equals(other.getGscIe()))
            && (this.getGscOe() == null ? other.getGscOe() == null : this.getGscOe().equals(other.getGscOe()))
            && (this.getGscMs() == null ? other.getGscMs() == null : this.getGscMs().equals(other.getGscMs()))
            && (this.getGscFc() == null ? other.getGscFc() == null : this.getGscFc().equals(other.getGscFc()))
            && (this.getDiSum() == null ? other.getDiSum() == null : this.getDiSum().equals(other.getDiSum()))
            && (this.getVaf() == null ? other.getVaf() == null : this.getVaf().equals(other.getVaf()))
            && (this.getCf() == null ? other.getCf() == null : this.getCf().equals(other.getCf()))
            && (this.getComplexity() == null ? other.getComplexity() == null : this.getComplexity().equals(other.getComplexity()))
            && (this.getStage() == null ? other.getStage() == null : this.getStage().equals(other.getStage()))
            && (this.getMethod() == null ? other.getMethod() == null : this.getMethod().equals(other.getMethod()))
            && (this.getUfp() == null ? other.getUfp() == null : this.getUfp().equals(other.getUfp()))
            && (this.getDfp() == null ? other.getDfp() == null : this.getDfp().equals(other.getDfp()))
            && (this.getS() == null ? other.getS() == null : this.getS().equals(other.getS()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getIfDelete() == null) ? 0 : getIfDelete().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        result = prime * result + ((getIlf() == null) ? 0 : getIlf().hashCode());
        result = prime * result + ((getEif() == null) ? 0 : getEif().hashCode());
        result = prime * result + ((getEi() == null) ? 0 : getEi().hashCode());
        result = prime * result + ((getEo() == null) ? 0 : getEo().hashCode());
        result = prime * result + ((getEq() == null) ? 0 : getEq().hashCode());
        result = prime * result + ((getGscDc() == null) ? 0 : getGscDc().hashCode());
        result = prime * result + ((getGscDdp() == null) ? 0 : getGscDdp().hashCode());
        result = prime * result + ((getGscP() == null) ? 0 : getGscP().hashCode());
        result = prime * result + ((getGscHuc() == null) ? 0 : getGscHuc().hashCode());
        result = prime * result + ((getGscTr() == null) ? 0 : getGscTr().hashCode());
        result = prime * result + ((getGscOde() == null) ? 0 : getGscOde().hashCode());
        result = prime * result + ((getGscEue() == null) ? 0 : getGscEue().hashCode());
        result = prime * result + ((getGscOu() == null) ? 0 : getGscOu().hashCode());
        result = prime * result + ((getGscCp() == null) ? 0 : getGscCp().hashCode());
        result = prime * result + ((getGscR() == null) ? 0 : getGscR().hashCode());
        result = prime * result + ((getGscIe() == null) ? 0 : getGscIe().hashCode());
        result = prime * result + ((getGscOe() == null) ? 0 : getGscOe().hashCode());
        result = prime * result + ((getGscMs() == null) ? 0 : getGscMs().hashCode());
        result = prime * result + ((getGscFc() == null) ? 0 : getGscFc().hashCode());
        result = prime * result + ((getDiSum() == null) ? 0 : getDiSum().hashCode());
        result = prime * result + ((getVaf() == null) ? 0 : getVaf().hashCode());
        result = prime * result + ((getCf() == null) ? 0 : getCf().hashCode());
        result = prime * result + ((getComplexity() == null) ? 0 : getComplexity().hashCode());
        result = prime * result + ((getStage() == null) ? 0 : getStage().hashCode());
        result = prime * result + ((getMethod() == null) ? 0 : getMethod().hashCode());
        result = prime * result + ((getUfp() == null) ? 0 : getUfp().hashCode());
        result = prime * result + ((getDfp() == null) ? 0 : getDfp().hashCode());
        result = prime * result + ((getS() == null) ? 0 : getS().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", userId=").append(userId);
        sb.append(", ifDelete=").append(ifDelete);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", ilf=").append(ilf);
        sb.append(", eif=").append(eif);
        sb.append(", ei=").append(ei);
        sb.append(", eo=").append(eo);
        sb.append(", eq=").append(eq);
        sb.append(", gscDc=").append(gscDc);
        sb.append(", gscDdp=").append(gscDdp);
        sb.append(", gscP=").append(gscP);
        sb.append(", gscHuc=").append(gscHuc);
        sb.append(", gscTr=").append(gscTr);
        sb.append(", gscOde=").append(gscOde);
        sb.append(", gscEue=").append(gscEue);
        sb.append(", gscOu=").append(gscOu);
        sb.append(", gscCp=").append(gscCp);
        sb.append(", gscR=").append(gscR);
        sb.append(", gscIe=").append(gscIe);
        sb.append(", gscOe=").append(gscOe);
        sb.append(", gscMs=").append(gscMs);
        sb.append(", gscFc=").append(gscFc);
        sb.append(", diSum=").append(diSum);
        sb.append(", vaf=").append(vaf);
        sb.append(", cf=").append(cf);
        sb.append(", complexity=").append(complexity);
        sb.append(", stage=").append(stage);
        sb.append(", method=").append(method);
        sb.append(", ufp=").append(ufp);
        sb.append(", dfp=").append(dfp);
        sb.append(", s=").append(s);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}