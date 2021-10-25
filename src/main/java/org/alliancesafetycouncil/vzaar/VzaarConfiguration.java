package org.alliancesafetycouncil.vzaar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VzaarConfiguration {

    @Value("${vzaar.clientid}")
    public String clientId;

    @Value("${vzaar.token}")
    public String token;

    @Value("${video.file.path}")
    public String videoFilePath;

    public VzaarConfiguration() {}
}
