package com.elysiaptr.wisdomslipsserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elysiaptr.wisdomslipsserver.entity.Project;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author elysiaptr
 * @description 针对表【project(项目分析)】的数据库操作Mapper
 * @createDate 2024-11-20 10:05:52
 * @Entity com.elysiaptr.wisdomslipsserver.entity.Project
 */
@Mapper
public interface ProjectMapper extends BaseMapper<Project> {

}




