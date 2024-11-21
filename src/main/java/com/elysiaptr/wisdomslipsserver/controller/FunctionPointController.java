package com.elysiaptr.wisdomslipsserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.elysiaptr.wisdomslipsserver.entity.ApiResponse;
import com.elysiaptr.wisdomslipsserver.entity.FunctionPoint;
import com.elysiaptr.wisdomslipsserver.service.FunctionPointService;
import com.elysiaptr.wisdomslipsserver.service.SubsystemService;
import com.elysiaptr.wisdomslipsserver.vo.FunctionPointVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/function_point")
public class FunctionPointController {

    @Autowired
    FunctionPointService functionPointService;

    @Autowired
    SubsystemService subsystemService;

    /**
     * 功能点添加
     * @param functionPoint 功能点
     * @return 是否成功
     */
    @PostMapping("/add_function")
    public ApiResponse<Boolean> addFunctionPoint(FunctionPoint functionPoint) {
        return ApiResponse.success(functionPointService.save(functionPoint));
    }

    /**
     * 功能点批量修改
     *
     * @param functionPoints 功能点列表
     * @return 是否成功
     */
    @PutMapping("/batch/update_function")
    public ApiResponse<Boolean> updateFunctionPoints(@RequestBody List<FunctionPoint> functionPoints) {
        boolean result = functionPointService.updateBatchById(functionPoints);
        return ApiResponse.success(result);
    }

    /**
     * 功能点批量删除
     *
     * @param ids 所有需要删除的id
     * @return 是否成功
     */
    @DeleteMapping("/batch/delete_function")
    public ApiResponse<Boolean> deleteFunctionPoints(@RequestBody List<Long> ids) {
        boolean result = functionPointService.removeByIds(ids);
        return ApiResponse.success(result);
    }

    /**
     * 双列模糊查询
     *
     * @param projectId 项目id
     * @param moduleKeyword 功能点模块
     * @param nameKeyword 功能点名
     * @param pageNum 页数
     * @param pageSize 也大小
     * @return 分页数据
     */
    @GetMapping("/search_function")
    public ApiResponse<IPage<FunctionPointVo>> searchFunctionPoints(
            @RequestParam Long projectId,
            @RequestParam String moduleKeyword,
            @RequestParam String nameKeyword,
            @RequestParam int pageNum,
            @RequestParam int pageSize) {

        // 创建查询条件
        QueryWrapper<FunctionPoint> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_id", projectId);
        queryWrapper.like("module", moduleKeyword);
        queryWrapper.like("name", nameKeyword);

        // 设置分页
        Page<FunctionPoint> page = new Page<>(pageNum, pageSize);

        // 查询数据库获取分页结果
        IPage<FunctionPoint> functionPointsPage = functionPointService.page(page, queryWrapper);

        // 提取查询结果并转换为 FunctionPointVo
        List<FunctionPointVo> functionPointVoList = functionPointsPage.getRecords().stream()
                .map(this::convertToVo)  // 转换每个 FunctionPoint 为 FunctionPointVo
                .collect(Collectors.toList());

        // 创建新的分页对象
        IPage<FunctionPointVo> functionPointsVoPage = new Page<>();
        functionPointsVoPage.setRecords(functionPointVoList);
        functionPointsVoPage.setTotal(functionPointsPage.getTotal());
        functionPointsVoPage.setCurrent(functionPointsPage.getCurrent());
        functionPointsVoPage.setSize(functionPointsPage.getSize());

        // 返回封装后的结果
        return ApiResponse.success(functionPointsVoPage);
    }

    /**
     * 转换方法，将 FunctionPoint 转换为 FunctionPointVo
     *
     * @param functionPoint 功能点
     * @return 对应功能点视图
     */
    private FunctionPointVo convertToVo(FunctionPoint functionPoint) {
        FunctionPointVo functionPointVo = new FunctionPointVo();
        BeanUtils.copyProperties(functionPoint, functionPointVo);
        functionPointVo.setSubsystemName(subsystemService.getById(functionPoint.getSubsystemId()).getName());
        functionPointVo.setSubsystemId(functionPoint.getSubsystemId());
        return functionPointVo;
    }
}
