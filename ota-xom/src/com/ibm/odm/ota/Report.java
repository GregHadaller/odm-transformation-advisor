package com.ibm.odm.ota;

import ilog.rules.bom.annotations.NotBusiness;
import ilog.rules.teamserver.brm.IlrProjectElement;
import ilog.rules.teamserver.brm.IlrRuleProject;

import java.util.ArrayList;
import java.util.List;

/**
 * Captures items to report.
 * 
 * @author pberland@us.ibm.com
 *
 */
public class Report {
	private String url;
	private String datasource;
	private String username;
	private List<ReportElement> elements = new ArrayList<ReportElement>();

	public void addObjectEntry(String type, IlrRuleProject where,
			IlrProjectElement what) {
		ReportElement reportElement = new ReportElement(type, where.getName(), what.getName(), what);
		if (!elements.contains(reportElement)) {
			elements.add(reportElement);
		}
	}

	public void addTextEntry(String type, String where, String what,
			IlrProjectElement context) {
		ReportElement reportElement = new ReportElement(type, where, what,
				context);
		if (!elements.contains(reportElement)) {
			elements.add(reportElement);
		}
	}

	@NotBusiness
	public Report(String url, String datasource, String username)
	{
		this.url = url;
		this.datasource = datasource;
		this.username = username;
	}
	
	@NotBusiness
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	@NotBusiness
	public List<ReportElement> getElements() {
		return elements;
	}

	@NotBusiness
	public String getUrl() {
		return url;
	}

	@NotBusiness
	public String getDatasource() {
		return (datasource == null) ? "default" : datasource;
	}

	@NotBusiness
	public String getUsername() {
		return username;
	}
}
