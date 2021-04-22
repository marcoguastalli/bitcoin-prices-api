package net.marco27.api.domain.releasenotes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import net.marco27.api.config.ApplicationYmlConfig;

@Data
public class ReleaseNotes {

    public static final String VERSION_1 = "v1";

    @JsonProperty
    private final String version;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime lastUpdate = VERSION_1_DATE;

    @Autowired
    public ReleaseNotes(final ApplicationYmlConfig applicationYmlConfig) {
        this.version = applicationYmlConfig.getVersion();
    }

    public static final LocalDateTime VERSION_1_DATE = LocalDate.parse("2012-04-22").atTime(LocalTime.parse("23:22:13"));

}
