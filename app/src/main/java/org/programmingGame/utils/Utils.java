package org.programmingGame.utils;

import java.util.List;

public class Utils {
	// remove a number of items from a list, right an associative
	public static <T> List<T> truncateList(List<T> list, int num) {
		return list.subList(Math.min(num - 1, list.size() - 1), list.size() - 1);
	}
}
