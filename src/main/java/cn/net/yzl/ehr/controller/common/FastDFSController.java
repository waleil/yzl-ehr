package cn.net.yzl.ehr.controller.common;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.util.FastDFSClientWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
@Api(value = "公共接口", tags = {"公共接口"})
public class FastDFSController {

    @Value("${file.prefix}")
    private String filePrefix;

    @Autowired
    private FastDFSClientWrapper client;

    @ApiOperation(value = "文件上传", notes = "文件上传")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ComResponse<String> upload(MultipartFile file) throws IOException {
        String path = client.uploadFile(file);
        return ComResponse.success(path).setMessage(filePrefix+"/"+path);
    }
}