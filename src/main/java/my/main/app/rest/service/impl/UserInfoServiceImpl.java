package my.main.app.rest.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.main.app.rest.dto.UserInfoDto;
import my.main.app.rest.repository.UserRepository;
import my.main.app.rest.repository.dao.User;
import my.main.app.rest.service.UserInfoService;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {

    private final UserRepository userRepository;
    private static final String FORMAT_EMAIL = "%s@gmail.com";

    @Override
    public UserInfoDto getUserInfo(String userId) {
        log.info("Get info user with id: " + userId);
        return userRepository.findById(UUID.fromString(userId))
                .map(user -> UserInfoDto.builder()
                        .uuid(user.getUuid())
                        .name(user.getName())
                        .email(user.getEmail())
                        .build())
                .orElseThrow(() -> new RuntimeException("Not found user: " + userId));
    }

    @Override
    public List<UserInfoDto> getUsersInfo() {
        log.info("Get users info");
        return userRepository.findAll().stream()
                .map(user -> UserInfoDto.builder()
                        .uuid(user.getUuid())
                        .name(user.getName())
                        .email(user.getEmail())
                        .build())
                .toList();
    }

    @Override
    public void addNewUser(String userName) {
        log.info("Create new user : " + userName);
        User user = new User();
        user.setName(userName);
        user.setEmail(String.format(FORMAT_EMAIL, UUID.randomUUID()));
        userRepository.save(user);
    }
}
