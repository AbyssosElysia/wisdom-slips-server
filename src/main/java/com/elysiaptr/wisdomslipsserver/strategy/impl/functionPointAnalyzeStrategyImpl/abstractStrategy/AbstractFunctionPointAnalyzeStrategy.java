package com.elysiaptr.wisdomslipsserver.strategy.impl.functionPointAnalyzeStrategyImpl.abstractStrategy;

import com.elysiaptr.wisdomslipsserver.entity.FunctionPoint;
import com.elysiaptr.wisdomslipsserver.entity.Project;
import com.elysiaptr.wisdomslipsserver.factory.UfpEntityFactory;
import com.elysiaptr.wisdomslipsserver.strategy.FunctionPointAnalyzeStrategy;
import com.elysiaptr.wisdomslipsserver.utils.FunctionPointAnalyzeAlgorithmUtil;

import java.util.List;
import java.util.Map;

/**
 * 抽象功能点计算策略，对数据进行预处理
 *
 * @author ElysiaPtr
 */
public abstract class AbstractFunctionPointAnalyzeStrategy implements FunctionPointAnalyzeStrategy {
    /**
     * 抽象函数，对数据进行预处理
     *
     * @param project        项目
     * @param functionPoints 功能点
     * @return 子系统ufp列表
     */
    protected Map<Long, Integer> extractSubsystemUfp(Project project, List<FunctionPoint> functionPoints) {
        Map<Long, Integer[]> subsystemUfpList = FunctionPointAnalyzeAlgorithmUtil.getSubsystemUfpList(functionPoints);
        Integer[] ufpList = subsystemUfpList.get(-1L);
        project.setIlf(ufpList[0]);
        project.setEif(ufpList[1]);
        project.setEi(ufpList[2]);
        project.setEo(ufpList[3]);
        project.setEq(ufpList[4]);

        Map<Long, Integer> subsystemUfp = FunctionPointAnalyzeAlgorithmUtil.getSubsystemUfp(subsystemUfpList,
                UfpEntityFactory.createUfpEntity(project.getComplexity()));
        project.setUfp(Double.valueOf(subsystemUfp.get(-1L)));

        return subsystemUfp;
    }
}
