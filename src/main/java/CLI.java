
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class CLI {

	String option1;
	String option2;
	boolean help;

	private void run(String[] args) {
		Options options = createOptions();

		if (parseOptions(options, args)) {
			if (help) {
				printHelp(options);
				return;
			}

			/*
			 * your code here
			 */

		}

	}

	public static void main(String[] args) {
		CLI runner = new CLI();
		runner.run(args);
	}

	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);

			option1 = cmd.getOptionValue("abc").toUpperCase();
			option2 = cmd.getOptionValue("def");
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
		options.addOption(Option.builder("abc").longOpt("option1").desc("option1_description").hasArg()
				.argName("op1_arg").required().build());

		options.addOption(Option.builder("def").longOpt("option2").desc("option2_Fdescription").hasArg()
				.argName("op2_arg").required().build());

		// add options by using OptionBuilder
		options.addOption(Option.builder("h").longOpt("help").desc("Help").build());

		return options;
	}

	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("CLI", options, true);
	}
}
