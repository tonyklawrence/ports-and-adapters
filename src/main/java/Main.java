import com.googlecode.utterlyidle.annotations.GET;
import com.googlecode.utterlyidle.annotations.Path;
import com.googlecode.utterlyidle.modules.Module;

import java.net.URL;

import static com.googlecode.totallylazy.URLs.packageUrl;
import static com.googlecode.utterlyidle.ApplicationBuilder.application;
import static com.googlecode.utterlyidle.dsl.DslBindings.bindings;
import static com.googlecode.utterlyidle.dsl.StaticBindingBuilder.in;
import static com.googlecode.utterlyidle.modules.Modules.bindingsModule;

public class Main {
    public static void main(String[] args) throws Exception {
        application()
                .add(staticFileModule(packageUrl(Main.class)))
                .addAnnotated(MainResource.class)
                .start(4050);
    }

    private static Module staticFileModule(URL url) {
        return bindingsModule(bindings(in(url).path("")));
    }

    public static class MainResource {
        @GET
        @Path("/")
        public String welcome() {
            return "Welcome";
        }
    }
}
