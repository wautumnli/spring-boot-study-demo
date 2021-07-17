package com.demo.ql.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("transcation_d")
public class TranscationD {

    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("name")
    private String name;
}
