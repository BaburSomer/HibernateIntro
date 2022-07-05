package com.bilgeadam.boost.course02.logging;

import java.util.logging.Logger;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class MyLogger {
	private static MyLogger instance;
	private Logger          logger;

	public static MyLogger getInstance() {
		if (MyLogger.instance == null) {
			MyLogger.instance = new MyLogger();
		}
		return MyLogger.instance;
	}

	private Logger getLogger() {
		if (this.logger == null) {
			this.logger = Logger.getLogger("My Logger");
		}
		return this.logger;
	}

	public void debug(String msg) {
		this.getLogger().info(msg);
	}

	public void warn(String msg) {
		this.getLogger().warning(msg);
	}
	
	public void error(String msg) {
		this.getLogger().severe(msg);
	}
}
