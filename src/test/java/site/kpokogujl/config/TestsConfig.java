package site.kpokogujl.config;

import org.aeonbits.owner.Config;

public interface TestsConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://reqres.in")
    String getBaseUrl();
}
