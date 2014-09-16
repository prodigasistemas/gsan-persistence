package br.gov.persistence.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class QuerySelectBuilderTest {

	private QuerySelectBuilder builder;
	
	@Before
	public void setup() {  
		builder = new QuerySelectBuilder(null, Class.class);
	}

	@Test
	public void setupQuerySelect() {
		assertEquals("SELECT obj FROM Class obj", builder.getSqlStatement().toString());
		assertEquals("", builder.getSqlConditions().toString());
	}
	
	@Test
	public void appendStatement() {
		builder.appendCondition("id", 0);
		
		assertEquals("SELECT obj FROM Class obj WHERE id = :id", builder.sql());
		assertTrue(builder.getParameters().size() == 1);
	}
	
	@Test
	public void appendTwoStatements() {
		builder.appendCondition("id", 0);
		builder.appendAndCondition("name", "");
		
		assertEquals("SELECT obj FROM Class obj WHERE id = :id AND name = :name", builder.sql());
		assertTrue(builder.getParameters().size() == 2);
	}
	
	@Test
	public void appendNullStatement() {
		builder.appendCondition("id", 0);
		builder.appendAndCondition("name", "");
		builder.appendAndCondition("value", null);
		
		assertEquals("SELECT obj FROM Class obj WHERE id = :id AND name = :name AND value is null", builder.sql());
		assertTrue(builder.getParameters().size() == 3);
	}
	
	@Test
	public void appendOrCondition() {
		builder.appendCondition("id", 0);
		builder.appendOrCondition("name", "");
		
		assertEquals("SELECT obj FROM Class obj WHERE id = :id OR name = :name", builder.sql());
		assertTrue(builder.getParameters().size() == 2);
	}
	
	@Test
	public void withLeftJoin() {
		builder.appendLeftJoin("reference");
		
		builder.appendCondition("id", 0);
		builder.appendOrCondition("name", "");
		
		assertEquals("SELECT obj FROM Class obj LEFT JOIN obj.reference reference WHERE id = :id OR name = :name", builder.sql());
		assertTrue(builder.getParameters().size() == 2);
	}
	
	@Test
	public void withLeftJoinAndFieldFromJoin() {
		builder.appendLeftJoin("reference");
		
		builder.appendCondition("id", 0);
		builder.appendOrCondition("name", "");
		builder.appendJoinCondition("reference", "id", "");
		
		assertEquals("SELECT obj FROM Class obj LEFT JOIN obj.reference reference WHERE id = :id OR name = :name AND reference.id = :reference_id", builder.sql());
		assertTrue(builder.getParameters().size() == 3);
	}
}
