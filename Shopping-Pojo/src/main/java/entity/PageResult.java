package entity;

import java.io.Serializable;
import java.util.List;

/*********************************************************
 ** @Description: TODO
 ** @Date: Created in 2018/9/28  22:52
 ** @author: 杨
 *********************************************************/
public class PageResult implements Serializable
{
	private Long total;//总记录数
	private List rows;//当前页结果

	private static final long serialVersionUID = 2L;

	public PageResult(Long total, List rows)
	{
		this.total = total;
		this.rows = rows;
	}

	public PageResult()
	{
	}

	public Long getTotal()
	{
		return total;
	}

	public void setTotal(Long total)
	{
		this.total = total;
	}

	public List getRows()
	{
		return rows;
	}

	public void setRows(List rows)
	{
		this.rows = rows;
	}
}
