package org.xujin.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;

/**
 * @author xujin
 * @package-name org.xujin.entity
 * @createtime 2020-03-30 14:41
 */
@Data
public class User {
    //@TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    @TableField(fill = FieldFill.INSERT)
    private int version;    //乐观锁的版本号
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;//做逻辑删除
}
