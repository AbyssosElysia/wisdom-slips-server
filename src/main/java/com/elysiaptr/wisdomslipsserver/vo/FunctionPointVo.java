package com.elysiaptr.wisdomslipsserver.vo;

import lombok.Data;

@Data
public class FunctionPointVo {
    /**
     * 子系统id
     */
    private Integer subsystemId;

    /**
     * 所属子系统名
     */
    private String subsystemName;

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
     * 备注
     */
    private String remark;
}
