package dev.bug.customvalidator.controller;

import dev.bug.customvalidator.ValidAge;
import dev.bug.customvalidator.ValidEmail;
import dev.bug.customvalidator.entity.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/users")
@Validated
public class UserController {

    @PostMapping
    public Long createUser(@RequestBody @ValidAge(minAge = 14) @ValidEmail User user) {
        return user.getId();
    }
}
