package com.joaocpvaz.springboot2project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.joaocpvaz.springboot2project.domain.User;
import com.joaocpvaz.springboot2project.request.UserPostRequestBody;
import com.joaocpvaz.springboot2project.request.UserPutRequestBody;


@Mapper(componentModel = "spring")
public abstract class UserMapper {
	
	public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	public abstract User toUser(UserPostRequestBody userPostRequestBody);
	
	public abstract User toUser(UserPutRequestBody userPutRequestBody);
}
