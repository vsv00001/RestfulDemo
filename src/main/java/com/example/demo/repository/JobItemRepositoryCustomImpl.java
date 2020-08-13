/*
package com.example.demo.repository;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;

import com.example.demo.pojo.JobItem;


public class JobItemRepositoryCustomImpl implements JobItemRepositoryCustom {

	private static final Logger logger = LoggerFactory.getLogger(JobItemRepositoryCustomImpl.class);
	
	private Page<JobItem> listPage;
	
	private List<JobItem> list;
	
	@Autowired
	MongoTemplate template;
	
	private Query query;
	
	private Pageable pageable;
	
	private int page;

	
	private int size=1;
	
	@Override
	public List<JobItem> findActiveJobItemList(String jobId) {
		if (getListPage() == null) {
			setPageable(PageRequest.of(getPage(), size));
			query = new Query();
			query.addCriteria(Criteria.where("jobId").is(jobId));
			setQuery(query.with(getPageable()));
			setList(template.find(getQuery(), JobItem.class));
			setListPage(PageableExecutionUtils.getPage(getList(), getPageable(), () -> count(getQuery())));
			return getList();
		}

		if (getListPage().hasNext()) {
			setQuery(getQuery().with(getListPage().nextPageable()));
			setList(template.find(query, JobItem.class));
			setListPage(
					PageableExecutionUtils.getPage(getList(), getListPage().nextPageable(), () -> count(getQuery())));
			return getList();

		} else {
			return new ArrayList<>();
		}

	}
	
	
	public Page<JobItem> getListPage() {
		return listPage;
	}

	public void setListPage(Page<JobItem> listPage) {
		this.listPage = listPage;
	}

	public List<JobItem> getList() {
		return list;
	}

	public void setList(List<JobItem> list) {
		this.list = list;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

	public Pageable getPageable() {
		return pageable;
	}

	public void setPageable(Pageable pageable) {
		this.pageable = pageable;
	}

	private long count(Query query) {
		return template.count(query, JobItem.class);
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
*/