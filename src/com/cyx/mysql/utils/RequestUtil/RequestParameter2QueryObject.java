package com.cyx.mysql.utils.RequestUtil;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class RequestParameter2QueryObject {

    public static  <T> T RequestParameter2QueryObject(HttpServletRequest req, Class<T> clz) throws Exception {
        T t = clz.newInstance();

        // 内省机制：获取 JavaBean 的描述对象
        BeanInfo info = Introspector.getBeanInfo(clz, Object.class);
        // 获取 JavaBean 对象中的属性描述器
        PropertyDescriptor[] descriptors = info.getPropertyDescriptors();
        // 遍历获取属性名对应的请求参数值，若值不为空，则放入 Query 对象中
        for (PropertyDescriptor descriptor : descriptors) {
            String parameter = req.getParameter(descriptor.getName());
            if (StringUtils.isNotBlank(parameter)) {
                // 此处传入的值为 String 类型，所以会造成参数类型不匹配：java.lang.IllegalArgumentException: argument type mismatch
                // descriptor.getWriteMethod().invoke(t, parameter);

                // 使用 org.apache.commons.beanutils.ConvertUtils 工具类来进行类型转换
                descriptor.getWriteMethod().invoke(t, ConvertUtils.convert(parameter, descriptor.getPropertyType()));
            }
        }
        return t;
    }
}