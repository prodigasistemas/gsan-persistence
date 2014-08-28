package br.gov.persistence.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class QueryUpdateBuilderTest {

	private QueryUpdateBuilder builder;
	
	@Before
	public void setup() {  
		builder = new QueryUpdateBuilder(null, Class.class);
	}

	@Test
	public void setupQueryUpdate() {
		assertEquals("UPDATE Class SET", builder.getSqlStatement().toString());
		assertEquals("", builder.getSqlConditions().toString());
	}
	
	@Test
	public void appendStatement() {
		builder.appendIfNotNull("field1", 0);
		
		assertEquals("UPDATE Class SET field1 = :field1,", builder.getSqlStatement().toString());
		assertTrue(builder.getParameters().size() == 1);
	}
	
	@Test
	public void appendTwoStatements() {
		builder.appendIfNotNull("field1", 0);
		builder.appendIfNotNull("field2", 2);
		
		assertEquals("UPDATE Class SET field1 = :field1, field2 = :field2,", builder.getSqlStatement().toString());
		assertTrue(builder.getParameters().size() == 2);
	}
	
	@Test
	public void appendNullStatement() {
		builder.appendIfNotNull("field1", 0);
		builder.appendIfNotNull("field2", 2);
		builder.appendIfNotNull("field3", null);
		
		assertEquals("UPDATE Class SET field1 = :field1, field2 = :field2,", builder.getSqlStatement().toString());
		assertTrue(builder.getParameters().size() == 2);
	}
	
	@Test
	public void appendCondition() {
		builder.appendCondition("field1", "=", 1);
		
		assertEquals(" WHERE field1 = :?field1", builder.getSqlConditions().toString());
		assertTrue(builder.getParameters().size() == 1);
	}
	
	@Test
	public void appendAndCondition() {
		builder.appendCondition("field1", "=", 1);
		builder.appendAndCondition("field2", "=", 2);
		
		assertEquals(" WHERE field1 = :?field1 AND field2 = :?field2", builder.getSqlConditions().toString());
		assertTrue(builder.getParameters().size() == 2);
	}
	
	@Test
	public void appendOrCondition() {
		builder.appendCondition("field1", "=", 1);
		builder.appendOrCondition("field2", "=", 2);
		
		assertEquals(" WHERE field1 = :?field1 OR field2 = :?field2", builder.getSqlConditions().toString());
		assertTrue(builder.getParameters().size() == 2);
	}
	
	@Test
	public void sqlFormatted() {
		builder.appendIfNotNull("field1", 0);
		builder.appendIfNotNull("field2", 2);
		builder.appendCondition("field1", "=", 1);
		builder.appendOrCondition("field2", "=", 2);
		
		assertEquals("UPDATE Class SET field1 = :field1, field2 = :field2 WHERE field1 = :?field1 OR field2 = :?field2", builder.sql());
		assertTrue(builder.getParameters().size() == 4);
	}
}
