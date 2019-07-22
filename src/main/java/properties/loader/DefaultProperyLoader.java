package properties.loader;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DefaultProperyLoader implements PropertyLoader {

    protected final Properties props = new Properties();
    private final static String PROP_PATH = "src/main/resources/props/settings.properties";

    public Properties load() {
        this.loadFromResource(this.props, PROP_PATH);
        this.props.putAll(System.getProperties());
        return this.props;
    }

    private void loadFromResource(Properties props, String path) {
        try {
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
                        is.close();
                    }
                }

            }
        } catch (IOException var16) {
            var16.printStackTrace();
        }

    }
}
