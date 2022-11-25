package com.liquido.facade;

import javax.annotation.PostConstruct;

import com.liquido.facade.bs2.Bs2CommonConfigs;
import com.google.common.base.Verify;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

@Import({
        Bs2CommonConfigs.class
})
@Getter
public class Bs2Configs {
    private final Bs2CommonConfigs configs;

    @Autowired
    Bs2Configs(final Bs2CommonConfigs configs) {
        this.configs = configs;
    }

    @PostConstruct
    public void init() {
        Verify.verify(getConfigs().getGrantType()
                        .equals(Bs2CommonConfigs.Bs2GrantType.CLIENT_CREDENTIALS.grantValue()),
                "Unsupported grant_type found: %s", getConfigs().getGrantType()
        );
        Verify.verify(getConfigs().getPixPayInKey() != null, "Pix pay-in key undefined");
    }
}
