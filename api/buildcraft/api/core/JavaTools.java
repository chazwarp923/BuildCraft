/**
 * Copyright (c) 2011-2014, SpaceToad and the BuildCraft Team
 * http://www.mod-buildcraft.com
 *
 * BuildCraft is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 */
package buildcraft.api.core;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaTools {

	public static <T> T[] concat(T[] first, T[] second) {
		T[] result = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}

	public static int[] concat(int[] first, int[] second) {
		int[] result = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}

	public static float[] concat(float[] first, float[] second) {
		float[] result = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}

	public <T> T[] concatenate (T[] A, T[] B) {
	    int aLen = A.length;
	    int bLen = B.length;

	    @SuppressWarnings("unchecked")
	    T[] C = (T[]) Array.newInstance(A.getClass().getComponentType(), aLen+bLen);
	    System.arraycopy(A, 0, C, 0, aLen);
	    System.arraycopy(B, 0, C, aLen, bLen);

	    return C;
	}

	public static List<Field> getAllFields(Class clas) {
	    List<Field> result = new ArrayList<Field>();

	    Class current = clas;

	    while (current != null && current != Object.class) {
	    	for (Field f : current.getDeclaredFields()) {
	    		result.add(f);
	    	}

	        current = current.getSuperclass();
	    }

	    return result;
	}

	public static List<Method> getAllMethods(Class clas) {
	    List<Method> result = new ArrayList<Method>();

	    Class current = clas;

	    while (current != null && current != Object.class) {
	    	for (Method m : current.getDeclaredMethods()) {
	    		result.add(m);
	    	}

	        current = current.getSuperclass();
	    }

	    return result;
	}
}