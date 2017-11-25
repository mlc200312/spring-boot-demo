package lab.springboot.redis.param;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.swagger.annotations.ApiParam;
import lab.springboot.core.model.User;
import lab.springboot.core.param.Param;

/**
 * 注册信息
 * 
 * @author liangchao.min
 *
 */
@SuppressWarnings("serial")
public class RegisterParam extends Param<User> {

	@ApiParam(value = "用户名", required = true)
	private String userName;
	@ApiParam(value = "密码", required = true)
	private String passWord;
	@ApiParam(value = "邮箱", required = true)
	private String email;
	@ApiParam(value = "昵称", required = true)
	private String nickName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public User param2model() {
		User user = super.param2model();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		user.setRegTime(format.format(new Date()));
		return user;
	}

}
