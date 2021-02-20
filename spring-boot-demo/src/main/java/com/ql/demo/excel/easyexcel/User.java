package com.ql.demo.excel.easyexcel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author： wanqiuli
 * DateTime: 2021/2/20 13:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @ExcelProperty(value = {"id", "编号"})
    private Integer id;

    @ExcelProperty(value = "名字")
    private String name;

    @ExcelProperty(value = "其他")
    private String tips;

    // 不写入Excel内容
    @ExcelIgnore
    private String dept;
}
