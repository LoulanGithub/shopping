package entity;

import java.io.Serializable;

/*********************************************************
 ** @Description: 返回结果
 ** @Date: Created in 2018/10/11  0:13
 ** @author: 杨
 *********************************************************/
public class Result implements Serializable
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private boolean flag;
	private String message;


	public Result(boolean flag, String message)
	{
		super();
		this.flag = flag;
		this.message = message;
	}

	public Result()
	{
	}

	public boolean isFlag()
	{
		return flag;
	}

	public void setFlag(boolean flag)
	{
		this.flag = flag;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}
}