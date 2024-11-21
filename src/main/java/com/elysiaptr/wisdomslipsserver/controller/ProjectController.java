package com.elysiaptr.wisdomslipsserver.controller;

import com.elysiaptr.wisdomslipsserver.entity.ApiResponse;
import com.elysiaptr.wisdomslipsserver.entity.Project;
import com.elysiaptr.wisdomslipsserver.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/get_project")
    public ApiResponse<Project> getProjectById(@RequestParam int projectId) {
        return ApiResponse.success(projectService.getById(projectId));
    }

    @PutMapping("/modify_project")
    public ApiResponse<Boolean> modifyProject(@RequestBody Project project) {
        return ApiResponse.success(projectService.updateById(project));
    }

    @DeleteMapping("/delete_project")
    public ApiResponse<Boolean> deleteProject(@RequestParam int projectId) {
        return ApiResponse.success(projectService.removeById(projectId));
    }

    @PostMapping("/add_project")
    public ApiResponse<Boolean> addProject(@RequestBody Project project) {
        return ApiResponse.success(projectService.save(project));
    }
}
