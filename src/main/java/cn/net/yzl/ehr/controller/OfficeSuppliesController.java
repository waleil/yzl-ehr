package cn.net.yzl.ehr.controller;

import cn.net.yzl.ehr.pojo.OfficeSupplies;
import cn.net.yzl.ehr.pojo.OfficeSuppliesChangeRecord;
import cn.net.yzl.ehr.service.OfficeSuppliesService;
import cn.net.yzl.ehr.vojo.OfficeSuppliesChangeRecordPageParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.List;

public class OfficeSuppliesController {

    @Autowired
    private OfficeSuppliesService officeSuppliesService;






    @ApiOperation(value="新增办公物品",notes="新增办公物品",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public int insertSelective(OfficeSupplies record) {
        return officeSuppliesService.insertSelective(record);
    }

    @ApiOperation(value="查看办公物品详情",notes="查看办公物品详情",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public OfficeSupplies selectByPrimaryKey(Integer id) {
        return officeSuppliesService.selectByPrimaryKey(id);
    }

    @ApiOperation(value="更改办公物品信息",notes="更改办公物品信息",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public int updateByPrimaryKeySelective(OfficeSupplies record) {
        return officeSuppliesService.updateByPrimaryKeySelective(record);
    }


    @ApiOperation(value="查询所有办公物品列表",notes="查询所有办公物品列表",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    /*@ApiImplicitParams({
            @ApiImplicitParam(name="课件id",value="coursewareId",required=true,dataType="String",paramType="query"),
            @ApiImplicitParam(name="状态编号",value="status",required=true,dataType="String",paramType="query")
    })*/
    public List<OfficeSupplies> selectAllList() {
        return officeSuppliesService.selectAllList();
    }

    @ApiOperation(value="分页查询此物品所有领用记录",notes="分页查询此物品所有领用记录",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    /*@ApiImplicitParams({
            @ApiImplicitParam(name="课件id",value="coursewareId",required=true,dataType="String",paramType="query"),
            @ApiImplicitParam(name="状态编号",value="status",required=true,dataType="String",paramType="query")
    })*/
    public List<OfficeSuppliesChangeRecord> selectPageRecordList(OfficeSuppliesChangeRecordPageParam param) {
        return officeSuppliesService.selectPageRecordList(param);
    }

    @ApiOperation(value="新增办公用品领取记录",notes="新增办公用品领取记录",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    /*@ApiImplicitParams({
            @ApiImplicitParam(name="课件id",value="coursewareId",required=true,dataType="String",paramType="query"),
            @ApiImplicitParam(name="状态编号",value="status",required=true,dataType="String",paramType="query")
    })*/
    public int insertRecord(OfficeSuppliesChangeRecord record) {
        return officeSuppliesService.insertRecord(record);
    }
}
