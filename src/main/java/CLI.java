
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class CLI {
	
	private void run(String[] args) {
		Options options = createOptions();

		if (parseOptions(options, args)) {
			if (help) {
				printHelp(options);
				return;
			}
			
			/*
				code ..
			 */
			
		}

	}

	String type;
	String concreteSentence;
	boolean help;

	public static void main(String[] args) {
		CLI runner = new CLI();
		runner.run(args);
	}

	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);

			type = cmd.getOptionValue("t").toUpperCase();
			concreteSentence = cmd.getOptionValue("c");
			help = cmd.hasOption("h");

		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}

	private Options createOptions() {
		Options options = new Options();

		// add options by using OptionBuilder
		options.addOption(Option.builder("t").longOpt("type").desc("Set a abstract syntax type(AE, WAE, FWAE...)")
				.hasArg().argName("Syntax type").required().build());

		options.addOption(Option.builder("c").longOpt("sentence").desc("Interpret a sentecne").hasArg()
				.argName("Sentence").required().build());

		// add options by using OptionBuilder
		options.addOption(Option.builder("h").longOpt("help").desc("Help").build());

		return options;
	}

	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("Interpreter", options, true);
	}
}
