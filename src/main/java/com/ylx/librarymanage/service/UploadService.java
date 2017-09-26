package com.ylx.librarymanage.service;

import com.ylx.librarymanage.response.ResponseTemplate;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    ResponseTemplate uploadExcelFile(MultipartFile multipartFile);

}
