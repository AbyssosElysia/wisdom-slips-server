package com.elysiaptr.wisdomslipsserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.elysiaptr.wisdomslipsserver.entity.FunctionPoint;
import com.elysiaptr.wisdomslipsserver.entity.Project;
import com.elysiaptr.wisdomslipsserver.entity.Subsystem;
import com.elysiaptr.wisdomslipsserver.factory.FunctionPointAnalyzeStrategyFactory;
import com.elysiaptr.wisdomslipsserver.mapper.FunctionPointMapper;
import com.elysiaptr.wisdomslipsserver.mapper.ProjectMapper;
import com.elysiaptr.wisdomslipsserver.mapper.SubsystemMapper;
import com.elysiaptr.wisdomslipsserver.service.AnalyzeService;
import com.elysiaptr.wisdomslipsserver.strategy.FunctionPointAnalyzeStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分析服务实现
 *
 * @author ElysiaPtr
 */
@Service
public class AnalyzeServiceImpl implements AnalyzeService {
    @Autowired
    FunctionPointMapper functionPointMapper;

    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    SubsystemMapper subsystemMapper;

    @Transactional
    public void doAnalyze(Project requestProject) {
        // 查找子系统
        QueryWrapper<Subsystem> subsystemQueryWrapper = new QueryWrapper<>();
        subsystemQueryWrapper.eq("project_id", requestProject.getId());
        List<Subsystem> subsystems = subsystemMapper.selectList(subsystemQueryWrapper);

        // 查找功能点
        QueryWrapper<FunctionPoint> functionPointQueryWrapper = new QueryWrapper<>();
        functionPointQueryWrapper.eq("project_id", requestProject.getId());
        List<FunctionPoint> functionPoints = functionPointMapper.selectList(functionPointQueryWrapper);

        // 查找项目
        Project project = projectMapper.selectById(requestProject.getId());

        // 进行两次策略计算
        FunctionPointAnalyzeStrategy generalSystemAdjustmentFactorMethod = FunctionPointAnalyzeStrategyFactory.getFunctionPointAnalyzeStrategy(1);
        generalSystemAdjustmentFactorMethod.process(project, functionPoints);

        FunctionPointAnalyzeStrategy demandChangeAdjustmentFactorMethod = FunctionPointAnalyzeStrategyFactory.getFunctionPointAnalyzeStrategy(2);
        Map<Long, Integer> subSystemUfp = demandChangeAdjustmentFactorMethod.process(project, functionPoints);

        // 将子系统ID映射到子系统对象，以提高性能
        Map<Long, Subsystem> subsystemMap = subsystems.stream()
                .collect(Collectors.toMap(Subsystem::getId, subsystem -> subsystem));

        // 更新子系统的UFP值
        for (Map.Entry<Long, Integer> entry : subSystemUfp.entrySet()) {
            Long subsystemId = entry.getKey();
            Integer subsystemUfp = entry.getValue();

            Subsystem subsystem = subsystemMap.get(subsystemId);
            if (subsystem != null) {
                subsystem.setUfp(subsystemUfp);
                // 更新subsystem数据库
                subsystemMapper.updateById(subsystem);
            }
        }
        // 更新project数据库
        projectMapper.updateById(project);

    }
}
