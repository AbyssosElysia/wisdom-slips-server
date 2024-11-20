package com.elysiaptr.wisdomslipsserver.strategy.impl.functionPointAnalyzeStrategyImpl;

import com.elysiaptr.wisdomslipsserver.entity.FunctionPoint;
import com.elysiaptr.wisdomslipsserver.entity.Project;
import com.elysiaptr.wisdomslipsserver.factory.StageFactory;
import com.elysiaptr.wisdomslipsserver.strategy.impl.functionPointAnalyzeStrategyImpl.abstractStrategy.AbstractFunctionPointAnalyzeStrategy;

import java.util.List;
import java.util.Map;

/**
 * 需求变更调整因子法S
 *
 * @author ElysiaPtr
 */
public class DemandChangeAdjustmentFactorMethod extends AbstractFunctionPointAnalyzeStrategy {

    public Map<Long, Integer> process(Project project, List<FunctionPoint> functionPoints) {
        // 数据预处理
        Map<Long, Integer> subsystemUfp = extractSubsystemUfp(project, functionPoints);

        // 获取cf
        double cf = StageFactory.getStageFactory(project.getStage());
        project.setCf(cf);

        // 计算dfp
        project.setS(cf * project.getUfp());

        return subsystemUfp;
    }
}
