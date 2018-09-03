package com.mmall.dto;

import com.google.common.collect.Lists;
import com.mmall.model.SysDept;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.List;
/**
 * 描述:
 *
 * @author SupriseMF
 * @create 2018-08-12 18:34
 */
@Getter
@Setter
@ToString
public class DeptLevelDto extends SysDept {

    private List<DeptLevelDto> deptList = Lists.newArrayList();

    public static DeptLevelDto adapt(SysDept dept) {
        DeptLevelDto dto = new DeptLevelDto();
//        使用copy Bean的工具：完成两个类相同字段的拷贝
        BeanUtils.copyProperties(dept, dto);
        return dto;
    }
}
