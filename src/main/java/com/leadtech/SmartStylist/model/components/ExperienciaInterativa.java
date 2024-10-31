package com.leadtech.SmartStylist.model.components;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class ExperienciaInterativa {

    @Field("tempo")
    private String tempo;

    @Field("feedback")
    private String feedback;
}
