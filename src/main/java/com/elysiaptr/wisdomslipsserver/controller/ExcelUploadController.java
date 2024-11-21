package com.elysiaptr.wisdomslipsserver.controller;

import com.elysiaptr.wisdomslipsserver.entity.ApiResponse;
import com.elysiaptr.wisdomslipsserver.entity.Project;
import com.elysiaptr.wisdomslipsserver.service.AnalyzeService;
import com.elysiaptr.wisdomslipsserver.service.ExcelUploadService;
import com.elysiaptr.wisdomslipsserver.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/excel")
public class ExcelUploadController {

    @Autowired
    ExcelUploadService excelUploadService;

    @Autowired
    AnalyzeService analyzeService;

    @Autowired
    ProjectService projectService;

    @PostMapping("/upload")
    public ApiResponse<String> handleFileUpload(@RequestParam("file") MultipartFile file,
                                                @RequestParam("project_id") Long projectId) throws IOException {
        excelUploadService.uploadExcel(file, projectId);

        Project project = projectService.getById(projectId);

        analyzeService.doAnalyze(project);

        return ApiResponse.success();
    }
}

