# SB
Several Initial settings

## File IO using Apache IO

### build.gradle

	// https://mvnrepository.com/artifact/commons-io/commons-io
	compile group: 'commons-io', name: 'commons-io', version: '2.6'

### read: 

File file = new File("test.txt");

String string = FileUtils.readFileToString(file);

### write:

File file = new File("test.txt");

FileUtils.writeStringToFile(file, string);
