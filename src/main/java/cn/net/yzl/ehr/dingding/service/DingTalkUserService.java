package cn.net.yzl.ehr.dingding.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import cn.net.yzl.common.entity.ComResponse;
import cn.net.yzl.common.enums.ResponseCodeEnums;
import cn.net.yzl.ehr.dingding.DingProperties;
import cn.net.yzl.ehr.dingding.DingtalkToken;
import cn.net.yzl.ehr.fegin.depart.DepartFeginService;
import cn.net.yzl.ehr.fegin.staff.StaffFeginService;
import cn.net.yzl.ehr.pojo.DepartPo;
import cn.net.yzl.ehr.pojo.DingTalkUserPo;
import cn.net.yzl.ehr.pojo.StaffDepartPostPo;
import cn.net.yzl.ehr.pojo.StaffPo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 钉钉 user 操作 服务
 */
@Service
public class DingTalkUserService {
    @Autowired
    private DingtalkToken defaultDingtalkToken;
    @Autowired
    private DingProperties dingProperties;
    @Autowired
    private DingTalkDepartmentService dingTalkDepartmentService;
    @Autowired
    private StaffFeginService staffFeginService;

    @Autowired
    private DepartFeginService departFeginService;
    private final Logger log = LoggerFactory.getLogger(DingTalkUserService.class);

    /**
     * 查询用户信息
     * @param userId
     * @return {
     *     "errcode": 0,
     *     "unionid": "PiiiPyQqBNBii0HnCJ3zljcuAiEiE", //在当前isv全局范围内唯一标识一个用户的身份,用户无法修改
     *     "openId": "PiiiPyQqBNBii0HnCJ3zljcuAiEiE", //在本 服务窗运营服务商 范围内，唯一标识关注者身份的id（不可修改）
     *     "roles": [{   //角色信息（ISV不可见），json数组格式
     *         "id": 23003585, //角色id（ISV不可见）
     *         "name": "engineer", //角色名称（ISV不可见）
     *         "groupName": "group one" //角色分组名称（ISV不可见）
     *     }],
     *     "remark": "remark", //备注（ISV不可见）
     *     "userid": "zhangsan", //员工唯一标识ID（不可修改）
     *     "isLeaderInDepts": "{1:false}", //在对应的部门中是否为主管：Map结构的json字符串，key是部门的Id，value是人员在这个部门中是否为主管，true：表示是 false：表示不是
     *     "isBoss": false, //是否为企业的老板，true表示是，false表示不是（【设置负责人】：主管理员登陆钉钉手机客户端 -【通讯录】-【企业名后面的管理】-【企业通讯录】-【负责人设置】进行添加即可。）
     *     "hiredDate": 1520265600000, //入职时间
     *     "isSenior": false, //是否是高管
     *     "tel": "010-88996533", //分机号（仅限企业内部开发调用）
     *     "department": [1,2], //成员所属部门id列表
     *     "workPlace": "beijing", //办公地点（ISV不可见）
     *     "email": "ceshi@aliyun.com", //员工的电子邮箱（ISV不可见）
     *     "orgEmail" : "ceshi@aliyun.com" //员工的企业邮箱，如果员工已经开通了企业邮箱，接口会返回，否则不会返回（ISV不可见）
     *     "orderInDepts": "{1:71738366882504}", //在对应的部门中的排序，Map结构的json字符串，key是部门的Id，value是人员在这个部门的排序值
     *     "mobile": "15901516821", //手机号码（ISV不可见）
     *     "errmsg": "ok",
     *     "active": false, //是否已经激活，true：表示已激活 false：表示未激活
     *     "avatar": "dingtalk.com/abc.jpg", //头像url
     *     "isAdmin": false, //是否为企业的管理员，true：表示是 false：表示不是
     *     "isHide": false, //是否号码隐藏,true：表示隐藏,false：表示不隐藏
     *     "jobnumber": "001", //员工工号
     *     "name": "test1", //成员名称
     *     "extattr": {}, //扩展属性，可以设置多种属性(但手机上最多只能显示10个扩展属性，具体显示哪些属性，请到OA管理后台->设置->通讯录信息设置和OA管理后台->设置->手机端显示信息设置)
     *     "stateCode": "86",  //手机号码区号
     *     "position": "manager" //职位信息
     * }
     * @throws ApiException
     */
    public OapiUserGetResponse getUser(String userId) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient(dingProperties.user_get_url);
        OapiUserGetRequest request = new OapiUserGetRequest();
        request.setUserid(userId);
        request.setHttpMethod("GET");
        return client.execute(request, defaultDingtalkToken.getToken());
    }

    // 获取部门下的用户 id 集合
    public OapiUserListidResponse getDepartUserIds(String departId) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient(dingProperties.depart_user_list_ids_url);
        OapiUserListidRequest req = new OapiUserListidRequest();
        req.setDeptId(Long.parseLong(departId));
        OapiUserListidResponse rsp = client.execute(req, defaultDingtalkToken.getToken());
        return rsp;
    }


    public ComResponse<Boolean> init(String departId) throws ApiException {
        OapiDepartmentGetResponse department = dingTalkDepartmentService.getDepartment(departId);
        if (department == null) {
            return ComResponse.fail(ResponseCodeEnums.DING_CONNECTION_ERROR_CODE.getCode(), ResponseCodeEnums.DING_CONNECTION_ERROR_CODE.getMessage());
        }
        Long errcode = department.getErrcode();
        String errmsg = department.getErrmsg();
        if (errcode != 0 && !errmsg.equals("ok")) {
            return ComResponse.fail(ResponseCodeEnums.DING_ERROR_CODE.getCode(), department.getErrcode()+"-"+department.getErrmsg());
        }

        // 获取当前部门下的用户
        OapiUserListidResponse departUserIds = getDepartUserIds(departId);
        Long errcode1 = departUserIds.getErrcode();
        String errmsg1 = departUserIds.getErrmsg();
        if(departUserIds==null){
            return ComResponse.fail(ResponseCodeEnums.DING_CONNECTION_ERROR_CODE.getCode(), ResponseCodeEnums.DING_CONNECTION_ERROR_CODE.getMessage());
        }
        if (errcode1 != 0 && !errmsg1.equals("ok")) {
            return ComResponse.fail(ResponseCodeEnums.DING_ERROR_CODE.getCode(), department.getErrcode()+"-"+department.getErrmsg());
        }

        departUserIds.getResult().getUseridList().forEach(userId->{
            //  获取用户信息
            try {
                OapiUserGetResponse user = getUser(userId);
                Long errcode2 = user.getErrcode();
                String errmsg2 = user.getErrmsg();
                if(errcode2==null){
                    log.info("dingding getUser info :钉钉连接异常! userId:{}",userId);
                }
                if (errcode2 != 0 && !errmsg2.equals("ok")) {
                    log.info("dingding getUser  info: errcode:{},errmsg:{},userId:{}",errcode2,errmsg2,userId);
                }
                DingTalkUserPo dingTalkUserPo = new DingTalkUserPo();
                BeanUtil.copyProperties(user,dingTalkUserPo,true);
                ;

                // 创建 钉钉 信息数据
                staffFeginService.createDingTalkUser(dingTalkUserPo);

                StaffPo staffPo = assembStaff(user);
                // 添加 员工
                ComResponse<StaffPo> insertStaffPo = staffFeginService.create(staffPo);

                // 判断部门
                List<StaffDepartPostPo> staffDepartList = new ArrayList<>();
                user.getDepartment().forEach(depId->{
                    ComResponse<DepartPo> byDingDepartId = departFeginService.getByDingDepartId(depId + "");
                    if(byDingDepartId!=null && byDingDepartId.getData()!=null){
                        StaffDepartPostPo staffDepartPostPo = new StaffDepartPostPo();
                        staffDepartPostPo.setStaffId(insertStaffPo.getData().getId());
                        staffDepartPostPo.setDepartId(byDingDepartId.getData().getId());
                        staffDepartList.add(staffDepartPostPo);
                    }
                });

                if(staffDepartList.size()>0){
                    // 插入数据库
                    staffFeginService.insertStaffDepartList(staffDepartList);
                }


            } catch (ApiException e) {
                e.printStackTrace();
            }


        });

        OapiDepartmentListIdsResponse departmentlistIds = dingTalkDepartmentService.getDepartmentlistIds(departId);

        if(departmentlistIds!=null && departmentlistIds.getSubDeptIdList()!=null&&departmentlistIds.getSubDeptIdList().size()>0){
            departmentlistIds.getSubDeptIdList().forEach(deptId->{
                try {
                    init(deptId+"");
                } catch (ApiException e) {
                    e.printStackTrace();
                }
            });

        }

        return ComResponse.success();


    }
    // 组装 staff 实体
    private StaffPo assembStaff(OapiUserGetResponse user) {
            return StaffPo.builder().name(user.getName())
                    .phone(user.getMobile())
                    .email(user.getEmail())
                    .dingUnionId(user.getUnionid())
                    .dingUserId(user.getUserid()).build();

    }





}
