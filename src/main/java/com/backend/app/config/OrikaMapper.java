package com.backend.app.config;

import com.backend.app.domain.NoteDomain;
import com.backend.app.domain.ReportDomain;
import com.backend.app.model.NoteModel;
import com.backend.app.model.ReportModel;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrikaMapper extends ConfigurableMapper {

    public MapperFactory mapper(MapperFactory factory) {
        factory.classMap(NoteModel.class, NoteDomain.class).byDefault().register();
        factory.classMap(ReportModel.class, ReportDomain.class).byDefault().register();
        return factory;
    }

}
