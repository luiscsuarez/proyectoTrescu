package co.api.trescubos.jobs;

import co.api.trescubos.dto.ReceiverDTO;
import co.api.trescubos.entities.ReceiverEntity;
import co.api.trescubos.logic.ReceiverLogic;
import java.sql.Timestamp;
import java.util.List;
import javax.ejb.EJB;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobFind implements Job {
    
    @EJB
    private ReceiverLogic receiversLogic;
    List<ReceiverEntity> receivers;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // Code to make POST call here
        System.out.println("Esto es la ejecucucion del Job a las: " + new Timestamp(System.currentTimeMillis()));
        receiversLogic.obtenerReceiversHora();
        receivers = receiversLogic.obtenerReceiversHora();
        System.out.println("Receptores: "+ReceiverDTO.toReceiverList(receivers));
    }
}
