package cn.net.yzl.ehr.controller;

import cn.net.yzl.ehr.util.FastDFSClientWrapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
@Api(value = "文件上传", tags = {"文件上传"})
public class FastDFSController {

    @Autowired
    private FastDFSClientWrapper client;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(MultipartFile file) throws IOException {
        return client.uploadFile(file);
    }
}