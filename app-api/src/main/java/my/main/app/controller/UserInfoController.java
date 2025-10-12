package my.main.app.controller;

import lombok.RequiredArgsConstructor;
import my.main.app.service.UserInfoService;
import my.main.app.service.dto.UserInfoDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserInfoController {


    private final UserInfoService userInfoService;

    @GetMapping("/info")
    public UserInfoDto getUserInfo(@RequestParam("id") String userId) {
        return userInfoService.getUserInfo(userId);
    }

    @GetMapping
    public List<UserInfoDto> getUsersInfo() {
        return userInfoService.getUsersInfo();
    }

    @PostMapping
    public void addNewUser(@RequestParam(name = "name") String userName) {
        userInfoService.addNewUser(userName);
    }

}
