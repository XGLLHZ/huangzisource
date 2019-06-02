package org.huangzi.huangziframe.util;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: XGLLHZ
 * Date: 2019/1/14
 * Time: 21:18
 * entity与dto转换方法类
 * @Author guohao
 */
public class BeanConverterUtil {

    /**
     * entity与dto的转换方法
     * @param entity entity
     * @param dto dto
     * @param <T1>
     * @param <T2>
     * @return entity
     */
    public static <T1,T2> T1 beanConvert(T1 entity,T2 dto){
        List<Map<String,Object>> entityList = getFieldInfo(entity);
        List<Map<String,Object>> dtoList = getFieldInfo(dto);
        for(Map mapEntity : entityList){
            for(Map mapDto :dtoList){
                if(mapEntity.get("type").toString().equals(mapDto.get("type").toString())
                        && mapEntity.get("name").toString().equals(mapDto.get("name").toString())){
                    try{
                        Field field = entity.getClass().getDeclaredField(mapEntity.get("name").toString());
                        field.setAccessible(true);
                        field.set(entity,mapDto.get("value"));
                    }catch(Exception e){
                        return null;
                    }
                }
            }
        }
        return entity;
    }

    //数组和集合的区别：两者都是Java中的容器
    //    ：数组大小是固定的，集合大小是动态变化的
    //    ：数组中的只能放一种类型的数据，集合中可以放多种类型的数据
    //数组与集合间的相互转化：
    //    ：数组 => 集合：Arrays.asList(String[] string)
    //    ：集合 => 数组：list.toArray()
    //集合中add()与addAll()的区别：
    //    ：add()：添加一条item
    //    ：addAll()：添加一条或多条item(添加量由被添加者决定)
    /**
     * 获取对象的属性类型(type)，属性名(name)，属性值(value)的map组成的list集合
     * @param object 对象
     * @return List<Map>
     */
    private static List<Map<String,Object>> getFieldInfo(Object object){
        List<Map<String,Object>> list = new ArrayList<>();
        List<Field> fieldList = new ArrayList<>();
        //获取对象中的字段名，并将其放入list中
        fieldList.addAll(Arrays.asList(object.getClass().getDeclaredFields()));
        for(Field field : fieldList){
            Map<String,Object> map = new HashMap<>();
            map.put("type",field.getType());
            map.put("name",field.getName());
            map.put("value",getFieldValueByName(field.getName(),object));
            list.add(map);
        }
        return list;
    }

    /**
     * 通过属性名来获取属性值
     * @param fieldName 对象属性名
     * @param object 对象
     * @return 对象属性值
     */
    private static Object getFieldValueByName(String fieldName,Object object){
        try{
            //通过反射机制来获取对象中的字段(Field反射类，提供了获取对象所有字段的方法)
            Field field = object.getClass().getDeclaredField(fieldName);
            //设置对象的访问权限，确保对private的属性访问
            field.setAccessible(true);
            //获取属性值
            return field.get(object);
        }catch(Exception e){
            return null;
        }
    }

    /**
     * entity与dto转换方法
     *
     * 此方法为版本一，转换成功，但dto中的属性值没有取到
     *
     * @param entity
     * @param dto
     * @return
     */
    public static Object contert(Object entity,Object dto){
        //Filed反射类，为我们提供了获得类的字段的属性，值，名字（包括方法）
        //获取Object1类中的所有字段（包括public、private、protected）
        Field[] fieldsDto = dto.getClass().getDeclaredFields();
        //获取Object2类中的所有字段（包括public、private、protected）
        Field[] fieldsEntity = entity.getClass().getDeclaredFields();
        String[] propertyDtoNames = new String[fieldsDto.length];
        String[] propertyEntityNames = new String[fieldsEntity.length];
        List list = new ArrayList();
        for(int i=0;i<fieldsDto.length;i++){
            propertyDtoNames[i] = fieldsDto[i].getName();
        }
        for(int i=0;i<fieldsEntity.length;i++){
            propertyEntityNames[i] = fieldsEntity[i].getName();
        }
        try{
            for(int i=0;i<fieldsEntity.length;i++){
                for(int j=0;j<fieldsDto.length;j++){
                    if(propertyDtoNames[j] != null && propertyEntityNames[i].equals(propertyDtoNames[j])){
                        list.add(propertyDtoNames[j]);
                    }
                }
            }
        }catch(Exception e){

        }
        if(list != null && !list.isEmpty()){
            return entity;
        }
        return dto;
    }

}
