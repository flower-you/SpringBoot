package xaut.wjh.dao;

import tk.mybatis.mapper.common.Mapper;
import xaut.wjh.entity.TUser;

//@Mapper
//在映射接口上添加一个Mapper注解，声明是一个映射接口类
//这个接口可以被自动扫描发现，但必须是main方法所在类的包或子包
public interface TUserMapper extends Mapper<TUser>{//extends Mapper<TUser>
   
//    int insert(TUser record);
/**
 * 如果默认的Mapper提供的查询方法不足，可以使用注解人为在Mapper接口中进行定义
 */
}