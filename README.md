# SB
Several Initial settings and descriptions

## File IO using Apache IO

### build.gradle

	// https://mvnrepository.com/artifact/commons-io/commons-io
	compile group: 'commons-io', name: 'commons-io', version: '2.6'

### read: 

	File file = new File("test.txt");
	String lines = FileUtils.readFileToString(file);
	List<String> lineList = FileUtils.readLines(file);

### write:

	File file = new File("test.txt");
	FileUtils.writeStringToFile(file, string);

## Apache CLI

### build.gradle
	// https://mvnrepository.com/artifact/commons-cli/commons-cli
	compile group: 'commons-cli', name: 'commons-cli', version: '1.4'
	
### Example

https://github.com/sungbin/SB/blob/master/src/main/java/CLI.java
