package com.elysiaptr.wisdomslipsserver.service.impl;

import com.elysiaptr.wisdomslipsserver.constant.ErrorConstant;
import com.elysiaptr.wisdomslipsserver.entity.FunctionPoint;
import com.elysiaptr.wisdomslipsserver.entity.Subsystem;
import com.elysiaptr.wisdomslipsserver.exception.WrongArgsException;
import com.elysiaptr.wisdomslipsserver.factory.ComplexityFactory;
import com.elysiaptr.wisdomslipsserver.mapper.FunctionPointMapper;
import com.elysiaptr.wisdomslipsserver.mapper.SubsystemMapper;
import com.elysiaptr.wisdomslipsserver.service.ExcelUploadService;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Excel上传功能实现
 *
 * @author ElysiaPtr
 */
@Service
public class ExcelUploadServiceImpl implements ExcelUploadService {

    @Autowired
    SubsystemMapper subsystemMapper;

    @Autowired
    FunctionPointMapper functionPointMapper;

    @Transactional
    public void uploadExcel(MultipartFile file, Long projectId) throws IOException {

        // 读取工作簿和工作表
        Workbook workbook = WorkbookFactory.create(file.getInputStream());
        // 读取第一张表
        Sheet sheet = workbook.getSheetAt(0);

        // 存储子系统表，第一列是存储后的名字，第二列存储以后的id
        Map<String, Long> subsystemMap = new HashMap<>();

        // 只访问第二列
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {

            Row row = sheet.getRow(i);
            if (row == null) continue; // 跳过空行
            Cell cell = row.getCell(1);
            if (cell == null) continue;  // 跳过空格

            String subsystemName = cell.getStringCellValue();

            if (!subsystemMap.containsKey(subsystemName)) {
                Subsystem newSubsystem = new Subsystem();
                newSubsystem.setProjectId(projectId);
                newSubsystem.setName(subsystemName);
                subsystemMapper.insert(newSubsystem);
                subsystemMap.put(newSubsystem.getName(), newSubsystem.getId());
            }
        }

        // 从第二行开始（跳过第一行列标）
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue; // 跳过空行

            FunctionPoint newFunctionPoint = new FunctionPoint();

            // 第一列
            Cell cell1 = row.getCell(1);
            if (cell1 == null) continue;  // 跳过空格
            newFunctionPoint.setSubsystemId(subsystemMap.get(cell1.getStringCellValue()));

            // 第二列
            Cell cell2 = row.getCell(2);
            if (cell2 == null) continue;  // 跳过空格
            newFunctionPoint.setModule(cell2.getStringCellValue());

            // 第三列
            Cell cell3 = row.getCell(3);
            if (cell3 == null) continue;
            newFunctionPoint.setName(cell3.getStringCellValue());

            // 第四列
            Cell cell4 = row.getCell(4);
            if (cell4 == null) continue;
            newFunctionPoint.setDescription(cell4.getStringCellValue());

            // 第五列
            Cell cell5 = row.getCell(5);
            if (cell5 == null) continue;
            newFunctionPoint.setCategory(cell5.getStringCellValue());

            // 第六列
            Cell cell6 = row.getCell(6);
            if (cell6 == null) continue;
            int ufpValue = getIntValue(cell6, row);
            newFunctionPoint.setUfp(ufpValue);

            // 第七列
            Cell cell7 = row.getCell(7);
            if (cell7 == null) continue;
            int complexity = ComplexityFactory.getComplexity(cell7.getStringCellValue());
            newFunctionPoint.setComplexity(complexity);

            newFunctionPoint.setProjectId(projectId);

            functionPointMapper.insert(newFunctionPoint);
        }

        workbook.close();
    }

    private static int getIntValue(Cell cell, Row row) {
        int value;
        // 判断单元格类型
        if (cell.getCellType() == CellType.NUMERIC) {
            // 如果是数字类型，直接转换
            value = (int) cell.getNumericCellValue();
        } else if (cell.getCellType() == CellType.STRING) {
            // 如果是字符串类型，尝试解析为整数
            value = Integer.parseInt(cell.getStringCellValue().trim());
        } else {
            // 其他类型，抛出异常
            throw new WrongArgsException(ErrorConstant.WRONG_CELL_ARGS + "，位于" + row.getRowNum() + "行");
        }
        return value;
    }

}
