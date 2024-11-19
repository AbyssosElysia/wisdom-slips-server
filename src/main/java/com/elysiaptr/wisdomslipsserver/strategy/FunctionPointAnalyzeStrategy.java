package com.elysiaptr.wisdomslipsserver.strategy;

import com.elysiaptr.wisdomslipsserver.entity.FunctionPoint;

import java.util.List;
import java.util.Map;

/**
 * 功能点分析方法策略
 *
 * @author ElysiaPtr
 */
public interface FunctionPointAnalyzeStrategy {
    /**
     * 执行方法
     *
     * @param project        项目信息
     * @param functionPoints 功能点
     * @return 一个List，包含两项，第一项为各分子系统信息，第二项为总系统的信息
     */
    Map<Long, Integer> process(Project project, List<FunctionPoint> functionPoints);
}
