package com.elysiaptr.wisdomslipsserver.service;

import com.elysiaptr.wisdomslipsserver.entity.Project;

/**
 * 分析服务
 *
 * @author ElysiaPtr
 */
public interface AnalyzeService {
    void doAnalyze(Project requestProject);
}
