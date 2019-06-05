package train.struts2.domain;

import java.util.Date;

/**
 * 用户对象
 */
public class User {
	
	/**
	 * 用户ID
	 */
	private int id;
	
	/**
	 * 用户名称
	 */
	private String username;
	
	/**
	 * 用户的出生日期
	 */
	private Date birthday;
	
	/**
	 * 用户状态
	 */
	private boolean status;
	
	/**
	 * 构造方法
	 * 
	 * @param id
	 * @param username
	 * @param birthday
	 * @param status
	 */
	public User(int id, String username, Date birthday, boolean status) {
		this.id = id;
		this.username = username;
		this.birthday = birthday;
		this.status = status;
	}

	// Get & Set
	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public Date getBirthday() {
		return birthday;
	}

	public boolean isStatus() {
		return status;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
