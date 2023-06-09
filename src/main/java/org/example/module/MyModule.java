package org.example.module;

import org.example.service.MyService;
import org.example.service.MyServiceImpl;

import com.google.inject.AbstractModule;

public class MyModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(MyService.class).to(MyServiceImpl.class);
	}

}
