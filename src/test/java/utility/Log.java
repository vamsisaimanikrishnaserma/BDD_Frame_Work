package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log {
	Logger logger;
	String path;

	public void createLogger(Class<?> currentClass) {
		logger = LogManager.getLogger(currentClass);
		
	}
	public void error(String message) {
		logger.error(message);
	}
	public void info(String message) {
		logger.info(message);
	}
	public void warn(String message) {
		logger.warn(message);
	}
	public void fatal(String message) {
		logger.fatal(message);
	}
	public void debug(String message) {
		logger.debug(message);
	}
}
