/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.highcharts.export.util;

import java.io.File;
import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author gert
 */
public class TempDir {

	protected static Logger logger = Logger.getLogger(TempDir.class);


	public static File tmpDir;
	public static File outputDir;
	public static File phantomJsDir;

	public TempDir() throws IOException {
//		tmpDir = Files.createTempDirectory("export");
        tmpDir = FileUtils.getFile(FileUtils.getTempDirectoryPath(), "export");
        tmpDir.mkdir();

		// Delete this directory on deletion of the JVM
		tmpDir.deleteOnExit();

        outputDir = FileUtils.getFile(tmpDir.getAbsolutePath(), "output");
        outputDir.mkdir();
//		outputDir = Files.createDirectory(Paths.get(tmpDir.toString(), "output"));

        phantomJsDir = FileUtils.getFile(tmpDir.getAbsolutePath(), "phantomjs");
        phantomJsDir.mkdir();
//		phantomJsDir = Files.createDirectory(Paths.get(tmpDir.toString(), "phantomjs"));

		logger.info("Highcharts Export Server using " +TempDir.getTmpDir().getAbsolutePath() + " as TEMP folder.");
	}

	public static File getTmpDir() {
		return tmpDir;
	}

	public static File getOutputDir() {
		return outputDir;
	}

	public static File getPhantomJsDir() {
		return phantomJsDir;
	}

	public static String getDownloadLink(String filename) {
		filename = FilenameUtils.getName(filename);
		String link = "files/" + filename;
		return link;
	}



}
