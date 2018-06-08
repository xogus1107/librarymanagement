import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Book {
private int code;
private String name;
private String writer;
private String publisher;
private int state;

public Book(int code, String name, String writer, String publisher, int state)
{
	this.code = code;
	this.name = name;
	this.writer = writer;
	this.publisher = publisher;
	this.state = state;
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

}


