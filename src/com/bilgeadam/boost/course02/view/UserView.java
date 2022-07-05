package com.bilgeadam.boost.course02.view;

import com.bilgeadam.boost.course02.controller.view.Showable;
import com.bilgeadam.boost.course02.model.UserEntity;

public class UserView implements Showable<UserEntity>{

	@Override
	public void show(UserEntity entity) {
		System.out.println(entity.toString());
	}
}
