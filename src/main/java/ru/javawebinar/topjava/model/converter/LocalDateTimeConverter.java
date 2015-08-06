package ru.javawebinar.topjava.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by senior on 15.07.15.
 */
@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public java.sql.Timestamp convertToDatabaseColumn(LocalDateTime entityValue) {
        return Timestamp.valueOf(entityValue);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(java.sql.Timestamp databaseValue) {
        return databaseValue.toLocalDateTime();
    }


}
