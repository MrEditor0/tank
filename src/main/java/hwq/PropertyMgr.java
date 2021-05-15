package hwq;

import java.io.IOException;
import java.util.Properties;

/**
 * @author haowq 2021/4/16 9:29
 */
public class PropertyMgr {

    static PropertyMgr propertyMgr = null;
    private Properties props = new Properties();

    private PropertyMgr() {
    }


    public static Object get(String key) {
        if (propertyMgr == null) {
            propertyMgr = new PropertyMgr();
            try {
                propertyMgr.props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("./config.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  propertyMgr.props.get(key);
    }


    }
