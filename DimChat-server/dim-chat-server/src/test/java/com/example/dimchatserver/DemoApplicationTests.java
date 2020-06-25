package com.example.dimchatserver;

import howin.dimChat.dao.LoginDao;
import howin.dimChat.models.LoginModel;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {
    @Autowired
	private LoginDao loginDao;

    private String email = "test@test.com";
	private String password = "testPassword0";

	@Test
	void createUser() {
	        loginDao.createUser(email, password);
	}

	@Test
	void deleteUser(){
		loginDao.deleteUser(email);
	}

	@Test
	void modifyUser(){
		loginDao.modifyUser(email, password);
	}

	@Test
	void getPassword(){
		LoginModel res = loginDao.getPassword(email);
		Assert.assertEquals(res.getPassword() , password);
	}

}
