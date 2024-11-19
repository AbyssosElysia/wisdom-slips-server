package com.elysiaptr.wisdomslipsserver.strategy.impl.functionPointAnalyzeStrategyImpl;

import com.elysiaptr.wisdomslipsserver.entity.FunctionPoint;
import com.elysiaptr.wisdomslipsserver.entity.Project;
import com.elysiaptr.wisdomslipsserver.strategy.FunctionPointAnalyzeStrategy;

import java.util.List;
import java.util.Map;

/**
 * 需求变更调整因子法S
 *
 * @author ElysiaPtr
 */
public class DemandChangeAdjustmentFactorMethod implements FunctionPointAnalyzeStrategy {
    public List<Map<Long, Double>> process(Project project, List<FunctionPoint> functionPoints) {
        return List.of();
    }
}
