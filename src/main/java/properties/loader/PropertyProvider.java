package properties.loader;

import org.apache.commons.lang.StringUtils;

import java.util.Properties;

public class PropertyProvider {

    private static Properties propsStore = new Properties();

    public PropertyProvider() {
    }

    public static boolean isDefined(String propertyName) {
        return propsStore.containsKey(propertyName);
    }

    public static String getProperty(String propertyName) {
        return propsStore.getProperty(propertyName, "");
    }

    public static String getProperty(String propertyName, String defaultValue) {
        return propsStore.getProperty(propertyName, defaultValue);
    }

    public static boolean getProperty(String propertyName, boolean defaultValue) {
        String value = getProperty(propertyName);
        return StringUtils.isBlank(value) ? defaultValue : Boolean.parseBoolean(value);
    }

    public static int getProperty(String propertyName, int defaultValue) {
        String value = getProperty(propertyName);
        return StringUtils.isBlank(value) ? defaultValue : Integer.parseInt(value);
    }

    public static long getProperty(String propertyName, long defaultValue) {
        String value = getProperty(propertyName);
        return StringUtils.isBlank(value) ? defaultValue : Long.parseLong(value);
    }

    public static String getPropertyOrThrow(String propertyName) {
        String prop = getProperty(propertyName);
        if (StringUtils.isBlank(prop)) {
            throw new IllegalStateException("Required property " + propertyName + " is empty or undefined");
        } else {
            return prop;
        }
    }

    public static Properties getAllProperties() {
        Properties newProps = new Properties();
        newProps.putAll(propsStore);
        return newProps;
    }

    static {
        String loaderClass = System.getProperty("propertyProvider.loaderClass", DefaultProperyLoader.class.getName());

        PropertyLoader loader;
        try {
            Class<? extends PropertyLoader>  clazz = (Class<? extends PropertyLoader>) Class.forName(loaderClass);
            loader = (PropertyLoader) clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException var3) {
            throw new RuntimeException("Cannot instantiate property loader class " + loaderClass, var3);
        }

        propsStore = loader.load();
    }
}
