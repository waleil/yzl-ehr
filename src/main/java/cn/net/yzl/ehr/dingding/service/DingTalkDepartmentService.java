package cn.net.yzl.ehr.dingding.service;

import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dingding.DingProperties;
import cn.net.yzl.ehr.dingding.DingtalkToken;
import cn.net.yzl.ehr.mapper.DepartMapper;
import cn.net.yzl.ehr.pojo.DepartPo;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.taobao.api.ApiException;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * 钉钉 部门操作服务
 */
@Service
public class DingTalkDepartmentService {

    @Autowired
    private DingtalkToken defaultDingtalkToken;
    @Autowired
    private DingProperties dingProperties;
    @Autowired
    private DepartMapper departMapper;

    // 获取部门列表
    public OapiDepartmentListResponse getDepartmentList(String parentId, Boolean fetchChild) throws ApiException {
        if (null == parentId) {
            parentId = "1";
        }
        if (null == fetchChild) {
            fetchChild = false;
        }
        DingTalkClient client = new DefaultDingTalkClient(dingProperties.department_list_url);
        OapiDepartmentListRequest request = new OapiDepartmentListRequest();
        request.setId(parentId);
        request.setHttpMethod("GET");
        request.setFetchChild(fetchChild);
        return client.execute(request, defaultDingtalkToken.getToken());
    }

    // 获取部门详情
    public OapiDepartmentGetResponse getDepartment(String id) throws ApiException {
        Assert.isTrue(StringUtils.hasLength(id), "部门ID未设定");
        DingTalkClient client = new DefaultDingTalkClient(dingProperties.department_get_url);
        OapiDepartmentGetRequest request = new OapiDepartmentGetRequest();
        request.setId(id);
        request.setHttpMethod("GET");
        OapiDepartmentGetResponse response = client.execute(request, defaultDingtalkToken.getToken());
        return response;
    }

    // 查询根部门下的子部门ID列表
    public OapiDepartmentListIdsResponse getDepartmentlistIds(String id) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient(dingProperties.department_list_ids_url);
        OapiDepartmentListIdsRequest req = new OapiDepartmentListIdsRequest();
        req.setId(id);
        req.setHttpMethod("GET");
        OapiDepartmentListIdsResponse response = client.execute(req, defaultDingtalkToken.getToken());
        return response;
    }


    // 部门初始化
    @Transactional
    public ComResponse<Boolean> init(String id) throws ApiException {
        // 先 从钉钉 获取 id 为1 根组织
        OapiDepartmentGetResponse department = getDepartment(id);
        if (department == null) {
            return ComResponse.fail(ResponseCodeEnums.DING_CONNECTION_ERROR_CODE.getCode(), ResponseCodeEnums.DING_CONNECTION_ERROR_CODE.getMessage());
        }
        Long errcode = department.getErrcode();
        String errmsg = department.getErrmsg();
        if (errcode != 0 && !errmsg.equals("ok")) {
            return ComResponse.fail(ResponseCodeEnums.DING_ERROR_CODE.getCode(), department.getErrcode()+"-"+department.getErrmsg());
        }

        DepartPo departPo = new DepartPo();
        // 构建 部门
        assembDepartPo(departPo,department);
        departMapper.save(departPo);
        // 获取 部门下的子
        OapiDepartmentListIdsResponse departmentlistIds = getDepartmentlistIds(departPo.getDingDepartId() + "");
        if(departmentlistIds!=null && departmentlistIds.getSubDeptIdList()!=null&&departmentlistIds.getSubDeptIdList().size()>0){
            departmentlistIds.getSubDeptIdList().forEach(departId->{
                try {
                    init(departId+"");
                } catch (ApiException e) {
                    e.printStackTrace();
                }


            });

        }

        return ComResponse.success();
    }
    // 组装 departpo
    private void assembDepartPo(DepartPo departPo, OapiDepartmentGetResponse department) {
        departPo.setName(department.getName());
        departPo.setDingName(department.getName());

        departPo.setDingDepartId(department.getId());
        if(department.getParentid()!=null){
            departPo.setDingPId(department.getParentid());
        }else{
            departPo.setDingPId(0L);
        }
        if(department.getId()==1){
            departPo.setPId(0);
        }else{
            // 还得查询 通过 department.getParentid() 查询 id
            DepartPo byDingIdAndCropId = departMapper.getByDingIdAndCropId(department.getParentid(), dingProperties.corpId);
            departPo.setPId(byDingIdAndCropId.getId());
        }
        departPo.setCorpId(dingProperties.corpId);
        departPo.setOrder(department.getOrder());
        departPo.setDingOrder(department.getOrder());
        departPo.setDingOwner(department.getOrgDeptOwner());
        departPo.setFrom((byte) 2);




    }


}
