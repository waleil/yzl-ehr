package cn.net.yzl.ehr.pojo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class DepartResumeListPo {

    private Integer postId;

    private Integer departOd;

    private List<DepartResumeItem> departResumeList;

    @Data
    static class DepartResumeItem{
        @NotBlank
        private String stepName;
        @NotBlank
        private String leaderNo;
        @NotNull
        @Min(0)
        private Integer no;

    }
}
