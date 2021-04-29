package net.marco27.api.domain;

import java.io.IOException;
import java.sql.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class JsonDeserializeDate extends JsonDeserializer<Date> {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonDeserializeDate.class);
    private static final String[] PATTERNS = new String[] { "yyyy-MM-dd'T'HH:mm:ss.SSSX", "yyyy-MM-dd HH:mm:ss" };

    @Override
    public Date deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        try {
            final String dateAsString = jsonParser.getText().trim();
            final long time = DateUtils.parseDateStrictly(dateAsString, PATTERNS[0], PATTERNS[1]).getTime();
            return new Date(time);
        } catch (Exception e) {
            LOGGER.error(String.format("Error deserialize date with input text: %s", jsonParser.getText()), e);
        }
        return null;
    }

}
