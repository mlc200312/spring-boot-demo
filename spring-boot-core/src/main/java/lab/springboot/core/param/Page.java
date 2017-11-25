package lab.springboot.core.param;

import java.io.Serializable;

import org.springframework.util.StringUtils;

@SuppressWarnings("serial")
public class Page implements Serializable {
	/**
	 * 当前第几页
	 */
	private int page;

	/**
	 * 显示多少条数据
	 */
	private int rows;

	/**
	 * 排序列名
	 */
	private String sidx;

	/**
	 * 排序规则 asc or desc
	 */
	private String sord;

	private String tempSidx;

	private String tempSord;

	public int getTotal(int records) {
		return records % getRows() == 0 ? records / getRows() : records
				/ getRows() + 1;
	}

	public void setDefaultOrder(String sidx, String sord) {
		this.tempSidx = sidx;
		this.tempSord = sord;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSidx() {
		if (StringUtils.isEmpty(sidx)) {
			sidx = tempSidx;
		}
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSord() {
		if (StringUtils.isEmpty(sord)) {
			sord = tempSord;
		}
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	@Override
	public String toString() {
		return "Page [page=" + page + ", rows=" + rows + ", sidx=" + sidx
				+ ", sord=" + sord + ", tempSidx=" + tempSidx + ", tempSord="
				+ tempSord + "]";
	}

}
