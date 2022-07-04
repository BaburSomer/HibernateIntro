package com.bilgeadam.boost.course02;

import com.bilgeadam.boost.course02.controller.UserController;
import com.bilgeadam.boost.course02.model.UserEntity;

public class Test {

	public static void main(String[] args) {
		UserController userController = new UserController();
		
		UserEntity user1 = new UserEntity("Babür", "Somer");
		user1.setEmail("babur@somer.com");
		System.out.println(user1.toString());
		userController.create(user1);
	}

}
