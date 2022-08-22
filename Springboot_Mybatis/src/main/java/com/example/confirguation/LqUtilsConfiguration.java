package com.example.confirguation;

import com.example.facade.HttpUtils;
import com.example.facade.JsonUtils;
import com.example.facade.XmlUtils;
import com.example.utils.LqWebClientBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
        JsonUtils.class,
        XmlUtils.class,
        HttpUtils.class,
        JacksonConfiguration.class,
        LqWebClientBuilder.class
})
@Configuration
public class LqUtilsConfiguration {
}
