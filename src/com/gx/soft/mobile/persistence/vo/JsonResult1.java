package com.gx.soft.mobile.persistence.vo;

import java.util.List;


/**
 * 返回JSON实体
 * @date 2016-1-4
 */
public class JsonResult1 {




	private Object tooltip;// 
	private Object legend;// 
	private Object toolbox;//
	private boolean calculable;// 返回消息
	private List<Object> series;
	private Object title;
	public JsonResult1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JsonResult1(Object tooltip, Object legend, Object toolbox,boolean calculable,List<Object> series) {
		super();
		this.tooltip = tooltip;
		this.legend = legend;
		this.toolbox = toolbox;
		this.calculable = calculable;
		this.series = series;
	}
	public JsonResult1(Object tooltip, Object legend, Object toolbox,List<Object> series) {
		super();
		this.tooltip = tooltip;
		this.legend = legend;
		this.toolbox = toolbox;

		this.series = series;
	}

	public Object getTooltip() {
		return tooltip;
	}

	public void setTooltip(Object tooltip) {
		this.tooltip = tooltip;
	}

	public Object getLegend() {
		return legend;
	}

	public void setLegend(Object legend) {
		this.legend = legend;
	}

	public Object getToolbox() {
		return toolbox;
	}

	public void setToolbox(Object toolbox) {
		this.toolbox = toolbox;
	}

	public boolean isCalculable() {
		return calculable;
	}

	public void setCalculable(boolean calculable) {
		this.calculable = calculable;
	}


	public List<Object> getSeries() {
		return series;
	}

	public void setSeries(List<Object> series) {
		this.series = series;
	}

	public Object getTitle() {
		return title;
	}

	public void setTitle(Object title) {
		this.title = title;
	}

	public JsonResult1(Object tooltip, Object legend, Object toolbox,
			boolean calculable, List<Object> series, Object title) {
		super();
		this.tooltip = tooltip;
		this.legend = legend;
		this.toolbox = toolbox;
		this.calculable = calculable;
		this.series = series;
		this.title = title;
	}

	public JsonResult1(Object tooltip, Object legend, Object toolbox,
			 List<Object> series, Object title) {
		super();
		this.tooltip = tooltip;
		this.legend = legend;
		this.toolbox = toolbox;
		this.series = series;
		this.title = title;
	}


	
}

