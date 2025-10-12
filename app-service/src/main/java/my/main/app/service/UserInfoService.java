package my.main.app.service;


import my.main.app.service.dto.UserInfoDto;

import java.util.List;

public interface UserInfoService {

    UserInfoDto getUserInfo(String userId);

    List<UserInfoDto> getUsersInfo();

    void addNewUser(String userName);
}
