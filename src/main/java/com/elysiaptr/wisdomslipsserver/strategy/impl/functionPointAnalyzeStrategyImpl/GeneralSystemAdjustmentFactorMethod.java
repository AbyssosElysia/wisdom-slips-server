package com.elysiaptr.wisdomslipsserver.strategy.impl.functionPointAnalyzeStrategyImpl;

import com.elysiaptr.wisdomslipsserver.entity.FunctionPoint;
import com.elysiaptr.wisdomslipsserver.entity.Project;
import com.elysiaptr.wisdomslipsserver.strategy.impl.functionPointAnalyzeStrategyImpl.abstractStrategy.AbstractFunctionPointAnalyzeStrategy;

import java.util.List;
import java.util.Map;

/**
 * 通用系统调整因子法DFP
 *
 * @author ElysiaPtr
 */
public class GeneralSystemAdjustmentFactorMethod extends AbstractFunctionPointAnalyzeStrategy {
    public Map<Long, Integer> process(Project project, List<FunctionPoint> functionPoints) {
        // 数据预处理
        Map<Long, Integer> subsystemUfp = extractSubsystemUfp(project, functionPoints);

        // 获取di和
        int di_sum = project.getGscDc() + project.getGscDdp() + project.getGscP() + project.getGscHuc() +
                project.getGscTr() + project.getGscOde() + project.getGscEue() + project.getGscOu() +
                project.getGscCp() + project.getGscR() + project.getGscIe() + project.getGscOe() +
                project.getGscMs() + project.getGscFc();
        project.setDiSum(di_sum);

        // 获取vaf
        double vaf = (di_sum * 0.01) + 0.65;
        project.setVaf(vaf);

        // 计算dfp
        project.setDfp(vaf * project.getUfp());

        return subsystemUfp;
    }
}
