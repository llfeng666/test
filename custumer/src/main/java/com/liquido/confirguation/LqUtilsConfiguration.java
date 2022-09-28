package com.liquido.confirguation;

import com.liquido.facade.HttpUtils;
import com.liquido.facade.JsonUtils;
import com.liquido.facade.XmlUtils;
import com.liquido.utils.LqWebClientBuilder;
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
