package com.elysiaptr.wisdomslipsserver.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Excel读取上传服务
 *
 * @author ElysiaPtr
 */
public interface ExcelUploadService {
    void uploadExcel(MultipartFile file, Long projectId) throws IOException;
}
