package com.mmall.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * 描述:
 * 部门参数类
 *
 * @author SupriseMF
 * @create 2018-08-12 12:15
 */

@Getter
@Setter
@ToString
public class DeptParam {

    private Integer id;

    @NotBlank(message = "部门名称不能为空")
    @Length(max = 15,min = 2,message = "部门名称需要在2--15字内")
    private String name;

    private Integer parentId = 0;

    @NotNull(message = "展示顺序不可为空")
    private Integer seq;

    @Length(max = 150,message = "备注的长度不能超过150字")
    private String remark;


}
