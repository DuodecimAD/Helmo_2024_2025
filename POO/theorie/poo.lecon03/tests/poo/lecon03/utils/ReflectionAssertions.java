package poo.lecon03.utils;

import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ReflectionAssertions {
	public static void assertAllFieldsPrivate(Class<?> classDesc) {
		var fields = classDesc.getDeclaredFields();
		var nonPrivateObjectFields = Arrays.stream(fields)
			.filter(f -> !Modifier.isStatic(f.getModifiers())) //all objects fields
			.filter(f -> !Modifier.isPrivate(f.getModifiers()))//not private
			.map(f -> f.getName())
			.collect(Collectors.toList());
		if(nonPrivateObjectFields.size() > 0) {
			fail("These object fields should be private : "+nonPrivateObjectFields.stream().collect(Collectors.joining(",")));
		}
	}
	
	public static void assertAllConstructorPublic(Class<?> classDesc) {
		var constructors = classDesc.getDeclaredConstructors();
		var nonPublicConstructors = Arrays.stream(constructors)
				.filter(c -> !Modifier.isPublic(c.getModifiers()))//not private
				.map(ReflectionAssertions::signaturesOf)
				.collect(Collectors.toList());
		
		if(nonPublicConstructors.size() > 0) {
			fail("These constructors should be public : "+nonPublicConstructors.stream().collect(Collectors.joining(",")));
		}
	}
	
	public static void assertAllMethodsPublic(Class<?> classDesc) {
		var methods = classDesc.getDeclaredMethods();
		var nonPublicMethods = Arrays.stream(methods)
				.filter(c -> !Modifier.isPublic(c.getModifiers()))//not private
				.map(ReflectionAssertions::signaturesOf)
				.collect(Collectors.toList());
		
		if(nonPublicMethods.size() > 0) {
			fail("These methods should be public : "+nonPublicMethods.stream().collect(Collectors.joining(",")));
		}
	}
	
	
	private static String signaturesOf(Executable m) {
		return m.getName()+parametersToString(m.getParameters());
	}
	
	private static String parametersToString(Parameter[] parameters) {
		return Arrays
				.stream(parameters)
				.map(p -> p.getType().getName())
				.collect(Collectors.joining(",","(",")"));
	}
	
}
