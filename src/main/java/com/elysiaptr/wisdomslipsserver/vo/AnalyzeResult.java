package com.elysiaptr.wisdomslipsserver.vo;

import com.elysiaptr.wisdomslipsserver.entity.Project;
import com.elysiaptr.wisdomslipsserver.vo.entity.FunctionPointVO;
import lombok.Data;

import java.util.List;

@Data
public class AnalyzeResult {
    private Project project;
    private List<FunctionPointVO> functionPoints;
}
