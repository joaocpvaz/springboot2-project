package com.joaocpvaz.springboot2project.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPostRequestBody {

	private String firstName;
	private String lastName;
	private String email;
	
}
