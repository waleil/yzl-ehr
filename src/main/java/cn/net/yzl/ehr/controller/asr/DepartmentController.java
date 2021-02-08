package cn.net.yzl.ehr.controller.asr;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.fegin.asr.DepartmentFeignService;
import cn.net.yzl.model.dto.DepartmentDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author wanghuasheng
 * @version 1.0
 * @description 代理asr操作业务组
 * @title: DepartmentController
 * @date: 2021/02/03 18:00 下午
 */
@RestController
@Slf4j
@Api(tags = "asr组织架构")
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    private DepartmentFeignService departmentFeignService;

    /**
     * @author wanghuasheng
     * @description 查询asr组织架构
     * @date: 2021/02/03 16:00 下午
     * @return: cn.net.yzl.common.entity.ComResponse<cn.net.yzl.model.dto.DepartmentDto>
     */
    @GetMapping(value = "v1/query/tree")
    @ApiOperation(value = "查询asr组织架构", httpMethod = "GET")
    public ComResponse<List<DepartmentDto>> getDepartmentTree() {
        return departmentFeignService.getDepartmentTree();
    }

    /**
     * @author wanghuasheng
     * @description 新增asr组织架构
     * @date: 2021/02/04 11:17 上午
     * @return: cn.net.yzl.common.entity.ComResponse<cn.net.yzl.model.dto.DepartmentDto>
     */
    @PostMapping(value = "v1/add")
    @ApiOperation(value = "新增asr组织架构", httpMethod = "POST")
    public ComResponse<Boolean> addDepartment(@RequestBody DepartmentDto departmentDto) {
        log.info("进入到新增ASR组织架构接口。。。departmentDto：{}", departmentDto.toString());
        return departmentFeignService.addDepartment(departmentDto);
    }

    /**
     * @author wanghuasheng
     * @description 删除asr组织架构
     * @date: 2021/02/04 11:17 上午
     * @return: cn.net.yzl.common.entity.ComResponse<cn.net.yzl.model.dto.DepartmentDto>
     */
    @DeleteMapping(value = "v1/delete/{id}")
    @ApiOperation(value = "删除asr组织架构", httpMethod = "DELETE")
    public ComResponse<Boolean> delDepartment(@PathVariable String id) {
        log.info("进入到删除ASR组织架构接口。。。id：{}", id);
        return departmentFeignService.delDepartment(id);
    }

    /**
     * @author wanghuasheng
     * @description asr组织架构修改
     * @date: 2021/02/04 11:17 上午
     * @return: cn.net.yzl.common.entity.ComResponse<cn.net.yzl.model.dto.DepartmentDto>
     */
    @PostMapping(value = "v1/update")
    @ApiOperation(value = "修改asr组织架构", httpMethod = "POST")
    public ComResponse<Boolean> updateDepartment(@RequestBody DepartmentDto departmentDto) {
        return departmentFeignService.updateDepartment(departmentDto);
    }

}
