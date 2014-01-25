import com.googlecode.utterlyidle.annotations.GET;
import com.googlecode.utterlyidle.annotations.Path;

import static com.googlecode.utterlyidle.ApplicationBuilder.application;

public class Main {
    public static void main(String[] args) throws Exception {
        application()
                .addAnnotated(MainResource.class)
                .start(4050);
    }

    public static class MainResource {
        @GET
        @Path("/welcome")
        public String welcome() {
            return "Welcome";
        }
    }
}
