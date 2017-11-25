package lab.springboot.mybatis.param;

import io.swagger.annotations.ApiParam;

import java.io.Serializable;

/**
 * 登陆信息
 * 
 * @author liangchao.min
 *
 */
@SuppressWarnings("serial")
public class LoginParam implements Serializable {

	@ApiParam(value = "用户名", required = true)
	private String userName;
	@ApiParam(value = "密码", required = true)
	private String passWord;

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

}
