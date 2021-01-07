package cn.net.yzl.ehr.pojo;

import cn.net.yzl.ehr.util.ValidList;
import lombok.Data;

import javax.validation.Valid;


@Data
public class PostItemPo {
    @Valid
    private ValidList<PostInsertPo> postInsertList;
    @Valid
    private ValidList<PostUpdatePo> postUpdateList;
    @Valid
    private ValidList<PostDeletePo> postDeleteList;
}
