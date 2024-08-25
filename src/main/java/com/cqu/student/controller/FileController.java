package com.cqu.student.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.cqu.student.pojo.Student;
import com.cqu.student.service.DomitoriesService;
import com.cqu.student.service.FileService;
import com.cqu.student.utils.R;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传控制类
 */
@RestController
@RequestMapping("/file")
public class FileController {
    @Value("${files.upload.path}")
    private String fileUpload;

    //读取文件映射路径
    @Value("${files.upload.fileMapper}")
    private String fileMapper;

    @Autowired
    private FileService fileService;

    /**
     * 上传文件
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public R upload(@RequestParam MultipartFile file,Integer stuId) throws IOException {

        System.out.println(stuId);
        //1.获取文件名
        String originalFilename = file.getOriginalFilename();
        //2.获取文件的后缀
        String fileType = FileUtil.extName(originalFilename);
        //3.获取文件的大小
        long size = file.getSize();
        //4.创建文件对象
        File uploadParentFile = new File(fileUpload);
        //5.判断存储文件的目录是否存在，不存在则创建
        if (!uploadParentFile.exists()){
            //创建目录
            uploadParentFile.mkdirs();
        }
        //6.重新命名文件 uuid
        String uuid = IdUtil.fastSimpleUUID();
        String fileName = uuid+ StrUtil.DOT+fileType;
        //7.设置文件路径*****
        String url = "http://localhost:8081"+fileMapper + fileName;
        //8.将文件写入磁盘
        File uploadFile = new File(fileUpload+"/"+fileName);
        file.transferTo(uploadFile);
        //9.文件上传成功以后，返回路径给前端
        /*url="D:/talent"+url;*/

        fileService.upload(url,stuId);

        System.out.println("Received stuId: " + stuId);

        System.out.println(url);

        return R.success(url);
    }
}

