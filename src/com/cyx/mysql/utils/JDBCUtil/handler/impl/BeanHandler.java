package com.cyx.mysql.utils.JDBCUtil.handler.impl;

import com.cyx.mysql.utils.JDBCUtil.handler.IResultSetHandler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

public class BeanHandler<T> implements IResultSetHandler<T> {

    /**
     * 需要转换的类型对象
     */
    private Class<T> classType;

    public BeanHandler(Class<T> classType) {
        this.classType = classType;
    }

    @Override
    public T handle(ResultSet set) throws Exception {
        T t = classType.newInstance();

        // 通过内省获取 Bean 信息
        // 通过内省器获取 JavaBean 信息对象
        BeanInfo beanInfo = Introspector.getBeanInfo(this.classType, Object.class);
        // 获取属性描述器
        PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
        if (set.next()) {
            for (PropertyDescriptor descriptor: descriptors) {
                descriptor.getWriteMethod().invoke(t, set.getObject(descriptor.getName()));
            }
            return t;
        }
        return null;
    }
}
