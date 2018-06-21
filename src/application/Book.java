package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Book {
private int code;
private String name;
private String writer;
private String publisher;
private int state;

private IntegerProperty tablecode;
private StringProperty tablename;
private StringProperty tablewriter;
private StringProperty tablepublisher;
private IntegerProperty tablestate;

public Book(int code, String name, String writer, String publisher, int state)
{
	this.code = code;
	this.name = name;
	this.writer = writer;
	this.publisher = publisher;
	this.state = state;
}
public Book(IntegerProperty tablecode, StringProperty tablename, StringProperty tablewriter, StringProperty tablepublisher, IntegerProperty tablestate)
{
	this.tablecode = tablecode;
	this.tablename = tablename;
	this.tablewriter = tablewriter;
	this.tablepublisher = tablepublisher;
	this.tablestate = tablestate;
}

public int getcode()
{
	return code;
}
public String getname()
{
	return name;
}
public String getwriter()
{
	return writer;
}
public String getpublisher()
{
	return publisher;
}

public int getstate()
{
	return state;
}

public void setCode(int code) {
	this.code = code;
}

public void setName(String name) {
	this.name = name;
}

public void setWriter(String writer) {
	this.writer = writer;
}

public void setPublisher(String publisher) {
	this.publisher = publisher;
}

public void setState(int state)
{
	this.state = state;
}

public IntegerProperty getTablecode()
{
	return tablecode;
}

public StringProperty getTablename()
{
	return tablename;
}

public StringProperty getTablewriter()
{
	return tablewriter;
}

public StringProperty getTablepublisher()
{
	return tablepublisher;
}

public IntegerProperty getTablestate()
{
	return tablestate;
}

}


