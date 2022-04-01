package us.careydevelopment.util.youtube;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.services.youtube.YouTube;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.careydevelopment.util.api.google.CredentialUtil;
import us.careydevelopment.util.api.google.config.GoogleApiConfig;

public class YouTubeService {
    private static final Logger LOG = LoggerFactory.getLogger(YouTubeService.class);

    private YouTube youtube;

    public YouTubeService(final String userId) {
        setup(userId);
    }

    private void setup(final String userId) {
        final GoogleApiConfig config = GoogleApiConfig.getInstance();

        final HttpTransport transport = config.getTransport();
        final JsonFactory factory = config.getJsonFactory();
        final String applicationName = config.getApplicationName();

        final Credential credential = CredentialUtil.getCredential(userId);

        youtube = new YouTube.Builder(transport, factory, credential)
                .setApplicationName(applicationName)
                .build();
    }

}
