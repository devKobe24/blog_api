package com.devkobe.domain.userInfo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserInfoRepositoryTest {

	@Autowired
	UserInfoRepository userInfoRepository;

	@AfterEach
	public void cleanup() {
		userInfoRepository.deleteAll();
	}

	@Test
	public void 유저_저장_정보_불러오기() {
		// given
		String name = "유저이름";
		String email = "유저이메일";
		String profileImage = "profile_image_url";
		String nickName = "유저닉네임";

		userInfoRepository.save(UserInfo.builder()
		                                .name(name)
		                                .email(email)
		                                .profileImage(profileImage)
		                                .nickName(nickName)
		                                .build());
		// when
		List<UserInfo> userInfoList = userInfoRepository.findAll();

		// then
		UserInfo userInfo = userInfoList.get(0);
		assertThat(userInfo.getName()).isEqualTo(name);
		assertThat(userInfo.getEmail()).isEqualTo(email);
		assertThat(userInfo.getProfileImage()).isEqualTo(profileImage);
		assertThat(userInfo.getNickName()).isEqualTo(nickName);
	}
}
