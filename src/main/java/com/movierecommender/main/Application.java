package com.movierecommender.main;

import com.beust.jcommander.JCommander;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.movierecommender.main.commands.CommandExecutor;
import com.movierecommender.main.di.MainModule;
import com.movierecommender.main.di.SparkModule;

public class Application {
    private static Args args;

    public static void main(String[] arguments) {
        parseArgs(arguments);
        Injector injector = Guice.createInjector(new MainModule(), new SparkModule());

        CommandExecutor executor = injector.getInstance(CommandExecutor.class);
        executor.execute("streaming-test");
    }

    private static void parseArgs(String[] arguments) {
        args = new Args();
        JCommander commander = new JCommander();
        commander.addObject(args);
        commander.parse(arguments);
    }
}
