package properties.loader;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DefaultProperyLoader implements PropertyLoader {

    protected final Properties props = new Properties();

    public DefaultProperyLoader() {
    }

    public Properties load() {
        this.loadFromResource(this.props, "src/main/resources/props/settings.properties");
        this.props.putAll(System.getProperties());
        return this.props;
    }

    private void loadFromResource(Properties props, String path) {
        try {
//            InputStream is = this.getClass().getClassLoader().getResourceAsStream(path);
            InputStream is = new FileInputStream(path);
            Throwable var4 = null;

            try {
                if (is != null) {
                    props.load(is);
                }
            } catch (Throwable var14) {
                var4 = var14;
                try {
                    throw var14;
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            } finally {
                if (is != null) {
                    if (var4 != null) {
                        try {
                            is.close();
                        } catch (Throwable ignored) {

                        }
                    } else {
                        is.close();
                    }
                }

            }
        } catch (IOException var16) {
            var16.printStackTrace();
        }

    }
}
