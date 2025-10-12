package my.main.app.service.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserInfoDto {

    private UUID uuid;

    private String name;

    private String email;
}
