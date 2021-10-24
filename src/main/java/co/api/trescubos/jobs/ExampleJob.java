package co.api.trescubos.jobs;

import java.sql.Timestamp;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ExampleJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // Code to make POST call here
        System.err.println("Esto es la ejecucucion del Job a las: " + new Timestamp(System.currentTimeMillis()));
    }
}
