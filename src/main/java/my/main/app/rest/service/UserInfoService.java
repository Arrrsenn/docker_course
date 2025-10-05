package my.main.app.rest.service;

import my.main.app.rest.dto.UserInfoDto;

import java.util.List;

public interface UserInfoService {

    UserInfoDto getUserInfo(String userId);

    List<UserInfoDto> getUsersInfo();

    void addNewUser(String userName);
}
