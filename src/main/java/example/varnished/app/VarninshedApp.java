package example.varnished.app;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import example.varnished.api.messaging.MessagingConfig;
import example.varnished.infra.adapter.AdapterConfig;
import example.varnished.infra.event.EventConfig;
import example.varnished.infra.repo.RepoConfig;
import example.varnished.infra.service.ServiceConfig;
import example.varnished.web.WebConfig;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.errors.MinioException;

/**
 * The default profile, does not auto-configure JDBC, even though there are triggering assets on the classpath. This is
 * so that we are able to run most unit and module testing with injected test dummies or mocks - as desirable. The
 * Frobulating application will be a delight to develop and try out locally, with the option to run a full
 * container-setup and the production-services using profiles.
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableScheduling
public class VarninshedApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(VarninshedApp.class, args);

        tryOutMinioClient();
    }

    private static void tryOutMinioClient() throws InvalidKeyException, IOException, NoSuchAlgorithmException {
        try {
            // Create a minioClient with the MinIO server playground, its access key and secret key.
            MinioClient minioClient = MinioClient.builder().endpoint("http://localhost:9000")
                    .credentials("minminio", "minminio").build();

            // Make 'asiatrip' bucket if not exist.
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket("examplebucket").build());
            if (!found) {
                // Make a new bucket called 'asiatrip'.
                minioClient.makeBucket(MakeBucketArgs.builder().bucket("examplebucket").build());
            } else {
                System.out.println("Bucket 'examplebucket' already exists.");
            }
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
            System.out.println("HTTP trace: " + e.httpTrace());
        }
    }

    @Configuration
    @Import({ // NOSONAR
            WebConfig.class, RepoConfig.class, EventConfig.class, MessagingConfig.class, AdapterConfig.class,
            ServiceConfig.class })
    public static class Bootstrap {
        // OK
    }
}
