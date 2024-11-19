package com.elysiaptr.wisdomslipsserver.strategy.impl.functionPointAnalyzeStrategyImpl;

import com.elysiaptr.wisdomslipsserver.entity.FunctionPoint;
import com.elysiaptr.wisdomslipsserver.entity.Project;
import com.elysiaptr.wisdomslipsserver.strategy.FunctionPointAnalyzeStrategy;

import java.util.List;
import java.util.Map;

/**
 * 通用系统调整因子法DFP
 *
 * @author ElysiaPtr
 */
public class GeneralSystemAdjustmentFactorMethod implements FunctionPointAnalyzeStrategy {
    public List<Map<Long, Double>> process(Project project, List<FunctionPoint> functionPoints) {
        // 遍历所有功能点，以子系统为键，提取相应操作个数
        for (FunctionPoint functionPoint : functionPoints) {
            continue;
        }
        return List.of();
    }
}
