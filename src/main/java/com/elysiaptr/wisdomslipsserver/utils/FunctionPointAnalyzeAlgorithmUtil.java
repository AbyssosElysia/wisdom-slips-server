package com.elysiaptr.wisdomslipsserver.utils;

import com.elysiaptr.wisdomslipsserver.constant.ErrorConstant;
import com.elysiaptr.wisdomslipsserver.entity.FunctionPoint;
import com.elysiaptr.wisdomslipsserver.exception.WrongArgsException;
import com.elysiaptr.wisdomslipsserver.factory.UfpEntityFactory;
import com.elysiaptr.wisdomslipsserver.factory.entity.UfpEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能点分析法通用工具类
 *
 * @author ElysiaPtr
 */
public class FunctionPointAnalyzeAlgorithmUtil {
    /**
     * 计算子系统的各功能点数组
     *
     * @param functionPoints 功能点
     * @return 各子系统功能点计数，key=-1时为总系统计数
     * long是子系统id，integer数组是ufp数组
     */
    public static Map<Long, Integer[]> getSubsystemUfpList(List<FunctionPoint> functionPoints) {
        // 新建查询表第一项为子系统id，第二项为category计数，category最后一列是复杂度
        Map<Long, Integer[]> result = new HashMap<>();
        Integer[] projectCategoryCount = new Integer[]{0, 0, 0, 0, 0, 2};  // 复杂度中

        // 遍历功能点
        for (FunctionPoint functionPoint : functionPoints) {
            Integer[] categoryCount = result.getOrDefault(functionPoint.getSubsystemId(),
                    new Integer[]{0, 0, 0, 0, 0, functionPoint.getComplexity()});
            if ("ILF".equals(functionPoint.getCategory())) {
                categoryCount[0]++;
                projectCategoryCount[0]++;
            } else if ("EIF".equals(functionPoint.getCategory())) {
                categoryCount[1]++;
                projectCategoryCount[1]++;
            } else if ("EI".equals(functionPoint.getCategory())) {
                categoryCount[2]++;
                projectCategoryCount[2]++;
            } else if ("EO".equals(functionPoint.getCategory())) {
                categoryCount[3]++;
                projectCategoryCount[3]++;
            } else if ("EQ".equals(functionPoint.getCategory())) {
                categoryCount[4]++;
                projectCategoryCount[4]++;
            } else {
                throw new WrongArgsException(ErrorConstant.WRONG_CATEGORY_INPUT_EXCEPTION);
            }
            result.put(functionPoint.getSubsystemId(), categoryCount);
        }
        result.put((long) -1, projectCategoryCount);
        return result;
    }

    /**
     * 计算子系统未调整功能点
     *
     * @param subsystemUfpList 子系统功能点列表
     * @return 各子系统未调整功能点，key=-1时为总系统未调整功能点
     */
    public static Map<Long, Integer> getSubsystemUfp(Map<Long, Integer[]> subsystemUfpList) {
        // 新建查询表第一项为子系统id，第二项为category计数
        Map<Long, Integer> result = new HashMap<>();

        // 遍历子系统功能点列表
        for (Map.Entry<Long, Integer[]> entry : subsystemUfpList.entrySet()) {

            Long subsystemId = entry.getKey();  // 获取子系统ID
            Integer[] ufpCounts = entry.getValue();  // 获取功能点数组

            UfpEntity ufpEntity = UfpEntityFactory.createUfpEntity(ufpCounts[5]);

            //根据ufp键值求加权和
            int sum = ufpCounts[0] * ufpEntity.getILF() + ufpCounts[1] * ufpEntity.getEIF() +
                    ufpCounts[2] * ufpEntity.getEI() + ufpCounts[3] * ufpEntity.getEO() +
                    ufpCounts[4] * ufpEntity.getEQ();

            result.put(subsystemId, sum);
        }

        return result;
    }

}
