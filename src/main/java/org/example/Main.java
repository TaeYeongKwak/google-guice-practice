package org.example;

import org.example.module.MyModule;
import org.example.service.MyService;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new MyModule());
		MyService myService = injector.getInstance(MyService.class);
		myService.createUser("test");
	}

}