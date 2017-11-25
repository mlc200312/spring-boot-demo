package lab.springboot.core.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "m_user")
public class User extends BaseEntity {

	private static final long serialVersionUID = 7209338130494063119L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "jdbc")
	private Long id;
	@Column(name = "userName")
	private String userName;
	@Column(name = "passWord")
	private String passWord;
	@Column(name = "email")
	private String email;
	@Column(name = "nickName")
	private String nickName;
	@Column(name = "regTime")
	private String regTime;

	public User() {
		super();
	}

	public User(String email, String nickName, String passWord,
			String userName, String regTime) {
		super();
		this.email = email;
		this.nickName = nickName;
		this.passWord = passWord;
		this.userName = userName;
		this.regTime = regTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord="
				+ passWord + ", email=" + email + ", nickName=" + nickName
				+ ", regTime=" + regTime + "]";
	}

}