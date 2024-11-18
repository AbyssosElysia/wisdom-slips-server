package com.elysiaptr.wisdomslipsserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elysiaptr.wisdomslipsserver.entity.Project;
import com.elysiaptr.wisdomslipsserver.service.ProjectService;
import com.elysiaptr.wisdomslipsserver.mapper.ProjectMapper;
import org.springframework.stereotype.Service;

/**
* @author elysiaptr
* @description 针对表【project(项目分析)】的数据库操作Service实现
* @createDate 2024-11-18 20:04:47
*/
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project>
    implements ProjectService{

}




