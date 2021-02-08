package cn.net.yzl.ehr.controller.common;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.ehr.dto.SysDictDataDto;
import cn.net.yzl.ehr.fegin.common.SysDictDataFeginService;
import cn.net.yzl.ehr.vo.SysDictDataVO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/sysDic")
@Api(value = "公共接口", tags = {"公共接口"})
@Valid
public class SysDictController {

    @Autowired
    private SysDictDataFeginService sysDictDataFeginService;

    @ApiOperation(value = "字典-根据类型获取字典集合", notes = "字典-根据类型获取字典集合", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dictType", value = "" +
                    "在岗状态:post_status," +
                    "工作地点:work_area," +
                    "职场:workplace," +
                    "政治面貌:political_status," +
                    "异动状态:abnormal_state," +
                    "异动类型:abnormal_type," +
                    "考勤类型:attendance_type," +
                    "岗位属性:post_attr," +
                    "培训方式:train_way" +
                    "部门属性:depart_attr," +
                    "学历类型:degree," +
                    "合作方:partner," +
                    "假勤类型:false_name," +
                    "社保类型:social" +
                    "工资计算时间:salary_sign"+
                    "异动类型:abnormal_type"+
                    "面试入库原因:resume_depart"+
                    "面试初试意向:intention"+
                    "面试类型:interview_type"+
                    "通知类型:notice"+
                    "面试结果:interview_result"+
                    "入岗状态:post_status"+
                    "培训完成度:training_completion"+
                    "选班班次:class"+
                    "", required = true, paramType = "query")
    })
    @RequestMapping(value = "/getByType", method = RequestMethod.GET)
    ComResponse<List<SysDictDataDto>> getByType(@NotBlank String dictType){
        return sysDictDataFeginService.getByType(dictType);
    }

    @ApiOperation(value = "字典-添加字典或者删除", notes = "字典-添加字典或者删除", consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST)
    ComResponse<Integer> addOrUpdate(@RequestBody  @Validated List<SysDictDataVO> dictDataList){
        return sysDictDataFeginService.addOrUpdate(dictDataList);
    }
}
