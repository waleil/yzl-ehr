package cn.net.yzl.ehr.fegin.asr;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.model.dto.DepartmentDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "departmentService",url = "${fegin.db.url}")
public interface DepartmentFeignService {

    /**
     * @author wanghuasheng
     * @description 查询asr组织架构
     * @date: 2021/02/03 16:00 下午
     * @return: cn.net.yzl.common.entity.ComResponse<cn.net.yzl.model.dto.DepartmentDto>
     */
    @GetMapping(value = "department/v1/query/tree")
    @ApiOperation(value = "查询asr组织架构", httpMethod = "GET")
    ComResponse<List<DepartmentDto>> getDepartmentTree() ;

    /**
     * @author wanghuasheng
     * @description 新增asr组织架构
     * @date: 2021/02/04 11:17 上午
     * @return: cn.net.yzl.common.entity.ComResponse<cn.net.yzl.model.dto.DepartmentDto>
     */
    @PostMapping(value = "department/v1/add")
    @ApiOperation(value = "新增asr组织架构", httpMethod = "POST")
    ComResponse<Boolean> addDepartment(@RequestBody DepartmentDto departmentDto);

    /**
     * @author wanghuasheng
     * @description 删除asr组织架构
     * @date: 2021/02/04 11:17 上午
     * @return: cn.net.yzl.common.entity.ComResponse<cn.net.yzl.model.dto.DepartmentDto>
     */
    @DeleteMapping(value = "department/v1/delete/{id}")
    @ApiOperation(value = "删除asr组织架构", httpMethod = "DELETE")
    ComResponse<Boolean> delDepartment(@PathVariable String id) ;

    /**
     * @author wanghuasheng
     * @description asr组织架构修改
     * @date: 2021/02/04 11:17 上午
     * @return: cn.net.yzl.common.entity.ComResponse<cn.net.yzl.model.dto.DepartmentDto>
     */
    @PostMapping(value = "department/v1/update")
    @ApiOperation(value = "修改asr组织架构", httpMethod = "POST")
    ComResponse<Boolean> updateDepartment(@RequestBody DepartmentDto departmentDto);

}
