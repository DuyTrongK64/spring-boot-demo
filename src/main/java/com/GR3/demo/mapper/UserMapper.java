package com.GR3.demo.mapper;

import com.GR3.demo.dto.request.UserCreationRequest;
import com.GR3.demo.dto.request.UserUpdateRequest;
import com.GR3.demo.dto.response.UserRespose;
import com.GR3.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserRespose toUserRespose(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
