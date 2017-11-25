package lab.springboot.redis.util;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class TokenUtil {

	private static TokenUtil TOKEN_UTIL;

	public final static String TOKEN_UNIQUE_ID = "TOKEN_UNIQUE_ID";

	public final static String TOKEN_PASSWORD = "TOKENFUFANG0123456";

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	public TokenUtil() {
		super();
	}

	@PostConstruct
	// 关键二 通过@PostConstruct 和 @PreDestroy 方法 实现初始化和销毁bean之前进行的操作
	public void init() {
		TOKEN_UTIL = this;
		TOKEN_UTIL.redisTemplate = this.redisTemplate;
	}

	public static TokenUtil Builder() {
		return TOKEN_UTIL;
	}

	/**
	 * set token
	 * 
	 * @return
	 */
	public static String setToken(String token) {
		BoundValueOperations<String, String> operations = TOKEN_UTIL.redisTemplate.boundValueOps(TOKEN_UNIQUE_ID + "_" + token);
		operations.expire(3600, TimeUnit.SECONDS);
		operations.set(token);
		return token;
	}

	/**
	 * 存在删除并返回true，不存在返回false
	 * 
	 * @param token
	 * @return
	 */
	public synchronized static boolean popToken(String token) {
		String key = TOKEN_UNIQUE_ID + "_" + token;

		if (token != null && TOKEN_UTIL.redisTemplate.hasKey(key)) {

			TOKEN_UTIL.redisTemplate.delete(key);
			return true;
		}
		return false;
	}

	/**
	 * 判断是否存在
	 * 
	 * @param token
	 * @return
	 */
	public static boolean hasToken(String token) {

		return token != null && TOKEN_UTIL.redisTemplate.hasKey(TOKEN_UNIQUE_ID + "_" + token);
	}

	/**
	 * is token password
	 * 
	 * @param token
	 * @return
	 */
	public static boolean isTokenPassword(String token) {

		return TokenUtil.TOKEN_PASSWORD.equalsIgnoreCase(token);
	}

	/**
	 * is not token password
	 * 
	 * @param token
	 * @return
	 */
	public static boolean isNotTokenPassword(String token) {

		return !TokenUtil.TOKEN_PASSWORD.equalsIgnoreCase(token);
	}
}
