package io.naraplatform.share.util.object;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ObjectUtil {
    //
    /**
     * Returns a deepCopy of the object, or null if the object cannot
     * be serialized.
     */
    public static Map convertObjectToMap(Object obj) {
        Map map = new HashMap();
        Field[] fields = obj.getClass().getDeclaredFields();
        for(int i=0; i <fields.length; i++){
            fields[i].setAccessible(true);
            try{
                map.put(fields[i].getName(), fields[i].get(obj));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return map;
    }

}
