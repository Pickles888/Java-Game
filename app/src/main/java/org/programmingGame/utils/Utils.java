package org.programmingGame.utils;

import java.util.List;

public class Utils {
	public static <T> List<T> truncateList(List<T> list) {
		return list.subList(Math.min(19, list.size() - 1), list.size() - 1);
	}
}
