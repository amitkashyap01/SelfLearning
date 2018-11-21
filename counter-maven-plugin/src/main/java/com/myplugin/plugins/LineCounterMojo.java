package com.myplugin.plugins;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Goal which touches a timestamp file.
 */
@Mojo( name = "count-source-line", defaultPhase = LifecyclePhase.PROCESS_SOURCES )
public class LineCounterMojo extends AbstractMojo
{
	@Parameter ( property = "sourceDirectory", defaultValue = "${project.build.sourceDirectory}")
	private File sourceDirectory;

	/**
	 * Location of the file.
	 */
	@Parameter( defaultValue = "${project.build.directory}", property = "outputDir", required = true )
	private File outputDirectory;

	public void execute()
			throws MojoExecutionException
	{
		try {
			long totalLinesOfSourceCode = Files.walk(sourceDirectory.toPath())
					.filter(f -> !f.toFile().isDirectory())
					.mapToLong(f ->newBufferedReader(f).lines().count()).sum();
			
			getLog().info("There are "+totalLinesOfSourceCode+ " lines of source code in this project");
		} catch (IOException e) {
			throw new MojoExecutionException("While counting lines of sourceCode " +e);
			
		}
	}
	
	private BufferedReader newBufferedReader(Path f) {
		
		try {
			return Files.newBufferedReader(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
