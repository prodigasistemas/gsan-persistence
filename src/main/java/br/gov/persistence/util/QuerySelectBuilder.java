package br.gov.persistence.util;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class QuerySelectBuilder {

	private EntityManager entity;

	private StringBuilder sqlStatement;
	private StringBuilder sqlConditions;
	private StringBuilder joins;
	private Query query;
	
	private Map<String, Object> parameters;
	
	
	private Class<?> klass;
	
	public QuerySelectBuilder(EntityManager manager, Class<?> klass){
		this.entity = manager;
		this.klass = klass;
		
		parameters    = new HashMap<String, Object>();
		sqlStatement  = new StringBuilder();
		sqlConditions = new StringBuilder();
		joins         = new StringBuilder();
		
		sqlStatement.append("SELECT obj");
		sqlStatement.append(" FROM ");
		sqlStatement.append(klass.getSimpleName());
		sqlStatement.append(" obj");
	}
	
	public QuerySelectBuilder appendCondition(String fieldName, Object value) {
		return appendCondition("obj." + fieldName, fieldName, value);
	}
	
	private QuerySelectBuilder appendCondition(String fieldName, String fieldReference, Object value) {
		if (sqlConditions.toString().isEmpty()) {
			sqlConditions.append(" WHERE");
		}
		
		if (sqlConditions.charAt(sqlConditions.length() - 1) != '.'){
			sqlConditions.append(" ");
		}
		
		sqlConditions.append(fieldName).append(" ");
		
		if (value == null){
			sqlConditions.append("is null");
		}else{
			sqlConditions.append("= :").append(fieldReference);
			parameters.put(fieldReference, value);
		}
		
		
		return this;
	}
	
	public QuerySelectBuilder appendAndCondition(String field, Object value) {
		sqlConditions.append(" AND");
		
		return appendCondition(field, value);
	}
	
	public QuerySelectBuilder appendOrCondition(String field, Object value) {
		sqlConditions.append(" OR");
		
		return appendCondition(field, value);
	}
	
	public QuerySelectBuilder appendLeftJoin(String joinField){
		joins.append(" LEFT JOIN obj.").append(joinField).append(" ").append(joinField);
		return this;
	}
	
	public QuerySelectBuilder appendInnerJoin(String joinField){
		joins.append(" INNER JOIN obj.").append(joinField).append(" ").append(joinField);
		return this;
	}
	
	public QuerySelectBuilder appendJoinCondition(String join, String field, Object value){
       if (sqlConditions.toString().isEmpty()) {
            sqlConditions.append(" WHERE ");
        }else{
            sqlConditions.append(" AND ");
        }

		sqlConditions.append(join).append(".");
		
		return appendCondition(field, join + "_" + field, value);
	}
	
	public Query createSelectQuery() {
		query = entity.createQuery(sql(), klass);
		
		Set<String> idsValue = parameters.keySet();
		for (String idValue : idsValue) {
			query.setParameter(idValue, parameters.get(idValue));

		}
		
		return query;
	}
	
	public StringBuilder getSqlStatement() {
		return sqlStatement;
	}

	public void setSqlStatement(StringBuilder sqlStatement) {
		this.sqlStatement = sqlStatement;
	}

	public StringBuilder getSqlConditions() {
		return sqlConditions;
	}

	public void setSqlConditions(StringBuilder sqlConditions) {
		this.sqlConditions = sqlConditions;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

	public Map<String, Object> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}

	public String sql() {
		return sqlStatement.append(joins).append(sqlConditions).toString();
	}	
}
