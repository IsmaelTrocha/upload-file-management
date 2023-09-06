package com.liquors.file.config;

import java.util.Locale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configuration
@Slf4j
public class LocaleConfig {

  @Bean
  public AcceptHeaderLocaleResolver localeResolver() {
    final AcceptHeaderLocaleResolver resolver = new AcceptHeaderLocaleResolver();
    resolver.setDefaultLocale(Locale.getDefault());
    log.info("your locale is : {}", Locale.getDefault());
    return resolver;
  }
}
