package imd0412.findmyrestaurant.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util
{
	public static Map<String, Integer> countWords(List<String> strings)
	{
		Map<String, Integer> result = new HashMap<>();
		for (String string : strings)
		{
			String[] words = string.split(" ");
			for (String word : words)
			{
				Integer count = result.get(word);
				if (null != count && count == 0)
				{
					result.put(word, 1);
				}
				else
				{
					result.put(word, count + 1);
				}
			}
		}
		return result;
	}
}
