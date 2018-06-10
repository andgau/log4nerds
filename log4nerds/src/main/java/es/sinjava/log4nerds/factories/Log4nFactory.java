/*
 * Copyright 2018-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * @ Author: Andres Gaudioso Simon mailto:andgau@gmail.com
 */

package es.sinjava.log4nerds.factories;

import static es.sinjava.log4nerds.utils.FieldEnum.FCLASS;
import static es.sinjava.log4nerds.utils.FieldEnum.FLEVEL;
import static es.sinjava.log4nerds.utils.FieldEnum.FMETHOD;
import static es.sinjava.log4nerds.utils.FieldEnum.FSEQ;
import static es.sinjava.log4nerds.utils.FieldEnum.FTIME;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.sinjava.log4nerds.configurators.ConsoleConfigurator;
import es.sinjava.log4nerds.configurators.FileConfigurator;
import es.sinjava.log4nerds.formatters.AdvancedFormatter;
import es.sinjava.log4nerds.formatters.DefaultFormatter;
import es.sinjava.log4nerds.formatters.SimpleFormatter;
import es.sinjava.log4nerds.utils.FieldEnum;

public class Log4nFactory {

	private static Logger logger;

	public static Logger getInstance(ConsoleConfigurator config) {
		if (logger == null) {
			logger = Logger.getAnonymousLogger();
			// log a archivo
			Handler ch = new ConsoleHandler();
			ch.setLevel(Level.ALL);
			Formatter newFormatter;
			if (config != null) {
				if (config.getFieldList() == null) {
					// Metemos un orden por defecto
					List<FieldEnum> fieldList = Arrays.asList(FSEQ, FLEVEL, FTIME, FCLASS, FMETHOD);
					config.setFieldList(fieldList);
				}

				newFormatter = new AdvancedFormatter(config);
			} else {
				newFormatter = new DefaultFormatter();
			}
			ch.setFormatter(newFormatter);
			logger.addHandler(ch);
			logger.setUseParentHandlers(false);
			logger.setLevel(Level.ALL);
		}
		return logger;
	}

	public static Logger getInstance(FileConfigurator fileConfigurator) {

		if (logger == null) {
			logger = Logger.getAnonymousLogger();
			// por defecto donde está el jar
			// caso contrario en la carpeta temporal
			try {

				String filename = fileConfigurator.getFileName();

				if (fileConfigurator.isTemp()) {
					filename = File.createTempFile(filename, ".log").getAbsolutePath();
				}
				// Si es temporal no tiene sentido hacer un append

				boolean mustAppend = !fileConfigurator.isTemp();

				Handler fileHandler = new FileHandler(filename, mustAppend);

				fileHandler.setLevel(Level.ALL);
				Formatter newFormatter = new SimpleFormatter(fileConfigurator.isLocalized());
				fileHandler.setFormatter(newFormatter);
				logger.addHandler(fileHandler);
			} catch (SecurityException | IOException e) {
				logger.severe(e.getMessage());
			}
			logger.setUseParentHandlers(false);
			logger.setLevel(Level.ALL);
		}
		return logger;
	}

}
