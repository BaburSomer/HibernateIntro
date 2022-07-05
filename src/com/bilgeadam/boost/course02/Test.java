package com.bilgeadam.boost.course02;

import java.util.ArrayList;

import com.bilgeadam.boost.course02.controller.UserController;
import com.bilgeadam.boost.course02.model.UserEntity;
import com.bilgeadam.boost.course02.view.UserView;

public class Test {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		UserController userController = new UserController();
		UserView       userView       = new UserView();

		UserEntity user1 = new UserEntity("Babür", "Somer");
		user1.setEmail("babur@somer.com1");
		userController.create(user1);
		userView.show(user1);

		ArrayList<UserEntity> users = userController.retrieve();
		System.out.println("\nOkunan kullanıcılar");
		for (UserEntity user : users) {
			System.out.println(user);
		}
		
		users = userController.findByEmail("babur@somer.com1");
		System.out.println("\nOkunan kullanıcı");
		UserEntity newUser = new UserEntity("Erşan", "Kuneri");
		newUser.setEmail("erşan@kuneri.com2");
		for (UserEntity user : users) {
			System.out.println(user);
			userController.update(user, newUser);
		}
		System.out.println();
		
		users = userController.findByEmail("erşan@kuneri.com");
		userController.delete(users.get(0));
		
		long stop = System.currentTimeMillis();
		System.out.println("Duration : " + (stop-start));

		
		
	}
}
